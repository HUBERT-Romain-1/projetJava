package Magasin.Controleur;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.event.*;

public class ControleurAjoutRayon implements ActionListener {

    Magasin magasin;
    JTextField txtNom;
    JTextField txtCapacite;
    JFrame fenetre;

    public ControleurAjoutRayon(Magasin m, JTextField nom,
            JTextField capa, JFrame f) {
        this.magasin = m;
        this.txtNom = nom;
        this.txtCapacite = capa;
        this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nom = txtNom.getText();
        String capacite = txtCapacite.getText();

        // ALERTE : Logo Alerte
        if (nom.isEmpty() || capacite.isEmpty()) {
            JOptionPane.showMessageDialog(fenetre,
                    "Attention : Vous devez remplir tous les champs",
                    "Champs incomplets",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmation
        int choix = JOptionPane.showConfirmDialog(fenetre,
                "Voulez vous valider ce nouveau rayon ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (choix == JOptionPane.YES_OPTION) {
            int capa = Integer.parseInt(capacite);
            new Rayon(nom, capa, magasin);

            JOptionPane.showMessageDialog(fenetre, "Rayon ajouté !");
            fenetre.dispose();
        }
    }
}