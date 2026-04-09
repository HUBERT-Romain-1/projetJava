
import java.io.*;
import java.util.*;

public class Rayon {
    public Rayon(String rayon, Magasin magasin) {
        this.nomRayon = rayon;
        this.magasin = magasin;
    }

    private String nomRayon;
    private Vector<Article> listeArticle = new Vector<Article>();
    public Magasin magasin;

}