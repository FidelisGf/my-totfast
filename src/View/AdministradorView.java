package View;

import Controler.*;
import Model.*;

import java.io.*;
import java.util.*;

public class AdministradorView {
    AdministradorControler controleAdm = new AdministradorControler();
    Scanner scan = new Scanner(System.in);

    public void menuAdministradorView(long idAdm) throws IOException {
        boolean status = true;

        while (status) {
            System.out.println("*****************************");
            System.out.println("      Administrador");
            System.out.println("*****************************");
            System.out.println("1 - Empresa");
            System.out.println("2 - Unidades");
            System.out.println("3 - Funcionarios");
            System.out.println("outro - Sair");
            System.out.println("*****************************");
            status = controleAdm.menuAdmistradorControler(scan.nextLine().trim());
        }
    }

    public void funcionarioAdministradorView() throws IOException{
        boolean status = true;

        while (status) {
            System.out.println("*****************************");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Visualizar Funcionarios");
            System.out.println("3 - Editar Funcionarios");
            System.out.println("outro - Voltar");
            System.out.println("*****************************");
            status = controleAdm.funcionarioAdministradorControler(scan.nextLine().trim());
        }
    }
}
