package autonoma.ComeComidas.models;

public class VenenoHongo extends Veneno {
    public VenenoHongo(int x) {
        super(x);
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/hongo.png")).getImage();
    }
}