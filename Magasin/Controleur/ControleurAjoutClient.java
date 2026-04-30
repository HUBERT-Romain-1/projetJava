package Magasin.Controleur;

import Magasin.Model.*;
import Magasin.Vue.*;

import javax.swing.*;
import java.awt.event.*;

public class ControleurAjoutClient implements ActionListener {

    Magasin magasin;
    JTextField txtNom;
    JTextField txtPrenom;
    JTextField txtEmail;
    JFrame fenetre; // pour pouvoir fermer

    public ControleurAjoutClient(Magasin m, JTextField nom,
            JTextField prenom, JTextField email, JFrame fe) {
        this.magasin = m;
        this.txtNom = nom;
        this.txtPrenom = prenom;
        this.txtEmail = email;
        this.fenetre = fe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String email = txtEmail.getText();

        // ALERTE : Logo Alerte
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(fenetre,
                    "Erreur : remplir tous les champs !",
                    "Attention",
                    JOptionPane.ERROR_MESSAGE); // logo Erreur
            return;
        }

        // Confirmation
        int choix = JOptionPane.showConfirmDialog(
                fenetre,
                "Voulez-vous vraiment enregistrer " + prenom + " " + nom + " " + email + "?",
                "Confirmation de validation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE // logo danger
        );

        if (choix == JOptionPane.YES_OPTION) {
            Client c = new Client(nom, prenom, email, magasin);

            JOptionPane.showMessageDialog(fenetre, "Client enregistré avec succès !");
            System.out.println("Client ajouté ! Total : " + magasin.getListeClient().size());

            // On ferme
            fenetre.dispose();
        }
    }
}
