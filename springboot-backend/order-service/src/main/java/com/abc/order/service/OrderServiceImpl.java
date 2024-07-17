package com.abc.order.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public OrderDTO saveOrder(OrderDTO orderDTO) {

		Set<OrderItemDTO> orderItemDTOs = orderDTO.getOrderItems();

		double orderAmount = 0;

		for (OrderItemDTO orderItemDTO : orderItemDTOs) {

			int qty = orderItemDTO.getQuantity();
			long productId = orderItemDTO.getProductId();

			// get the product details
			ResponseEntity<ProductDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/product/" + productId, ProductDTO.class);

			ProductDTO productDTO = responseEntity.getBody();

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
		order.setCustomerId(orderDTO.getCustomerId());

		Set<OrderItem> orderItems = new LinkedHashSet<>();

		for (OrderItemDTO itemDTO : orderItemDTOs) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemTotal(itemDTO.getItemTotal());
			orderItem.setProductId(itemDTO.getProductId());
			orderItem.setQuantity(itemDTO.getQuantity());
			
			orderItem.setOrder(order);

			orderItems.add(orderItem);
		}

		order.setOrderItems(orderItems);

		orderRepository.save(order);

		// convert entity to dto
		OrderDTO newOrder = modelMapper.map(order, OrderDTO.class);

		return newOrder;
	}

	@Override
	public OrderDTO findOrderById(long orderId) {
	    Optional<Order> optionalOrder = orderRepository.findById(orderId);
	    if(optionalOrder.isEmpty()) {
	        throw new ResourceNotFoundException("Order not found");
	    }
	    Order order = optionalOrder.get();
	    
	    //get the customer by using customer id
	    ResponseEntity<CustomerDTO> customerResponse = restTemplate
	            .getForEntity("http://localhost:8081/customer/" + order.getCustomerId(), CustomerDTO.class);
	    CustomerDTO customerDTO = customerResponse.getBody();
	    
	    //get the products details by using productid
	    Set<OrderItem> orders = order.getOrderItems();
	    Set<OrderItemDTO> orderItemsDTO = new HashSet<>();
	    for(OrderItem product : orders) {
	        ResponseEntity<ProductDTO> productResponse = restTemplate
	                .getForEntity("http://localhost:8082/product/" + product.getProductId(), ProductDTO.class);
	        ProductDTO productDTO = productResponse.getBody();
	        OrderItemDTO orderItemDTO = new OrderItemDTO();
	        orderItemDTO.setProductId(product.getProductId());
	        orderItemDTO.setId(productDTO.getId());
	        orderItemDTO.setMfd(productDTO.getMfd());
	        orderItemDTO.setCategory(productDTO.getCategory());
	        orderItemDTO.setProductName(productDTO.getProductName());
	        orderItemDTO.setQuantity(product.getQuantity());
	        orderItemDTO.setProductPrice(productDTO.getProductPrice());
	        double itemTotal = product.getQuantity() * productDTO.getProductPrice();
	        orderItemDTO.setItemTotal(itemTotal);
	        
	        orderItemsDTO.add(orderItemDTO);
	    }
	    
	    OrderDTO orderDto = new OrderDTO();
	    orderDto.setId(order.getId());
	    orderDto.setOrderAmount(order.getOrderAmount());
	    orderDto.setOrderDate(order.getOrderDate());
	    orderDto.setOrderStatus(order.getOrderStatus());
	    orderDto.setCustomerId(order.getCustomerId());
	    orderDto.setCustomerName(customerDTO.getCustomerName());
	    orderDto.setDob(customerDTO.getDob());
	    orderDto.setEmail(customerDTO.getEmail());
	    orderDto.setMobile(customerDTO.getMobile());
	    orderDto.setCity(customerDTO.getCity());
	    
	    orderDto.setOrderItems(orderItemsDTO);
	    
	    return orderDto;
	}


	@Override
	public Set<OrderDTO> findAllOrdersByCustomer(long customerId) {
		
		List<Order> orders = orderRepository.findOrderByCustomerId(customerId);
		
		Set<OrderDTO> orderDTOs = orders.stream().map(order-> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toSet());
		
		return orderDTOs;
	}

}
