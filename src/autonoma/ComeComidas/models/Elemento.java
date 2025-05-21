package autonoma.ComeComidas.models;

import autonoma.ComeComidas.models.JuegoInterface;
import java.awt.*;

import javax.swing.ImageIcon;

public abstract class Elemento implements JuegoInterface {
    protected int x, y, velocidad;
    protected Image imagen;

    public Elemento(int x, int velocidad, String ruta) {
        this.x = x;
        this.y = 0;
        this.velocidad = velocidad;
        this.imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
    }

    public void mover() {
        y += velocidad;
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, 50, 50, null);
    }

    public boolean contiene(int mx, int my) {
        return mx >= x && mx <= x + 50 && my >= y && my <= y + 50;
    }

    public int getY() {
        return y;
    }
} 
