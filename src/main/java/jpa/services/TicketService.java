package jpa.services;

import java.util.ArrayList;
import java.util.List;

import jpa.dtos.TicketDto;
import jpa.models.Ticket;
import jpa.repositories.TicketRepository;

public class TicketService {
    private TicketRepository ticketRepository;
    private TicketDto ticketDto;

    public TicketService() {
        ticketRepository = new TicketRepository();
        ticketDto = new TicketDto();
    }

   /**
    * This method return all project from database
    *
    * @return List<TicketDto>
    */
    public List<TicketDto> getAllTicket(){
        List<Ticket> t = ticketRepository.selectAll();
        List<TicketDto> ticketDtos = new ArrayList<>();
        if(!t.isEmpty()){
            for (Ticket ticket : t) {
               ticketDtos.add(ticketDto.fromEntity(ticket));
            }
        }
        return ticketDtos;
    }

    /**
    * This method return one project from database. This project is identify by its id
    *
    * @return ticketDto
    */
    public TicketDto getTicket(Long id){
        Ticket p = ticketRepository.findById(id);
        if(p != null){
            return ticketDto.fromEntity(p);
        }

        return ticketDto;
    }

    /**
     * This method is used to add new Ticket data in database
     * @param pD is ticketDto
     * @return ticketDto
     * @throws Exception 
     */
    public TicketDto addTicket(TicketDto tD) throws Exception{
        Ticket t = tD.toEntity();
        ticketRepository.create(t);
        t = ticketRepository.findById(t.getId());
        if(t != null){
            return ticketDto.fromEntity(t);
        }

        return ticketDto;
    }
}
