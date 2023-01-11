/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.db.GUI;

import app.db.Users;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Hassan
 */
public class MakeProjectManagerUICOPY extends JFrame {
    ArrayList<Users> allUsers = Users.getUsers();
    ArrayList<String> allUserLists = new ArrayList<>();
    ArrayList<Users> UserObjectsArray= new ArrayList<>();

    /**
     * Creates new form AddMembersUI
     */
    public MakeProjectManagerUICOPY() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddProjectsPanel6 = new JPanel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

        jList1.setPreferredSize(new java.awt.Dimension(48, 90));
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(252, 252, 252));
        jButton1.setText("Make Project Manager");

        jButton1.addMouseListener( new java.awt.event.MouseAdapter(){
            public void mouseClicked (MouseEvent evt){
                int i= jList1.getSelectedIndex();
                if(allUserLists.size() !=0) {
                    allUsers.get(i).setRole("manager");
                }
            }

        });

        GroupLayout AddProjectsPanel6Layout = new GroupLayout(AddProjectsPanel6);
        AddProjectsPanel6.setLayout(AddProjectsPanel6Layout);
        AddProjectsPanel6Layout.setHorizontalGroup(
            AddProjectsPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jButton1)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        AddProjectsPanel6Layout.setVerticalGroup(
            AddProjectsPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(AddProjectsPanel6, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(AddProjectsPanel6, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel AddProjectsPanel6;
    private JButton jButton1;
    private JLabel jLabel2;
    private JList<String> jList1;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
