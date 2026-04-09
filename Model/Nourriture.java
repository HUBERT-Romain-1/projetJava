
import java.io.*;
import java.util.*;

public class Nourriture extends Article {

    public Nourriture(String nom, double prix, int stock, String sport,
            Magasin magasin, String saveur, Date date) {
        super(nom, prix, stock, sport, magasin);
        this.saveur = saveur;
        this.dateExpiration = date;
    }

    private String saveur;
    private Date dateExpiration;

}