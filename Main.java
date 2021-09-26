import java.util.Scanner;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Totfast totem = new Totfast();
        Scanner scan = new Scanner(System.in);
        Users user = new Users();
        Administrator admin = new Administrator();

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
