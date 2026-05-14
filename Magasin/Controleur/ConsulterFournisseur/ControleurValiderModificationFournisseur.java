package Magasin.Controleur.ConsulterFournisseur;

import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Vector;

public class ControleurValiderModificationFournisseur implements ActionListener {

    Magasin magasin;
    DefaultTableModel modeleTable;
    JFrame fenetre;

    public ControleurValiderModificationFournisseur(Magasin m, DefaultTableModel modele, JFrame f) {
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

                // Recup Client
                Vector<Fournisseur> res = magasin.rechercherFournisseur(id, "ID");

                if (!res.isEmpty()) {
                    Fournisseur f = res.get(0);
                    f.setNomFournisseur(modeleTable.getValueAt(i, 1) + "");
                    f.setAdresse(modeleTable.getValueAt(i, 2) + "");
                }
            }

            JOptionPane.showMessageDialog(fenetre, "Modifications enregistrées !");
            fenetre.dispose(); // On ferme
        }
    }
}
