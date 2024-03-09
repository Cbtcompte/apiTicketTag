package jpa.repositories;

import jpa.models.Tag;
import jpa.repositories.abstracts.Repository;

public class TagRepository extends Repository<Tag>{

    public TagRepository() {
        super("Tag");
    }


    
}
