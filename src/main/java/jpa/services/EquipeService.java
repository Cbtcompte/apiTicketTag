package jpa.services;

import java.util.ArrayList;
import java.util.List;

import jpa.dtos.EquipeDto;
import jpa.models.Equipe;
import jpa.repositories.EquipeRepository;
import jpa.services.interfaces.Service;

public class EquipeService implements Service<EquipeDto> {

    private EquipeRepository equipeRepository;
    private EquipeDto equipeDto;

    public EquipeService() {
        equipeRepository = new EquipeRepository();
        equipeDto = new EquipeDto();
    }


    @Override
    public List<EquipeDto> getAll() {
        List<Equipe> e = equipeRepository.selectAll();
        List<EquipeDto> equipeDtos = new ArrayList<>();
        if(!e.isEmpty()){
            for (Equipe equipe : e) {
               equipeDtos.add(equipeDto.fromEntity(equipe));
            }
        }
        return equipeDtos;
    }

    @Override
    public EquipeDto get(Long id) {
        // TODO Auto-generated method stub
        Equipe e = equipeRepository.findByIdWithJoinFetch("listes", id);
        if(e != null){
            return equipeDto.fromEntity(e);
        }
        return equipeDto;
    }

    @Override
    public EquipeDto add(EquipeDto ed) throws Exception {
        Equipe e = ed.toEntity();
        equipeRepository.create(e);
        e = equipeRepository.findById(e.getId());
        if(e != null){
            return equipeDto.fromEntity(e);
        }

        return equipeDto;
    }

    @Override
    public EquipeDto update(EquipeDto eD, Long id) throws Exception {
        Equipe eq = equipeRepository.findById(id);
        eq.setName(eD.getName());
        try {
            equipeRepository.update(eq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(eq != null){
            return equipeDto.fromEntity(eq);
        }
        return equipeDto;
    }

    @Override
    public void delete(Long id) {
        equipeRepository.getManager();
        equipeRepository.delete(id);

    }
    
}
