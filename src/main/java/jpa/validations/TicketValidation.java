package jpa.validations;

import jpa.dtos.TicketDto;
import jpa.validations.abstracts.Validation;

public class TicketValidation extends Validation<TicketDto>{
    
    @Override
    public void rules(TicketDto t) {
        if( t.getLibelle() == null || t.getLibelle().isEmpty()){
            this.getMessages().put("libelle", "Le libellé est obligatoire");
            this.setError(true);
        }

        if(t.getListe() == null){
            this.getMessages().put("liste", "Le choix de la liste est obligatoire");
            this.setError(true);
        }
    }
    
}
