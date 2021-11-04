package View;

import Model.*;
import Controler.*;
import java.util.Scanner;
import java.io.*;

public class EmpresaView {
    Empresa empresa = new Empresa();
    EmpresaControler controleEmpresa = new EmpresaControler();
    Scanner scan = new Scanner(System.in);

    public void menuEmpresaView() throws IOException{
        boolean status = true;
        while (status) {
            System.out.println("*****************************");
            System.out.println("         Empresa");
            System.out.println("*****************************");
            System.out.println("1 - Cadastrar Empresa");
            System.out.println("2 - Visualizar Empresa");
            System.out.println("3 - Editar Empresa");
            System.out.println("outro - Voltar");
            System.out.println("*****************************");
            status = controleEmpresa.menuEmpresaControle(scan.nextLine().trim());
        }
    }

    public void cadastrarEmpresaView() throws IOException{
        String status;

        System.out.print("Nome: ");
        empresa.setNomeEmpresa(scan.nextLine().trim());
        System.out.print("Endereco: ");
        empresa.setEnderecoEmpresa(scan.nextLine().trim());
        System.out.print("Cnpj: ");
        empresa.setCnpjEmpresa(scan.nextLine().trim());
        status = controleEmpresa.cadastrarEmpresaControler(empresa);

        System.out.println(status);
    }
}
