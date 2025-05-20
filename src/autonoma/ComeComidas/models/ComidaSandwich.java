package autonoma.ComeComidas.models;

import autonoma.ComeComidas.models.Comida;

public class ComidaSandwich extends Comida {
    public ComidaSandwich(int x) {
        super(x);
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/sandwich.png")).getImage();
    }
}
