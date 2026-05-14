package Magasin.Controleur.ConsulterRayon;

import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Vector;

public class ControleurValiderModificationRayon implements ActionListener {

    Magasin magasin;
    DefaultTableModel modeleTable;
    JFrame fenetre;

    public ControleurValiderModificationRayon(Magasin m, DefaultTableModel modele, JFrame f) {
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
                Vector<Rayon> res = magasin.rechercherRayon(id, "ID");
                String strCapa = modeleTable.getValueAt(i, 2) + "";

                int capacite = Integer.parseInt(strCapa);

                if (!res.isEmpty()) {
                    Rayon r = res.get(0);
                    r.setNomRayon(modeleTable.getValueAt(i, 1) + "");
                    r.setCapacite(capacite);
                }
            }

            JOptionPane.showMessageDialog(fenetre, "Modifications enregistrées !");
            fenetre.dispose(); // On ferme
        }
    }
}
