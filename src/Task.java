import java.util.Date;

public class Task extends ToDo
{
    private boolean complete;

    public Task(String name, String authorName, Date startDate, Date endDate) throws Exception
    {
        super(name, authorName, startDate, endDate);
        this.complete = false;
    }
}
