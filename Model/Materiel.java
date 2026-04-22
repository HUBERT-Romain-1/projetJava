
import java.io.*;
import java.util.*;

public class Materiel extends Article {
    public Materiel(String nom, double prix, int stock, String sport, Magasin m, double poids, double dimension) {
        super(nom, prix, stock, sport, m);
        this.poids = poids;
        this.dimension = dimension;

    }

    private double poids;
    private double dimension;

    public double getPoids() {
        return this.poids;
    }

    public double getDimension() {
        return this.dimension;
    }

    @Override
    public String toString() {
        return super.toString() + " | Poids : " + poids + "kg | Dimension : " + dimension + "cm";
    }

}