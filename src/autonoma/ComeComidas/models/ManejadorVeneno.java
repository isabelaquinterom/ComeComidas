package autonoma.ComeComidas.models;

import autonoma.ComeComidas.Views.JuegoPanel;
import java.util.Random;

public class ManejadorVeneno implements Runnable {
    private JuegoPanel panel;
    private Random rand = new Random();

    public ManejadorVeneno(JuegoPanel panel) {
        this.panel = panel;
    }

    public void run() {
        while (true) {
            int x = rand.nextInt(750);
            int tipo = rand.nextInt(4);
            switch (tipo) {
                case 0 -> panel.agregarElemento(new Veneno(x));
                case 1 -> panel.agregarElemento(new VenenoHongo(x));
                case 2 -> panel.agregarElemento(new VenenoBacteria(x));
                case 3 -> panel.agregarElemento(new VenenoCalavera(x));
            }
            try {
                Thread.sleep(2800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}