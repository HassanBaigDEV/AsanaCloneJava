/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.db.GUI;

import app.db.Users;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class MakeProjectManagerUI extends JFrame {
    ArrayList<Users> allUsers = Users.getUsers();
    ArrayList<String> allUserLists = new ArrayList<>();
    ArrayList<Users> UserObjectsArray= new ArrayList<>();

    public MakeProjectManagerUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        AddProjectsPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddProjectsPanel6.setBackground(new java.awt.Color(37, 38, 40));
        AddProjectsPanel6.setPreferredSize(new java.awt.Dimension(940, 535));


        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Members");

        jList1.setBackground(new java.awt.Color(102, 102, 102));
        jList1.setForeground(new java.awt.Color(255, 255, 255));

        for (Users user: allUsers){
            allUserLists.add(user.getUser_name());
        }

        jList1.setModel(new AbstractListModel<String>() {
            String[] strings = allUserLists.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jButton1.addMouseListener( new java.awt.event.MouseAdapter(){
            public void mouseClicked (MouseEvent evt){
                int i= jList1.getSelectedIndex();
                if(allUserLists.size() !=0) {
                    allUsers.get(i).setRole("manager");
                }
            }

        });

        jList1.setPreferredSize(new java.awt.Dimension(48, 90));
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(252, 252, 252));
        jButton1.setText("Make Project Manager");

        deleteUserBtn.setBackground(new java.awt.Color(102, 102, 102));
        deleteUserBtn.setForeground(new java.awt.Color(252, 252, 252));
        deleteUserBtn.setText("Delete User");

        deleteUserBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i= jList1.getSelectedIndex();
                if(allUserLists.size() !=0) {
                    System.out.println(allUsers.get(i).getUser_email());
                    Users.deleteUser(allUsers.get(i).getUser_email());
                }
            }
        });

        javax.swing.GroupLayout AddProjectsPanel6Layout = new javax.swing.GroupLayout(AddProjectsPanel6);
        AddProjectsPanel6.setLayout(AddProjectsPanel6Layout);
        AddProjectsPanel6Layout.setHorizontalGroup(
            AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                        .addComponent(deleteUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        AddProjectsPanel6Layout.setVerticalGroup(
            AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;

}
