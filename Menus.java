import java.util.Scanner;

public class Menus {
    private Totfast totem = new Totfast();

    public String menuAdmin() {
        Scanner scan = new Scanner(System.in);

        totem.cls();
        System.out.println("********************************");
        System.out.println("1 - Gerenciar Empresa");
        System.out.println("2 - Sair");
        System.out.println("********************************");
        return scan.nextLine();
    }

    public String gerenciarEmpresa() {
        Scanner scan = new Scanner(System.in);

        totem.cls();
        System.out.println("********************************");
        System.out.println("1 - Registrar Empresa");
        System.out.println("2 - Vizualizar Empresa");
        System.out.println("3 - Editar Empresa");
        System.out.println("4 - Voltar");
        System.out.println("********************************");
        return scan.nextLine();
    }

    public String editarEmpresa() {  // opcao 3 do gerenciarEmpresa()
        Scanner scan = new Scanner(System.in);

        totem.cls();
        System.out.println("********************************");
        System.out.println("1 - Editar todos os campos");
        System.out.println("2 - Editar somente Nome");
        System.out.println("3 - Editar somente Endereco");
        System.out.println("4 - Editar somente CNPJ");
        System.out.println("5 - Voltar");
        System.out.println("********************************");
        return scan.nextLine();
    }
}
