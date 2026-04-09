
import java.io.*;
import java.util.*;

/**
 * 
 */
public class LigneVente {

    public LigneVente(int quant, Vente v, Article a) {
        this.quantite = quant;
        this.vente = v;
        this.article = a;
    }

    private int quantite;
    private Vente vente;
    private Article article;

}