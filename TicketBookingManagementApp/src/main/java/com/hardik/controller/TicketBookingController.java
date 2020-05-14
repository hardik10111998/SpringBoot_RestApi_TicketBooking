package com.hardik.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.modal.Ticket;
import com.hardik.service.TicketBookingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@PostMapping(value="/create")
	@ApiOperation(value = "Create Ticket Details")
	public Ticket createTicket(@RequestBody Ticket ticket){
		return ticketBookingService.createTicket(ticket);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	@ApiOperation(value = "Get Ticket Details By given ID")
	//@RequestMapping(value="/ticket/{ticketId}")
	public Optional<Ticket> getTicketById(@PathVariable("ticketId")Integer ticketId){
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@GetMapping(value="/ticket/alltickets")
	@ApiOperation(value = "Get All Ticket Details")
	public Iterable<Ticket> getAllBookedTickets(){
		return ticketBookingService.getAllBookedTickets();
	}
	
	@DeleteMapping(value="/ticket/{ticketId}")
	@ApiOperation(value = "Delete Ticket Details By Id")
	public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
		ticketBookingService.deleteTicket(ticketId);
	}
	
//	@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
//	public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail")String newEmail){
//		return ticketBookingService.updateTicket(ticketId,newEmail);
//	}
	
	
	@PutMapping(value="/ticket/{ticketId}")
	@ApiOperation(value = "Update Ticket Details By Id with Given details")
	public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId,@RequestBody Ticket ticket){
		return ticketBookingService.updateTicket(ticketId,ticket);
	}
}
