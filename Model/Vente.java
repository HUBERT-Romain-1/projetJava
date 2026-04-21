
import java.io.*;
import java.util.*;

public class Vente {

    public Vente(Date dVente, Client c, Vendeur v, Magasin m) {
        this.dateVente = dVente;
        this.client = c;
        this.vendeur = v;
        this.magasin = m;
        this.SommeTotal = 0.0;

        this.idVente = compteurID++;

        m.addVente(this);

    }

    private static int compteurID = 0;
    private int idVente;
    private Date dateVente;
    private double SommeTotal;
    private Magasin magasin;
    private Vector<LigneVente> listeLigneVente = new Vector<LigneVente>();
    private Client client;
    private Vendeur vendeur;

    public void addLigneVente(LigneVente lignev) {
        listeLigneVente.add(lignev);

        this.SommeTotal += lignev.getArticle().getPrix() * lignev.getQuantite();
    }

    public int getIdVente() {
        return this.idVente;
    }

    public Date getDateVente() {
        return this.dateVente;
    }

    public double getSommeTotal() {
        return this.SommeTotal;
    }

    public Magasin getMagasin() {
        return this.magasin;
    }

    public Client getClient() {
        return this.client;
    }

    public Vendeur getVendeur() {
        return this.vendeur;
    }

    public void ajouterProduit(Article a, int qte) {

        if (a.getStock() >= qte) {
            LigneVente lv = new LigneVente(qte, this, a);

            // 3. On l'ajoute à la liste de la vente
            this.listeLigneVente.add(lv);

            // mise a jour du stock
            a.setStock(a.getStock() - qte);

            // mise a jour de la somme a payer
            this.SommeTotal += a.getPrix() * qte;

        } else {
            System.out.println("Erreur : Stock insuffisant pour " + a.getNomProduit());
        }
    }

    public void validationCommande() {

    }

    public String toString() {
        return "ID : " + this.idVente
                + " | Client : " + this.client.getNomClient()
                + " | Vendeur : " + this.vendeur.getNomVendeur()
                + " | Date : " + this.dateVente
                + " | TOTAL : " + this.SommeTotal + " euros";
    }

}