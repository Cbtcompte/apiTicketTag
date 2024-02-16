package jpa.repositories;

import java.util.List;

import jpa.models.Comments;
import jpa.repositories.subClasses.Repository;

public class CommentRepository extends Repository<Comments>{
    public CommentRepository() {
        super("Comments");
    }

    public static void main(String[] args) {
		
		CommentRepository test = new CommentRepository();
        test.getManager();
        List<Comments> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}
}
