
import java.io.*;
import java.util.*;

public class Vente {

    /**
     * Default constructor
     */
    public Vente(Date dVente, Client c, Vendeur v, Magasin m) {
        this.dateVente = dVente;
        this.client = c;
        this.vendeur = v;
        this.magasin = m;
        this.SommeTotal = 0.0;

        this.idVente = compteurID++;

    }

    private static int compteurID = 0;
    private int idVente;
    private Date dateVente;
    private double SommeTotal;
    private Magasin magasin;
    private Vector<LigneVente> listeLigneVente = new Vector<LigneVente>();
    public Client client;
    private Vendeur vendeur;

    public void addLigneVente(LigneVente lignev) {
        listeLigneVente.add(lignev);
    }
}