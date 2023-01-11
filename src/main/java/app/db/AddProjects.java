package app.db;

import java.io.*;

public class AddProjects  implements Serializable {

    public static int addProject(String name, Projects project) {

        File file = new File(name + ".ser");
        ObjectOutputStream oos;
        try {
            if (file.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(project);
            oos.close();
            addProjectToList(project.getProjectName());

            return 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
            //return -1;
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

     public static int addProjectToList(String name){
         File file = new File(  "AllProjects.ser");
         ObjectOutputStream oos;
         try {
             if (file.exists()) {
                 oos = new MyObjectOutputStream(new FileOutputStream(file, true));
             } else {
                 oos = new ObjectOutputStream(new FileOutputStream(file));
             }
             oos.writeObject(name);
             oos.close();
             Projects.allProjects.add(name);
             return 1;
         } catch (IOException e) {
             throw new RuntimeException(e);
             //return -1;
         } catch (Exception e) {
             System.out.println(e);
         } catch (Error e) {
             System.out.println(e);
         }
         return -1;
     }



}
