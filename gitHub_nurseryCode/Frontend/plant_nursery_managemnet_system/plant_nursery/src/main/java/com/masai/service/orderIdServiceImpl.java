package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.orderIdException;
import com.masai.exception.plantException;
import com.masai.model.OrderId;
import com.masai.model.Plant;
import com.masai.repository.orderIdDao;


@Service
public class orderIdServiceImpl implements orderIdService{
	
	@Autowired
	private orderIdDao getorderIdDao;

	@Override
	public OrderId addOrder(OrderId orderid) throws orderIdException {
		
		
	    OrderId saveOrder=getorderIdDao.save(orderid);
	    
	    if(saveOrder==null) {
	    	throw new orderIdException("this orderID is already added");
	    	
	    }else {
	    	return saveOrder;
	    }
	    
	}

	@Override
	public OrderId updateOrder(OrderId orderid) throws orderIdException {
		
		Optional<OrderId> updateorder=getorderIdDao.findById(orderid.getBookingOrderId());
		
		if(updateorder.isPresent()) {
			return getorderIdDao.save(orderid);
		}else {
			throw new orderIdException("this orderID is not found");
		}
		
	}

	@Override
	public OrderId deleteOrder(Integer bookingId) throws orderIdException {
		Optional<OrderId> deleteorder=getorderIdDao.findById(bookingId);
		
		if(deleteorder.isPresent()) {
			OrderId delorder=deleteorder.get();
			
			getorderIdDao.delete(delorder);
			return delorder;
		}
		else {
			throw new orderIdException("this orderID is not found");
		}
		
	}

	@Override
	public OrderId viewOrderById(Integer bookingId) throws orderIdException {
		Optional<OrderId> vieworder= getorderIdDao.findById(bookingId);
		
		if(vieworder.isPresent()) {
			OrderId ord= vieworder.get();
			
			return ord;
		}else {
			throw new orderIdException("there is no order to view");
		}
		
	}

	@Override
	public List<OrderId> viewAllOrders() throws orderIdException {
   List<OrderId> allorder= getorderIdDao.findAll();
		
		if(allorder.size()>0) {
			return allorder;
		}else {
			throw new orderIdException("no orders are available");
		}
		
		
	}

}
