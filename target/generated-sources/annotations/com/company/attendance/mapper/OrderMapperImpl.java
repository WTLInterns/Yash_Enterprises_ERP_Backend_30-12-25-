package com.company.attendance.mapper;

import com.company.attendance.dto.OrderDto;
import com.company.attendance.entity.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-02T15:53:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order o) {
        if ( o == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( o.getId() );
        orderDto.setOrderNumber( o.getOrderNumber() );
        orderDto.setClientId( o.getClientId() );
        orderDto.setItems( o.getItems() );
        orderDto.setAmount( o.getAmount() );
        orderDto.setStatus( o.getStatus() );
        orderDto.setCreatedBy( o.getCreatedBy() );

        return orderDto;
    }

    @Override
    public Order toEntity(OrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( dto.getId() );
        order.orderNumber( dto.getOrderNumber() );
        order.clientId( dto.getClientId() );
        order.items( dto.getItems() );
        order.amount( dto.getAmount() );
        order.status( dto.getStatus() );
        order.createdBy( dto.getCreatedBy() );

        return order.build();
    }
}
