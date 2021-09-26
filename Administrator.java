import java.util.Scanner;
import java.io.*;

public class Administrator {
    private Totfast totem = new Totfast();
    private Menus menu = new Menus();
    private Company company = new Company();
    private String option;
    private Scanner scan = new Scanner(System.in);

    public void runAdministrator() throws IOException {
        while (true) {
            totem.cls();
            option = menu.menuAdmin();

            if (option.equals("1")) {
                while (true) {
                    totem.cls();
                    option = menu.manageCompany();
                    totem.cls();

                    if (option.equals("1")) {
                        if (! company.companyExists()) {
                            System.out.print("Nome: ");
                            String newName = scan.nextLine().toUpperCase();
                            System.out.print("Endereco: ");
                            String newAddress = scan.nextLine().toUpperCase();
                            System.out.print("CNPJ: ");
                            String newCnpj = scan.nextLine().toUpperCase();
                            company = new Company(newName, newAddress, newCnpj);
                            company.saveCompany(newName, newAddress, newCnpj);
                        }
                        else {
                            System.out.print("Ja possui empresa cadastrada! - Pressione ENTER para continuar ");
                            scan.nextLine();
                        }
                    }
                    else if (option.equals("2")) {
                        company.readCompany(); 
                    }
                    else if (option.equals("3")) {
                        break;
                    }
                    else {
                        System.out.println("[ERRO] OPCAO INVALIDA!");
                    }
                }
            }
            else if (option.equals("2")) {
                break;
            }
            else {
                System.out.println("[ERRO] OPCAO INVALIDA!");
            }

        }
    }

    
}
