import java.io.*;
import java.util.*;

public class Empresa {
    private String name;
    private String address;
    private String cnpj;
    private Totfast totem = new Totfast();
    private Scanner scan = new Scanner(System.in);

    Empresa() {

    }

    Empresa(String newName, String newAddress, String newCnpj) {
        this.name = newName;
        this.address = newAddress;
        this.cnpj = newCnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void salvarEmpresa() throws IOException {
        FileWriter file = new FileWriter("./config/empresa.txt");
        PrintWriter fileW = new PrintWriter(file);

        fileW.println("NOME: " + this.name.toUpperCase());
        fileW.println("ENDERECO: " + this.address.toUpperCase());
        fileW.println("CNPJ: " + this.cnpj.toUpperCase());

        file.close();

        totem.cls();
        System.out.print("As informacoes da empresa foram salvas com sucesso! - Pressione ENTER para continuar ");
        scan.nextLine();
    }

    public void visualizarEmpresa() throws IOException {
        totem.cls();

        try {
            FileReader file = new FileReader("./config/empresa.txt");
            BufferedReader fileR = new BufferedReader(file);
            String textLine;

            System.out.println("********************************");
            textLine = fileR.readLine();
            while (textLine != null) {
                System.out.println(textLine);
                textLine = fileR.readLine();
            }
            file.close();
            System.out.println("********************************");

            System.out.print("\n\nPressione ENTER para continuar ");
            scan.nextLine();
        }
        catch (Exception error) {
            System.out.println("Nao possui empresa cadastrada - Entre em contato com o Administrador! ");
            System.out.print("\n\nPressione ENTER para continuar ");
            scan.nextLine();
        }
    }

    public boolean empresaExiste() throws IOException { 
        try {
            FileReader file = new FileReader("./config/empresa.txt");
            BufferedReader fileR = new BufferedReader(file);
            fileR.readLine();
            file.close();
            return true;
        }
        catch (Exception error) {
            return false;
        }
    }

    public void editarEmpresa(String option) throws IOException {
        totem.cls();
        dadosEmpresa();  // carrega os dados da empresa

        if (option.equals("1")) {  // editar tudo
            System.out.print("Nome: ");
            this.name = scan.nextLine();

            System.out.print("Endereco: ");
            this.address = scan.nextLine();

            System.out.print("CNPJ: ");
            this.cnpj = scan.nextLine();
        }
        else if (option.equals("2")) {  // editar nome
            System.out.print("Nome: ");
            this.name = scan.nextLine();
        }
        else if (option.equals("3")) {  // editar endereco
            System.out.print("Endereco: ");
            this.address = scan.nextLine();
        }
        else if (option.equals("4")) {  // editar cnpj
            System.out.print("CNPJ: ");
            this.cnpj = scan.nextLine();
        }
        else {
            System.out.print("[ERRO] OPCAO INVALIDA! - Presione ENTER para continuar ");
            scan.nextLine();
        }
        salvarEmpresa();
    }

    public void dadosEmpresa() throws IOException {
        FileReader file = new FileReader("./config/empresa.txt");
        BufferedReader fileR = new BufferedReader(file);
        String textLine;

        textLine = fileR.readLine();
        this.name = textLine;

        textLine = fileR.readLine();
        this.address = textLine;

        textLine = fileR.readLine();
        this.cnpj = textLine;

        file.close();
    }
}
