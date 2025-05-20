package autonoma.ComeComidas.models;

import autonoma.ComeComidas.models.ComidaSandwich;
import autonoma.ComeComidas.models.ComidaPizza;
import autonoma.ComeComidas.models.ComidaHelado;
import autonoma.ComeComidas.models.Comida;
import autonoma.ComeComidas.Views.JuegoPanel;
import java.util.Random;

public class ManejadorComida implements Runnable {
    private JuegoPanel panel;
    private Random rand = new Random();

    public ManejadorComida(JuegoPanel panel) {
        this.panel = panel;
    }

    public void run() {
        while (true) {
            int x = rand.nextInt(750);
            int tipo = rand.nextInt(4);
            switch (tipo) {
                case 0 -> panel.agregarElemento(new Comida(x));
                case 1 -> panel.agregarElemento(new ComidaPizza(x));
                case 2 -> panel.agregarElemento(new ComidaSandwich(x));
                case 3 -> panel.agregarElemento(new ComidaHelado(x));
            }
            try {
                Thread.sleep(2200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} 
