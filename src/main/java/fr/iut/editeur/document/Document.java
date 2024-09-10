package fr.iut.editeur.document;

public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }

    public void remplacer(int debut, int fin, String remplacement) {
        String partieGauche = texte.substring(0, debut);
        String partieDroite = texte.substring(fin + 1);
        texte = partieGauche + remplacement + partieDroite;
    }

    public void majuscules(int debut, int fin) {
        // Vérification que les indices sont valides
        if (debut < 0 || fin >= texte.length() || debut > fin) {
            System.err.println("Indices invalides");
            return;
        }

        // Extraire la portion de texte à mettre en majuscules
        String portion = texte.substring(debut, fin + 1);

        // Convertir la portion en majuscules
        String portionMajuscules = portion.toUpperCase();

        // Remplacer la portion dans le texte avec la méthode remplacer
        remplacer(debut, fin, portionMajuscules);
    }
    public void minuscule(int debut, int fin) {
        // Vérification que les indices sont valides
        if (debut < 0 || fin >= texte.length() || debut > fin) {
            System.err.println("Indices invalides");
            return;
        }

        // Extraire la portion de texte à mettre en majuscules
        String portion = texte.substring(debut, fin + 1);

        // Convertir la portion en majuscules
        String portionMajuscules = portion.toLowerCase();

        // Remplacer la portion dans le texte avec la méthode remplacer
        remplacer(debut, fin, portionMajuscules);
    }
    public void effacer(int debut, int fin) {
        // Vérification que les indices sont valides
        if (debut < 0 || fin >= texte.length() || debut > fin) {
            System.err.println("Indices invalides");
            return;
        }


        // Utilisation de la méthode remplacer avec une chaîne vide pour supprimer le texte
        remplacer(debut, fin, "");
    }

    public void clear() {
        this.texte = "";
    }
    public void inserer() {
        this.texte += "*inserer*";
    }





    @Override
    public String toString() {
        return this.texte;
    }
}
