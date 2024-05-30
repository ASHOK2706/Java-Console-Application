
public class Task {
    private int id;
    private String title;
    private String discription;
    private String priority;
    private String status;
    
    public Task(int id,String title,String discription,String priority,String status) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Title: " + title + ", Discription: " + discription + ", Priority: " + priority
                + ", Status=" + status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
 }
