package autonoma.ComeComidas.Views;

import javax.swing.*;

public class JuegoFrame extends JFrame {
    public JuegoFrame() {
        // muestra un cuadro de dialogo preguntando si desea jugar
        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas jugar?", "Come Comida", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            // configura la ventana del juego si el usuario desea jugar
            setTitle("Atrapa la Comida!");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            add(new JuegoPanel());
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        } else {
            // cierra la aplicacion si el usuario no va jugar
            System.exit(0);
        }
    }
}
