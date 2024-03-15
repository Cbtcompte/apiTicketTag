package jpa.services;

import jpa.dtos.ListeDto;
import jpa.dtos.TicketDto;
import jpa.models.Liste;
import jpa.models.Ticket;
import jpa.repositories.ListeRepository;
import jpa.repositories.TicketRepository;
import jpa.services.abstracts.Service;

import java.util.ArrayList;
import java.util.List;

public class TicketService implements Service<TicketDto>{
    
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
    @Override
    public List<TicketDto> getAll(){
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
     * @return TicketDto
     */
    @Override
    public TicketDto get(Long id){
        Ticket t = ticketRepository.findById(id);
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
    @Override
    public TicketDto add(TicketDto tD){
        Liste l = (new ListeRepository()).findById(tD.getListe());
        Ticket t = tD.toEntity(l);
        try {
            ticketRepository.create(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t = ticketRepository.findById(t.getId());
        if(t != null){
            return ticketDto.fromEntity(t);
        }

        return ticketDto;
    }

    @Override
    public void delete(Long id){
        ticketRepository.delete(id);

    }

    public TicketDto getWithOthersRelations(String champ, String tableAssociate, Object value){
        Ticket t = ticketRepository.selectWithJoinFetchAndWhereClause(champ, tableAssociate, value);
        if(t != null){
            return ticketDto.fromEntity(t);
        }

        return ticketDto;
    }

}
