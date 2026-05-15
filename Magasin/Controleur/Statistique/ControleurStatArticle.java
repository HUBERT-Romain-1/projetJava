package Magasin.Controleur.Statistique;

import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Magasin.Model.*;

import java.awt.event.*;

public class ControleurStatArticle implements ActionListener {

    JTextField zoneSaisie;
    JComboBox<String> combo;
    DefaultTableModel modele;
    Magasin magasin;

    public ControleurStatArticle(JComboBox<String> comboChoix, JTextField txt, DefaultTableModel modele,
            Magasin m) {
        this.zoneSaisie = txt;
        this.combo = comboChoix;
        this.modele = modele;
        this.magasin = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int indice = combo.getSelectedIndex();
        String texte = zoneSaisie.getText();
        Vector<Article> resultats = new Vector<>();

        this.modele.setRowCount(0);

        // Tous les articles
        if (indice == 0) {
            resultats = magasin.getListeArticle();
        }

        // Bientôt en rupture
        else if (indice == 1) {
            int seuil = 5;
            if (!texte.isEmpty() && estEntierValide(texte)) {
                seuil = Integer.parseInt(texte);
            }
            resultats = magasin.getArticlesEnRupture(seuil);
        }

        else if (indice == 2) { // meilleur Vente

            Article top = magasin.articleLePlusRentable();

            modele.setRowCount(0);

            if (top != null) {
                modele.addRow(top.getLigneTableau());
            }
        }

        // Bientôt périmé
        else if (indice == 3) {
            int jours = 7;
            if (!texte.isEmpty() && estEntierValide(texte)) {
                jours = Integer.parseInt(texte);
            }
            resultats = magasin.getListeArticleBientotPerime(jours);
        }

        // Périmé
        else {
            resultats = magasin.getListeArticlePerime();
        }

        for (int i = 0; i < resultats.size(); i++) {
            Article a = resultats.get(i);
            modele.addRow(a.getLigneTableau());
        }

    }

    public boolean estEntierValide(String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
