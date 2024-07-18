package com.abc.order.service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.order.dto.CustomerDTO;
import com.abc.order.dto.OrderDTO;
import com.abc.order.dto.OrderItemDTO;
import com.abc.order.dto.ProductDTO;
import com.abc.order.entity.Order;
import com.abc.order.entity.OrderItem;
import com.abc.order.exception.ResourceNotFoundException;
import com.abc.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductApiClient productApiClient;
	
	@Autowired
	private CustomerApiClient customerApiClient;

//	@Autowired
//	private RestTemplate restTemplate;

	@Override
	public String saveOrder(OrderDTO orderDTO) {

		Set<OrderItemDTO> orderItemDTOs = orderDTO.getOrderItems();

		double orderAmount = 0;

		for (OrderItemDTO orderItemDTO : orderItemDTOs) {

			int qty = orderItemDTO.getQuantity();
			long productId = orderItemDTO.getProduct().getId();

			// get the product details
//			ResponseEntity<ProductDTO> responseEntity = restTemplate
//					.getForEntity("http://localhost:8082/product/" + productId, ProductDTO.class);
//
//			ProductDTO productDTO = responseEntity.getBody();
			
			ProductDTO productDTO = productApiClient.fetchProductDetails(productId);
			

			double itemTotal = qty * productDTO.getProductPrice();

			orderItemDTO.setItemTotal(itemTotal);// we need to set the item total (productPrice * qty)

			orderAmount = orderAmount + itemTotal;

		}

		orderDTO.setOrderAmount(orderAmount);
		orderDTO.setOrderDate(LocalDate.now());
		orderDTO.setOrderStatus("Success");

		//convert dto to entity

		Order order = new Order();
		order.setOrderAmount(orderDTO.getOrderAmount());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setOrderStatus(orderDTO.getOrderStatus());
		order.setCustomerId(orderDTO.getCustomer().getId());

		Set<OrderItem> orderItems = new LinkedHashSet<>();

		for (OrderItemDTO itemDTO : orderItemDTOs) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemTotal(itemDTO.getItemTotal());
			orderItem.setProductId(itemDTO.getProduct().getId());
			orderItem.setQuantity(itemDTO.getQuantity());
			
			orderItem.setOrder(order);

			orderItems.add(orderItem);
		}

		order.setOrderItems(orderItems);

		orderRepository.save(order);		

		return "Order Successfully Placed";
	}

	@Override
	public OrderDTO findOrderById(long orderId) {
		
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found");
		}
		Order order = optionalOrder.get();
		
		OrderDTO orderDTO =  modelMapper.map(order, OrderDTO.class);		
				
		CustomerDTO customerDTO = customerApiClient.getCustomerDetails(orderDTO.getCustomer().getId());
		orderDTO.setCustomer(customerDTO);
		
		Set<OrderItemDTO> orderItemDtos = orderDTO.getOrderItems();
		
		for(OrderItemDTO item : orderItemDtos) {
			ProductDTO productDTO = productApiClient.fetchProductDetails(item.getProduct().getId());
			item.setProduct(productDTO);
		}
		
		orderDTO.setOrderItems(orderItemDtos);
		
		return orderDTO;
	}

	@Override
	public Set<OrderDTO> findAllOrdersByCustomer(long customerId) {
		
		List<Order> orders = orderRepository.findOrderByCustomerId(customerId);		
		CustomerDTO customerDTO = customerApiClient.getCustomerDetails(customerId);

		Set<OrderDTO> orderDTOs = orders.stream().map(order-> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toSet());
		
		for (OrderDTO order:orderDTOs) {
			order.setCustomer(customerDTO);
			Set<OrderItemDTO> orderItems=order.getOrderItems();
			for(OrderItemDTO item : orderItems) {
				ProductDTO productDTO = productApiClient.fetchProductDetails(item.getId());
				item.setProduct(productDTO);
			}
		};
		
		return orderDTOs;
	}

}
