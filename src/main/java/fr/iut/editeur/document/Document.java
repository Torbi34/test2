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

    // Méthode d'insertion
    public void inserer(int position, String texteAInserer) {
        if (position < 0 || position > texte.length()) {
            System.err.println("Position invalide.");
            return;
        }
        String partieGauche = texte.substring(0, position);
        String partieDroite = texte.substring(position);
        texte = partieGauche + texteAInserer + partieDroite;
    }

    public void remplacer(int debut, int fin, String remplacement) {
        if (debut < 0 || fin >= texte.length() || debut > fin) {
            System.err.println("Indices de remplacement invalides.");
            return;
        }
        String partieGauche = texte.substring(0, debut);
        String partieDroite = texte.substring(fin + 1);
        texte = partieGauche + remplacement + partieDroite;
    }

    public void majuscules(int debut, int fin) {
        if (debut < 0 || fin >= texte.length() || debut > fin) {
            System.err.println("Indices de majuscules invalides.");
            return;
        }
        String partieGauche = texte.substring(0, debut);
        String partieDroite = texte.substring(fin);
        texte = partieGauche + texte.substring(debut, fin).toUpperCase() + partieDroite;
    }

    public void effacer(int debut, int fin) {
        if (debut < 0 || fin >= texte.length() || debut > fin) {
            System.err.println("Indices d'effacement invalides.");
            return;
        }
        String partieGauche = texte.substring(0, debut);
        String partieDroite = texte.substring(fin);
        texte = partieGauche + partieDroite;
    }

    public void clear() {
        texte = "";
    }

    @Override
    public String toString() {
        return this.texte;
    }
}
