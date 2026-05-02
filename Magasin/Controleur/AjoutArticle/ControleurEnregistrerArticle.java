package Magasin.Controleur.AjoutArticle;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.awt.CardLayout;

public class ControleurEnregistrerArticle implements ActionListener {
    Magasin magasin;
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

    public ControleurEnregistrerArticle(Magasin m, JPanel conteneur, JPanel p2, JComboBox<String> comboType,
            JTextField nom,
            JTextField prix, JTextField stock, JTextField sport, JTextField saveur,
            JTextField taille, JTextField longueur, JTextField largeur, JTextField poids,
            JTextField jour,
            JTextField mois,
            JTextField annee,
            JFrame fenetre) {

        this.magasin = m;
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
        String nomRayonChoisi = (String) comboType.getSelectedItem();
        Rayon rayonCible = magasin.trouverRayon(nomRayonChoisi);

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

        if (!magasin.peutAjouterDansRayon(typeSelectionne)) {
            JOptionPane.showMessageDialog(vue, "Le rayon " + typeSelectionne + " est plein !", "Stock Maximum",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!estPrixValide(strPrix)) {
            JOptionPane.showMessageDialog(vue, "Le prix doit être un nombre positif (ex: 19.99) !",
                    "Erreur Prix",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (rayonCible == null || rayonCible.estPlein()) {
            JOptionPane.showMessageDialog(vue, "Rayon plein ou inexistant !");
            return;
        }

        double prix = Double.parseDouble(strPrix);
        int stock = Integer.parseInt(strStock);

        if (typeSelectionne.equals("Nourriture")) {
            LocalDate datePeremption = validerEtCreerDate();
            String strSaveur = txtSaveur.getText();

            if (strSaveur.isEmpty()) {
                JOptionPane.showMessageDialog(vue, "Veuillez remplir la saveur !");
                return;
            }

            Nourriture n = new Nourriture(strNom, prix, stock, strSport, rayonCible, magasin, strSaveur,
                    datePeremption);
            magasin.addArticle(n);
            rayonCible.addArticle(n);
        } else if (typeSelectionne.equals("Vetement")) {

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

    public LocalDate validerEtCreerDate() {
        String j = txtJ.getText();
        String m = txtM.getText();
        String a = txtA.getText();

        // Vérification si vide
        if (j.isEmpty() || m.isEmpty() || a.isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Veuillez remplir la date complète !");
            return null;
        }

        // Verif numerique
        if (!estNumerique(j) || !estNumerique(m) || !estNumerique(a)) {
            JOptionPane.showMessageDialog(vue, "La date doit contenir uniquement des chiffres !");
            return null;
        }

        // Verif plage
        int jourVal = Integer.parseInt(j);
        int moisVal = Integer.parseInt(m);
        int anneeVal = Integer.parseInt(a);

        if (moisVal < 1 || moisVal > 12) {
            JOptionPane.showMessageDialog(vue, "Le mois doit être entre 1 et 12 !");
            return null;
        }
        if (jourVal < 1 || jourVal > 31) {
            JOptionPane.showMessageDialog(vue, "Le jour doit être entre 1 et 31 !");
            return null;
        }

        // formatage exact (05 au lieu de 5)
        String jourFmt;
        if (jourVal < 10) {
            jourFmt = "0" + jourVal;
        } else {
            jourFmt = jourVal + "";
        }

        String moisFmt;
        if (moisVal < 10) {
            moisFmt = "0" + moisVal;
        } else {
            moisFmt = moisVal + "";
        }

        // Concaténation et retour de l'objet
        return LocalDate.parse(anneeVal + "-" + moisFmt + "-" + jourFmt);
    }
}
