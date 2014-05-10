import java.util.Date;

public class CustomDate extends Date
{
    int year, month, day;

    public CustomDate(int year, int month, int day)
    {
        super(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getMonth()
    {
        return this.month;
    }
}
