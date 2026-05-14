package Magasin.Controleur.AjoutArticle;

import Magasin.Model.*;
import Magasin.Vue.VueAjout.VueAjoutArticle;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class ControleurEnregistrerArticle implements ActionListener {

    Magasin magasin;
    VueAjoutArticle vue; // On stocke toute la fenêtre

    public ControleurEnregistrerArticle(Magasin m, VueAjoutArticle v) {
        this.magasin = m;
        this.vue = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // le type sélectionné (Nourriture, Vêtement ou Matériel)
        String typeSelectionne = (String) vue.comboType.getSelectedItem();
        Rayon rayonCible = (Rayon) vue.comboRayon.getSelectedItem();
        Fournisseur fournisseur = (Fournisseur) vue.comboFournisseur.getSelectedItem();

        String strNom = vue.zoneNom.getText();
        String strPrix = vue.zonePrix.getText().replace(",", "."); // On gère la virgule
        String strStock = vue.zoneStock.getText();
        String strMarque = vue.zoneMarque.getText();

        if (strNom.isEmpty() || strPrix.isEmpty() || strStock.isEmpty() || strMarque.isEmpty()) {
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

        if (rayonCible != null && rayonCible.estPlein()) {
            JOptionPane.showMessageDialog(vue, "Le rayon " + rayonCible.getNomRayon() + " est plein !");
            return;
        }
        if (!estPrixValide(strPrix)) {
            JOptionPane.showMessageDialog(vue, "Le prix doit être un nombre positif (ex: 19.99) !",
                    "Erreur Prix",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (rayonCible == null || rayonCible.estPlein()) {
            JOptionPane.showMessageDialog(vue, "Rayon plein ",
                    "Erreur Rayon",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double prix = Double.parseDouble(strPrix);
        int stock = Integer.parseInt(strStock);

        // champs non primaire

        if (typeSelectionne.equals("Nourriture")) {
            LocalDate datePeremption = validerEtCreerDate();
            String strSaveur = vue.zoneSaveur.getText();

            if (strSaveur.isEmpty() || datePeremption == null) {
                JOptionPane.showMessageDialog(vue, "Veuillez remplir la zone saveur et la date !",
                        "Erreur Saveur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            new Nourriture(strNom, prix, stock, strMarque, rayonCible, fournisseur, magasin, strSaveur,
                    datePeremption);

            JOptionPane.showMessageDialog(vue, "Nourriture enregistrée !");
            System.out.println("Nourriture enregistré");
            vue.dispose();

        } else if (typeSelectionne.equals("Vêtement")) {
            String strCouleur = vue.zoneCouleur.getText();
            String taille = (String) vue.comboTaille.getSelectedItem();

            if (strCouleur.isEmpty()) {
                JOptionPane.showMessageDialog(vue,
                        " Veuillez remplir la zone couleur !",
                        "Attention",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            new Vetement(strNom, prix, stock, strMarque, rayonCible, fournisseur, magasin, taille, strCouleur);

            JOptionPane.showMessageDialog(vue, "Vêtement enregistrée !");
            vue.dispose();
        }

        else {

            String strPoids = vue.zonePoids.getText() + "";
            String strLargeur = vue.zoneLargeur.getText() + "";
            String strLongeur = vue.zoneLongueur.getText() + "";

            if (strLongeur.isEmpty() || strLargeur.isEmpty() || strPoids.isEmpty()) {
                JOptionPane.showMessageDialog(vue, "Veuillez remplir tous les champs !",
                        "Attention",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!estPrixValide(strLongeur) || !estPrixValide(strLargeur) || !estPrixValide(strPoids)) {
                JOptionPane.showMessageDialog(vue,
                        "Les dimensions et le poids doivent être des nombres valides (ex: 12.5)",
                        "Erreur de saisie",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Double doubleLongeur = Double.parseDouble(vue.zoneLongueur.getText());
            Double doubleLargeur = Double.parseDouble(vue.zoneLargeur.getText());
            Double doublePoids = Double.parseDouble(vue.zonePoids.getText());

            Materiel m = new Materiel(strNom, prix, stock, strMarque, magasin, rayonCible,
                    fournisseur, doublePoids, doubleLongeur, doubleLargeur);

            JOptionPane.showMessageDialog(vue, "Matériel enregistrée !");
            vue.dispose();
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
        String j = vue.txtJ.getText();
        String m = vue.txtM.getText();
        String a = vue.txtA.getText();

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
