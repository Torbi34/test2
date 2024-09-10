package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeInserer extends CommandeDocument {

    public CommandeInserer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : inserer;position;texte");
            return;
        }
        try {
            int position = Integer.parseInt(parameters[1]);
            String texte = parameters[2];
            this.document.inserer(position, texte);
        } catch (NumberFormatException e) {
            System.err.println("La position doit être un entier valide.");
        }
        super.executer();
    }

    @Override
    public String getDescriptionCommande() {
        return "Insère le texte spécifié à la position donnée dans le document. Format: inserer;position;texte";
    }
}
