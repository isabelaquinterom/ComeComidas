package autonoma.ComeComidas.views;

import javax.swing.*;

public class JuegoFrame extends JFrame {
    public JuegoFrame() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas jugar?", "Come Comida", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            setTitle("Atrapa la Comida!");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            add(new JuegoPanel());
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        } else {
            System.exit(0);
        }
    }
}
