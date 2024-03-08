package jpa.services;

import jpa.dtos.CollaborateurDto;
import jpa.models.Collaborateur;
import jpa.repositories.CollaborateurRepository;

import java.util.ArrayList;
import java.util.List;

public class CollaborateurService {

    private CollaborateurRepository collaborateurRepository;
    private CollaborateurDto collaborateurDto;

    public CollaborateurService() {
        collaborateurRepository = new CollaborateurRepository();
        collaborateurDto = new CollaborateurDto();
    }

    /**
     * This method return all collaborateur from database
     *
     * @return List<CollaborateurDto>
     */
    public List<CollaborateurDto> getAllCollaborateur(){
        collaborateurRepository.getManager();
        List<Collaborateur> c = collaborateurRepository.selectAll();
        collaborateurRepository.closeManager();
        List<CollaborateurDto> collaborateurDtos = new ArrayList<>();
        if(!c.isEmpty()){
            for (Collaborateur collaborateur : c) {
                collaborateurDtos.add(collaborateurDto.fromEntity(collaborateur));
            }
        }
        return collaborateurDtos;
    }

    /**
     * This method return one collaborateur from database. This collaborateur is identify by its id
     *
     * @return CollaborateurDto
     */
    public CollaborateurDto getCollaborateur(Long id){
        collaborateurRepository.getManager();
        Collaborateur c = collaborateurRepository.findById(id);
        collaborateurRepository.closeManager();
        if(c != null){
            return collaborateurDto.fromEntity(c);
        }

        return collaborateurDto;
    }

    /**
     * This method is used to add new collaborateur data in database
     * @param cD is collaborateurDto
     * @return CollaborateurDto
     */
    public CollaborateurDto addCollaborateur(CollaborateurDto cD){
        Collaborateur c = cD.toEntity();
        collaborateurRepository.getManager();
        collaborateurRepository.create(c);
        c = collaborateurRepository.findById(c.getId());
        if(c != null){
            return collaborateurDto.fromEntity(c);
        }

        return collaborateurDto;
    }

    public void deleteCollaborateur(Long id){
        collaborateurRepository.getManager();
        collaborateurRepository.delete(id);

    }

    }
