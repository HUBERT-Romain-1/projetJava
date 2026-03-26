
import java.io.*;
import java.util.*;

public class Articles {

    public Articles(String nom, double prix, int nbStock, String nomSport) {
        this.nomProduit = nom;
        this.prix = prix;
        this.stock = nbStock;
        this.sport = nomSport;

        refProduit++;

    }

    private static int refProduit;
    private String nomProduit;
    private double prix;
    private int stock;
    private String sport;

    public static int getRefProduit() {
        return refProduit;
    }

    public String getnomProduit() {
        return this.nomProduit;
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

    public void setPrix(double newPrix) {
        this.prix = newPrix;
    }

    public void setStock(int newstock) {
        this.stock = newstock;
    }

    public void setSport(String newSport) {
        this.sport = newSport;
    }

    public void afficherArticles() {
        System.out.println();
    }
}