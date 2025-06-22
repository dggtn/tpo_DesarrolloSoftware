package vista;

import controlador.TecladoController;

public class Login extends Pantalla {

    public Login(TecladoController teclado) {
        super(teclado);
    }

    @Override
    public String mostrar() {
        System.out.println("ME FALTO HACER EL LOGIN");
        return "Inicio";
    }
}
