package Controler;
import View.*;

import java.io.IOException;
import java.io.*;

public class AdministradorControler {

    public boolean menuAdmistradorControler(String option) throws IOException{
        AdministradorView adm = new AdministradorView();
        boolean msg = true;

        if (option.equals("1")) {  // empresa

        }
        else if (option.equals("2")) {  // unidades

        }
        else if (option.equals("3")) {  // funcionarios
            adm.funcionarioAdministradorView();
        }
        else {  // invalida
            msg = false;
        }
        return msg;
    }

    public boolean funcionarioAdministradorControler(String option) throws IOException {
        boolean msg = true;
        UsuariosView usuario = new UsuariosView();

        if (option.equals("1")) {  // cadastrar funcionario
            usuario.cadastroUsuarioView();
        }
        else if (option.equals("2")) {  // visualizar funcionario
            usuario.visualizarUsuarioView();
        }
        else if (option.equals("3")) {  // editar funcionario
            usuario.editarUsuarioView();
        }
        else {  // invalida
            msg = false;
        }

        return msg;
    }
}
