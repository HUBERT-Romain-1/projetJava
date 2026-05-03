package Magasin.Model;

import java.io.*;
import java.util.*;

public class Fournisseur {
    public Fournisseur(String fournisseur, String lieu, Magasin m) {
        this.nomFournisseur = fournisseur;
        this.lieuFournisseur = lieu;
        this.magasin = m;

        m.addFournisseur(this);

        this.idFournisseur = compteurID++;
    }

    private static int compteurID = 2000;
    private int idFournisseur;
    private String nomFournisseur;
    private String lieuFournisseur;
    private Magasin magasin;

    private Vector<Article> listeArticle = new Vector<Article>();

    public static String[] getCriteresRecherche() {
        return new String[] { "ID", "Nom fournisseur", "Adresse fournisseur" };
    }

    public String[] getLigneTableau() {
        return new String[] {
                this.getIdFournisseur() + "",
                this.getNomFournisseur(),
                this.getAdresseFournisseur(),
        };
    }

    public void addArticle(Article a) {
        listeArticle.add(a);
    }

    public int getIdFournisseur() {
        return this.idFournisseur;
    }

    public String getNomFournisseur() {
        return this.nomFournisseur;
    }

    public String getAdresseFournisseur() {
        return this.lieuFournisseur;
    }

    public String getNomMagasin() {
        return this.magasin.getNomMagasin();
    }

    public String toString() {
        return "nom du fournisseur  " + this.getNomFournisseur()
                + " | Adresse : " + this.getAdresseFournisseur()
                + " | nom magasin : " + this.getNomMagasin();
    }
}