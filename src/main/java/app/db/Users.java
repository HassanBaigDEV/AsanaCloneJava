package app.db;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


public class Users implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    public static Users currentUser;

    private String role = "member";
    private String user_name;
    private String user_email;

    private String password;
    // private UUID ID;
    private ArrayList<Task> tasks;

    private ArrayList<String> projects;
    public String getUser_email() {
        return user_email;
    }


    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }

    public Users(String user_name, char[] password , String user_email) {
        this.user_name = user_name;
            this.user_email = user_email;
            this.password= String.valueOf(password);
            tasks = new ArrayList<>();
            projects = new ArrayList<>();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        ArrayList<Users> users = getUsers();
        File file = new File("users.ser");

        ObjectOutputStream oos;
        if (users!= null) {
            for (Users u : users) {
                if(Objects.equals(u.user_email,this.getUser_email())) {
                    u.role = role.toLowerCase();
                    Projects.setProjectManager(u);
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

    }

    @Override
    public String toString() {
        return "Users{" +
                "user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", tasks=" + tasks +
                ", project_name=" + projects +
                '}';
    }

    public ArrayList<String> getProjects() {
        return projects;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void writeUser(Users user) throws IOException {
        File file = new File("users.ser");
        ObjectOutputStream oos;
        try {
            if (file.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(user);
            oos.close();
    } catch (IOException e) {
        throw new IOException();
        }
    }

    public static void addProjecttoUser(String projectName,String email){
        ArrayList<Users> users = getUsers();
        File file = new File("users.ser");

        ObjectOutputStream oos;
        if (users!= null) {
            for (Users u : users) {
                if(Objects.equals(u.user_email,email)) {
                    u.getProjects().add(projectName);
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
    }
    public static Users searchUser(String email){
        ArrayList<Users> users = getUsers();
        if (users!= null) {
            for (Users u : users) {
                if(Objects.equals(u.user_email,email)) {
                    return u;
                }
            }
            return null;
        }
       else return null;
    }

    public static void deleteUser(String email){
        ArrayList<Users> users = getUsers();
        File file = new File("users.ser");

        ObjectOutputStream oos;
        if (users!= null) {
            users.removeIf(u -> Objects.equals(u.user_email, email));
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


    }
    public static ArrayList<Users> getUsers(){
        ArrayList<Users> users = new ArrayList<>();
        try {
            File file = new File("users.ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                Users user = (Users) ois.readObject();
                users.add(user);
            }
        } catch (EOFException e) {
            return users;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            users=null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void addTasks(Task task){
        this.tasks.add(task);

    }



}
