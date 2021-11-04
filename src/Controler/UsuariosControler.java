package Controler;
import Model.*;
import View.AdministradorView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UsuariosControler {
    private File caminhoUsuarios = new File("./config/usuarios");

    public String cadastroUsuarioControler(Usuarios usuario) throws IOException {
        if (usuario.getAcessoUsuario() != null) {
            FileWriter file = new FileWriter(caminhoUsuarios, true);
            PrintWriter fileW = new PrintWriter(file);
            fileW.println(usuario);
            file.close();
            return usuario.getNomeUsuario() + " foi cadastrado com sucesso!";
        }
        else {
            return "erro ao cadastrar usuario!";
        }
    }

    public String visualizarUsuarioControler() throws IOException{
        if (caminhoUsuarios.exists()) {
            FileReader file = new FileReader(caminhoUsuarios);
            BufferedReader fileR = new BufferedReader(file);
            String texto = fileR.readLine();
            String usuarios = "ID | NOME | SENHA | ACESSO | UNIDADE\n";

            while (texto != null) {
                usuarios += texto + '\n';
                texto = fileR.readLine();
            }

            file.close();

            return usuarios;
        }
        else {
            return "nenhum usuario cadastrado!";
        }
    }

    public String visualizarUsuarioPorId(String id) throws IOException{
        if (caminhoUsuarios.exists()) {
            FileReader file = new FileReader(caminhoUsuarios);
            BufferedReader fileR = new BufferedReader(file);
            StringTokenizer token;
            String texto;
            String buffer;

            while (true) {
                texto = fileR.readLine();
                if (texto == null) {
                    break;
                }
                else {
                    token = new StringTokenizer(texto, " | ");
                    buffer = token.nextToken();
                    if (id.equals(buffer)) {
                        return "ID | NOME | SENHA | ACESSO | UNIDADE\n" + texto;
                    }
                }
            }
            file.close();
            return "usuario nao encontrado!";
        }
        else {
            return "nenhum usuario cadastrado!";
        }
    }

    public List<String> backupUsuarios(long id) throws IOException{
        FileReader file = new FileReader(caminhoUsuarios);
        BufferedReader fileR = new BufferedReader(file);
        StringTokenizer token;
        String bufferId;
        String texto;
        List<String> usuarios = new ArrayList<>();

        while (true) {
            texto = fileR.readLine();
            if (texto == null) {
                break;
            }
            token = new StringTokenizer(texto, " | ");
            bufferId = token.nextToken();
            if (id != Long.parseLong(bufferId)) {
                usuarios.add(texto);
            }
        }
        file.close();

        return usuarios;  // lista dos usuarios
    }

    public String editarUsuarioControler(Usuarios usuario) throws IOException{
        if (usuario.getAcessoUsuario() != null) {
            List<String> usuarios = backupUsuarios(usuario.getIdUsuario()-1);
            FileWriter file = new FileWriter(caminhoUsuarios);
            PrintWriter fileW = new PrintWriter(file);

            for (int i = 0; i < usuarios.size(); i ++) {
                fileW.println(usuarios.get(i));
            }
            fileW.println(usuario);
            file.close();

            return usuario.getNomeUsuario() + " foi editado com sucesso!";
        }
        else {
            return "erro ao editar usuario!";
        }
    }

    public String deletarUsuarioControler(Usuarios usuario) throws IOException{
        List<String> usuarios = backupUsuarios(usuario.getIdUsuario()-1);
        FileWriter file = new FileWriter(caminhoUsuarios);
        PrintWriter fileW = new PrintWriter(file);

        for (int i = 0; i < usuarios.size(); i ++) {
            fileW.println(usuarios.get(i));
        }
        file.close();

        return "usuario foi deletado com sucesso!";
    }

    public void loginUsuarioControler(Usuarios usuario) throws IOException{  // get() > 1 = usuario, 2 = senha, 3 = acesso
        if (caminhoUsuarios.exists()) {
            FileReader file = new FileReader(caminhoUsuarios);
            BufferedReader fileR = new BufferedReader(file);
            StringTokenizer token;
            String texto;
            List<String> linha;
            String acesso = "";

            while (true) {
                linha = new ArrayList<>();
                texto = fileR.readLine();
                if (texto == null) {
                    break;
                }
                token = new StringTokenizer(texto, " | ");
                while (token.hasMoreTokens()) {
                    linha.add(token.nextToken());
                }
                if (linha.get(1).equals(usuario.getNomeUsuario())) {
                    if (linha.get(2).equals(usuario.getSenhaUsuario())) {
                        acesso = linha.get(3);
                        break;
                    }
                }
            }
            file.close();

            // redireciona para a classe responsavel, de acordo com o login de acesso
            if (acesso.equals("administrador")) {
                AdministradorView adm = new AdministradorView();
                adm.menuAdministradorView(Long.parseLong(linha.get(0)));  // manda o id do adm pra classe dele
            }
            else if (acesso.equals("supervisor")) {

            }
            else if (acesso.equals("funcionario")) {

            }
        }
    }
}
