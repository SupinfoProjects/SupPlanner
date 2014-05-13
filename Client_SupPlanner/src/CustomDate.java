import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate
{
    String dateString;
    Date date;

    public CustomDate()
    {
        this("");
    }

    public CustomDate(String s)
    {
        this.dateString = s;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            this.date = format.parse(s);
        }
        catch (Exception e)
        {

        }
    }

    public String toString()
    {
        return this.dateString;
    }
}
