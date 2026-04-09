
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Article {
    public Article(String nom, double prix, int stock, String sport, Magasin magasin) {
        this.nomProduit = nom;
        this.prix = prix;
        this.stock = stock;
        this.sport = sport;
        this.magasin = magasin;

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
}