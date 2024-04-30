package jpa.validations;

import jpa.dtos.EquipeDto;
import jpa.validations.abstracts.Validation;

public class EquipeValidation extends Validation<EquipeDto> {
   
    public void rules(EquipeDto e){
       
        if(e.getName() == null || e.getName().isEmpty()){
            this.getMessages().put("name", "Le nom est obligatoire");
            this.setError(true);
        }
    }
}
