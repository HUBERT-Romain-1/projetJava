package Magasin.Vue.VueStatistique;

import Magasin.Model.*;
import Magasin.Controleur.*;
import Magasin.Controleur.Statistique.*;

import javax.swing.*;
import java.awt.*;

public class VueStatistique extends JFrame {

    JButton statArticle = new JButton("Statistique Article");
    JButton statClient = new JButton("Statistique Client");
    JButton statVendeur = new JButton("Statistique Vendeur");

    Magasin magasin;

    public VueStatistique(Magasin m) {
        this.magasin = m;
        this.setTitle("Nom du Magasin : " + magasin.getNomMagasin());

        this.getContentPane().setLayout(new BorderLayout());

        JPanel boutons = new JPanel();

        boutons.add(statArticle);
        boutons.add(statClient);
        boutons.add(statVendeur);

        this.add(boutons, BorderLayout.CENTER);

        BtnStatArticle article = new BtnStatArticle(m);
        statArticle.addActionListener(article);

        BtnStatClient ctrBtn = new BtnStatClient(m);
        statClient.addActionListener(ctrBtn);

        BtnStatVendeur ctrBtnVendeur = new BtnStatVendeur(m);
        statVendeur.addActionListener(ctrBtnVendeur);
    }
}
