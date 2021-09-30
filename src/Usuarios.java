import java.io.*;
import java.util.Scanner;

public class Usuarios {
    private int id;
    private String username;
    private String password;
    private String unity;
    private String access;
    private Totfast totem = new Totfast();
    private Scanner scan = new Scanner(System.in);


    Usuarios() {

    }

    Usuarios(int newId, String newUser, String newPassword,String newUnity, String newAccess) {
        this.id = newId;
        this.username = newUser.trim();
        this.password = newPassword.trim();
        this.unity = newUnity.trim();
        this.access = newAccess.trim();
    }

    public int getId() throws IOException {  // le o id do arquivo
        File fileExists = new File("./config/funcionarios_id");
        int idNow;

        if (! fileExists.exists()) {
            FileWriter file = new FileWriter("./config/funcionarios_id");
            PrintWriter fileW = new PrintWriter(file);
            fileW.println("0");
            idNow = 0;
            file.close();
        }
        else {
            FileReader file = new FileReader("./config/funcionarios_id");
            BufferedReader fileR = new BufferedReader(file);
            idNow = Integer.parseInt(fileR.readLine());
            file.close();
        }
        return idNow + 1;
    }

    public void setId(int id) throws IOException {  // escreve o id atual no arquivo
        FileWriter file = new FileWriter("./config/funcionarios_id");
        PrintWriter fileW = new PrintWriter(file);
        fileW.println(id);
        file.close();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public void salvarUsuario() throws IOException {
        FileWriter file = new FileWriter("./config/funcionarios.txt", true);
        PrintWriter fileW = new PrintWriter(file);

        fileW.println(this.id + " " + this.username + " " + this.password + " " + this.unity + " " + this.access);
        file.close();
    }

    public void visualizarFuncionarios() throws IOException {
        File fileExists = new File("./config/funcionarios.txt");

        totem.cls();

        if (fileExists.exists()) {
            FileReader file = new FileReader("./config/funcionarios.txt");
            BufferedReader fileR = new BufferedReader(file);
            String textLine = fileR.readLine();
            
            System.out.println("ID | NOME | SENHA | UNIDADE | ACESSO");
            System.out.println("*************************************");
            while (textLine != null) {
                System.out.println(textLine);
                textLine = fileR.readLine();
            }
            System.out.println("*************************************");
    
            file.close();

            System.out.print("\n\nPressione ENTER para continuar ");
            scan.nextLine();
        }
        else {
            System.err.print("Nao possui funcionarios cadastrados! - Pressione ENTER para continuar ");
            scan.nextLine();
        }
    }
}
