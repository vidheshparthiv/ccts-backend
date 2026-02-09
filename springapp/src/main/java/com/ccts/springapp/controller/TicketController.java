package com.ccts.springapp.controller; 
@RestController
public class TicketController {
    public TicketService ts;
    public TicketController(TicketService ts){
        this.ts=ts;
    }
    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        Ticket t=ts.addTicket(ticket);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }
    @GetMapping("/sorted/{field}")
    public ResponseEntity<List<Ticket>> getBySorted(@PathVariable String field){
        return new ResponseEntity<>(ts.getBySorted(field),HttpStatus.OK);
    }
    @GetMapping("/pages/{page}/{size}")
    public ResponseEntity<List<Ticket>> getByPages(@PathVariable int page,@PathVariable int size){
        return new ResponseEntity<>(ts.getByPages(page, size),HttpStatus.OK);
    }
}
