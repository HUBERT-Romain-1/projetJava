package Magasin.Model;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Article {
    public Article(String nom, double prix, int stock, String sport, Rayon rayon, Fournisseur f, Magasin m) {
        this.nomProduit = nom;
        this.prix = prix;
        this.stock = stock;
        this.sport = sport;
        this.fournisseur = f;
        this.magasin = m;

        this.listeRayon.add(rayon);
        rayon.addArticle(this);
        m.addArticle(this);
        refProduit = compteurID++;
    }

    private static int compteurID = 200;

    private int refProduit;
    private String nomProduit;
    private double prix;
    private int stock;
    private String sport;
    private Fournisseur fournisseur;
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
            this.prix = -1;
        }
    }

    public void setStock(int newStock) {
        if (newStock > 0) {
            this.stock = newStock;
        } else {
            this.stock = -1;
        }
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

    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }

    public Magasin getMagasin() {
        return this.magasin;
    }

    public Vector<LigneVente> getListeLigneVente() {
        return this.listeLigneVente;
    }

    public int calculerQuantiteVendue() {
        int totalVendu = 0;
        for (int i = 0; i < listeLigneVente.size(); i++) {
            LigneVente lv = this.listeLigneVente.get(i);

            totalVendu = totalVendu + lv.getQuantite();
        }
        return totalVendu;
    }

    public double calculerArgentRapporter() {
        return calculerQuantiteVendue() * this.prix;
    }

    // Un produit normal ne périme jamais
    public boolean estPerimer() {
        return false;
    }

    public boolean perimerBientot(int nbJour) {
        return false;
    }

    public boolean estEnRupture(int seuil) {
        return this.stock <= seuil;
    }

    public String toString() {
        return this.getIdArticle() + " - " + this.getNomProduit();
    };
}