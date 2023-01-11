package app.db;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userAuth implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;



    private boolean emailValidation(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }


    public static int signUp(Users user) {
        ArrayList<Users> users = getUsers();
        if (users!= null) {
            for (Users u : users) {
                if(Objects.equals(u.getUser_email(),user.getUser_email())) {

                    return 0;
                }
            }
        }

        try{
            File file = new File("users.ser");
            ObjectOutputStream oos;
           // Users.writeUser(new Users(user.userName, user.email));
        if (file.exists()) {
            oos = new MyObjectOutputStream(new FileOutputStream(file,true));
        }
        else{
        oos = new ObjectOutputStream(new FileOutputStream(file));
        }

        oos.writeObject(user);
        oos.close();

        return 1;
        } catch (IOException e) {
            //throw new RuntimeException(e);
            return -1;
        }
    }
    public static int login(String email,String pass){
        ArrayList<Users> users = getUsers();
            if(users!=null) {
                for(Users user:users){
                if(Objects.equals(email,user.getUser_email()))//noinspection SuspiciousIndentAfterControlStatement
                {
                    if(Objects.deepEquals(pass,user.getPassword())) {
                        Users.currentUser = user; //replace it with copy constructor
                        return 1;
                    }
                        }
                }
            }
            else return -1;
        return  -1;
    }

    private static ArrayList<Users> getUsers(){
        ArrayList<Users> users = new ArrayList<>();
        try {
            File file = new File("users.ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                System.out.println(ois.readObject());
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


}