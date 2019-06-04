package com.ray.study.dockercompose.orderservice.service.impl;

import com.ray.study.dockercompose.dcmodel.entity.order.Order;
import com.ray.study.dockercompose.dcmodel.entity.product.Product;
import com.ray.study.dockercompose.orderservice.client.ProductClient;
import com.ray.study.dockercompose.orderservice.repository.OrderRepository;
import com.ray.study.dockercompose.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * description
 *
 * @author shira 2019/06/04 15:47
 */
@Service
public class OrderServiceImpl  implements OrderService {

	private OrderRepository orderRepository;
	private ProductClient productClient;

	public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient){
		this.orderRepository = orderRepository;
		this.productClient = productClient;
	}



	@Override
	public List<Order> list() {
		return orderRepository.findAll();
	}

	@Override
	public Order query(Long id) {
		Optional<Order> orderOptional = orderRepository.findById(id);
		orderOptional.ifPresent(value -> {
			Order order = value;
			Product product = productClient.query(order.getProductId());
			order.setProduct(product);
		});

		return orderOptional.orElse(null);
	}

	@Override
	public Order create(Order order) {

		if(order.getProductId() ==null ){
			new RuntimeException("未选择商品");
		}

		Product product = productClient.query(order.getProductId());

		Order  newOrder =  new Order();
		newOrder.setProductId(order.getProductId());
		newOrder.setPayment(product.getPrice());
		newOrder.setStatus(0);
		newOrder.setCreateDate(new Date());
		newOrder.setLastUpdateDate(new Date());

		return orderRepository.save(order);
	}

	@Override
	public Order pay(Order order) {
		order.setStatus(1);
		order.setPaymentDate(new Date());
		order.setLastUpdateDate(new Date());

		return orderRepository.save(order);
	}


	@Override
	public void delete(Long id) {
		orderRepository.deleteById(id);
	}
}
