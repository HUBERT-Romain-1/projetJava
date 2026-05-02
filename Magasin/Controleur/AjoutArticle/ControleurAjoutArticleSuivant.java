package Magasin.Controleur.AjoutArticle;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.CardLayout;

public class ControleurAjoutArticleSuivant implements ActionListener {
    JPanel conteneurPrincipal;
    JPanel panelP2;
    JComboBox<String> comboType;
    JComboBox<Rayon> comboRayon;
    CardLayout clPrincipal;
    CardLayout clP2;

    JTextField txtNom;
    JTextField txtPrix;
    JTextField txtStock;
    JTextField txtSport;

    JFrame vue;

    public ControleurAjoutArticleSuivant(JPanel conteneur, JPanel p2, JComboBox<String> comboType, JTextField nom,
            JTextField prix, JTextField stock, JTextField sport, JComboBox<Rayon> comboRayon, JFrame fenetre) {
        this.conteneurPrincipal = conteneur;
        this.panelP2 = p2;
        this.comboType = comboType;
        this.txtNom = nom;
        this.txtPrix = prix;
        this.txtSport = sport;
        this.txtStock = stock;
        this.comboRayon = comboRayon;
        this.vue = fenetre;

        // On récupère les gestionnaires de disposition
        this.clPrincipal = (CardLayout) conteneur.getLayout();
        this.clP2 = (CardLayout) p2.getLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // le type sélectionné (Nourriture, Vêtement ou Matériel)
        String typeSelectionne = (String) comboType.getSelectedItem();
        String rayonSelectionne = (String) comboRayon.getSelectedItem();

        String strNom = txtNom.getText();
        String strPrix = txtPrix.getText().replace(",", "."); // On gère la virgule
        String strStock = txtStock.getText();
        String strSport = txtSport.getText();

        if (strNom.isEmpty() || strPrix.isEmpty() || strStock.isEmpty() || strSport.isEmpty()) {
            JOptionPane.showMessageDialog(vue,
                    "Erreur : remplir tous les champs !",
                    "Attention",
                    JOptionPane.ERROR_MESSAGE); // logo Erreur
            return;
        }

        // 1. On vérifie d'abord si ce sont bien des chiffres
        if (!estNumerique(strStock)) {
            JOptionPane.showMessageDialog(vue,
                    "La quantité doit être un nombre entier positif !",
                    "Attention",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!estPrixValide(strPrix)) {
            JOptionPane.showMessageDialog(vue,
                    "Le prix doit être un nombre positif (ex: 19.99) !",
                    "Erreur Prix",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        clP2.show(panelP2, typeSelectionne);

        // Changement de PAge
        clPrincipal.show(conteneurPrincipal, "P2");
    }

    public boolean estNumerique(String str) {
        if (str == null || str.isEmpty())
            return false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean estPrixValide(String str) {
        int nbPoints = 0;
        if (str.isEmpty())
            return false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                nbPoints++;
            } else if (c < '0' || c > '9') {
                return false; // Caractère interdit
            }
        }
        return nbPoints <= 1; // Valide si 0 ou 1 point max
    }
}
