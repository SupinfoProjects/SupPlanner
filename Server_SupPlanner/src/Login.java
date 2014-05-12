import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login {
    public static boolean login(Connection connexion, String  mail, String passwd){
        String email = "";
        String pass = "";

        try{
            java.sql.Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT userType,name,email,password from user WHERE email='"+mail+"' AND password='"+passwd +"';");
            while (resultat.next()){
                String userType = resultat.getString("userType");
                String name = resultat.getString("name");
                email = resultat.getString("email");
                pass = resultat.getString("password");
            }
            if(email.equals(mail) && pass.equals(passwd)){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
