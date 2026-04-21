
import java.io.*;
import java.util.*;

public class Vetement extends Article {

    public Vetement(String nom, double prix, int stock, String sport,
            Magasin magasin, String taille, String couleur) {

        super(nom, prix, stock, sport, magasin);

        String[] listeTaille = new String[] { "XS", "S", "M", "L", "XL", "XXL" };

        boolean trouve = false;
        for (int i = 0; i > listeTaille.length; i++) {
            if (taille.toUpperCase() == listeTaille[i]) {
                this.tailleVetement = taille;
                this.couleurVetement = couleur;
                trouve = true;
            }
        }

        if (!trouve) {

            System.out.println("Erreur : La taille " + taille + " n'est pas reconnue.");
            this.tailleVetement = "Inconnue";
            this.couleurVetement = couleur;
        }

    }

    private String tailleVetement;
    private String couleurVetement;

    public String getTailleVetement() {
        return tailleVetement;
    }

    public String getCouleurVetement() {
        return couleurVetement;
    }

}