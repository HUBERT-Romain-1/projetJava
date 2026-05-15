package Magasin.Controleur.Statistique;

import Magasin.Model.*;
import Magasin.Vue.VueStatistique.VueStatArticle;

import javax.swing.*;
import java.awt.event.*;

public class BtnStatArticle implements ActionListener {

    Magasin magasin;

    public BtnStatArticle(Magasin m) {
        this.magasin = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        VueStatArticle vueStatArticle = new VueStatArticle(magasin);

        vueStatArticle.pack();
        vueStatArticle.show();

    }

}
