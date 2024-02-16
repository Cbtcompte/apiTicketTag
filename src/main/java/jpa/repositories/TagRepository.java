package jpa.repositories;

import java.util.List;

import jpa.models.Tags;
import jpa.repositories.subClasses.Repository;

public class TagRepository extends Repository<Tags>{

    public TagRepository() {
        super("Tags");
    }

    public static void main(String[] args) {
		
		TagRepository test = new TagRepository();
        test.getManager();
        List<Tags> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}
    
}
