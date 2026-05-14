package Magasin.Controleur.ConsulterVendeur;

import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Vector;

public class ControleurValiderModificationVendeur implements ActionListener {

    Magasin magasin;
    DefaultTableModel modeleTable;
    JFrame fenetre;

    public ControleurValiderModificationVendeur(Magasin m, DefaultTableModel modele, JFrame f) {
        this.magasin = m;
        this.modeleTable = modele;
        this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Demande Confirmation
        int choix = JOptionPane.showConfirmDialog(
                fenetre,
                "Voulez-vous vraiment enregistrer les modifications ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        // Si UI dit OKK
        if (choix == JOptionPane.YES_OPTION) {

            for (int i = 0; i < modeleTable.getRowCount(); i++) {
                String id = modeleTable.getValueAt(i, 0) + "";

                // Recup Rayon
                Vector<Vendeur> res = magasin.rechercherVendeur(id, "ID");

                if (!res.isEmpty()) {
                    Vendeur v = res.get(0);
                    v.setNomVendeur(modeleTable.getValueAt(i, 1) + "");
                    v.setPrenomVendeur(modeleTable.getValueAt(i, 2) + "");
                    v.setTelephone(modeleTable.getValueAt(i, 3) + "");
                }
            }

            JOptionPane.showMessageDialog(fenetre, "Modifications enregistrées !");
            fenetre.dispose(); // On ferme
        }
    }
}
