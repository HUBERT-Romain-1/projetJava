
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Client {

    public Client(String nom, String prenom, String email, Magasin magasin) {
        this.nomClient = nom;
        this.prenomClient = prenom;
        this.email = email;
        this.magasin = magasin;

        this.idClient = compteurID++;
    }

    private static int compteurID = 0;
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String email;
    private Vector<Vente> listeVente = new Vector<Vente>();
    private Magasin magasin;

    public void addVente(Vente v) {
        listeVente.add(v);
    }
}