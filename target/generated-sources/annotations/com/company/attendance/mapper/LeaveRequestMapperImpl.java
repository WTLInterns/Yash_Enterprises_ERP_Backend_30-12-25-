package com.company.attendance.mapper;

import com.company.attendance.dto.LeaveRequestDto;
import com.company.attendance.entity.Employee;
import com.company.attendance.entity.LeaveRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class LeaveRequestMapperImpl implements LeaveRequestMapper {

    @Override
    public LeaveRequestDto toDto(LeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }

        LeaveRequestDto leaveRequestDto = new LeaveRequestDto();

        leaveRequestDto.setEmployeeId( leaveRequestEmployeeId( leaveRequest ) );
        leaveRequestDto.setId( leaveRequest.getId() );
        if ( leaveRequest.getLeaveType() != null ) {
            leaveRequestDto.setLeaveType( leaveRequest.getLeaveType().name() );
        }
        leaveRequestDto.setFromDate( leaveRequest.getFromDate() );
        leaveRequestDto.setToDate( leaveRequest.getToDate() );
        if ( leaveRequest.getStatus() != null ) {
            leaveRequestDto.setStatus( leaveRequest.getStatus().name() );
        }
        leaveRequestDto.setReason( leaveRequest.getReason() );

        return leaveRequestDto;
    }

    @Override
    public LeaveRequest toEntity(LeaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        LeaveRequest.LeaveRequestBuilder leaveRequest = LeaveRequest.builder();

        leaveRequest.id( dto.getId() );
        if ( dto.getLeaveType() != null ) {
            leaveRequest.leaveType( Enum.valueOf( LeaveRequest.LeaveType.class, dto.getLeaveType() ) );
        }
        leaveRequest.fromDate( dto.getFromDate() );
        leaveRequest.toDate( dto.getToDate() );
        if ( dto.getStatus() != null ) {
            leaveRequest.status( Enum.valueOf( LeaveRequest.Status.class, dto.getStatus() ) );
        }
        leaveRequest.reason( dto.getReason() );

        return leaveRequest.build();
    }

    private Long leaveRequestEmployeeId(LeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }
        Employee employee = leaveRequest.getEmployee();
        if ( employee == null ) {
            return null;
        }
        Long id = employee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
