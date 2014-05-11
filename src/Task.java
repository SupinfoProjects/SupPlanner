public class Task extends ToDo
{
    private boolean complete;

    public Task(String name, String authorName, CustomDate startDate, CustomDate endDate) throws Exception
    {
        super(name, authorName, startDate, endDate);
        this.complete = false;
    }

    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

    public boolean isComplete()
    {
        return this.complete;
    }
}
