package Controler;
import View.*;

import java.io.IOException;

public class AdministradorController {

    public void menuAdmistradorController(String option) throws IOException{
        AdministradorView adm = new AdministradorView();
        EmpresaView empresa = new EmpresaView();
        UsuarioView usuario = new UsuarioView();


        if (option.equals("1")) {  // empresa
            empresa.menuEmpresaView();
            adm.menuAdministradorView();
        }
        else if (option.equals("2")) {  // unidades
            adm.menuAdministradorView();
        }
        else if (option.equals("3")) {  // funcionarios
            usuario.funcionarioView();
            adm.menuAdministradorView();
        }
    }

}
