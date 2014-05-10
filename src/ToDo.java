import java.util.Date;

public abstract class ToDo {
    String name;
    String authorName;
    Date startDate;
    Date endDate;

    public ToDo(String _name, String _authorName, Date _startDate, Date _endDate)
    {
        this.name = _name;
        this.authorName = _authorName;
        this.startDate = _startDate;
        this.endDate = _endDate;
    }
}
