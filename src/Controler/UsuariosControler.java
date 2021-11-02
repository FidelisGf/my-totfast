package Controler;
import Model.*;

import java.io.*;
import java.text.FieldPosition;
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

    public String editarUsuarioControler(Usuarios usuario) throws IOException{
        if (usuario.getAcessoUsuario() != null) {
            FileReader file2 = new FileReader(caminhoUsuarios);
            BufferedReader fileR = new BufferedReader(file2);
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
                if (usuario.getIdUsuario()-1 != Long.parseLong(bufferId)) {
                    usuarios.add(texto);
                }
            }
            file2.close();
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
}
