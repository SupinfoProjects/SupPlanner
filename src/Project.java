import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Project extends ToDo
{
    List<Task> tasks;

    public Project()
    {
        super("", "", new Date(), new Date());
    }

    public Project(String name, String authorName, Date startDate, Date endDate)
    {
        super(name, authorName, startDate, endDate);
    }

    public void addNewTask(Task task)
    {
        this.tasks.add(task);
    }

    public JProgressBar getProjectProgress()
    {
        int percent = 0;
        for (Task task : this.tasks)
        {
            if (task.isComplete())
                percent++;
        }
        percent *= 100;
        percent /= this.tasks.size();
        return new JProgressBar(percent);
    }
}
