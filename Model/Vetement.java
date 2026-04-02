
import java.io.*;
import java.util.*;

public class Vetement extends Article {
    public Vetement(String nom, String marque, double prix, int stock,
            String sport, String taille, String couleur) {
        super(nom, marque, prix, stock, sport);
        this.tailleVetement = taille;
        this.couleurVetement = couleur;
    }

    private String tailleVetement;
    private String couleurVetement;

    public String getTailleVetement() {
        return this.tailleVetement;
    }

    public String getCouleurVetement() {
        return this.couleurVetement;
    }

    public void setTailleVetement(String newTaille) {
        this.tailleVetement = newTaille;
    }

    public void setCouleurVetement(String newCouleur) {
        this.couleurVetement = newCouleur;
    }

    public void afficherArticles() {
        super.afficherArticles();
        System.out.println(" | taille : " + this.getTailleVetement()
                + " | couleur : " + this.getCouleurVetement());

    }
}