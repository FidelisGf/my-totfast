package View;

import Model.*;
import Controler.*;
import java.util.Scanner;
import java.io.*;

public class UsuariosView {
    Usuarios usuario = new Usuarios();
    UsuariosControler controleUsuario = new UsuariosControler();
    Scanner scan = new Scanner(System.in);

    public void cadastroUsuarioView() throws IOException{
        String status;

        usuario.setIdUsuario(usuario.getIdUsuario());
        System.out.print("Usuario: ");
        usuario.setNomeUsuario(scan.nextLine().trim());
        System.out.print("Senha: ");
        usuario.setSenhaUsuario(scan.nextLine().trim());
        System.out.print("Acesso [1 - Administrador / 2 - Supervisor / 3 - Funcionario]: ");
        usuario.setAcessoUsuario(scan.nextLine().trim());
        System.out.print("Unidade: ");
        usuario.setUnidadeUsuario(scan.nextLine().trim());

        status = controleUsuario.cadastroUsuarioControler(usuario);
        System.out.println(status);
    }

    public void visualizarUsuarioView() throws IOException {
        String usuarios = controleUsuario.visualizarUsuarioControler();
        System.out.println(usuarios);
    }

    public void editarUsuarioView() throws IOException {
        String status;
        System.out.print("Digite o ID do usuario que deseja editar: ");
        String id = scan.nextLine().trim();

        status = controleUsuario.visualizarUsuarioPorId(id);
        System.out.println(status);

        if (! status.equals("usuario nao encontrado!") && ! status.equals("nenhum usuario cadastrado!")) {  // se usuario existe

            System.out.print("1 - Editar / 2 - Deletar / outro - Cancelar: ");
            String option = scan.nextLine().trim();

            if (option.equals("1")) {
                usuario.setIdUsuario(Long.parseLong(id));
                System.out.print("Usuario: ");
                usuario.setNomeUsuario(scan.nextLine().trim());
                System.out.print("Senha: ");
                usuario.setSenhaUsuario(scan.nextLine().trim());
                System.out.print("Acesso [1 - Administrador / 2 - Supervisor / 3 - Funcionario]: ");
                usuario.setAcessoUsuario(scan.nextLine().trim());
                System.out.print("Unidade: ");
                usuario.setUnidadeUsuario(scan.nextLine().trim());

                status = controleUsuario.editarUsuarioControler(usuario);
                System.out.println(status);
            }
            else if (option.equals("2")) {
                System.out.print("Tem certeza que deseja excluir? [sim/nao]: ");
                String confirma = scan.nextLine().trim().toLowerCase();
                if (confirma.equals("sim")) {
                    usuario.setIdUsuario(Long.parseLong(id));
                    status = controleUsuario.deletarUsuarioControler(usuario);
                    System.out.println(status);
                }
            }
        }
    }
}
