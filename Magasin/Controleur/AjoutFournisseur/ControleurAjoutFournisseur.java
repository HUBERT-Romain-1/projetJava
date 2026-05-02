package Magasin.Controleur.AjoutFournisseur;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.event.*;

public class ControleurAjoutFournisseur implements ActionListener {

    Magasin magasin;
    JTextField txtNom;
    JTextField txtNum;
    JTextField txtRue;
    JTextField txtVille;
    JFrame fenetre;

    public ControleurAjoutFournisseur(Magasin m, JTextField nom,
            JTextField num, JTextField rue,
            JTextField ville, JFrame f) {
        this.magasin = m;
        this.txtNom = nom;
        this.txtNum = num;
        this.txtRue = rue;
        this.txtVille = ville;
        this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nom = txtNom.getText();
        String num = txtNum.getText();
        String rue = txtRue.getText();
        String ville = txtVille.getText();

        // ALERTE : Logo Alerte
        if (nom.isEmpty() || num.isEmpty() || rue.isEmpty() || ville.isEmpty()) {
            JOptionPane.showMessageDialog(fenetre,
                    "Attention : Vous devez remplir le nom et l'adresse complète !",
                    "Champs incomplets",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmation
        int choix = JOptionPane.showConfirmDialog(fenetre,
                "Valider la fiche de ce fournisseur ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (choix == JOptionPane.YES_OPTION) {

            String adresseComplete = num + " " + rue + ", " + ville;

            new Fournisseur(ville, adresseComplete, magasin);

            JOptionPane.showMessageDialog(fenetre, "Fournisseur ajouté !");
            fenetre.dispose();
        }
    }
}