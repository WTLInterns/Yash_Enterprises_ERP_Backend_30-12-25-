package com.company.attendance.mapper;

import com.company.attendance.dto.ExpenseDto;
import com.company.attendance.entity.Expense;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ExpenseMapperImpl implements ExpenseMapper {

    @Override
    public ExpenseDto toDto(Expense o) {
        if ( o == null ) {
            return null;
        }

        ExpenseDto expenseDto = new ExpenseDto();

        expenseDto.setId( o.getId() );
        expenseDto.setEmployeeId( o.getEmployeeId() );
        expenseDto.setAmount( o.getAmount() );
        expenseDto.setCategory( o.getCategory() );
        expenseDto.setReceiptUrl( o.getReceiptUrl() );
        expenseDto.setApprovedBy( o.getApprovedBy() );
        expenseDto.setStatus( o.getStatus() );

        return expenseDto;
    }

    @Override
    public Expense toEntity(ExpenseDto dto) {
        if ( dto == null ) {
            return null;
        }

        Expense.ExpenseBuilder expense = Expense.builder();

        expense.id( dto.getId() );
        expense.employeeId( dto.getEmployeeId() );
        expense.amount( dto.getAmount() );
        expense.category( dto.getCategory() );
        expense.receiptUrl( dto.getReceiptUrl() );
        expense.approvedBy( dto.getApprovedBy() );
        expense.status( dto.getStatus() );

        return expense.build();
    }
}
