package jpa.services;

import jpa.dtos.UtilisateurDto;
import jpa.models.Utilisateur;
import jpa.repositories.UtilisateurRepository;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurService {
    
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
    public List<UtilisateurDto> getAllUtilisateur(){
        utilisateurRepository.getManager();
        List<Utilisateur> u = utilisateurRepository.selectAll();
        utilisateurRepository.closeManager();
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
    public UtilisateurDto getUtilisateur(Long id){
        utilisateurRepository.getManager();
        Utilisateur u = utilisateurRepository.findById(id);
        utilisateurRepository.closeManager();
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
    public UtilisateurDto addUtilisateur(UtilisateurDto uD){
        Utilisateur u = uD.toEntity();
        utilisateurRepository.getManager();
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

    public void deleteUtilisateur(Long id){
        utilisateurRepository.getManager();
        utilisateurRepository.delete(id);

    }

}
