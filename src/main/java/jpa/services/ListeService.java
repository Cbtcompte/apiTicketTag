package jpa.services;

import jpa.dtos.ListeDto;
import jpa.models.Liste;
import jpa.repositories.ListeRepository;

import java.util.ArrayList;
import java.util.List;

public class ListeService {
    
    private ListeRepository listeRepository;
    private ListeDto listeDto;

    public ListeService() {
        listeRepository = new ListeRepository();
        listeDto = new ListeDto();
    }

    /**
     * This method return all listes from database
     *
     * @return List<ListeDto>
     */
    public List<ListeDto> getAllListe(){
        listeRepository.getManager();
        List<Liste> l = listeRepository.selectAll();
        listeRepository.closeManager();
        List<ListeDto> listeDtos = new ArrayList<>();
        if(!l.isEmpty()){
            for (Liste liste : l) {
                listeDtos.add(listeDto.fromEntity(liste));
            }
        }
        return listeDtos;
    }

    /**
     * This method return one liste from database. This liste is identify by its id
     *
     * @return ListeDto
     */
    public ListeDto getListe(Long id){
        listeRepository.getManager();
        Liste l = listeRepository.findById(id);
        listeRepository.closeManager();
        if(l != null){
            return listeDto.fromEntity(l);
        }

        return listeDto;
    }

    /**
     * This method is used to add new liste data in database
     * @param lD is ListeDto
     * @return ListeDto
     */
    public ListeDto addListe(ListeDto lD){
        Liste l = lD.toEntity();
        listeRepository.getManager();
        listeRepository.create(l);
        l = listeRepository.findById(l.getId());
        if(l != null){
            return listeDto.fromEntity(l);
        }

        return listeDto;
    }

    public void deleteListe(Long id){
        listeRepository.getManager();
        listeRepository.delete(id);

    }

}
