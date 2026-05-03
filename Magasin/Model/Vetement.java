package Magasin.Model;

import java.io.*;
import java.util.*;

public class Vetement extends Article {

    public Vetement(String nom, double prix, int stock, String sport, Rayon rayon, Fournisseur fournisseur,
            Magasin magasin, String taille, String couleur) {

        super(nom, prix, stock, sport, rayon, fournisseur, magasin);
        this.tailleVetement = taille;
        this.couleurVetement = couleur;

    }

    private String tailleVetement;
    private String couleurVetement;

    @Override
    public String getInfosSpecifiques() {
        return "Taille: " + this.getTailleVetement() + " | Couleur: " + this.getCouleurVetement();
    }

    public String getTailleVetement() {
        return tailleVetement;
    }

    public String getCouleurVetement() {
        return couleurVetement;
    }

}