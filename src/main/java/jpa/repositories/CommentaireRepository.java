package jpa.repositories;

import java.util.List;

import jpa.asupprimer.Commentaire;
import jpa.repositories.subClasses.Repository;

public class CommentaireRepository extends Repository<Commentaire>{
    public CommentaireRepository() {
        super("Commentaire");
    }

    public static void main(String[] args) {
		
		CommentaireRepository test = new CommentaireRepository();
        test.getManager();
        List<Commentaire> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}
}
                        