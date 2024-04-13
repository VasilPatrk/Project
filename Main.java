import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        boolean exit = false;
        while (!exit) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Delete Task");
            System.out.println("4. Generate Report for Tasks Due Today");
            System.out.println("5. View All Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
                    String dueDateString = scanner.nextLine();
                    Date dueDate;
                    try {
                        dueDate = dateFormat.parse(dueDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
                        continue; // Go back to the beginning of the loop
                    }
                    Task task = new Task(description, dueDate);
                    taskManager.addTask(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Task ID to mark as completed: ");
                    int taskId = scanner.nextInt();
                    taskManager.markTaskAsCompleted(taskId);
                    break;
                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    taskId = scanner.nextInt();
                    taskManager.deleteTask(taskId);
                    break;
                case 4:
                    taskManager.generateReportForTasksDueToday();
                    break;
                case 5:
                    taskManager.viewAllTasks();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }
}
import java.util.*;
public class Task {
    private int taskId;
    private String description;
    private Date dueDate;
    private boolean completed;

    // Constructors
    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false; // By default, task is not completed
    }

    // Getters and Setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
import java.util.*;
public class TaskManager {
    private List<Task> tasks;
    private int lastTaskId;

    public TaskManager() {
        tasks = new ArrayList<>();
        lastTaskId = 0;
    }

    // Method to add new task
    public void addTask(Task task) {
        task.setTaskId(++lastTaskId);
        tasks.add(task);
    }

    // Method to mark task as completed
    public void markTaskAsCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                task.setCompleted(true);
                return;
            }
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // Method to delete task
    public void deleteTask(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId() == taskId) {
                tasks.remove(i);
                return;
            }
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // Method to generate report for tasks due today
    public void generateReportForTasksDueToday() {
        Date today = new Date();
        System.out.println("Tasks due today:");
        for (Task task : tasks) {
            if (task.getDueDate().equals(today)) {
                System.out.println(task.getDescription());
            }
        }
    }

    // Method to view all tasks
    public void viewAllTasks() {
        System.out.println("All tasks:");
        for (Task task : tasks) {
            System.out.println("ID: " + task.getTaskId() + ", Description: " + task.getDescription() + ", Due Date: " + task.getDueDate() + ", Completed: " + task.isCompleted());
        }
    }
}
