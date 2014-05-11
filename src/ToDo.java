public abstract class ToDo {
    String name;
    String authorName;
    CustomDate startDate;
    CustomDate endDate;

    public ToDo(String _name, String _authorName, CustomDate _startDate, CustomDate _endDate)
    {
        this.name = _name;
        this.authorName = _authorName;
        this.startDate = _startDate;
        this.endDate = _endDate;
    }

    public String getTitle()
    {
        return this.name;
    }

    public String getAuthorName()
    {
        return this.authorName;
    }

    public String getStartDate()
    {
        return this.startDate.toString();
    }

    public String getEndDate()
    {
        return this.endDate.toString();
    }
}
