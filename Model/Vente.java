
import java.io.*;
import java.util.*;

public class Vente {

    /**
     * Default constructor
     */
    public Vente() {
    }

    /**
     * 
     */
    private static int idVente;

    /**
     * 
     */
    private Date dateVente;

    /**
     * 
     */
    private double SommeTotal;

    /**
     * 
     */
    private Magasin magasin;

    /**
     * 
     */
    private Set<Client> listeClient;

    /**
     * 
     */
    private Set<LigneVente> listeLigneVente;

    /**
     * 
     */
    public Set<Client> client;

    /**
     * 
     */
    private Vendeur vendeur;

}