import com.br.juliancambraia.templatemethod.ClasseAbstrata;
import com.br.juliancambraia.templatemethod.SubClasse1;
import com.br.juliancambraia.templatemethod.SubClasseN;

public class Principal {
    public static void main(String[] args) {
        ClasseAbstrata abstrata = new SubClasse1();
        abstrata.templateMethod();

        ClasseAbstrata abstrata1 = new SubClasseN();
        abstrata1.templateMethod();
    }
}
