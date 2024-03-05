package jpa.repositories;

import jpa.models.Tag;
import jpa.repositories.subClasses.Repository;

public class TagRepository extends Repository<Tag>{

    public TagRepository() {
        super("Tag");
    }


    
}
