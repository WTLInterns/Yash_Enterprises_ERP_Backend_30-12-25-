package com.company.attendance.controller;

import com.company.attendance.dto.SupportTicketDto;
import com.company.attendance.service.SupportTicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/support-tickets")
@RequiredArgsConstructor
@Slf4j
public class SupportTicketController {
    
    private final SupportTicketService supportTicketService;
    
    @GetMapping
    public ResponseEntity<List<SupportTicketDto>> getAllTickets() {
        log.info("GET /api/support-tickets - Fetching all support tickets");
        List<SupportTicketDto> tickets = supportTicketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketDto> getTicketById(@PathVariable Long id) {
        log.info("GET /api/support-tickets/{} - Fetching support ticket", id);
        try {
            SupportTicketDto ticket = supportTicketService.getTicketById(id);
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            log.error("Error fetching support ticket: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<SupportTicketDto> createTicket(@RequestBody SupportTicketDto ticketDto) {
        log.info("POST /api/support-tickets - Creating new support ticket: {}", ticketDto.getSubject());
        try {
            SupportTicketDto createdTicket = supportTicketService.createTicket(ticketDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
        } catch (Exception e) {
            log.error("Error creating support ticket: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SupportTicketDto> updateTicket(@PathVariable Long id, @RequestBody SupportTicketDto ticketDto) {
        log.info("PUT /api/support-tickets/{} - Updating support ticket", id);
        try {
            SupportTicketDto updatedTicket = supportTicketService.updateTicket(id, ticketDto);
            return ResponseEntity.ok(updatedTicket);
        } catch (RuntimeException e) {
            log.error("Error updating support ticket: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        log.info("DELETE /api/support-tickets/{} - Deleting support ticket", id);
        try {
            supportTicketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error("Error deleting support ticket: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<SupportTicketDto>> getTicketsByStatus(@PathVariable String status) {
        log.info("GET /api/support-tickets/status/{} - Fetching tickets by status", status);
        try {
            List<SupportTicketDto> tickets = supportTicketService.getTicketsByStatus(status);
            return ResponseEntity.ok(tickets);
        } catch (IllegalArgumentException e) {
            log.error("Invalid status parameter: {}", status);
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<SupportTicketDto>> getTicketsByPriority(@PathVariable String priority) {
        log.info("GET /api/support-tickets/priority/{} - Fetching tickets by priority", priority);
        try {
            List<SupportTicketDto> tickets = supportTicketService.getTicketsByPriority(priority);
            return ResponseEntity.ok(tickets);
        } catch (IllegalArgumentException e) {
            log.error("Invalid priority parameter: {}", priority);
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<SupportTicketDto>> searchTickets(@RequestParam String q) {
        log.info("GET /api/support-tickets/search?q={} - Searching tickets", q);
        List<SupportTicketDto> tickets = supportTicketService.searchTickets(q);
        return ResponseEntity.ok(tickets);
    }
    
    @PostMapping("/{id}/close")
    public ResponseEntity<SupportTicketDto> closeTicket(@PathVariable Long id, @RequestBody Map<String, String> request) {
        log.info("POST /api/support-tickets/{}/close - Closing support ticket", id);
        try {
            String resolution = request.get("resolution");
            SupportTicketDto closedTicket = supportTicketService.closeTicket(id, resolution);
            return ResponseEntity.ok(closedTicket);
        } catch (RuntimeException e) {
            log.error("Error closing support ticket: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getTicketStatistics() {
        log.info("GET /api/support-tickets/statistics - Fetching ticket statistics");
        Map<String, Object> statistics = Map.of(
            "total", supportTicketService.getTicketCount(),
            "open", supportTicketService.getOpenTicketCount(),
            "inProgress", supportTicketService.getInProgressTicketCount(),
            "closed", supportTicketService.getClosedTicketCount()
        );
        return ResponseEntity.ok(statistics);
    }
}
