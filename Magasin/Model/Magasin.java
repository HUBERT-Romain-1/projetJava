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

    public Vector<Vente> getListeVente() {
        return this.listeVente;
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

    public Vector<Article> rechercherArticle(String saisie, String typeCritere) {
        Vector<Article> tabArticle = new Vector<Article>();
        String[] criteres = Article.getCriteresRecherche();

        for (int i = 0; i < listeArticle.size(); i++) {
            Article a = listeArticle.get(i);
            String[] donneesArticle = a.getLigneTableau();

            // on cherche l'indice du critère
            for (int j = 0; j < criteres.length; j++) {

                // Si Bon criteres
                if (typeCritere.equals(criteres[j])) {

                    // On regarde si saisie est inclu dans la donneesArticles
                    if (donneesArticle[j].equalsIgnoreCase(saisie)) {
                        tabArticle.add(a);
                    }
                    break;
                }
            }
        }
        return tabArticle;
    }

    public Vector<Client> rechercherClient(String saisie, String typeCritere) {
        Vector<Client> tab = new Vector<Client>();
        String[] criteres = Client.getCriteresRecherche();

        for (int i = 0; i < listeClient.size(); i++) {
            Client c = listeClient.get(i);
            String[] donneesArticle = c.getLigneTableau();

            // on cherche l'indice du critère
            for (int j = 0; j < criteres.length; j++) {

                // Si Bon criteres
                if (typeCritere.equals(criteres[j])) {

                    // On regarde si saisie est inclu dans la donneesArticles
                    if (donneesArticle[j].equalsIgnoreCase(saisie)) {
                        tab.add(c);
                    }
                    break;
                }
            }
        }
        return tab;
    }

    public Vector<Fournisseur> rechercherFournisseur(String saisie, String typeCritere) {
        Vector<Fournisseur> tab = new Vector<Fournisseur>();
        String[] criteres = Fournisseur.getCriteresRecherche();

        for (int i = 0; i < listeFournisseur.size(); i++) {
            Fournisseur f = listeFournisseur.get(i);
            String[] donneesArticle = f.getLigneTableau();

            // on cherche l'indice du critère
            for (int j = 0; j < criteres.length; j++) {

                // Si Bon criteres
                if (typeCritere.equals(criteres[j])) {

                    // On regarde si saisie est inclu dans la donneesArticles
                    if (donneesArticle[j].equalsIgnoreCase(saisie)) {
                        tab.add(f);
                    }
                    break;
                }
            }
        }
        return tab;
    }

    public Vector<Rayon> rechercherRayon(String saisie, String typeCritere) {
        Vector<Rayon> tab = new Vector<Rayon>();
        String[] criteres = Rayon.getCriteresRecherche();

        for (int i = 0; i < listeRayon.size(); i++) {
            Rayon r = listeRayon.get(i);
            String[] donneesArticle = r.getLigneTableau();

            // on cherche l'indice du critère
            for (int j = 0; j < criteres.length; j++) {

                // Si Bon criteres
                if (typeCritere.equals(criteres[j])) {

                    // On regarde si saisie est inclu dans la donneesArticles
                    if (donneesArticle[j].equalsIgnoreCase(saisie)) {
                        tab.add(r);
                    }
                    break;
                }
            }
        }
        return tab;
    }

    public Vector<Vendeur> rechercherVendeur(String saisie, String typeCritere) {
        Vector<Vendeur> tab = new Vector<Vendeur>();
        String[] criteres = Vendeur.getCriteresRecherche();

        for (int i = 0; i < listeVendeur.size(); i++) {
            Vendeur v = listeVendeur.get(i);
            String[] donneesArticle = v.getLigneTableau();

            // on cherche l'indice du critère
            for (int j = 0; j < criteres.length; j++) {

                // Si Bon criteres
                if (typeCritere.equals(criteres[j])) {

                    // On regarde si saisie est inclu dans la donneesArticles
                    if (donneesArticle[j].equalsIgnoreCase(saisie)) {
                        tab.add(v);
                    }
                    break;
                }
            }
        }
        return tab;
    }

    public Vector<Vente> rechercherVente(String saisie, String typeCritere) {
        Vector<Vente> tab = new Vector<Vente>();
        String[] criteres = Vente.getCriteresRecherche();

        for (int i = 0; i < listeVente.size(); i++) {
            Vente v = listeVente.get(i);
            String[] donneesArticle = v.getLigneTableau();

            // on cherche l'indice du critère
            for (int j = 0; j < criteres.length; j++) {

                // Si Bon criteres
                if (typeCritere.equals(criteres[j])) {

                    // On regarde si saisie est inclu dans la donneesArticles
                    if (donneesArticle[j].equalsIgnoreCase(saisie)) {
                        tab.add(v);
                    }
                    break;
                }
            }
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