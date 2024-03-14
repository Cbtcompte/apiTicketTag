package jpa.validations;

import jpa.dtos.ListeDto;
import jpa.validations.abstracts.Validation;

public class ListeValidation extends Validation<ListeDto>{

    @Override
    public void rules(ListeDto l) {
        if(l.getTitre() == null || l.getTitre().isEmpty()){
            this.getMessages().put("titre", "Le titre est obligatoire");
            this.setError(true);
        }
        if(l.getProjet() == null){
            this.getMessages().put("projet", "Le projet doit être défini");
            this.setError(true);
        }
    }
    
}
