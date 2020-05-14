package com.hardik;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hardik.modal.Ticket;
import com.hardik.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingManagementAppApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(TicketBookingManagementAppApplication.class, args);
		
		TicketBookingService ticketBookingService = applicationContext.getBean("ticketBookingService", TicketBookingService.class);
		//this is just dummy data for durby databse
		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestStation("Gandhinagar");
		ticket.setSourceStation("Ahemdabad");
		ticket.setPassengerName("HArdik");
		ticket.setEmail("Hardik@yahoo.com");
		
		ticketBookingService.createTicket(ticket);
	}

}
