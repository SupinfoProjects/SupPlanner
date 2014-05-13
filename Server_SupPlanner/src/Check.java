import java.sql.Connection;
import java.sql.ResultSet;

public class Check {
    public static boolean checkName(Connection connection, String name){
        try
        {
            name = name.toLowerCase();
            java.sql.Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT  name from user WHERE name='" + name + "'");
            int i = 0;
            while (result.next())
            {
                i++;
            }
            return i != 0;

        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    public static boolean checkMail(Connection connection, String mail){
        try
        {
            mail = mail.toLowerCase();
            java.sql.Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT  email from user WHERE email='" + mail + "'");
            int i = 0;
            while (result.next()){
                i++;
            }
            return i != 0;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
