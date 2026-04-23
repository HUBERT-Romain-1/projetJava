package Magasin.Model;

import java.time.LocalDate;
import java.io.*;
import java.util.*;

public class Nourriture extends Article {

    public Nourriture(String nom, double prix, int stock, String sport,
            Magasin m, String saveur, LocalDate date) {
        super(nom, prix, stock, sport, m);
        this.saveur = saveur;
        this.dateExpiration = date;

    }

    private String saveur;
    private LocalDate dateExpiration;

    public String getSaveur() {
        return this.saveur;
    }

    public LocalDate getDateExpiration() {
        return this.dateExpiration;
    }

    @Override
    public boolean estPerimer() {
        return this.dateExpiration.isBefore(LocalDate.now());
    }

    @Override
    public boolean perimerBientot(int nbJour) {
        return this.dateExpiration.isBefore(LocalDate.now().plusDays(nbJour)) && !estPerimer();
    }

    @Override
    public String toString() {
        return super.toString()
                + " | saveur : " + this.getSaveur() + " | date d'expiration : " + this.getDateExpiration();
    }

}