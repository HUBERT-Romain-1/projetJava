
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Materiel extends Article {
    public Materiel(String nom, double prix, int stock, String sport, Magasin magasin, double poids, double dimension) {
        super(nom, prix, stock, sport, magasin);
        this.poids = poids;
        this.dimension = dimension;

    }

    private double poids;
    private double dimension;

}