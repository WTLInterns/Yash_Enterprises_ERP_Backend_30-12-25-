package com.company.attendance.repository;

import com.company.attendance.entity.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    
    List<SupportTicket> findByStatus(String status);
    
    List<SupportTicket> findByPriority(String priority);
    
    List<SupportTicket> findByCreatedBy(Long createdBy);
    
    @Query("SELECT st FROM SupportTicket st WHERE " +
           "LOWER(st.subject) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(st.description) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(st.category) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<SupportTicket> searchTickets(@Param("search") String search);
    
    @Query("SELECT COUNT(st) FROM SupportTicket st WHERE st.status = :status")
    long countByStatus(@Param("status") String status);
    
    @Query("SELECT COUNT(st) FROM SupportTicket st WHERE st.priority = :priority")
    long countByPriority(@Param("priority") String priority);
}
