public class Mail {
    public static boolean isValid(String mail) {
        return mail.toLowerCase().matches("^[a-z0-9.]+@supinfo.com$");
    }
}
