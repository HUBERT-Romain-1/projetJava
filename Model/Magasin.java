
import java.io.*;
import java.util.*;

public class Magasin {

    public Magasin(String nom, String adresse) {
        this.adresse = adresse;
        this.nomMagasin = nom;
    }

    private String nomMagasin;
    private String adresse;
    private int idMagasin = 100;

    private Vector<Vente> listeVente = new Vector<Vente>();
    private Vector<Client> listeClient = new Vector<Client>();
    private Vector<Article> listeArticle = new Vector<Article>();
    private Vector<Fournisseur> listeFournisseur = new Vector<Fournisseur>();
    private Vector<Vendeur> listeVendeur = new Vector<Vendeur>();
    private Vector<Rayon> listeRayon = new Vector<Rayon>();

    public void addVente(Vente vente) {
        listeVente.add(vente);
    }

    public void addClient(Client c) {
        listeClient.add(c);
    }

    public void addArticle(Article a) {
        listeArticle.add(a);
    }

    public void addFournisseur(Fournisseur fournisseur) {
        listeFournisseur.add(fournisseur);
    }

    public void addVendeur(Vendeur vendeur) {
        listeVendeur.add(vendeur);
    }

    public void addRayon(Rayon rayon) {
        listeRayon.add(rayon);
    }

}