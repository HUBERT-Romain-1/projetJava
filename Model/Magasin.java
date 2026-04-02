
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Magasin {

    /**
     * Default constructor
     */
    public Magasin() {
    }

    /**
     * 
     */
    public String adresse;

    /**
     * 
     */
    private String nomMagasin;

    /**
     * 
     */
    private int idMagasin;

    /**
     * 
     */
    private Set<Vente> listeVente;

    /**
     * 
     */
    private Set<Client> listeClient;
    private Set<Article> listeArticle;

    private Set<Fournisseur> listeFournisseur;

    /**
     * 
     */
    public Set<Vendeur> listeVendeur;

}