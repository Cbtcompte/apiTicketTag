package jpa.validations;

import jpa.dtos.TagDto;
import jpa.validations.abstracts.Validation;

public class TagValidation extends Validation<TagDto> {

    @Override
    public void rules(TagDto t) {
        if(t.getCouleur() == null || t.getCouleur().isEmpty()){
            this.getMessages().put("couleur", "La couleur est obligatoire");
            this.setError(true);
        }

        if(t.getLibelle() == null || t.getLibelle().isEmpty()){
            this.getMessages().put("libelle", "Le libellé est obligatoire");
            this.setError(true);
        }
    }
    
}
