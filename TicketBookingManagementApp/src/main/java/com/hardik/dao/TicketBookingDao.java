package com.hardik.dao;


import org.springframework.data.repository.CrudRepository;

import com.hardik.modal.Ticket;



public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
