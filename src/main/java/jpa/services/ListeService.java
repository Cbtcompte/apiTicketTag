package jpa.services;

import jpa.dtos.ListeDto;
import jpa.dtos.ProjetDto;
import jpa.models.Liste;
import jpa.models.Projet;
import jpa.repositories.ListeRepository;
import jpa.repositories.ProjetRepository;
import jpa.services.interfaces.Service;

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
        List<Liste> l = listeRepository.selectWithLeftJoinFetch("tickets");
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
        Liste p = listeRepository.findByIdWithJoinFetch("tickets", id);
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

    // public ListeDto getWithOthersRelations(String champ, Object value){
    //     List<Liste> l = listeRepository.selectWithJoinFetchAndWhereClause(champ, "tickets", value);
    //     if(l != null){
    //         return listeDto.fromEntity(l);
    //     }

    //     return listeDto;
    // }

    @Override
    public ListeDto update(ListeDto t, Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public List<ListeDto> getListeByProjetId(Long id) {
        Projet p = new ProjetRepository().findById(id);
        if(p == null){
            return null;
        }
        List<Liste> l = listeRepository.selectWithJoinFetchAndWhereClause("projet", "tickets", p);
        List<ListeDto> listeDtos = new ArrayList<>();

        if(!l.isEmpty()){
            for (Liste liste : l) {
                listeDtos.add(listeDto.fromEntity(liste));
            }
        }
        return listeDtos;
    }

}
