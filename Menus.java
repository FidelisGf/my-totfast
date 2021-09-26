import java.util.Scanner;

public class Menus {
    
    public String menuAdmin() {
        Scanner scan = new Scanner(System.in);

        System.out.println("********************************");
        System.out.println("1 - Gerenciar Empresa");
        System.out.println("2 - Sair");
        System.out.println("********************************");
        return scan.nextLine();
    }

    public String manageCompany() {
        Scanner scan = new Scanner(System.in);

        System.out.println("********************************");
        System.out.println("1 - Registrar Empresa");
        System.out.println("2 - Vizualizar Empresa");
        System.out.println("3 - Voltar");
        System.out.println("********************************");
        return scan.nextLine();
    }
}
