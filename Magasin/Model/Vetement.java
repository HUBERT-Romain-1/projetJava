package Magasin.Model;

import java.io.*;
import java.util.*;

public class Vetement extends Article {

    public Vetement(String nom, double prix, int stock, String sport, Rayon rayon,
            Magasin magasin, String taille, String couleur) {

        super(nom, prix, stock, sport, rayon, magasin);
        this.tailleVetement = taille;
        this.couleurVetement = couleur;

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