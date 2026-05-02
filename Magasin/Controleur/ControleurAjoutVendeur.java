package Magasin.Controleur;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.event.*;

public class ControleurAjoutVendeur implements ActionListener {

    Magasin magasin;
    JTextField txtNom;
    JTextField txtPrenom;
    JTextField txtTel;
    JFrame fenetre; // pour pouvoir fermer

    public ControleurAjoutVendeur(Magasin m, JTextField nom,
            JTextField prenom, JTextField tel, JFrame fe) {
        this.magasin = m;
        this.txtNom = nom;
        this.txtPrenom = prenom;
        this.txtTel = tel;
        this.fenetre = fe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String tel = txtTel.getText();

        // ALERTE : Logo Alerte
        if (nom.isEmpty() || prenom.isEmpty() || tel.isEmpty()) {
            JOptionPane.showMessageDialog(fenetre,
                    "Erreur : remplir tous les champs !",
                    "Attention",
                    JOptionPane.ERROR_MESSAGE); // logo Erreur
            return;
        }

        // Confirmation
        int choix = JOptionPane.showConfirmDialog(
                fenetre,
                "Voulez-vous vraiment enregistrer " + prenom + " " + nom + " " + tel + "?",
                "Confirmation de validation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE // logo danger
        );

        if (choix == JOptionPane.YES_OPTION) {
            new Vendeur(nom, prenom, tel, magasin);

            JOptionPane.showMessageDialog(fenetre, "Vendeur enregistré avec succès !");
            // On ferme
            fenetre.dispose();
        }
    }
}
