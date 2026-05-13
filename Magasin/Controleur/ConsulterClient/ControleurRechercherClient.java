package Magasin.Controleur.ConsulterClient;

import Magasin.Model.*;
import Magasin.Vue.VueAjout.VueAjoutArticle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Vector;

public class ControleurRechercherClient implements ActionListener {

    Magasin magasin;
    JComboBox<String> combo;
    JTextField zoneTexte;
    DefaultTableModel modele;

    public ControleurRechercherClient(JComboBox<String> comboChoix, JTextField txt, DefaultTableModel modele,
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

        Vector<Client> resultats;
        // Vide le tableau
        this.modele.setRowCount(0);

        if (texte.isEmpty()) {
            resultats = magasin.getListeClient();
        } else {

            // la liste des Client rechercher Par le critere
            resultats = magasin.rechercherClient(texte, critere);
        }

        for (int i = 0; i < resultats.size(); i++) {
            Client a = resultats.get(i);
            modele.addRow(a.getLigneTableau());
        }

    }

}
