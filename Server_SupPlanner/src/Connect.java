import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.sql.StatementEvent;
import javax.swing.plaf.nimbus.State;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class Connect {
    public static void main(String[] args){
        Connection connexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            String url = "jdbc:mysql://localhost:3306/SupPlanner";
            String user = "root";
            String passwd = "";

            connexion = DriverManager.getConnection(url, user,passwd);
            System.out.println("Connexion effective !");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        PrintWriter out;
        BufferedReader Read;
        ServerSocket socketServer;
        Socket socketDuServeur ;

        try {
            while (true){
                socketServer = new ServerSocket(8080);
                System.out.println("Le serveur est à l'écoute du port "+socketServer.getLocalPort());
                socketDuServeur = socketServer.accept();
                System.out.println("Tentative de connection");
                Read = new BufferedReader (new InputStreamReader(socketDuServeur.getInputStream()));
                String step = Read.readLine();
                if (step.equals("login")){
                    String log = Read.readLine();
                    String password = Read.readLine();
                    out = new PrintWriter(socketDuServeur.getOutputStream());
                    Boolean connectionTry;
                    if (log.equals("") || password.equals(""))
                    {
                        connectionTry = false;
                    }
                    else {
                        connectionTry = Login.login(connexion, log, password);
                    }

                    if (connectionTry){
                        System.out.println("Connection établie.");
                        out.println("true");
                        out.flush();
                    }
                    else {
                        out.println("false");
                        out.flush();
                    }
                    socketServer.close();
                    socketDuServeur.close();
                }
                else if(step.equals("register")){
                    String name = Read.readLine();
                    String mail = Read.readLine();
                    String pass = Read.readLine();
                    String userType = Read.readLine();
                    out = new PrintWriter(socketDuServeur.getOutputStream());
                    Boolean inscriptionTry;
                    inscriptionTry = Register.register(connexion, name, mail, pass, userType);

                    if (inscriptionTry){
                        System.out.println("Ajout utilisateur effectué.");
                        out.println("true");
                        out.flush();
                    }
                    else {
                        out.println("false");
                        out.flush();
                    }
                    socketServer.close();
                    socketDuServeur.close();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connexion.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
