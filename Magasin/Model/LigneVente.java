package Magasin.Model;

import java.io.*;
import java.util.*;

public class LigneVente {

    public LigneVente(int quant, Article a, Vente v) {
        this.quantite = quant;
        this.vente = v;
        this.article = a;
    }

    private int quantite;
    private Vente vente;
    private Article article;

    public int getQuantite() {
        return this.quantite;
    }

    public double CalculTotalLigne() {
        return this.article.getPrix() * this.getQuantite();
    }

    public Article getArticle() {
        return this.article;
    }

    public Vente getVente() {
        return this.vente;
    }

}