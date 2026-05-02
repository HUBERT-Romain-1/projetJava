package Magasin.Controleur;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.awt.CardLayout;

public class ControleurEnregistrerArticle implements ActionListener {
    JPanel conteneurPrincipal;
    JPanel panelP2;
    JComboBox<String> comboType;
    CardLayout clPrincipal;
    CardLayout clP2;

    JTextField txtNom;
    JTextField txtPrix;
    JTextField txtStock;
    JTextField txtSport;

    JTextField txtSaveur;
    JTextField txtTaille;
    JTextField txtLongueur;
    JTextField txtLargeur;
    JTextField txtPoids;

    JTextField txtJ;
    JTextField txtM;
    JTextField txtA;
    JFrame vue;

    public ControleurEnregistrerArticle(JPanel conteneur, JPanel p2, JComboBox<String> comboType, JTextField nom,
            JTextField prix, JTextField stock, JTextField sport, JTextField saveur,
            JTextField taille, JTextField longueur, JTextField largeur, JTextField poids,
            JTextField jour,
            JTextField mois,
            JTextField annee,
            JFrame fenetre) {
        this.conteneurPrincipal = conteneur;
        this.panelP2 = p2;
        this.comboType = comboType;
        this.txtNom = nom;
        this.txtPrix = prix;
        this.txtSport = sport;
        this.txtStock = stock;

        this.txtSaveur = saveur;
        this.txtTaille = taille;
        this.txtLongueur = longueur;
        this.txtLargeur = largeur;
        this.txtPoids = poids;

        this.txtJ = jour;
        this.txtM = mois;
        this.txtA = annee;
        this.vue = fenetre;

        // On récupère les gestionnaires de disposition
        this.clPrincipal = (CardLayout) conteneur.getLayout();
        this.clP2 = (CardLayout) p2.getLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // le type sélectionné (Nourriture, Vêtement ou Matériel)
        String typeSelectionne = (String) comboType.getSelectedItem();

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
            JOptionPane.showMessageDialog(vue, "Le prix doit être un nombre positif (ex: 19.99) !",
                    "Erreur Prix",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (typeSelectionne.equals("Nourriture")) {

            String strSaveur = txtSaveur.getText();
            String jour = txtJ.getText().trim();
            String mois = txtM.getText().trim();
            String annee = txtA.getText().trim();

            String dateComplete = annee + "-" + mois + "-" + jour;

            LocalDate date = LocalDate.parse(dateComplete);

            Nourriture n = new Nourriture(strNom, 0, 0, strSport, null, null, strSaveur, date);

        }

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
