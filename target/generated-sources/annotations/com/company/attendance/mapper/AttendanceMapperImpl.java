package com.company.attendance.mapper;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.entity.Attendance;
import com.company.attendance.entity.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AttendanceMapperImpl implements AttendanceMapper {

    @Override
    public AttendanceDto toDto(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }

        AttendanceDto attendanceDto = new AttendanceDto();

        attendanceDto.setEmployeeId( attendanceEmployeeId( attendance ) );
        if ( attendance.getStatus() != null ) {
            attendanceDto.setStatus( attendance.getStatus().name() );
        }
        attendanceDto.setId( attendance.getId() );
        attendanceDto.setDate( attendance.getDate() );
        attendanceDto.setPunchInTime( attendance.getPunchInTime() );
        attendanceDto.setPunchOutTime( attendance.getPunchOutTime() );
        attendanceDto.setInLocationLat( attendance.getInLocationLat() );
        attendanceDto.setInLocationLng( attendance.getInLocationLng() );
        attendanceDto.setOutLocationLat( attendance.getOutLocationLat() );
        attendanceDto.setOutLocationLng( attendance.getOutLocationLng() );
        attendanceDto.setNote( attendance.getNote() );
        attendanceDto.setDeviceInfo( attendance.getDeviceInfo() );
        attendanceDto.setIsLunchIn( attendance.getIsLunchIn() );
        attendanceDto.setIsLunchOut( attendance.getIsLunchOut() );

        return attendanceDto;
    }

    @Override
    public Attendance toEntity(AttendanceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Attendance.AttendanceBuilder attendance = Attendance.builder();

        attendance.date( dto.getDate() );
        attendance.punchInTime( dto.getPunchInTime() );
        attendance.punchOutTime( dto.getPunchOutTime() );
        attendance.inLocationLat( dto.getInLocationLat() );
        attendance.inLocationLng( dto.getInLocationLng() );
        attendance.outLocationLat( dto.getOutLocationLat() );
        attendance.outLocationLng( dto.getOutLocationLng() );
        if ( dto.getStatus() != null ) {
            attendance.status( Enum.valueOf( Attendance.Status.class, dto.getStatus() ) );
        }
        attendance.note( dto.getNote() );
        attendance.deviceInfo( dto.getDeviceInfo() );
        attendance.isLunchIn( dto.getIsLunchIn() );
        attendance.isLunchOut( dto.getIsLunchOut() );

        return attendance.build();
    }

    @Override
    public void updateEntityFromDto(AttendanceDto dto, Attendance attendance) {
        if ( dto == null ) {
            return;
        }

        attendance.setDate( dto.getDate() );
        attendance.setPunchInTime( dto.getPunchInTime() );
        attendance.setPunchOutTime( dto.getPunchOutTime() );
        attendance.setInLocationLat( dto.getInLocationLat() );
        attendance.setInLocationLng( dto.getInLocationLng() );
        attendance.setOutLocationLat( dto.getOutLocationLat() );
        attendance.setOutLocationLng( dto.getOutLocationLng() );
        if ( dto.getStatus() != null ) {
            attendance.setStatus( Enum.valueOf( Attendance.Status.class, dto.getStatus() ) );
        }
        else {
            attendance.setStatus( null );
        }
        attendance.setNote( dto.getNote() );
        attendance.setDeviceInfo( dto.getDeviceInfo() );
        attendance.setIsLunchIn( dto.getIsLunchIn() );
        attendance.setIsLunchOut( dto.getIsLunchOut() );
    }

    private Long attendanceEmployeeId(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }
        Employee employee = attendance.getEmployee();
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
