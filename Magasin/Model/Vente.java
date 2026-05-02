package Magasin.Model;

import java.io.*;
import java.util.*;
import java.time.*;

public class Vente {

    public Vente(LocalDate dVente, Client c, Vendeur v, Magasin m) {
        this.dateVente = dVente;
        this.client = c;
        this.vendeur = v;
        this.magasin = m;
        this.SommeTotal = 0.0;

        this.idVente = compteurID++;

        m.addVente(this);

    }

    private static int compteurID = 0;
    private int idVente;
    private LocalDate dateVente;
    private double SommeTotal;
    private Magasin magasin;
    private Vector<LigneVente> listeLigneVente = new Vector<LigneVente>();
    private Client client;
    private Vendeur vendeur;

    public void addLigneVente(LigneVente lignev) {
        listeLigneVente.add(lignev);

        this.SommeTotal += lignev.CalculTotalLigne();
    }

    public int getIdVente() {
        return this.idVente;
    }

    public LocalDate getDateVente() {
        return this.dateVente;
    }

    public double getSommeTotal() {
        return this.SommeTotal;
    }

    public Magasin getMagasin() {
        return this.magasin;
    }

    public Client getClient() {
        return this.client;
    }

    public Vendeur getVendeur() {
        return this.vendeur;
    }

    public LigneVente ajouterProduit(Article a, int qte) {
        if (a.getStock() >= qte) {
            LigneVente lv = new LigneVente(qte, a, this);
            this.listeLigneVente.add(lv);
            a.setStock(a.getStock() - qte);
            this.SommeTotal += lv.CalculTotalLigne();
            return lv;
        }
        return null;
    }

    public void validerVente() {
        this.vendeur.addVente(this);
        this.client.addVente(this);
    }

    public String toString() {
        return "ID : " + this.idVente
                + " | Client : " + this.client.getNomClient()
                + " | Vendeur : " + this.vendeur.getNomVendeur()
                + " | Date : " + this.dateVente
                + " | TOTAL : " + this.SommeTotal + " euros";
    }

}