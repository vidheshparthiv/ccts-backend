package com.ccts.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ccts.springapp.model.Ticket;
import com.ccts.springapp.repository.TicketRepo;

@Service
public class TicketService {
    public TicketRepo tr;
    public TicketService(TicketRepo tr){
        this.tr=tr;
    }
    public Ticket addTicket(Ticket ticket){
        return tr.save(ticket);
    }
    public List<Ticket> getBySorted(String field){
        return tr.findAll(Sort.by(field));
    }
    public List<Ticket> getByPages(int page,int size){
        org.springframework.data.domain.Page<Ticket>p=tr.findAll(PageRequest.of(page, size));
        return p.getContent();
    }
    //get all
    public List<Ticket> getAllTickets(){
        return tr.findAll();
    }

    //get by id
    public Optional<Ticket> getTicketById(int id){
        return tr.findById(id);
    }

    //update Ticket
    public Ticket updateTicket(int id,Ticket Ticket){
        Optional<Ticket>c=tr.findById(id);
        if(c.isEmpty()){
            return null;
        }
        Ticket.setTicketId(id);
        return tr.save(Ticket);
    }

    //delete by id
    public Ticket deleteTicket(int id){
        Optional<Ticket>c=tr.findById(id);
        if(c.isEmpty()){
            return null;
        }
        tr.deleteById(id);
        return c.get();
    }

    //delete all
    public void deleteAllTickets(){
        tr.deleteAll();
    }

    //get all by sorted value
    public List<Ticket> getAllTicketsSorted(String field){//like name etc
        return tr.findAll(Sort.by(field));
    }

}
