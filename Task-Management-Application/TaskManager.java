import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> task_list = new ArrayList<Task>();
    Scanner scan = new Scanner(System.in);
    //1
    public void add_task(int taskid) {

        System.out.print("Enter Task title: ");
        String title = scan.nextLine();
        System.out.print("Enter task description: ");
        String discription = scan.nextLine();
        String priority = inputPriority();
        String status = inputStatus();
        
        task_list.add(new Task(taskid, title, discription, priority, status));
    }
    //2
    public void edit_task() {

        System.out.print("Enter task ID to edit: ");

        Task editTaskObj = getTaskIdObj();
        
        scan.nextLine();
        System.out.print("Enter new title (leave blank to keep existing): ");
        String newTitle = scan.nextLine();
        if(!(newTitle.equals(""))) {
            editTaskObj.setTitle(newTitle);
        }
        System.out.print("Enter new description (leave blank to keep existing): ");
        String newDiscription = scan.nextLine();
        if(!(newDiscription.equals(""))) {
            editTaskObj.setDiscription(newDiscription);
        }

        System.out.print("Enter new priority (leave blank to keep existing): ");
        String newPriority = new_inputPriority();
        if(!(newPriority.equals(""))) {
            editTaskObj.setPriority(newPriority);
        }
        System.out.print("Enter new status (leave blank to keep existing): ");
        String newStatus = new_inputStatus();
        if(!(newStatus.equals(""))) {
            editTaskObj.setStatus(newStatus);
        }
    }

    //3
    public void delete_task() {
        System.out.print("Enter Task id to Delete : ");
        Task deleteTaskObj = getTaskIdObj();
        if(deleteTaskObj!=null)
            task_list.remove(deleteTaskObj);
        

    }
    //4
    public void view_all_tasks() {
        for(Task task:task_list) {
            System.out.println(task);
        }
    }

    //5
    public void filter_tasks_by_priority() {
        System.out.print("Enter priority to filter tasks (High/Medium/Low): ");
        String filterPriority = getInputfilterPriority();
        for(Task task:task_list) {
            if(filterPriority.equals(task.getPriority())) {
                System.out.println(task);
            }
        }
    }
    //
//-------------


private Task getTaskIdObj() {
        Task editTaskObj=null;
        boolean loop;
        do{
            int id = scan.nextInt();
            
            for(Task task:task_list) {
                if(id==task.getId()) {
                    editTaskObj = task;
                }
            }
            if(editTaskObj==null) {
                System.out.print("Task id is not exists (or) Please Enter Valid Task ID :");
                loop = true;
            }
            else {
                loop = false;
            }
        }while(loop);
        return editTaskObj;
}
    public String inputPriority() {
        String priority;
        while(true){
            System.out.print("Enter Task Priority (High/Medium/Low): ");
            priority = scan.nextLine();
            if(priority.equals("High") ||
               priority.equals("Medium") || 
               priority.equals("Low")) {
                break;
               }
            else {
                System.out.println("Please Enter Correct Input");
            }
        }
        return priority;
    }
    public String inputStatus() {
        String status;
        while(true){
            System.out.print("Enter task status(Pending/In Progress/Completed): ");
            status = scan.nextLine();
            if(status.equals("Pending") ||
               status.equals("In Progress") || 
               status.equals("Completed")) {
                break;
               }
            else {
                System.out.println("Please Enter Correct Input ");
            }
        }
        return status;
    }

    public String new_inputPriority() {
        String newPriority;
        while(true) {
            newPriority = scan.nextLine();
            if(newPriority.equals("")) {
                return "";
            }
            else {
                if(newPriority.equals("High") ||
                   newPriority.equals("Medium") || 
                   newPriority.equals("Low")) {
                    break;
                }
            else {
                System.out.println("Please Enter Correct Input(High/Medium/Low)");
            }
            }
        }
        return newPriority;
    }
    public String new_inputStatus() {
        String newStatus;
        while(true) {
            newStatus = scan.nextLine();
            if(newStatus.equals("")) {
                return "";
            }
            else {
                if(newStatus.equals("Pending") ||
                newStatus.equals("In Progss") || 
                newStatus.equals("Completed")) {
                    break;
                }
                else {
                    System.out.println("Please Enter Correct Input(Pending/In Progress/Completed)");
                }
            }
        }
        return newStatus;
    }
    public String getInputfilterPriority() {
        String filterPriority;
        while(true) {
            filterPriority = scan.nextLine();
            if(filterPriority.equals("High") ||
            filterPriority.equals("Medium") || 
            filterPriority.equals("Low")) {
                    break;
                }
            else {
                System.out.print("Please Enter Correct Input (High/Medium/Low)");
            }
        }
        return  filterPriority;
    }
}
