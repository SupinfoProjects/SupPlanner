import java.util.Date;
import java.util.List;

public class Project extends ToDo
{
    List<Task> tasks;
    int percentComplete;

    public Project(String name, String authorName, Date startDate, Date endDate) throws Exception
    {
        super(name, authorName, startDate, endDate);
        this.percentComplete = 0;
    }

    public void addNewTask(Task task)
    {
        this.tasks.add(task);
    }
}
