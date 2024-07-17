package com.abc.service;

import java.util.Set;

import com.abc.dto.OrderDTO;

public interface OrderService {

	OrderDTO saveOrder(OrderDTO order);
	
	OrderDTO findOrderById(long orderId);
	
	Set<OrderDTO> findAllOrdersByCustomer(long customerId);
}
