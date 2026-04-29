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

    public void affichageMagasin() {
        System.out.println("---------- MAGASIN : " + this.nomMagasin.toUpperCase() + " ----------");
        System.out.println("Adresse : " + this.getAdresse());
        System.out.println("ID Magasin : " + this.idMagasin);

        System.out.println("\n --- LISTE DES FOURNISSEUR ---\n");

        for (int i = 0; i < listeFournisseur.size(); i++) {
            Fournisseur f = listeFournisseur.get(i);
            System.out.println(f.toString());

        }

        System.out.println("\n --- LISTE DES RAYON ---\n");

        for (int i = 0; i < listeRayon.size(); i++) {
            Rayon r = listeRayon.get(i);
            System.out.println(r.toString());
        }

        System.out.println("\n --- LISTE DES CLIENTS ---\n");

        for (int i = 0; i < listeClient.size(); i++) {
            Client c = listeClient.get(i);
            System.out.println(c.toString());
        }

        System.out.println("\n --- LISTE DES ARTICLES ---\n");

        for (int i = 0; i < listeArticle.size(); i++) {
            Article a = listeArticle.get(i);
            System.out.println(a.toString());
        }

        System.out.println("\n --- LISTE DES VENTES ---\n");

        for (int i = 0; i < listeVente.size(); i++) {
            Vente vente = listeVente.get(i);
            System.out.println(vente.toString());
        }

        System.out.println("\n --- LISTE DES VENDEUR ---\n");

        for (int i = 0; i < listeVendeur.size(); i++) {
            Vendeur v = listeVendeur.get(i);
            System.out.println(v.toString());
        }
    }
}