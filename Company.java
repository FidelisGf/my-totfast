import java.io.*;
import java.util.*;

public class Company {
    private String name;
    private String address;
    private String cnpj;
    private Totfast totem = new Totfast();
    
    Company() {}

    Company(String newName, String newAddress, String newCnpj) {
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

    public void saveCompany(String name, String address, String cnpj) throws IOException {
        FileWriter file = new FileWriter("./settings/company.txt");
        PrintWriter fileW = new PrintWriter(file);

        fileW.println("NOME: " + name);
        fileW.println("ENDERECO: " + address);
        fileW.println("CNPJ: " + cnpj);

        file.close();
    }

    public void readCompany() throws IOException {
        Scanner scan = new Scanner(System.in);

        totem.cls();

        try {
            FileReader file = new FileReader("./settings/company.txt");
            BufferedReader fileR = new BufferedReader(file);
            String textLine;

            textLine = fileR.readLine();
            while (textLine != null) {
                System.out.println(textLine);
                textLine = fileR.readLine();
            }

            file.close();

            System.out.print("\n\nPressione ENTER para continuar ");
            scan.nextLine();
        }
        catch (Exception error) {
            System.out.println("Nao possui empresa cadastrada - Entre em contato com o Administrador! ");
            System.out.print("\n\nPressione ENTER para continuar ");
            scan.nextLine();
        }
    }

    public boolean companyExists() throws IOException {        
        try {
            FileReader file = new FileReader("./settings/company.txt");
            BufferedReader fileR = new BufferedReader(file);
            fileR.readLine();
            file.close();
            return true;
        }
        catch (Exception error) {
            return false;
        }
    }
}
