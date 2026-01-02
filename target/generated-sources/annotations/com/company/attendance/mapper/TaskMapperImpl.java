package com.company.attendance.mapper;

import com.company.attendance.dto.TaskDto;
import com.company.attendance.entity.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setId( task.getId() );
        taskDto.setTitle( task.getTitle() );
        taskDto.setDescription( task.getDescription() );
        taskDto.setAssignedTo( task.getAssignedTo() );
        taskDto.setAssignedBy( task.getAssignedBy() );
        taskDto.setDueDate( task.getDueDate() );
        taskDto.setStatus( task.getStatus() );
        taskDto.setPriority( task.getPriority() );
        taskDto.setCreatedAt( task.getCreatedAt() );

        return taskDto;
    }

    @Override
    public Task toEntity(TaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.id( dto.getId() );
        task.title( dto.getTitle() );
        task.description( dto.getDescription() );
        task.assignedTo( dto.getAssignedTo() );
        task.assignedBy( dto.getAssignedBy() );
        task.dueDate( dto.getDueDate() );
        task.status( dto.getStatus() );
        task.priority( dto.getPriority() );
        task.createdAt( dto.getCreatedAt() );

        return task.build();
    }
}
