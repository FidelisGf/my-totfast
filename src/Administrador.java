import java.util.Scanner;
import java.io.*;

public class Administrador {
    private Totfast totem = new Totfast();
    private Menus menu = new Menus();
    private Empresa empresa = new Empresa();
    private Scanner scan = new Scanner(System.in);
    private Usuarios usuario = new Usuarios();
    private String option;

    public void executaAdministrador() throws IOException {
        File empresaExiste = new File("./config/empresa.txt");

        while (true) {
            totem.cls();
            option = menu.menuAdmin();

            if (option.equals("1")) {  // GERENCIAR EMPRESA
                while (true) {
                    totem.cls();
                    option = menu.gerenciarEmpresa();
                    totem.cls();

                    if (option.equals("1")) {
                        if (! empresaExiste.exists()) {
                            System.out.print("Nome: ");
                            String newName = scan.nextLine();

                            System.out.print("Endereco: ");
                            String newAddress = scan.nextLine();

                            System.out.print("CNPJ: ");
                            String newCnpj = scan.nextLine();
                            
                            empresa = new Empresa(newName, newAddress, newCnpj);
                            empresa.salvarEmpresa();
                        }
                        else {
                            System.err.print("Ja possui empresa cadastrada! - Pressione ENTER para continuar ");
                            scan.nextLine();
                        }
                    }
                    else if (option.equals("2")) { 
                        empresa.visualizarEmpresa(); 
                    }
                    else if (option.equals("3")) {
                        if (empresaExiste.exists()) {
                            while (true) {
                                option = menu.editarEmpresa();
                                if (! option.equals("5")) { // opcao 5 == voltar
                                    empresa.editarEmpresa(option);
                                }
                                else {
                                    break;
                                }
                            }
                        }
                        else {
                            System.err.print("Nao possui empresa cadastrada - Pressione ENTER para continuar ");
                            scan.nextLine();
                        }
                    }
                    else if (option.equals("4")) {
                        break;
                    }
                    else {
                        System.err.print("[ERRO] OPCAO INVALIDA! - Presione ENTER para continuar ");
                        scan.nextLine();
                    }
                }
            }
            else if (option.equals("2")) {
                while (true) {

                    option = menu.gerenciarFuncionarios();

                    if (option.equals("1")) {
                        String newUsername = menu.funcionarioUsuario();
                        if (newUsername.length() == 0) {System.err.print("Cadastro de funcionario cancelado - Pressione ENTER para continuar "); scan.nextLine();break;}

                        String newPassword = menu.funcionarioSenha();
                        if (newPassword.length() == 0) {System.err.print("Cadastro de funcionario cancelado - Pressione ENTER para continuar "); scan.nextLine();break;}

                        String newAccess = menu.funcionarioAcesso();
                        if (newAccess.length() == 0) {System.err.print("Cadastro de funcionario cancelado - Pressione ENTER para continuar "); scan.nextLine();break;}

                        String newUnity = menu.funcionarioUnidade();
                        if (newUnity.length() == 0) {System.err.print("Cadastro de funcionario cancelado - Pressione ENTER para continuar "); scan.nextLine();break;}

                        int newId = usuario.getId();
                        usuario.setId(newId);
                        usuario = new Usuarios(newId, newUsername, newPassword, newUnity, newAccess);
                        usuario.salvarUsuario();
                    }
                    else if (option.equals("2")) {
                        usuario.visualizarFuncionarios();
                    }
                    else if (option.equals("3")) {
                        break;
                    }
                    else {
                        System.err.print("[ERRO] OPCAO INVALIDA! - Presione ENTER para continuar ");
                        scan.nextLine();
                    }
                }
            }
            else if (option.equals("5")) {
                break;
            }
            else {
                System.err.print("[ERRO] OPCAO INVALIDA! - Presione ENTER para continuar ");
                scan.nextLine();
            }
        }
    }
}
