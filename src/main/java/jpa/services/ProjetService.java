package jpa.services;

import java.util.ArrayList;
import java.util.List;

import jpa.dtos.ProjetDto;
import jpa.models.Projet;
import jpa.repositories.ProjetRepository;

public class ProjetService {

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
    public List<ProjetDto> getAllProjet(){
        projetRepository.getManager();
        List<Projet> p = projetRepository.selectAll();
        projetRepository.closeManager();
        List<ProjetDto> projetDtos = new ArrayList<>();
        if(!p.isEmpty()){
            for (Projet projet : p) {
               projetDtos.add(projetDto.fromEntity(projet));
            }
        }
        return projetDtos;
    }

    /**
    * This method return one project from database. This project is identify by its id
    *
    * @return ProjetDto
    */
    public ProjetDto getProjet(Long id){
        projetRepository.getManager();
        Projet p = projetRepository.findById(id);
        projetRepository.closeManager();
        if(p != null){
            return projetDto.fromEntity(p);
        }

        return projetDto;
    }

    /**
     * This method is used to add new projet data in database
     * @param pD is ProjetDto
     * @return ProjetDto
     */
    public ProjetDto addProjet(ProjetDto pD){
        Projet p = pD.toEntity();
        projetRepository.getManager();
        projetRepository.create(p);
        p = projetRepository.findById(p.getId());
        if(p != null){
            return projetDto.fromEntity(p);
        }

        return projetDto;
    }

    public void deleteProjet(Long id){
        projetRepository.getManager();
        projetRepository.delete(id);

    }
    
}
