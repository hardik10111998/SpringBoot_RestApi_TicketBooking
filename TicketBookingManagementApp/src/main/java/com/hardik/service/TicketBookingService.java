package com.hardik.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardik.dao.TicketBookingDao;
import com.hardik.modal.Ticket;



@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}
	public Optional<Ticket> getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId);
	}
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}
	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}
//	public Ticket updateTicket(Integer ticketId, String newEmail) {
//		Ticket ticketFromDb = (Ticket)ticketBookingDao.findById(ticketId);
//		ticketFromDb.setEmail(newEmail);
//		Ticket upadedTicket = ticketBookingDao.save(ticketFromDb);
//		return upadedTicket;
//	}
	
	public Ticket updateTicket(Integer ticketId, Ticket ticket) {
//		
//		if(ticketBookingDao.existsById(ticketId)){
//			Ticket upadedTicket = ticketBookingDao.save(ticket);
//			return upadedTicket;
//		}
//		else return null;
		Ticket ticketFromDb = ticketBookingDao.findById(ticketId).orElseThrow();
		//setting old details to new and save it.
		ticketFromDb.setTicketId(ticket.getTicketId());
		ticketFromDb.setBookingDate(ticket.getBookingDate());
		ticketFromDb.setDestStation(ticket.getDestStation());
		ticketFromDb.setEmail(ticket.getEmail());
		ticketFromDb.setPassengerName(ticket.getPassengerName());
		ticketFromDb.setSourceStation(ticket.getSourceStation());
		
		Ticket upadedTicket = ticketBookingDao.save(ticketFromDb);
		return upadedTicket;
		
		
	}
}
