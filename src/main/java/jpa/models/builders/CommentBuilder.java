package jpa.models.builders;

import jpa.models.Comments;
import jpa.models.Tickets;
import jpa.models.Utilisateurs;

public class CommentBuilder {
    private Utilisateurs utilisateur;
    private String comment;
    private Tickets ticket;

    public CommentBuilder setComment(String comment) {
        this.comment = comment;

        return this;
    }

    public CommentBuilder setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;

        return this;
    }

    public CommentBuilder setTicket(Tickets tickets) {
        this.ticket = tickets;

        return this;
    }

    public Comments build() {
        Comments comments = new Comments();

        comments.setComment(this.comment);
        comments.setUtilisateur(this.utilisateur);
        comments.setTicket(this.ticket);

        return comments;
    }
}
