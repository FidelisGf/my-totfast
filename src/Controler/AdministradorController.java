package Controler;
import View.*;

import java.io.IOException;

public class AdministradorController {

    public void menuAdmistradorController(String option) throws IOException{
        AdministradorView adm = new AdministradorView();
        EmpresaView empresa = new EmpresaView();


        if (option.equals("1")) {  // empresa
            empresa.menuEmpresaView();
            adm.menuAdministradorView();
        }
        else if (option.equals("2")) {  // unidades
            adm.menuAdministradorView();
        }
        else if (option.equals("3")) {  // funcionarios
            adm.funcionarioAdministradorView();
            adm.menuAdministradorView();
        }
    }

    public void funcionarioAdministradorController(String option) throws IOException {
        UsuarioView usuario = new UsuarioView();
        AdministradorView adm = new AdministradorView();

        if (option.equals("1")) {  // cadastrar funcionario
            usuario.cadastroUsuarioView();
            adm.funcionarioAdministradorView();
        }
        else if (option.equals("2")) {  // visualizar funcionario
            usuario.visualizarUsuarioView();
            adm.funcionarioAdministradorView();
        }
        else if (option.equals("3")) {  // editar funcionario
            usuario.editarUsuarioView();
            adm.funcionarioAdministradorView();
        }
    }
}
