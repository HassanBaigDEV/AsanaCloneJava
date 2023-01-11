package app.db;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class AddTask implements Serializable {
    public static void AddTasktoUser(Task task, String email) {
        boolean check = true;
        ArrayList<Users> users = Users.getUsers();
        File file = new File("users.ser");
        ObjectOutputStream oos;
        if (users != null) {
            for (Users u : users) {
                if (Objects.equals(u.getUser_email(), email)) {
                    for (Task t : u.getTasks()) {
                        if (t.getTaskName().equals(task.getTaskName())) {
                            check = false;
                            System.out.println("false hogya ye to");
                        }
                    }
                    if (check) {
                        System.out.println("hogya task add");
                        u.getTasks().add(task);
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


    static void writeTasks() {

    }
}
