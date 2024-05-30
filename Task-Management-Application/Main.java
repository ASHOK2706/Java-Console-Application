

/*
 * 
 * 
 * 
 * Task Manager Application Assignment Document
 1. Introduction:
 -----------------
 The Task Manager application is designed to provide users with a convenient way to
 manage tasks effectively. This document outlines the requirements, functionalities, and
 specifications for the development of the Task Manager application.
 2. Functional Requirements:
 --------------------------
 The Task Manager application should fulfill the following functional requirements:
 ● Usersshould be able to add tasks by providing a title, description, priority
 (High/Medium/Low), and status (Pending/In Progress/Completed).
 ● Usersshould be able to edit existing tasks by specifying the task ID and providing
 updated information for the title, description, priority, and status.
 ● Usersshould be able to delete tasks by specifying the task ID.
 ● Usersshould be able to view all tasks to see a list of all existing tasks along with
 their details.
 ● Usersshould be able to filter tasks by priority to view tasks with a specific priority
 level.
 3. Class Structure:
 ------------------
 The Task Manager application should consist of the following classes:
 ● TaskClass:
 ● Attributes: id, title, description, priority, status.
 ● Methods: __init__(), __str__().
 ● TaskManager Class:
 ● Attributes: tasks (list of Task objects).
 ● Methods: __init__(), add_task(), edit_task(), delete_task(),
 get_task_by_id(), view_all_tasks(), filter_tasks_by_priority().
 4. User Interaction:
 --------------------
 ● TheTaskManagerapplication should provide a command-line interface for user
 interaction.
● Usersshould be presented with a menu containing options to perform various
 tasks (add, edit, delete, view all tasks, filter tasks by priority, exit).
 ● Usersshould input their choice by entering a corresponding number.
 5. Error Handling:
 --------------------
 ● TheTaskManagerapplication should provide error handling for invalid user
 inputs, such as incorrect task IDs or priority/status values.
 ● Error messages should be displayed to guide users in correcting input errors
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TaskManager obj = new TaskManager();
        int taskid=1;
        while(true) {
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Filter Task by Priority");
            System.out.println("6. Exit");

            System.out.print("\n\n Enter your choice (1-6) : ");
            String choice = scan.next();
            
            switch (choice) {
                case "1":
                    obj.add_task(taskid);
                    taskid+=1;
                    break;
                case "2":
                    obj.edit_task();
                    break;
                case "3":
                    obj.delete_task();
                    break;
                case "4":
                    obj.view_all_tasks();
                    break;
                case "5":
                    obj.filter_tasks_by_priority();  
                    break;
                case "6":
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Invalid Choice . Please Enter number from 1 to 6");
                    break;
            }

            System.out.println();
        }
    }
}