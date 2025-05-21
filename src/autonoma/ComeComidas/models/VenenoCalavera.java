package autonoma.ComeComida.models;

public class VenenoCalavera extends Veneno {
    public VenenoCalavera(int x) {
        super(x);
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/calavera.png")).getImage();
    }
}