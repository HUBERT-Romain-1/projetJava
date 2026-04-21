import java.io.*;
import java.util.*;

public class Fournisseur {
    public Fournisseur(String fournisseur, String lieu, Magasin m) {
        this.nomFournisseur = fournisseur;
        this.lieuFournisseur = lieu;
        this.magasin = m;

        m.addFournisseur(this);
    }

    private String nomFournisseur;
    private String lieuFournisseur;
    private Magasin magasin;

    private Vector<Article> listeArticle = new Vector<Article>();

    public void addArticle(Article a) {
        listeArticle.add(a);
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