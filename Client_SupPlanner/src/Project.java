import javax.swing.*;
import java.util.List;

public class Project extends ToDo
{
    List<Task> tasks;

    public Project()
    {
        super("", "", new CustomDate(), new CustomDate());
    }

    public Project(String name, String authorName, CustomDate startDate, CustomDate endDate)
    {
        super(name, authorName, startDate, endDate);
    }

    public void addNewTask(Task task)
    {
        this.tasks.add(task);
    }

    public Task[] getTasks()
    {
        if (this.tasks == null || this.tasks.size() == 0)
            return new Task[0];
        return (Task[]) this.tasks.toArray();
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
