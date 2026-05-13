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
        for (int i = 0; i < listeArticle.size(); i++) {
            Article a = listeArticle.get(i);

            if (typeCritere.equals("ID") && (a.getIdArticle() + "").equals(saisie)) {
                tabArticle.add(a);
            } else if (typeCritere.equals("Nom Produit") &&
                    a.getNomProduit().equalsIgnoreCase(saisie)) {
                tabArticle.add(a);
            } else if (typeCritere.equals("Prix") &&
                    (a.getPrix() + "").equals(saisie)) {
                tabArticle.add(a);
            } else if (typeCritere.equals("Stock") &&
                    (a.getStock() + "").equals(saisie)) {
                tabArticle.add(a);
            } else if (typeCritere.equals("Sport") &&
                    (a.getSport() + "").equals(saisie)) {
                tabArticle.add(a);
            } else if (typeCritere.equals("Fournisseur") &&
                    (a.getFournisseur() + "").equals(saisie)) {
                tabArticle.add(a);
            }
        }
        return tabArticle;
    }

    public Vector<Client> rechercherClient(String saisie, String typeCritere) {
        Vector<Client> tabClient = new Vector<Client>();
        for (int i = 0; i < listeClient.size(); i++) {
            Client c = listeClient.get(i);

            if (typeCritere.equals("ID") && (c.getIdClient() + "").equals(saisie)) {
                tabClient.add(c);
            } else if (typeCritere.equals("Nom") && c.getNomClient().equalsIgnoreCase(saisie)) {
                tabClient.add(c);
            } else if (typeCritere.equals("Prénom") && c.getPrenomClient().equalsIgnoreCase(saisie)) {
                tabClient.add(c);
            } else if (typeCritere.equals("Email") && c.getEmail().equalsIgnoreCase(saisie)) {
                tabClient.add(c);
            }
        }
        return tabClient;
    }

    public Vector<Fournisseur> rechercherFournisseur(String saisie, String typeCritere) {
        Vector<Fournisseur> tabFournisseur = new Vector<Fournisseur>();
        for (int i = 0; i < listeFournisseur.size(); i++) {
            Fournisseur f = listeFournisseur.get(i);

            if (typeCritere.equals("ID") && (f.getIdFournisseur() + "").equals(saisie)) {
                tabFournisseur.add(f);
            } else if (typeCritere.equals("Nom fournisseur") &&
                    f.getNomFournisseur().equalsIgnoreCase(saisie)) {
                tabFournisseur.add(f);
            } else if (typeCritere.equals("Adresse fournisseur") &&
                    f.getAdresseFournisseur().equalsIgnoreCase(saisie)) {
                tabFournisseur.add(f);
            }
        }
        return tabFournisseur;
    }

    public Vector<Rayon> rechercherRayon(String saisie, String typeCritere) {
        Vector<Rayon> tabRayon = new Vector<Rayon>();
        for (int i = 0; i < listeRayon.size(); i++) {
            Rayon r = listeRayon.get(i);

            if (typeCritere.equals("ID") && (r.getIdRayon() + "").equals(saisie)) {
                tabRayon.add(r);
            } else if (typeCritere.equals("Nom Rayon") && r.getNomRayon().equalsIgnoreCase(saisie)) {
                tabRayon.add(r);
            } else if (typeCritere.equals("Capacité maximum") && (r.getCapacite() + "").equalsIgnoreCase(saisie)) {
                tabRayon.add(r);
            }
        }
        return tabRayon;
    }

    // return new String[] { "ID", "Nom", "Prénom", "Téléphone" , "CA"};
    public Vector<Vendeur> rechercherVendeur(String saisie, String typeCritere) {
        Vector<Vendeur> tabVendeur = new Vector<Vendeur>();
        for (int i = 0; i < listeVendeur.size(); i++) {
            Vendeur v = listeVendeur.get(i);

            if (typeCritere.equals("ID") && (v.getIdVendeur() + "").equals(saisie)) {
                tabVendeur.add(v);
            } else if (typeCritere.equals("Nom") && v.getNomVendeur().equalsIgnoreCase(saisie)) {
                tabVendeur.add(v);
            } else if (typeCritere.equals("Prénom") && v.getPrenomVendeur().equalsIgnoreCase(saisie)) {
                tabVendeur.add(v);
            } else if (typeCritere.equals("Téléphone") && v.getTelephone().equalsIgnoreCase(saisie)) {
                tabVendeur.add(v);
            } else if (typeCritere.equals("CA") && (v.calculCA() + "").equalsIgnoreCase(saisie)) {
                tabVendeur.add(v);
            }
        }
        return tabVendeur;
    }

    // return new String[] { "ID Vente", "Date Vente", "Nom Client", "Nom Vendeur",
    // "Total" };
    public Vector<Vente> rechercherVente(String saisie, String typeCritere) {
        Vector<Vente> tabVente = new Vector<Vente>();
        for (int i = 0; i < listeVente.size(); i++) {
            Vente v = listeVente.get(i);

            if (typeCritere.equals("ID Vente") && (v.getIdVente() + "").equals(saisie)) {
                tabVente.add(v);
            } else if (typeCritere.equals("Date Vente") && (v.getDateVente() + "").equalsIgnoreCase(saisie)) {
                tabVente.add(v);
            } else if (typeCritere.equals("Nom Client") && (v.getClient() + "").equalsIgnoreCase(saisie)) {
                tabVente.add(v);
            } else if (typeCritere.equals("Nom Vendeur") && (v.getVendeur() + "").equalsIgnoreCase(saisie)) {
                tabVente.add(v);
            } else if (typeCritere.equals("Total ") && (v.getSommeTotal() + "").equalsIgnoreCase(saisie)) {
                tabVente.add(v);
            }
        }
        return tabVente;
    }

    // public Vector<Article> rechercherArticle(String saisie, String typeCritere) {
    // Vector<Article> tabArticle = new Vector<Article>();
    // for (int i = 0; i < listeClient.size(); i++) {
    // Client c = listeClient.get(i);

    // if (typeCritere.equals("ID") && (c.getIdClient() + "").equals(saisie)) {
    // tabClient.add(c);
    // } else if (typeCritere.equals("Nom") &&
    // c.getNomClient().equalsIgnoreCase(saisie)) {
    // tabClient.add(c);
    // } else if (typeCritere.equals("Prénom") &&
    // c.getPrenomClient().equalsIgnoreCase(saisie)) {
    // tabClient.add(c);
    // } else if (typeCritere.equals("Email") &&
    // c.getEmail().equalsIgnoreCase(saisie)) {
    // tabClient.add(c);
    // }
    // }
    // return tabArticle;
    // }

    // public Client rechercherClientID(int id) {
    // for (int i = 0; i < listeClient.size(); i++) {
    // Client c = listeClient.get(i);
    // if (c.getIdClient() == id) {
    // return c; // Trouvé
    // }
    // }
    // return null;
    // }

    // public Article rechercherArticleID(int id) {
    // for (int i = 0; i < listeArticle.size(); i++) {
    // Article a = listeArticle.get(i);
    // if (a.getIdArticle() == id) {
    // return a; // Trouvé
    // }
    // }
    // return null;
    // }

    // public Vendeur rechercherVendeurID(int id) {
    // for (int i = 0; i < listeVendeur.size(); i++) {
    // Vendeur v = listeVendeur.get(i);
    // if (v.getIdVendeur() == id) {
    // return v; // Trouvé
    // }
    // }
    // return null;
    // }

    // public String[] getNomArticleTab() {
    // String[] tab = new String[listeArticle.size()];

    // for (int i = 0; i < tab.length; i++) {
    // Article a = listeArticle.get(i);
    // tab[i] = a.getIdArticle() + " - " + a.getNomProduit();
    // }
    // return tab;
    // }

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