package app.db;

import java.io.*;
import java.util.ArrayList;

import static app.db.Users.getUsers;

public class Projects implements Serializable {

    private static Users projectManager;
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public static ArrayList<String> allProjects = getAllProjects();

    private String projectName;
    private Date DueDate;
    private Date StartDate;
    private String status;
    private ArrayList<Users> members;
    private ArrayList<Task> tasks;


    private Projects() {

    }

    public static Users getProjectManager() {
        return projectManager;
    }

    public static void setProjectManager(Users projectManager) {
        Projects.projectManager = projectManager;
    }

    public Projects(String projectName, Date dueDate, Date startDate, ArrayList<Users> members, ArrayList<Task> tasks) {
        if (allProjects.contains(projectName)) {
            throw new IllegalArgumentException("Project with this name already exists ");
        }
        this.projectName = projectName;
        DueDate = dueDate;
        this.status = "To Do";
        StartDate = startDate;
        this.members = members;
        this.tasks = tasks;
    }


    private static ArrayList<String> getAllProjects() {
        ArrayList<String> projs = new ArrayList<>();

        try {
            File file = new File("AllProjects.ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            //noinspection InfiniteLoopStatement
            while (true) {
                String project = ois.readObject().toString();
                projs.add(project);
            }
        } catch (EOFException e) {
            return projs;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            projs = null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return projs;
    }


    public Date getDueDate() {
        return DueDate;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public String getStatus() {
        return status.toLowerCase();
    }

    public ArrayList<Users> getMembers() {
        return this.members;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setStatus(String status) {

        Projects proj = null;
        File file = new File(this.getProjectName() + ".ser");
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            proj = (Projects) ois.readObject();
            //projects.add(proj);

            switch (status.toLowerCase()) {
                case "to do" -> proj.status = "To Do";
                case "completed" -> proj.status = "Completed";
                case "overdue" -> proj.status = "OverDue";
                default -> {
                }
            }

        } catch (EOFException e) {
            //    System.out.println("equal");
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(proj);
            oos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
            //return -1;
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeProject() {

        for (Task task : this.getTasks()) {
            task.removeTask();
        }

        File file = new File(this.getProjectName() + ".ser");
        boolean delete = file.delete();

        allProjects.remove(this.getProjectName());

        ArrayList<Users> users = getUsers();
        File file1 = new File("users.ser");

        ObjectOutputStream oos;
        if (users != null) {
            for (Users u : users) {
                if (u.getProjects().remove(this.getProjectName())) {
                    System.out.println("hogya delete");
                }
            }
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                for (Users u : users) {
                    oos.writeObject(u);
                }
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Projects.allProjects.remove(this.getProjectName());
    }

    public void removeMemberFromProject(String memberName){

        Projects project = new Projects();
        File file = new File(this.getProjectName() + ".ser");
        try {
           // System.out.println(this.getProjectName() + ".ser");
            ;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            //noinspection InfiniteLoopStatement
            while (true) {
                project = (Projects) ois.readObject();
                System.out.println(project.toString());
            }

        } catch (EOFException e) {
            project.getMembers().removeIf(member -> member.getUser_email().equalsIgnoreCase(memberName));
            //System.out.println("bbbb"+ project.getMembers().removeIf(member -> member.getUser_email().equalsIgnoreCase(memberName)));

            //return project;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            project = null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            // System.out.println(this.getProjectName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            //noinspection InfiniteLoopStatement
                oos.writeObject(project);
                oos.close();
                //System.out.println(project.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Users> users = getUsers();
        File file1 = new File("users.ser");

        ObjectOutputStream oos;
        if (users != null) {
            for (Users u : users) {
                if(u.getUser_email().equalsIgnoreCase(memberName))
                  if (u.getProjects().remove(this.getProjectName())) {
                    System.out.println("hogya delete");
                }
                for(Task task: this.getTasks()){
                    u.getTasks().remove(task);
                }
            }
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file1));
                for (Users u : users) {
                    oos.writeObject(u);
                }
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void addTasks(Task task) {
        Projects proj = null;
        File file = new File(this.getProjectName() + ".ser");
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            //noinspection InfiniteLoopStatement
            while (true) {
                proj = (Projects) ois.readObject();
                //projects.add(proj);
                proj.getTasks().add(task);
            }
        } catch (EOFException e) {
            System.out.println("equal");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(proj);
            oos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
            //return -1;
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
        }


    }

    public static Projects getProject(String name) {
        //ArrayList<Projects> projects = new ArrayList<>();
        Projects project = new Projects();
        try {
            System.out.println(name + ".ser");
            File file = new File(name + ".ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            //noinspection InfiniteLoopStatement
            while (true) {
                project = (Projects) ois.readObject();
                System.out.println(project.toString());
                //return project;

                //  projects.add(project);
            }

        } catch (EOFException e) {
            return project;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            project = null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return project;

    }


    public void AddMemberToProject(Users user) {
        // ArrayList<Projects> projects = new ArrayList<>();
        Projects proj = null;
        File file = new File(this.getProjectName() + ".ser");
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                proj = (Projects) ois.readObject();
                //projects.add(proj);
                proj.getMembers().add(user);
            }
        } catch (EOFException e) {
            System.out.println("equal");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(proj);
            oos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
            //return -1;
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
        }

    }


    public String getProjectName() {
        return projectName;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projectName='" + projectName + '\'' +
                ", DueDate=" + DueDate +
                ", StartDate=" + StartDate +
                ", status=" + status +
                ", members=" + members +
                ", tasks=" + tasks +
                '}';
    }


}
