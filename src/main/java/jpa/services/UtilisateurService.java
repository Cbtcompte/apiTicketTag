package jpa.services;

import jpa.dtos.UtilisateurDto;
import jpa.models.Utilisateur;
import jpa.repositories.UtilisateurRepository;
import jpa.services.interfaces.Service;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurService implements Service<UtilisateurDto>{
    
    private UtilisateurRepository utilisateurRepository;
    private UtilisateurDto utilisateurDto;

    public UtilisateurService() {
        utilisateurRepository = new UtilisateurRepository();
        utilisateurDto = new UtilisateurDto();
    }

    /**
     * This method return all utilisateur from database
     *
     * @return List<UtilisateurDto>
     */
    @Override
    public List<UtilisateurDto> getAll(){
        List<Utilisateur> u = utilisateurRepository.selectAll();
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        if(!u.isEmpty()){
            for (Utilisateur utilisateur : u) {
                utilisateurDtos.add(utilisateurDto.fromEntity(utilisateur));
            }
        }
        return utilisateurDtos;
    }

    /**
     * This method return one utilisateur from database. This utilisateur is identify by its id
     *
     * @return UtilisateurDto
     */
    @Override
    public UtilisateurDto get(Long id){
        Utilisateur u = utilisateurRepository.findById(id);
        if(u != null){
            return utilisateurDto.fromEntity(u);
        }

        return utilisateurDto;
    }

    /**
     * This method is used to add new utilisateur data in database
     * @param uD is UtilisateurDto
     * @return UtilisateurDto
     */
    @Override
    public UtilisateurDto add(UtilisateurDto uD){
        Utilisateur u = uD.toEntity();
        try {
            utilisateurRepository.create(u);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        u = utilisateurRepository.findById(u.getId());
        if(u != null){
            return utilisateurDto.fromEntity(u);
        }

        return utilisateurDto;
    }

    @Override
    public void delete(Long id){
        utilisateurRepository.delete(id);
    }

    @Override
    public UtilisateurDto update(UtilisateurDto uD, Long id) throws Exception {
        Utilisateur u = utilisateurRepository.findById(id);
        u.setName(uD.getName());
        u.setEmail(uD.getEmail());
        try {
            utilisateurRepository.update(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(u != null){
            return utilisateurDto.fromEntity(u);
        }
        return utilisateurDto;
    }

}
