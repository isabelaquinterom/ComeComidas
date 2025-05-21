package autonoma.ComeComidas.Views;

import autonoma.ComeComidas.Views.JuegoPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaJuego extends JFrame {

    public VentanaJuego() {
        // configura la ventana principal del juego
        this.setTitle("¡Come Comida!");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // muestra la pantalla de inicio
        mostrarPantallaInicio();
    }

    // muestra la pantalla inicial con el titulo y boton para jugar
    private void mostrarPantallaInicio() {
        JPanel panelInicio = new JPanel();
        panelInicio.setBackground(Color.BLACK);
        panelInicio.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("🍔 ¿Deseas jugar? 🍟", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        panelInicio.add(titulo, BorderLayout.CENTER);

        JButton botonJugar = new JButton("¡Si, quiero jugar!");
        botonJugar.setFont(new Font("Arial", Font.BOLD, 20));
        botonJugar.setBackground(Color.GREEN);
        botonJugar.setFocusPainted(false);
        botonJugar.addActionListener(e -> iniciarJuego());
        panelInicio.add(botonJugar, BorderLayout.SOUTH);

        this.setContentPane(panelInicio);
        this.setVisible(true);
    }

    // cambia el contenido de la ventana al panel del juego
    private void iniciarJuego() {
        this.setContentPane(new JuegoPanel());
        this.revalidate();
        this.repaint();
    }
}
