package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeClear extends CommandeDocument {

    public CommandeClear(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        // Appel de la méthode clear dans Document
        this.document.clear();

        // Exécution de la commande
        super.executer();

    }
}
