package app.db;

import java.io.*;
import java.util.ArrayList;
import app.db.Date;
import java.util.Locale;
import java.util.Objects;

public class Task implements Serializable {
    private String parentProject;
    private String taskName;
    private Date taskStartDate;
    private Date taskDueDate;
    private String status;

    public Task(String parentProject, String taskName, Date taskStartDate, Date taskDueDate) {
        this.parentProject = parentProject;
        this.taskName = taskName;
        this.taskStartDate = taskStartDate;
        this.taskDueDate = taskDueDate;
        this.status = "To Do";
    }

    public String getTaskName() {
        return taskName;
    }

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }


    public void setStatus(String status, String email) {
        ArrayList<Users> users = Users.getUsers();
        File file = new File("users.ser");
        ObjectOutputStream oos;
        if (users != null) {
            for (Users u : users) {
                    for (Task t : u.getTasks()) {
                        if (t.getTaskName().equals(this.getTaskName())) {
                            //System.out.println("hogya task add");
                            switch (status.toLowerCase()) {
                                case "to do" -> t.status = "To Do";
                                case "completed" -> t.status = "Completed";
                                case "overdue" -> t.status = "OverDue";
                                default -> {
                                }
                            }
                        }
                    }
            }
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                for (Users u : users) {
                    oos.writeObject(u);
                }
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        File file1 = new File(this.getParentProject() + ".ser");
        Projects proj = null;
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(file1));
            while (true) {
                proj = (Projects) ois.readObject();
                for (Task t : proj.getTasks()) {
                    if (t.getTaskName().equals(this.getTaskName())) {
                        switch (status.toLowerCase()) {
                            case "to do" -> t.status = "To Do";
                            case "completed" -> t.status = "Completed";
                            case "overdue" -> t.status = "OverDue";
                        }
                    }
                }
            }
        } catch (EOFException e) {
            System.out.println("equal");
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(proj);
            oos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
        }
    }


    public void removeTask() {
        ArrayList<Users> users = Users.getUsers();
        File file = new File("users.ser");
        ObjectOutputStream oos;
        if (users != null) {
            for (Users u : users) {
                //System.out.println("hogya task add");
                u.getTasks().removeIf(t -> t.getTaskName().equals(this.getTaskName()));

            }
        }
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            for (Users u : users) {
                oos.writeObject(u);
            }
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file1 = new File(this.getParentProject() + ".ser");
        Projects proj = null;
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(file1));
            while (true) {
                proj = (Projects) ois.readObject();
                proj.getTasks().removeIf(t -> t.getTaskName().equals(this.getTaskName()));
                }
        } catch (EOFException e) {
            System.out.println("file end");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(proj);
            oos.close();
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
        }
    }

    public String getStatus() {
        return status.toLowerCase(Locale.ROOT);
    }


    public String getParentProject() {
        return parentProject;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskStartDate=" + taskStartDate +
                ", taskDueDate=" + taskDueDate +
                ", status=" + status +
                '}';
    }


}
