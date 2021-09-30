import java.util.Scanner;

public class Menus {
    private Totfast totem = new Totfast();
    private Scanner scan = new Scanner(System.in);

    public String menuAdmin() {
        totem.cls();
        System.out.println("********************************");
        System.out.println("1 - Gerenciar Empresa");
        System.out.println("2 - Gerenciar Funcionario");
        System.out.println("5 - Sair");
        System.out.println("********************************");
        return scan.nextLine().trim();
    }

    public String gerenciarEmpresa() {
        totem.cls();
        System.out.println("********************************");
        System.out.println("1 - Registrar Empresa");
        System.out.println("2 - Vizualizar Empresa");
        System.out.println("3 - Editar Empresa");
        System.out.println("4 - Voltar");
        System.out.println("********************************");
        return scan.nextLine().trim();
    }

    public String editarEmpresa() {  // opcao 3 do gerenciarEmpresa()
        totem.cls();
        System.out.println("********************************");
        System.out.println("1 - Editar todos os campos");
        System.out.println("2 - Editar somente Nome");
        System.out.println("3 - Editar somente Endereco");
        System.out.println("4 - Editar somente CNPJ");
        System.out.println("5 - Voltar");
        System.out.println("********************************");
        return scan.nextLine().trim();
    }

    public String gerenciarFuncionarios() {
        totem.cls();
        System.out.println("********************************");
        System.out.println("1 - Cadastrar Funcionario");
        System.out.println("2 - Visualizar Funcionarios");
        System.out.println("3 - Voltar");
        System.out.println("********************************");
        return scan.nextLine().trim();
    }

    public void funcionarioAjuda() {
        totem.cls();
        System.out.println("Deixe o campo VAZIO e pressione ENTER para cancelar o cadastro de funcionario!\n\n");
    }

    public String funcionarioUsuario() {
        funcionarioAjuda();

        System.out.print("Usuario: ");
        return scan.nextLine().trim();
    }

    public String funcionarioSenha() {
        funcionarioAjuda();

        System.out.print("Senha: ");
        return scan.nextLine().trim();
    }

    public String funcionarioUnidade() {
        funcionarioAjuda();
        
        // return scan.nextLine();
        return "unidade_teste";
    }

    public String funcionarioAcesso() {
        funcionarioAjuda();

        System.out.println("********************************");
        System.out.println("1 - Administrador");
        System.out.println("2 - Supervisor");
        System.out.println("3 - Funcionario");
        System.out.println("********************************");
        String access = scan.nextLine().trim();

        if (access.equals("1")) {
            access = "administrador";
        }
        else if (access.equals("2")) {
            access = "supervisor";
        }
        else if (access.equals("3")) {
            access = "funcionario";
        }
        // fazer um else para dps

        return access;
    }
}
