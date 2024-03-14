package jpa.validations;

import jpa.dtos.ProjetDto;
import jpa.validations.abstracts.Validation;

public class ProjetValidation extends Validation<ProjetDto> {
   
    public void rules(ProjetDto p){
        if(p.getStartProjet() == null){
            this.getMessages().put("startProjet", "La date de démarrage est obligatoire");
            this.setError(true);
        }

        if(p.getEndProjet() == null){
            this.getMessages().put("endProjet", "La date de fin est obligatoire");
            this.setError(true);
        }

        if(p.getTheme() == null || p.getTheme().isEmpty()){
            this.getMessages().put("theme", "Le thème est obligatoire");
            this.setError(true);
        }
    }
}
