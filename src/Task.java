import java.util.Date;

public class Task extends ToDo
{
    private boolean complete;

    public Task(String _name, String _authorName, Date _startDate, Date _endDate) throws Exception {
        this.name = _name;
        this.authorName = _authorName;
        this.startDate = _startDate;
        this.endDate = _endDate;
        if (this.startDate.after(this.endDate))
            throw new Exception("Start date cannot be after end date");
        this.complete = false;
    }


}
