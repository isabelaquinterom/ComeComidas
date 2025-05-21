package autonoma.ComeComidas.Views;

import autonoma.ComeComidas.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.util.ArrayList;
import java.util.Iterator;

public class JuegoPanel extends JPanel implements MouseListener {
    private ArrayList<Elemento> elementos; // lista de elementos en pantalla
    private int puntaje = 0; // puntaje actual del jugador
    private Image fondo; // imagen de fondo

    public JuegoPanel() {
        // configura el tamaño del panel
        setPreferredSize(new Dimension(800, 600));
        fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_divertido.png")).getImage();
        elementos = new ArrayList<>();
        addMouseListener(this);

        // inicia los hilos que agregan elementos al juego
        new Thread(new ManejadorComida(this)).start();
        new Thread(new ManejadorVeneno(this)).start();

        // inicia el temporizador para actualizar el juego
        Timer timer = new Timer(30, e -> actualizar());
        timer.start();
    }

    // agrega un nuevo elemento si hay menos de 7 del mismo tipo
    public synchronized void agregarElemento(Elemento e) {
        if (contarTipo(e.getClass()) < 7) {
            elementos.add(e);
        }
    }

    // cuenta cuantos elementos hay de cierto tipo
    private int contarTipo(Class<?> tipo) {
        int c = 0;
        for (Elemento e : elementos) {
            if (e.getClass() == tipo) c++;
        }
        return c;
    }

    // actualiza la posicion de los elementos y los elimina si salen de la pantalla
    private void actualizar() {
        Iterator<Elemento> it = elementos.iterator();
        while (it.hasNext()) {
            Elemento e = it.next();
            e.mover();
            if (e.getY() > getHeight()) {
                it.remove();
            }
        }
        repaint();
    }

    // dibuja el fondo los elementos y el puntaje
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
        for (Elemento e : elementos) {
            e.dibujar(g);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Puntaje: " + puntaje, 10, 30);
    }

    // maneja los clics del mouse para detectar si se ha hecho clic en un elemento
    @Override
    public void mouseClicked(MouseEvent e) {
        Iterator<Elemento> it = elementos.iterator();
        while (it.hasNext()) {
            Elemento el = it.next();
            if (el.contiene(e.getX(), e.getY())) {
                if (el instanceof Comida) puntaje++;
                if (el instanceof Veneno) puntaje -= 2;
                it.remove();
                break;
            }
        }
        repaint();

        // verifica si el juego debe terminar por puntaje alto o bajo
        if (puntaje >= 10 || puntaje <= -5) {
            int opcion = JOptionPane.showConfirmDialog(
                this,
                "Juego terminado.\nTu puntaje fue: " + puntaje + "\n¿Deseas jugar otra vez?",
                "Fin del juego",
                JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                reiniciarJuego();
            } else {
                System.exit(0);
            }
        }
    }

    // reinicia el juego limpiando los elementos y reiniciando el puntaje
    private void reiniciarJuego() {
        elementos.clear();
        puntaje = 0;
        repaint();
    }

    // metodos vacios requeridos por mouselistener
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
