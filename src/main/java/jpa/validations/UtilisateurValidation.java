package jpa.validations;

import jpa.dtos.UtilisateurDto;
import jpa.validations.abstracts.Validation;

public class UtilisateurValidation extends Validation<UtilisateurDto>{

    @Override
    public void rules(UtilisateurDto t) {
        if(t.getName() == null || t.getName().isEmpty()){
            this.getMessages().put("name", "Le nom est obligatoire");
            this.setError(true);
        }

        if( t.getEmail() == null || t.getEmail().isEmpty()){
            this.getMessages().put("email", "L'adresse mail est obligatoire");
            this.setError(true);
        }
    }
    
}
