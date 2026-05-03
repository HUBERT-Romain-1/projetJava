package Magasin.Model;

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

    public String getNomMagasin() {
        return this.nomMagasin;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public Vector<Client> getListeClient() {
        return this.listeClient;
    }

    public Vector<Vendeur> getListeVendeur() {
        return this.listeVendeur;
    }

    public Vector<Article> getListeArticle() {
        return this.listeArticle;
    }

    public Vector<Rayon> getListeRayon() {
        return this.listeRayon;
    }

    public Vector<Fournisseur> getListeFournisseur() {
        return this.listeFournisseur;
    }

    public Rayon trouverRayon(String nomRayon) {
        for (int i = 0; i < listeRayon.size(); i++) {
            Rayon r = listeRayon.get(i);
            if (r.getNomRayon().equalsIgnoreCase(nomRayon)) {
                return r;
            }
        }
        return null;
    }

    public boolean peutAjouterDansRayon(String typeArticle) {
        Rayon r = trouverRayon(typeArticle);
        return (r != null && !r.estPlein());
    }

    public Vector<Client> rechercherClient(String critere) {
        Vector<Client> tabClient = new Vector<Client>();
        for (int i = 0; i < listeClient.size(); i++) {
            Client c = listeClient.get(i);
            if (c.getNomClient().equalsIgnoreCase(critere) ||
                    c.getPrenomClient().equalsIgnoreCase(critere) ||
                    c.getEmail().equalsIgnoreCase(critere)) {
                tabClient.add(c);
            }
        }
        return tabClient;
    }

    public Client rechercherClientID(int id) {
        for (int i = 0; i < listeClient.size(); i++) {
            Client c = listeClient.get(i);
            if (c.getIdClient() == id) {
                return c; // Trouvé
            }
        }
        return null;
    }

    public Article rechercherArticleID(int id) {
        for (int i = 0; i < listeArticle.size(); i++) {
            Article a = listeArticle.get(i);
            if (a.getIdArticle() == id) {
                return a; // Trouvé
            }
        }
        return null;
    }

    public Vendeur rechercherVendeurID(int id) {
        for (int i = 0; i < listeVendeur.size(); i++) {
            Vendeur v = listeVendeur.get(i);
            if (v.getIdVendeur() == id) {
                return v; // Trouvé
            }
        }
        return null;
    }

    public String[] getNomArticleTab() {
        String[] tab = new String[listeArticle.size()];

        for (int i = 0; i < tab.length; i++) {
            Article a = listeArticle.get(i);
            tab[i] = a.getIdArticle() + " - " + a.getNomProduit();
        }
        return tab;
    }

    public Article articleMoinsVendu() {

        if (listeArticle.isEmpty()) {
            return null;
        }

        Article pireVente = listeArticle.get(0);
        int miniQuantite = listeArticle.get(0).calculerQuantiteVendue();

        for (int i = 0; i < listeArticle.size(); i++) {
            if (listeArticle.get(i).calculerQuantiteVendue() < miniQuantite) {

                pireVente = listeArticle.get(i);
                miniQuantite = listeArticle.get(i).calculerQuantiteVendue();
            }
        }

        return pireVente;
    }

    public Article articlePlusVendu() {

        if (listeArticle.isEmpty()) {
            return null;
        }

        Article meilleurVente = listeArticle.get(0);
        int maxQuantite = listeArticle.get(0).calculerQuantiteVendue();

        for (int i = 0; i < listeArticle.size(); i++) {
            if (listeArticle.get(i).calculerQuantiteVendue() > maxQuantite) {

                meilleurVente = listeArticle.get(i);
                maxQuantite = listeArticle.get(i).calculerQuantiteVendue();
            }
        }

        return meilleurVente;
    }

    public Article articleLePlusRentable() {
        if (listeArticle.isEmpty()) {
            return null;
        }

        Article meilleurArticle = listeArticle.get(0);
        double maxCA = listeArticle.get(0).calculerArgentRapporter();

        for (int i = 0; i < listeArticle.size(); i++) {
            if (listeArticle.get(i).calculerArgentRapporter() > maxCA) {

                meilleurArticle = listeArticle.get(i);
                maxCA = listeArticle.get(i).calculerArgentRapporter();
            }
        }

        return meilleurArticle;
    }

    public Vector<Article> getListeArticleBientotPerime(int nbJour) {
        Vector<Article> alerte = new Vector<Article>();

        for (int i = 0; i < listeArticle.size(); i++) {
            Article a = listeArticle.get(i);
            if (a.perimerBientot(nbJour)) {
                alerte.add(a);
            }
        }
        return alerte;
    }

    public Vector<Article> getListeArticlePerime() {
        Vector<Article> perimer = new Vector<Article>();

        for (int i = 0; i < listeArticle.size(); i++) {
            Article a = listeArticle.get(i);
            if (a.estPerimer()) {
                perimer.add(a);
            }
        }
        return perimer;
    }

    public Vector<Article> getArticlesEnRupture(int seuil) {
        Vector<Article> stockFaible = new Vector<Article>();

        for (int i = 0; i < listeArticle.size(); i++) {
            Article a = listeArticle.get(i);

            if (a.estEnRupture(seuil)) {
                stockFaible.add(a);
            }
        }
        return stockFaible;
    }

}