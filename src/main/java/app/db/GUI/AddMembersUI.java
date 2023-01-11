/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.db.GUI;

import app.db.Projects;
import app.db.Users;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AddMembersUI extends JFrame {
    ArrayList<Users> allUsers = Users.getUsers();
    ArrayList<String> allUserLists = new ArrayList<>();
    ArrayList<Users> UserObjectsArray= new ArrayList<>();

    public AddMembersUI(Projects project) {
        initComponents(project);
    }

    @SuppressWarnings("unchecked")

    private void initComponents(Projects project) {

        AddProjectsPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        AddProjectsPanel6.setBackground(new java.awt.Color(37, 38, 40));
        AddProjectsPanel6.setPreferredSize(new java.awt.Dimension(940, 535));

        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Members");

        jList1.setBackground(new java.awt.Color(102, 102, 102));
        jList1.setForeground(new java.awt.Color(255, 255, 255));

        for (Users user: allUsers){
            boolean check = true;
            for (int i = 0; i < project.getMembers().size(); ++i) {
                if (project.getMembers().get(i).getUser_email().equals(user.getUser_email())) {
                    check = false;
                    System.out.println("qqqq");
                }
            }
            if (check) {
                allUserLists.add(user.getUser_name());
                UserObjectsArray.add(user);
            }
        }

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings =  allUserLists.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jList1.setPreferredSize(new java.awt.Dimension(48, 90));
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm");

        jButton1.addMouseListener( new java.awt.event.MouseAdapter(){
            public void mouseClicked (java.awt.event.MouseEvent evt){
                int i= jList1.getSelectedIndex();
                if(allUserLists.size() !=0) {
                    // System.out.println(allUserLists.get(i));
                    //  System.out.println("addd"+UserObjectsArray.get(i).toString());
                    //project.getMembers().add(UserObjectsArray.get(i));
                    project.AddMemberToProject(UserObjectsArray.get(i));
                    Users.addProjecttoUser(project.getProjectName(),UserObjectsArray.get(i).getUser_email());
                    // System.out.println(project);
                    project.toString();
                    allUserLists.remove(i);
                    UserObjectsArray.remove(i);
                    jList1.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = allUserLists.toArray(new String[0]);
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                    });
                }
            }

        });

        javax.swing.GroupLayout AddProjectsPanel6Layout = new javax.swing.GroupLayout(AddProjectsPanel6);
        AddProjectsPanel6.setLayout(AddProjectsPanel6Layout);
        AddProjectsPanel6Layout.setHorizontalGroup(
            AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        AddProjectsPanel6Layout.setVerticalGroup(
            AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(AddProjectsPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AddProjectsPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
        );

        pack();
    }


    private javax.swing.JPanel AddProjectsPanel6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;

}
