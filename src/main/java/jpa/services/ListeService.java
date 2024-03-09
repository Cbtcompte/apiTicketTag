package jpa.services;

import java.util.ArrayList;
import java.util.List;

import jpa.dtos.ListeDto;
import jpa.models.Liste;
import jpa.repositories.ListeRepository;

public class ListeService {
    private ListeRepository listeRepository;
    private ListeDto listeDto;

    public ListeService() {
        listeRepository = new ListeRepository();
        listeDto = new ListeDto();
    }

   /**
    * This method return all project from database
    *
    * @return List<ListeDto>
    */
    public List<ListeDto> getAllListe(){
        List<Liste> l = listeRepository.selectAll();
        List<ListeDto> listeDtos = new ArrayList<>();
        if(!l.isEmpty()){
            for (Liste Liste : l) {
               listeDtos.add(listeDto.fromEntity(Liste));
            }
        }
        return listeDtos;
    }

    /**
    * This method return one project from database. This project is identify by its id
    *
    * @return ListeDto
    */
    public ListeDto getListe(Long id){
        Liste p = listeRepository.findById(id);
        if(p != null){
            return listeDto.fromEntity(p);
        }

        return listeDto;
    }

    /**
     * This method is used to add new Liste data in database
     * @param pD is ListeDto
     * @return ListeDto
     * @throws Exception 
     */
    public ListeDto addListe(ListeDto tD) throws Exception{
        Liste t = tD.toEntity();
        listeRepository.create(t);
        t = listeRepository.findById(t.getId());
        if(t != null){
            return listeDto.fromEntity(t);
        }

        return listeDto;
    }
}
