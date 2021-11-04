package Controler;
import Model.*;
import View.*;
import java.io.*;

public class EmpresaControler {
    File caminhoEmpresa = new File("./config/empresa");

    public boolean menuEmpresaControle(String option) throws IOException{
        EmpresaView empresa = new EmpresaView();

        boolean msg = true;

        if (option.equals("1")) {  // cadastrar empresa
            empresa.cadastrarEmpresaView();
        }
        else if (option.equals("2")) {  // visualizar empresa

        }
        else if (option.equals("3")) {  // editar empresa

        }
        else {  // invalida
            msg = false;
        }

        return msg;
    }

    public String cadastrarEmpresaControler(Empresa empresa) throws IOException{
        if (! caminhoEmpresa.exists() && empresa.getNomeEmpresa() != null && empresa.getEnderecoEmpresa() != null && empresa.getCnpjEmpresa() != null) {
            FileWriter file = new FileWriter(caminhoEmpresa);
            PrintWriter fileW = new PrintWriter(file);

            fileW.println(empresa);
            file.close();

            return empresa.getNomeEmpresa() + " foi cadastrada com sucesso!";
        }
        else {
            return "nao foi possivel cadastrar a empresa!";
        }
    }
}
