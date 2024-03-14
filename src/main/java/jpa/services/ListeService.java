package jpa.services;

import jpa.dtos.ListeDto;
import jpa.models.Liste;
import jpa.repositories.ListeRepository;
import jpa.repositories.ProjetRepository;
import jpa.services.abstracts.Service;

import java.util.ArrayList;
import java.util.List;

public class ListeService implements Service<ListeDto>{
    
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
    @Override
    public List<ListeDto> getAll(){
        List<Liste> l = listeRepository.selectAll();
        List<ListeDto> listeDtos = new ArrayList<>();
        if(!l.isEmpty()){
            for (Liste liste : l) {
                listeDtos.add(listeDto.fromEntity(liste));
            }
        }
        // System.out.println(l.get(0));
        return listeDtos;
    }

    /**
    * This method return one project from database. This project is identify by its id
    *
    * @return ListeDto
    */
    @Override
    public ListeDto get(Long id){
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
    @Override
    public ListeDto add(ListeDto ld) throws Exception{
        ProjetRepository pr = new ProjetRepository();
        Liste l = ld.toEntity(pr.findById(ld.getProjet()));
        listeRepository.create(l);
        l = listeRepository.findById(l.getId());
        if(l != null){
            return listeDto.fromEntity(l);
        }

        return listeDto;
    }

    @Override
    public void delete(Long id){
        listeRepository.getManager();
        listeRepository.delete(id);
    }

}
