package com.company.attendance.service;

import com.company.attendance.dto.SupportTicketDto;
import com.company.attendance.entity.SupportTicket;
import com.company.attendance.mapper.SupportTicketMapper;
import com.company.attendance.repository.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SupportTicketService {
    
    private final SupportTicketRepository supportTicketRepository;
    private final SupportTicketMapper supportTicketMapper;
    
    public List<SupportTicketDto> getAllTickets() {
        log.info("Fetching all support tickets");
        List<SupportTicket> tickets = supportTicketRepository.findAll();
        return tickets.stream()
                .map(supportTicketMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public SupportTicketDto getTicketById(Long id) {
        log.info("Fetching support ticket with ID: {}", id);
        SupportTicket ticket = supportTicketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Support ticket not found with ID: " + id));
        return supportTicketMapper.toDto(ticket);
    }
    
    public SupportTicketDto createTicket(SupportTicketDto ticketDto) {
        log.info("Creating new support ticket: {}", ticketDto.getSubject());
        SupportTicket ticket = supportTicketMapper.toEntity(ticketDto);
        SupportTicket savedTicket = supportTicketRepository.save(ticket);
        log.info("Created support ticket with ID: {}", savedTicket.getId());
        return supportTicketMapper.toDto(savedTicket);
    }
    
    public SupportTicketDto updateTicket(Long id, SupportTicketDto ticketDto) {
        log.info("Updating support ticket with ID: {}", id);
        SupportTicket existingTicket = supportTicketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Support ticket not found with ID: " + id));
        
        supportTicketMapper.updateEntityFromDto(ticketDto, existingTicket);
        SupportTicket updatedTicket = supportTicketRepository.save(existingTicket);
        log.info("Updated support ticket with ID: {}", updatedTicket.getId());
        return supportTicketMapper.toDto(updatedTicket);
    }
    
    public void deleteTicket(Long id) {
        log.info("Deleting support ticket with ID: {}", id);
        if (!supportTicketRepository.existsById(id)) {
            throw new RuntimeException("Support ticket not found with ID: " + id);
        }
        supportTicketRepository.deleteById(id);
        log.info("Deleted support ticket with ID: {}", id);
    }
    
    public List<SupportTicketDto> getTicketsByStatus(String status) {
        log.info("Fetching support tickets with status: {}", status);
        List<SupportTicket> tickets = supportTicketRepository.findByStatus(status);
        return tickets.stream()
                .map(supportTicketMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public List<SupportTicketDto> getTicketsByPriority(String priority) {
        log.info("Fetching support tickets with priority: {}", priority);
        List<SupportTicket> tickets = supportTicketRepository.findByPriority(priority);
        return tickets.stream()
                .map(supportTicketMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public List<SupportTicketDto> searchTickets(String search) {
        log.info("Searching support tickets with term: {}", search);
        List<SupportTicket> tickets = supportTicketRepository.searchTickets(search);
        return tickets.stream()
                .map(supportTicketMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public SupportTicketDto closeTicket(Long id, String resolution) {
        log.info("Closing support ticket with ID: {}", id);
        SupportTicket ticket = supportTicketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Support ticket not found with ID: " + id));
        
        ticket.setStatus("closed");
        ticket.setResolution(resolution);
        SupportTicket updatedTicket = supportTicketRepository.save(ticket);
        log.info("Closed support ticket with ID: {}", updatedTicket.getId());
        return supportTicketMapper.toDto(updatedTicket);
    }
    
    public long getTicketCount() {
        return supportTicketRepository.count();
    }
    
    public long getOpenTicketCount() {
        return supportTicketRepository.countByStatus("open");
    }
    
    public long getInProgressTicketCount() {
        return supportTicketRepository.countByStatus("in-progress");
    }
    
    public long getClosedTicketCount() {
        return supportTicketRepository.countByStatus("closed");
    }
}
