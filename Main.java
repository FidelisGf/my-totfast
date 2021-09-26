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
            System.out.print("Username: ");
            String username = scan.nextLine().toLowerCase();
            
            if (username.equals("quit")) { 
                break; 
            }

            user.setAccess(username);
            String access = user.getAccess();
            
            if (access.equals("administrator")) {
                admin.runAdministrator();
            }

        }

        scan.close();
    }   
}
