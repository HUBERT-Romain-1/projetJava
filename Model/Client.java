
import java.io.*;
import java.util.*;

public class Client {

    public Client(String nom, String prenom, String email, Magasin m) {
        this.nomClient = nom;
        this.prenomClient = prenom;
        this.email = email;
        this.magasin = m;

        m.addClient(this);
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

    public int getIdClient() {
        return this.idClient;
    }

    public String getNomClient() {
        return this.nomClient;
    }

    public String getPrenomClient() {
        return this.prenomClient;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNomMagasin() {
        return this.magasin.getNomMagasin();
    }

    public void setNonClient(String newNom) {
        this.nomClient = newNom;
    }

    public void setPrenomClient(String newPrenom) {
        this.prenomClient = newPrenom;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public Vector<Vente> getHistoriqueAchats() {
        return this.listeVente;
    }

    public String toString() {
        return "Id Client : " + this.getIdClient()
                + " | Nom : " + this.getNomClient()
                + " | Prenom : " + this.getPrenomClient()
                + " | Email : " + this.getEmail()
                + " | Magasin : " + this.getNomMagasin()
                + " | Liste des achats";
    }
}