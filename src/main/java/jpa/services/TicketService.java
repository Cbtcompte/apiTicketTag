package jpa.services;

import jpa.dtos.TicketDto;
import jpa.models.Ticket;
import jpa.repositories.TicketRepository;

import java.util.ArrayList;
import java.util.List;

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
        ticketRepository.getManager();
        List<Ticket> t = ticketRepository.selectAll();
        ticketRepository.closeManager();
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
     * @return TicketDto
     */
    public TicketDto getTicket(Long id){
        ticketRepository.getManager();
        Ticket t = ticketRepository.findById(id);
        ticketRepository.closeManager();
        if(t != null){
            return ticketDto.fromEntity(t);
        }

        return ticketDto;
    }

    /**
     * This method is used to add new ticket data in database
     * @param tD is TicketDto
     * @return TicketDto
     */
    public TicketDto addTicket(TicketDto tD){
        Ticket t = tD.toEntity();
        ticketRepository.getManager();
        ticketRepository.create(t);
        t = ticketRepository.findById(t.getId());
        if(t != null){
            return ticketDto.fromEntity(t);
        }

        return ticketDto;
    }

    public void deleteTicket(Long id){
        ticketRepository.getManager();
        ticketRepository.delete(id);

    }

    }
