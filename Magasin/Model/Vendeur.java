package Magasin.Model;

import java.io.*;
import java.util.*;

public class Vendeur {

    public Vendeur(String nom, String prenom, String tel, Magasin m) {
        this.nomVendeur = nom;
        this.prenomVendeur = prenom;
        this.telephone = tel;
        this.magasin = m;

        m.addVendeur(this);
        idVendeur = compteurID++;
    }

    private static int compteurID = 0;
    private int idVendeur;
    private String nomVendeur;
    private String prenomVendeur;
    private String telephone;
    private Magasin magasin;
    private Vector<Vente> listeVente = new Vector<Vente>();

    public static String[] getCriteresRecherche() {
        return new String[] { "ID", "Nom", "Prénom", "Téléphone", " CA" };
    }

    public String[] getLigneTableau() {
        return new String[] {
                this.getIdVendeur() + "",
                this.getNomVendeur(),
                this.getPrenomVendeur(),
                this.getTelephone(),
                this.calculCA() + ""
        };
    }

    public void addVente(Vente v) {
        listeVente.add(v);
    }

    public int getIdVendeur() {
        return this.idVendeur;
    }

    public String getNomVendeur() {
        return this.nomVendeur;
    }

    public void setNomVendeur(String newNom) {
        this.nomVendeur = newNom;
    }

    public String getPrenomVendeur() {
        return this.prenomVendeur;
    }

    public void setPrenomVendeur(String newPrenom) {
        this.nomVendeur = newPrenom;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String newTel) {
        this.nomVendeur = newTel;
    }

    public double calculCA() {
        double totalCa = 0;
        for (int i = 0; i < listeVente.size(); i++) {
            Vente v = this.listeVente.get(i);
            totalCa += v.getSommeTotal();

        }

        return totalCa;
    }

    public String getNomMagasin() {
        return this.magasin.getNomMagasin();
    }

    public String toString() {
        return this.getIdVendeur() + " - " + this.getNomVendeur().toUpperCase() + " " + this.getPrenomVendeur();
    }

}