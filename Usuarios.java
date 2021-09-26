public class Usuarios {
    private String username;
    private String password;
    private String access;

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        if (access.equals("administrator") || access.equals("admin")) {
            this.access = "administrator";
        }
        else {
            this.access = "client";
        }
    }

}
