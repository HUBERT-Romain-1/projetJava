import java.io.*;
import java.util.*;

public class Article {
    public Article(String nom, double prix, int stock, String sport, Magasin m) {
        this.nomProduit = nom;
        this.prix = prix;
        this.stock = stock;
        this.sport = sport;
        this.magasin = m;

        m.addArticle(this);
        refProduit = compteurID++;
    }

    private static int compteurID = 0;

    private int refProduit;
    private String nomProduit;
    private double prix;
    private int stock;
    private String sport;
    private Magasin magasin;
    private Vector<Rayon> listeRayon = new Vector<Rayon>();
    private Vector<LigneVente> listeLigneVente = new Vector<LigneVente>();

    public void addRayon(Rayon r) {
        listeRayon.add(r);
    }

    public void addLigneVente(LigneVente vente) {
        listeLigneVente.add(vente);
    }

    public void setNomProduit(String nom) {
        this.nomProduit = nom;
    }

    public void setPrix(double newPrix) {
        if (newPrix > 0) {
            this.prix = newPrix;
        } else {

            System.out.println("prix négatif");
        }
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }

    public void setSport(String newSport) {
        this.sport = newSport;
    }

    public int getIdArticle() {
        return this.refProduit;
    }

    public String getNomProduit() {
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

    public Magasin getMagasin() {
        return this.magasin;
    }

    public String toString() {
        return "Article : " + this.nomProduit
                + " (Réf : " + this.refProduit + ") | Sport : " + this.sport
                + " | Prix : " + this.prix + " euros | Stock : "
                + this.stock;
    };
}