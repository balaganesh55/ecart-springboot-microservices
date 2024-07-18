package com.abc.order.service;

import java.util.Set;

import com.abc.order.dto.OrderDTO;

public interface OrderService {

	String saveOrder(OrderDTO orderDTO);
	
	OrderDTO findOrderById(long orderId);
	
	Set<OrderDTO> findAllOrdersByCustomer(long customerId);
}
