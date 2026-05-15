package Magasin.Controleur.Statistique;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.event.*;

public class BtnStatClient implements ActionListener {

    Magasin magasin;

    public BtnStatClient(Magasin m) {
        this.magasin = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(
                null,
                "Erreur 404 : Développement en Cours ! ",
                "Développement en Cours",
                JOptionPane.INFORMATION_MESSAGE

        );
    }
}
