package autonoma.ComeComidas.models;

import autonoma.ComeComidas.models.Comida;

public class ComidaPizza extends Comida {
    public ComidaPizza(int x) {
        super(x);
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizza.png")).getImage();
    }
}
    