import java.util.Scanner;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Totfast totem = new Totfast();
        Scanner scan = new Scanner(System.in);
        Usuarios user = new Usuarios();
        Administrador admin = new Administrador();

        while (true) {
            totem.cls();

            System.out.print("Usuario: ");
            String usuario = scan.nextLine().toLowerCase();

            // System.out.print("Senha: ");
            // String senha;
            
            if (usuario.equals("quit")) { 
                break; 
            }

            user.setAccess(usuario);
            String access = user.getAccess();
            access="administrador";
            
            if (access.equals("administrador")) {
                admin.executaAdministrador();
            }

        }

        scan.close();
    }   
}
