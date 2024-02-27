package jpa.builders;

import jpa.asupprimer.Commentaire;
import jpa.models.Collaborateur;
import jpa.models.Ticket;
import jpa.models.associativeTables.Attribuer;

public class AttribuerBuilder {
    private Collaborateur collaborateur;
    private String message;
    private Ticket ticket;

    public AttribuerBuilder setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;

        return this;
    }

    public AttribuerBuilder setMessage(String message) {
        this.message = message;

        return this;
    }


    public AttribuerBuilder setTicket(Ticket tickets) {
        this.ticket = tickets;

        return this;
    }

    public Attribuer build() {
        Attribuer attribuer = new Attribuer();

        attribuer.setMessage(this.message);
        attribuer.setCollaborateur(this.collaborateur);
        attribuer.setTicket(this.ticket);

        return attribuer;
    }
}
