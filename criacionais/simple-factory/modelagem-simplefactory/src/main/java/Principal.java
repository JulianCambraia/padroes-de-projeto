import com.br.juliancambraia.simplefactorymodelagem.negocio.SimpleFactory;
import com.br.juliancambraia.simplefactorymodelagem.negocio.TipoAbstrato;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Chamada Randômica para decidir qual classe concreta será instanciada inernamente pela classe SimpleFactory ");
        TipoAbstrato objeto = SimpleFactory.newObject();
        System.out.println("Tipo de objeto criado " + objeto.getClass().getSimpleName());
    }
}
