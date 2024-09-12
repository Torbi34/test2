package fr.iut.editeur.document;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.iut.editeur.document.Document;

public class DocumentTest {

    private Document document;

    @BeforeEach
    public void setUp() {
        document = new Document();
    }

    @Test
    public void testAjouter() {
        document.ajouter("Bonjour");
        assertEquals("Bonjour", document.getTexte());

        document.ajouter(" Monde");
        assertEquals("Bonjour Monde", document.getTexte());
    }


    @Test
    public void testRemplacer() {
        document.ajouter("Bonjour Monde");
        document.remplacer(7, 11, "le Monde");
        assertEquals("Bonjour le Monde", document.getTexte());
    }

    @Test
    public void testRemplacerIndicesInvalides() {
        document.ajouter("Bonjour Monde");
        document.remplacer(50, 60, "le Monde"); // indices invalides
        assertEquals("Bonjour Monde", document.getTexte(), "Le texte ne doit pas changer si les indices sont invalides.");
    }

    @Test
    public void testMajuscules() {
        document.ajouter("bonjour monde");
        document.majuscules(0, 7);
        assertEquals("BONJOUR monde", document.getTexte());
    }

    @Test
    public void testMajusculesIndicesInvalides() {
        document.ajouter("bonjour monde");
        document.majuscules(10, 20); // indices invalides
        assertEquals("bonjour monde", document.getTexte(), "Le texte ne doit pas changer si les indices sont invalides.");
    }

    @Test
    public void testEffacer() {
        document.ajouter("Bonjour le Monde");
        document.effacer(7, 10);
        assertEquals("Bonjour Monde", document.getTexte());
    }

    @Test
    public void testEffacerIndicesInvalides() {
        document.ajouter("Bonjour Monde");
        document.effacer(50, 60); // indices invalides
        assertEquals("Bonjour Monde", document.getTexte(), "Le texte ne doit pas changer si les indices sont invalides.");
    }

    @Test
    public void testClear() {
        document.ajouter("Bonjour Monde");
        document.clear();
        assertEquals("", document.getTexte());
    }

    @Test
    public void testToString() {
        document.ajouter("Bonjour Monde");
        assertEquals("Bonjour Monde", document.toString());
    }
}
