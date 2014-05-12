import java.sql.Connection;
import java.sql.ResultSet;

public class Register {
    public static boolean register(Connection connection, String name, String mail, String pass, String userType){

        try{
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO user (name,email,password,userType) VALUES ('"+ name + "','"+mail+"','"+pass+"','"+userType+"');");
            System.out.println("requête effectuée.");
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
