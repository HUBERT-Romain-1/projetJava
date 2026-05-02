package Magasin.Model;

import java.io.*;
import java.util.*;

public class Rayon {
    public Rayon(String rayon, int capa, Magasin m) {
        this.nomRayon = rayon;
        this.capacite = capa;
        this.magasin = m;

        m.addRayon(this);

        this.refRayon = compteurID++;
    }

    private static int compteurID = 1000;

    private int refRayon;
    private String nomRayon;
    private int capacite;
    private Vector<Article> listeArticle = new Vector<Article>();
    private Magasin magasin;

    public boolean estPlein() {
        return listeArticle.size() >= capacite;
    }

    public void addArticle(Article a) {
        if (!estPlein()) {
            listeArticle.add(a);
        }
    }

    public String getNomRayon() {
        return this.nomRayon;
    }

    public void setRayon(String newRayon) {
        this.nomRayon = newRayon;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public void setCapacite(int newCapa) {
        this.capacite = newCapa;
    }

    public String getNomMagasin() {
        return this.magasin.getNomMagasin();
    }

    public int getIdRayon() {
        return this.refRayon;
    }

    public String toString() {
        return this.getIdRayon() + " - " + this.getNomRayon();
    }
}