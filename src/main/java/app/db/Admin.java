package app.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class Admin {

    public void setRole(String role,String email){
        ArrayList<Users> users = Users.getUsers();

        switch (role.toLowerCase()) {
            case "manager":
                for (Users user : users) {
                    if (Objects.equals(user.getUser_email(), email)) {
                        user.setRole("manager");
                    }
                }
                break;
            case "member":
                for (Users user : users) {
                    if (Objects.equals(user.getUser_email(), email)) {
                        user.setRole("member");
                    }
                }
                break;
            default:
                System.out.println("default");
                break;
        }
        File file = new File("users.ser");
        ObjectOutputStream oos;
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
