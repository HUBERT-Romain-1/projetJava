
import java.io.*;
import java.util.*;

/**
 * 
 */
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
    public Set<Article> v;

    /**
     * 
     */
    private Magasin magasin;

    /**
     * 
     */
    private Set<Client> listeVente;

    /**
     * 
     */
    private Set<LigneVente> listeLigne;


    /**
     * 
     */
    public Set<Client> client;

    /**
     * 
     */
    public Vendeur vendeur;

}