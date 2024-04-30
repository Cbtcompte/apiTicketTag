package jpa.services;

import java.util.ArrayList;
import java.util.List;

import jpa.dtos.ProjetDto;
import jpa.models.Projet;
import jpa.repositories.ProjetRepository;
import jpa.services.interfaces.Service;

public class ProjetService implements Service<ProjetDto>{

    private ProjetRepository projetRepository;
    private ProjetDto projetDto;

    public ProjetService() {
        projetRepository = new ProjetRepository();
        projetDto = new ProjetDto();
    }

   /**
     * This method return all project from database
     *
     * @return List<ProjetDto>
    */
    @Override
    public List<ProjetDto> getAll(){
        List<Projet> p = projetRepository.selectAll();
        List<ProjetDto> projetDtos = new ArrayList<>();
        if(!p.isEmpty()){
            for (Projet projet : p) {
               projetDtos.add(projetDto.fromEntityWithoutList(projet));
            }
        }
        return projetDtos;
    }

    /**
     * This method return one project from database. This project is identify by its id
     *
     * @return ProjetDto
    */
    @Override
    public ProjetDto get(Long id){
        // String[] tableAssociation = {"listes", "tickets"};
        Projet p = projetRepository.findByIdWithJoinFetch("listes", id);
        if(p != null){
            return projetDto.fromEntity(p);
        }
        return projetDto;
    }
    

    // /**
    //  * This method return one project from database. This project is identify by its id
    //  *
    //  * @return ProjetDto
    // */
    // public ProjetDto getWithOthersRelations(String champ, Object value){
    //     Projet p = projetRepository.selectWithJoinFetchAndWhereClause(champ, "listes", value);
    //     if(p != null){
    //         return projetDto.fromEntity(p);
    //     }

    //     return projetDto;
    // }


    /**
     * This method is used to add new projet data in database
     * @param pD is ProjetDto
     * @return ProjetDto
     * @throws Exception 
     */
    @Override
    public ProjetDto add(ProjetDto pD) throws Exception{
        Projet p = pD.toEntity();
        projetRepository.create(p);
        p = projetRepository.findById(p.getId());
        if(p != null){
            return projetDto.fromEntity(p);
        }

        return projetDto;
    }

    @Override
    public void delete(Long id){
        projetRepository.getManager();
        projetRepository.delete(id);

    }

    @Override
    public ProjetDto update(ProjetDto pD, Long id) throws Exception {
        Projet t = projetRepository.findById(id);
        t.setTheme(pD.getTheme());
        t.setDescription(pD.getDescription());
        t.setStartProjet(pD.getStartProjet());
        t.setEndProjet(pD.getEndProjet());
        try {
            projetRepository.update(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(t != null){
            return projetDto.fromEntity(t);
        }
        return projetDto;
    }
}
