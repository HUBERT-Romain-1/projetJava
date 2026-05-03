package Magasin.Model;

import java.io.*;
import java.util.*;

public class Materiel extends Article {
    public Materiel(String nom, double prix, int stock, String sport, Magasin m, Rayon rayon, Fournisseur fournisseur,
            double poids, double Longueur,
            double largeur) {
        super(nom, prix, stock, sport, rayon, fournisseur, m);
        this.poids = poids;
        this.Longueur = Longueur;
        this.largeur = largeur;
    }

    private double poids;
    private double Longueur;
    private double largeur;

    public double getPoids() {
        return this.poids;
    }

    public double getLongueur() {
        return this.Longueur;
    }

    public double getLargeur() {
        return this.largeur;
    }

    @Override
    public String toString() {
        return this.getIdArticle() + " - " + this.getNomProduit();
    }

}