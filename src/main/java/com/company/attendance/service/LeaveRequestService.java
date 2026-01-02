package com.company.attendance.service;
import com.company.attendance.entity.LeaveRequest;
import com.company.attendance.repository.LeaveRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest save(LeaveRequest leave) {
        return leaveRequestRepository.save(leave);
    }

    public List<LeaveRequest> findAll() {
        return leaveRequestRepository.findAll();
    }

    public Optional<LeaveRequest> findById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    public LeaveRequest getById(Long id) {
        return leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveRequest not found"));
    }

    public LeaveRequest update(Long id, LeaveRequest updated) {
        LeaveRequest existing = getById(id);
        return leaveRequestRepository.save(existing);
    }

    public LeaveRequest approve(Long id) {
        LeaveRequest leave = getById(id);
        leave.setStatus(LeaveRequest.Status.APPROVED);
        return leaveRequestRepository.save(leave);
    }

    public LeaveRequest reject(Long id) {
        LeaveRequest leave = getById(id);
        leave.setStatus(LeaveRequest.Status.REJECTED);
        return leaveRequestRepository.save(leave);
    }

    public void delete(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}
