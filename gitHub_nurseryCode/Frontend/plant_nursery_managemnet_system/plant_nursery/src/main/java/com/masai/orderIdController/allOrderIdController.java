package com.masai.orderIdController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.orderIdException;
import com.masai.model.OrderId;
import com.masai.service.orderIdService;


@CrossOrigin(origins = "*")
@RestController
public class allOrderIdController {
	
	@Autowired
	private orderIdService getorIdService;
	
	@PostMapping("naturenursery/addOrderId")
	public ResponseEntity<OrderId> addorderHandler(@RequestBody OrderId orderid)throws orderIdException{
		
		OrderId orderCon= getorIdService.addOrder(orderid);
		
		return new ResponseEntity<OrderId>(orderCon,HttpStatus.CREATED);
	}
	
	@PutMapping("naturenursery/updateOrderId")
	public ResponseEntity<OrderId> updateorderHandler(@RequestBody OrderId orderid)throws orderIdException{
		OrderId orderupdate= getorIdService.updateOrder(orderid);
		
		return new ResponseEntity<OrderId>(orderupdate,HttpStatus.OK);
		
	}
	
	@DeleteMapping("naturenursery/deleteOrderId/{orderid}")
	public ResponseEntity<OrderId> deleteOrderHandler(@PathVariable("orderid") Integer orderid) throws orderIdException{
		
		OrderId deleteorder =getorIdService.deleteOrder(orderid);
		
		return new ResponseEntity<OrderId>(deleteorder,HttpStatus.OK);
	}
	
	
	@GetMapping("naturenursery/getOrderByBookingID/{orderid}")
	public ResponseEntity<OrderId> viewOrderIdByBookingId(@PathVariable("orderid") Integer orderid) throws orderIdException{
		OrderId vieworder= getorIdService.viewOrderById(orderid);
		
		return new ResponseEntity<OrderId>(vieworder,HttpStatus.OK);
				
	}
	
	@GetMapping("naturenursery/allOrderDetails")
	public ResponseEntity<List<OrderId>> vieworderAllOder()throws orderIdException{
		
		List<OrderId> allorder= getorIdService.viewAllOrders();
		
		return new ResponseEntity<List<OrderId>>(allorder,HttpStatus.OK);
		
	}
	
	

}
