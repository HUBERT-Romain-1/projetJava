
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Vetement extends Article {

    public Vetement(String nom, double prix, int stock, String sport,
            Magasin magasin, String taille, String couleur) {

        super(nom, prix, stock, sport, magasin);
        this.tailleVetement = taille;
        this.couleurVetement = couleur;
    }

    private String tailleVetement;
    private String couleurVetement;

}