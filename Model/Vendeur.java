
import java.io.*;
import java.util.*;

public class Vendeur {

    public Vendeur(String nom, String prenom, String tel, Magasin mag) {
        this.nomVendeur = nom;
        this.prenomVendeur = prenom;
        this.telephone = tel;
        this.magasin = mag;

        idVendeur = compteurID++;
    }

    private static int compteurID = 0;
    private int idVendeur;
    private String nomVendeur;
    private String prenomVendeur;
    private String telephone;
    private Magasin magasin;
    private Vector<Vente> listeVente = new Vector<Vente>();

    public void addVente(Vente v) {
        listeVente.add(v);
    }
}