package com.masai.service;

import java.util.List;

import com.masai.exception.orderIdException;
import com.masai.model.OrderId;


public interface orderIdService {
	
	public OrderId addOrder(OrderId orderid) throws orderIdException;
	public OrderId updateOrder(OrderId orderid)throws orderIdException;
	public OrderId deleteOrder(Integer bookingId) throws orderIdException;
	public OrderId viewOrderById(Integer bookingId)throws orderIdException;
	public List<OrderId>viewAllOrders()throws orderIdException;
	
	
	

}
