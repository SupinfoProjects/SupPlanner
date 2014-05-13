/**
 * Created by tyr on 12/05/14.
 */
public class User
{
    private String name;
    private String email;
    private String password;
    private boolean isManager;

    public User(String _name, String _email, String _password)
    {
        this.name = _name;
        this.email = _email;
        this.password = _password;
    }

    public User(String _name, String _email, String _password, boolean _isManager)
    {
        this(_name,  _email, _password);
        this.isManager = _isManager;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        // Renvoie le password crypté
        return this.password;
    }

    public boolean isManager()
    {
        return this.isManager;
    }
}
