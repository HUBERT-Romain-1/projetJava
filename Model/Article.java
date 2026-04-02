
import java.io.*;
import java.util.*;

public class Article {

    public Article(String nom, String marque, double prix, int stock, String sport) {
        this.nomProduit = nom;
        this.marque = marque;
        this.prix = prix;
        this.stock = stock;
        this.sport = sport;
    }

    private static int refProduit;
    private String nomProduit;
    private String marque;
    private double prix;
    private int stock;
    private String sport;
    private Magasin magasin;
    private Vector<Rayon> listeRayon;
    private Vector<LigneVente> listeLigneVente;
    private Vector<Fournisseur> fournisseur;

    public static int getRefProduit() {
        return refProduit;
    }

    public String getnomProduit() {
        return this.nomProduit;
    }

    public String getMarque() {
        return this.marque;
    }

    public double getPrix() {
        return this.prix;
    }

    public int getStock() {
        return this.stock;
    }

    public String getSport() {
        return this.sport;
    }

    public void setnomProduit(String newNom) {
        this.nomProduit = newNom;
    }

    public void setMarque(String newMarque) {
        this.marque = newMarque;
    }

    public void setPrix(double newPrix) {
        if (newPrix > 0) {
            this.prix = newPrix;
        }
        System.out.println("Prix négatif");
    }

    public void setStock(int newstock) {
        this.stock = newstock;
    }

    public void setSport(String newSport) {
        this.sport = newSport;
    }

    public void afficherArticles() {
        System.out.println(
                "nomProduit : " + this.getnomProduit() + " | marque : " + this.marque + " | prix : " + this.getPrix()
                        + " | stock : " + getStock() + " | sport : " + this.getSport());
    }

}