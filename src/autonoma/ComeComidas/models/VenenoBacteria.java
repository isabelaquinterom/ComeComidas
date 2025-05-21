package autonoma.ComeComida.models;

public class VenenoBacteria extends Veneno {
    public VenenoBacteria(int x) {
        super(x);
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/bacteria.png")).getImage();
    }
}