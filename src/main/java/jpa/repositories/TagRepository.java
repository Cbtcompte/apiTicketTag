package jpa.repositories;

import java.util.List;

import jpa.models.Tag;
import jpa.repositories.subClasses.Repository;

public class TagRepository extends Repository<Tag>{

    public TagRepository() {
        super("Tag");
    }


    
}
