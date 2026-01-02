package com.company.attendance.controller;

import com.company.attendance.dto.CaseDocumentDto;
import com.company.attendance.service.CaseDocumentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/case-documents")
@RequiredArgsConstructor
public class CaseDocumentController {
    
    private static final Logger log = LoggerFactory.getLogger(CaseDocumentController.class);

    private final CaseDocumentService caseDocumentService;

    @PostMapping("/upload")
    public ResponseEntity<CaseDocumentDto> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("caseId") Long caseId,
            @RequestParam(value = "documentName", required = false) String documentName,
            @RequestParam(value = "description", required = false) String description) {
        log.info("POST /api/case-documents/upload - Uploading document for case: {}", caseId);
        
        try {
            CaseDocumentDto documentDto = new CaseDocumentDto();
            documentDto.setCaseId(caseId);
            documentDto.setDocumentName(documentName);
            documentDto.setDescription(description);
            
            CaseDocumentDto uploadedDocument = caseDocumentService.uploadDocument(documentDto, file);
            return ResponseEntity.status(HttpStatus.CREATED).body(uploadedDocument);
            
        } catch (Exception e) {
            log.error("Error uploading document: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CaseDocumentDto> updateDocument(@PathVariable Long id, @Valid @RequestBody CaseDocumentDto documentDto) {
        log.info("PUT /api/case-documents/{} - Updating document", id);
        try {
            CaseDocumentDto updatedDocument = caseDocumentService.updateDocument(id, documentDto);
            return ResponseEntity.ok(updatedDocument);
        } catch (Exception e) {
            log.error("Error updating document: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CaseDocumentDto> getDocumentById(@PathVariable Long id) {
        log.info("GET /api/case-documents/{} - Fetching document", id);
        try {
            CaseDocumentDto documentDto = caseDocumentService.getDocumentById(id);
            return ResponseEntity.ok(documentDto);
        } catch (Exception e) {
            log.error("Error fetching document: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<CaseDocumentDto>> getDocumentsByCaseId(@PathVariable Long caseId) {
        log.info("GET /api/case-documents/case/{} - Fetching documents for case", caseId);
        try {
            List<CaseDocumentDto> documents = caseDocumentService.getDocumentsByCaseId(caseId);
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            log.error("Error fetching documents for case: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<CaseDocumentDto>> searchDocuments(@RequestParam String search) {
        log.info("GET /api/case-documents/search - Searching documents with term: {}", search);
        try {
            List<CaseDocumentDto> documents = caseDocumentService.searchDocuments(search);
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            log.error("Error searching documents: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/case/{caseId}/count")
    public ResponseEntity<Long> getDocumentsCountByCaseId(@PathVariable Long caseId) {
        log.info("GET /api/case-documents/case/{}/count - Getting documents count for case", caseId);
        try {
            Long count = caseDocumentService.getDocumentsCountByCaseId(caseId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            log.error("Error getting documents count for case: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long id) {
        log.info("GET /api/case-documents/download/{} - Downloading document", id);
        try {
            CaseDocumentDto documentDto = caseDocumentService.getDocumentById(id);
            
            byte[] fileContent = caseDocumentService.downloadDocument(id);
            
            Resource resource = new ByteArrayResource(fileContent) {
                @Override
                public String getFilename() {
                    return documentDto.getFileName();
                }
            };
            
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentDto.getFileName() + "\"")
                    .body(resource);
                    
        } catch (IOException e) {
            log.error("Error downloading document: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error fetching document for download: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/view/{id}")
    public ResponseEntity<Resource> viewDocument(@PathVariable Long id, HttpServletResponse response) throws IOException {
        log.info("GET /api/case-documents/view/{} - Viewing document", id);
        try {
            CaseDocumentDto documentDto = caseDocumentService.getDocumentById(id);
            log.info("Document found: {} with file path: {}", documentDto.getDocumentName(), documentDto.getFilePath());
            
            // Determine content type based on file extension
            String contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
            String fileName = documentDto.getFileName().toLowerCase();
            if (fileName.endsWith(".pdf")) {
                contentType = "application/pdf";
            } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
                contentType = "image/jpeg";
            } else if (fileName.endsWith(".png")) {
                contentType = "image/png";
            } else if (fileName.endsWith(".gif")) {
                contentType = "image/gif";
            }
            
            log.info("Streaming content type: {} for file: {}", contentType, fileName);
            
            // Stream the file directly to avoid memory issues
            java.io.File file = new java.io.File(documentDto.getFilePath());
            if (!file.exists()) {
                log.error("File not found on disk: {}", documentDto.getFilePath());
                return ResponseEntity.notFound().build();
            }
            
            response.setContentType(contentType);
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + documentDto.getFileName() + "\"");
            response.setHeader(HttpHeaders.CACHE_CONTROL, "max-age=3600");
            response.setHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));
            
            // Stream the file
            try (java.io.InputStream inputStream = new java.io.FileInputStream(file);
                 java.io.OutputStream outputStream = response.getOutputStream()) {
                
                byte[] buffer = new byte[8192]; // 8KB buffer
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            }
            
            return ResponseEntity.ok().build();
                    
        } catch (IOException e) {
            log.error("Error viewing document: {} - {}", e.getMessage(), e.getClass().getSimpleName());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error fetching document for viewing: {} - {}", e.getMessage(), e.getClass().getSimpleName());
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        log.info("DELETE /api/case-documents/{} - Deleting document", id);
        try {
            caseDocumentService.deleteDocument(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleting document: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
