import java.util.Date;

public class Project extends ToDo
{
    Task[] tasks;
    int percentComplete;

    public Project(String name, String authorName, Date startDate, Date endDate) throws Exception
    {
        super(name, authorName, startDate, endDate);
        this.percentComplete = 0;
    }
}
