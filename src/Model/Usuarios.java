package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;


public class Usuarios {
    private long idUsuario;
    private String nomeUsuario;
    private String senhaUsuario;
    private String acessoUsuario;
    private String unidadeUsuario;

    public Usuarios() {

    }

    public Usuarios(long idUsuario, String nomeUsuario, String senhaUsuario, String acessoUsuario, String uniadeUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.acessoUsuario = acessoUsuario;
        this.unidadeUsuario = uniadeUsuario;
    }

    public long getIdUsuario() throws IOException{
        File caminhoIdUsuario = new File("./config/idUsuarios");

        if (caminhoIdUsuario.exists()) {  // se ja tiver alguem cadastrado
            FileReader file = new FileReader(caminhoIdUsuario);
            BufferedReader fileR = new BufferedReader(file);
            idUsuario = Long.parseLong(fileR.readLine());
            file.close();
        }
        else {  // nao existe id cadastrado, entao cria o arquivo com o id (0)
            FileWriter file = new FileWriter(caminhoIdUsuario);
            PrintWriter fileW = new PrintWriter(file);

            fileW.println("0");  // id inicial (0)
            file.close();
            idUsuario = 0;
        }

        return idUsuario + 1;
    }

    public void setIdUsuario(long idUsuario) throws IOException{
        File caminhoIdUsuario = new File("./config/idUsuarios");
        FileWriter file = new FileWriter(caminhoIdUsuario);
        PrintWriter fileW = new PrintWriter(file);
        fileW.println(idUsuario);
        file.close();
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getAcessoUsuario() {
        return acessoUsuario;
    }

    public void setAcessoUsuario(String acessoUsuario) {
        if (acessoUsuario.equals("1")) {
            this.acessoUsuario = "administrador";
        }
        else if (acessoUsuario.equals("2")) {
            this.acessoUsuario = "supervisor";
        }
        else if (acessoUsuario.equals("3")) {
            this.acessoUsuario = "funcionario";
        }
    }

    public String getUnidadeUsuario() {
        return unidadeUsuario;
    }

    public void setUnidadeUsuario(String unidadeUsuario) {
        this.unidadeUsuario = unidadeUsuario;
    }

    @Override
    public String toString() {
        return idUsuario + " | " + nomeUsuario + " | " + senhaUsuario + " | " + acessoUsuario + " | " + unidadeUsuario;
    }

//    @Override
//    public String toString() {
//        return "Usuarios{" +
//                "idUsuario=" + idUsuario +
//                ", nomeUsuario='" + nomeUsuario + '\'' +
//                ", senhaUsuario='" + senhaUsuario + '\'' +
//                ", acessoUsuario='" + acessoUsuario + '\'' +
//                ", uniadeUsuario='" + uniadeUsuario + '\'' +
//                '}';
//    }
}
