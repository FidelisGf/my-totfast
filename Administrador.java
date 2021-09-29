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
        while (true) {
            totem.cls();
            option = menu.menuAdmin();

            if (option.equals("1")) {  // GERENCIAR EMPRESA
                while (true) {
                    totem.cls();
                    option = menu.gerenciarEmpresa();
                    totem.cls();

                    if (option.equals("1")) {
                        if (! empresa.empresaExiste()) {
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
                            System.out.print("Ja possui empresa cadastrada! - Pressione ENTER para continuar ");
                            scan.nextLine();
                        }
                    }
                    else if (option.equals("2")) { 
                        empresa.visualizarEmpresa(); 
                    }
                    else if (option.equals("3")) {
                        if (empresa.empresaExiste()) {
                            while (true) {
                                option = menu.editarEmpresa();
                                if (! option.equals("5")) {
                                    empresa.editarEmpresa(option);
                                }
                                else {
                                    break;
                                }
                            }
                        }
                        else {
                            System.out.println("Nao possui empresa cadastrada - Entre em contato com o Administrador! ");
                            System.out.print("\n\nPressione ENTER para continuar ");
                            scan.nextLine();
                        }
                    }
                    else if (option.equals("4")) {
                        break;
                    }
                    else {
                        System.out.print("[ERRO] OPCAO INVALIDA! - Presione ENTER para continuar ");
                        scan.nextLine();
                    }
                }
            }
            else if (option.equals("2")) {
                while (true) {

                    option = menu.gerenciarFuncionarios();

                    if (option.equals("1")) {
                        String newUsername = menu.funcionarioUsuario();
                        if (newUsername.length() == 0) {break;}

                        String newPassword = menu.funcionarioSenha();
                        String newAccess = menu.funcionarioAcesso();
                        String newUnity = menu.funcionarioUnidade();
        
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
                        System.out.print("[ERRO] OPCAO INVALIDA! - Presione ENTER para continuar ");
                        scan.nextLine();
                    }
                }
            }
            else if (option.equals("5")) {
                break;
            }
            else {
                System.out.print("[ERRO] OPCAO INVALIDA! - Presione ENTER para continuar ");
                scan.nextLine();
            }
        }
    }
}
