package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {

    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        // Vérification du nombre de paramètres
        if (parameters.length < 4) {
            System.err.println("Format attendu : remplacer;debut;fin;chaine");
            return;
        }

        try {
            // Extraction et conversion des paramètres
            int debut = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);
            String remplacement = parameters[3];

            // Appel de la méthode remplacer dans Document
            this.document.remplacer(debut, fin, remplacement);

            // Exécution de la commande
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices début et fin doivent être des entiers.");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Les indices sont hors des limites du document.");
        }
    }
}

