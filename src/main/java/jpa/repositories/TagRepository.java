package jpa.repositories;

import java.util.List;

import jpa.models.Tag;
import jpa.repositories.subClasses.Repository;

public class TagRepository extends Repository<Tag>{

    public TagRepository() {
        super("Tag");
    }

    public static void main(String[] args) {
		
		TagRepository test = new TagRepository();
        test.getManager();
        List<Tag> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}
    
}
