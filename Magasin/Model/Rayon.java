package Magasin.Model;

import java.io.*;
import java.util.*;

public class Rayon {
    public Rayon(String rayon, Magasin m, int capa) {
        this.nomRayon = rayon;
        this.magasin = m;
        this.capacite = capa;

        m.addRayon(this);
    }

    private String nomRayon;
    private int capacite;
    private Vector<Article> listeArticle = new Vector<Article>();
    public Magasin magasin;

    public void addArticle(Article article) {
        listeArticle.add(article);
    }

    public String getRayon() {
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

    public String toString() {
        return "nom du rayon : " + this.getRayon()
                + " | capacite max : " + this.getCapacite();
    }
}