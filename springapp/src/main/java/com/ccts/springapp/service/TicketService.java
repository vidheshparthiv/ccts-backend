package com.ccts.springapp.service;

import java.util.List;

import org.hibernate.query.Page;
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
}
