
import java.io.*;
import java.util.*;

public class Fournisseur {
    public Fournisseur(String fournisseur, String lieu, Magasin m) {
        this.nomFournisseur = fournisseur;
        this.lieuFournisseur = lieu;
        this.magasin = m;
    }

    private String nomFournisseur;
    private String lieuFournisseur;
    private Magasin magasin;

    private Vector<Article> listeArticle = new Vector<Article>();

    public void addArticle(Article a) {
        listeArticle.add(a);
    }

}