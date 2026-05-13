package Magasin.Controleur.ConsulterFournisseur;

import Magasin.Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Vector;

public class ControleurRechercherFournisseur implements ActionListener {

    Magasin magasin;
    JComboBox<String> combo;
    JTextField zoneTexte;
    DefaultTableModel modele;

    public ControleurRechercherFournisseur(JComboBox<String> comboChoix, JTextField txt, DefaultTableModel modele,
            Magasin m) {

        this.combo = comboChoix;
        this.zoneTexte = txt;
        this.modele = modele;
        this.magasin = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String critere = (String) combo.getSelectedItem();
        String texte = zoneTexte.getText();

        Vector<Fournisseur> resultats;
        // Vide le tableau
        this.modele.setRowCount(0);

        if (texte.isEmpty()) {
            resultats = magasin.getListeFournisseur();
        } else {

            // la liste des Client rechercher Par le critere
            resultats = magasin.rechercherFournisseur(texte, critere);
        }

        for (int i = 0; i < resultats.size(); i++) {
            Fournisseur f = resultats.get(i);
            modele.addRow(f.getLigneTableau());
        }

    }

}
