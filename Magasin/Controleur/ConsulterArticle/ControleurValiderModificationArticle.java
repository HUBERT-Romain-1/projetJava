package Magasin.Controleur.ConsulterArticle;

import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Vector;

public class ControleurValiderModificationArticle implements ActionListener {

    Magasin magasin;
    DefaultTableModel modeleTable;
    JFrame fenetre;

    public ControleurValiderModificationArticle(Magasin m, DefaultTableModel modele, JFrame f) {
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
                String idSaisie = modeleTable.getValueAt(i, 0) + "";

                // Recup Article
                Vector<Article> res = magasin.rechercherArticle(idSaisie, "ID");

                if (!res.isEmpty()) {
                    Article a = res.get(0);

                    String prixString = modeleTable.getValueAt(i, 2) + "";
                    String stockString = modeleTable.getValueAt(i, 3) + "";

                    prixString = prixString.replace(" Euro", "");

                    // On transforme le String en double / int
                    double prixDouble = Double.parseDouble(prixString);
                    int stockInt = Integer.parseInt(stockString);

                    a.setNomProduit(modeleTable.getValueAt(i, 1) + "");
                    a.setPrix(prixDouble);
                    a.setStock(stockInt);
                    a.setMarque(modeleTable.getValueAt(i, 4) + "");
                }
            }

            JOptionPane.showMessageDialog(fenetre, "Modifications enregistrées !");
            fenetre.dispose(); // On ferme
        }
    }
}
