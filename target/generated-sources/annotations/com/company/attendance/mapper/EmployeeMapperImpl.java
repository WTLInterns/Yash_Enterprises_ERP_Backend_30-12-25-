package com.company.attendance.mapper;

import com.company.attendance.dto.EmployeeDto;
import com.company.attendance.entity.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( dto.getId() );
        employee.userId( dto.getUserId() );
        employee.employeeId( dto.getEmployeeId() );
        employee.firstName( dto.getFirstName() );
        employee.lastName( dto.getLastName() );
        employee.email( dto.getEmail() );
        employee.phone( dto.getPhone() );
        employee.subadminId( dto.getSubadminId() );
        if ( dto.getStatus() != null ) {
            employee.status( Enum.valueOf( Employee.Status.class, dto.getStatus() ) );
        }
        employee.profileImageUrl( dto.getProfileImageUrl() );
        employee.hiredAt( dto.getHiredAt() );
        employee.terminationDate( dto.getTerminationDate() );
        employee.locationLat( dto.getLocationLat() );
        employee.locationLng( dto.getLocationLng() );
        employee.employeeCode( dto.getEmployeeCode() );
        employee.attendanceAllowed( dto.getAttendanceAllowed() );

        return employee.build();
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto.EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.id( entity.getId() );
        employeeDto.userId( entity.getUserId() );
        employeeDto.employeeId( entity.getEmployeeId() );
        employeeDto.firstName( entity.getFirstName() );
        employeeDto.lastName( entity.getLastName() );
        employeeDto.email( entity.getEmail() );
        employeeDto.phone( entity.getPhone() );
        employeeDto.subadminId( entity.getSubadminId() );
        if ( entity.getStatus() != null ) {
            employeeDto.status( entity.getStatus().name() );
        }
        employeeDto.profileImageUrl( entity.getProfileImageUrl() );
        employeeDto.hiredAt( entity.getHiredAt() );
        employeeDto.terminationDate( entity.getTerminationDate() );
        employeeDto.locationLat( entity.getLocationLat() );
        employeeDto.locationLng( entity.getLocationLng() );
        employeeDto.employeeCode( entity.getEmployeeCode() );
        employeeDto.attendanceAllowed( entity.getAttendanceAllowed() );

        return employeeDto.build();
    }

    @Override
    public void updateEntityFromDto(EmployeeDto dto, Employee entity) {
        if ( dto == null ) {
            return;
        }

        entity.setFirstName( dto.getFirstName() );
        entity.setLastName( dto.getLastName() );
        entity.setEmail( dto.getEmail() );
        entity.setPhone( dto.getPhone() );
        entity.setSubadminId( dto.getSubadminId() );
        if ( dto.getStatus() != null ) {
            entity.setStatus( Enum.valueOf( Employee.Status.class, dto.getStatus() ) );
        }
        else {
            entity.setStatus( null );
        }
        entity.setProfileImageUrl( dto.getProfileImageUrl() );
        entity.setHiredAt( dto.getHiredAt() );
        entity.setTerminationDate( dto.getTerminationDate() );
        entity.setLocationLat( dto.getLocationLat() );
        entity.setLocationLng( dto.getLocationLng() );
        entity.setEmployeeCode( dto.getEmployeeCode() );
        entity.setAttendanceAllowed( dto.getAttendanceAllowed() );
        entity.setCreatedBy( dto.getCreatedBy() );
        entity.setUpdatedBy( dto.getUpdatedBy() );
    }
}
