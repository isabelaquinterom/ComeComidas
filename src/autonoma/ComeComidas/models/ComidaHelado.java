package autonoma.ComeComidas.models;

import autonoma.ComeComidas.models.Comida;

public class ComidaHelado extends Comida {
    public ComidaHelado(int x) {
        super(x);
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/helado.png")).getImage();
    }
}

   