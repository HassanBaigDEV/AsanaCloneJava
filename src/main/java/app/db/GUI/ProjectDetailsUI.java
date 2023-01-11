/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.db.GUI;

import app.db.AddTask;
import app.db.Projects;
import app.db.Task;
import app.db.Users;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static app.db.Projects.getProject;


public class ProjectDetailsUI extends JFrame {

    private Projects project;
    private ArrayList<String> tasksList = new ArrayList<>();
    private ArrayList<String> membersList = new ArrayList<>();
    public ProjectDetailsUI(String valueAt) {
        initComponents(valueAt);
    }


    @SuppressWarnings("unchecked")

    private void initComponents(String valueAt) {

        jButton2 = new javax.swing.JButton();
        AddProjectsPanel6 = new javax.swing.JPanel();
        AddTaskBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectMembersList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        projectTaskList = new javax.swing.JList<>();
        AddNewMemberBtn = new javax.swing.JButton();
        assignTaskBtn = new javax.swing.JButton();
        removeMemberBtn = new javax.swing.JButton();
        deleteTaskBtn = new javax.swing.JButton();
        deleteProjectBtn = new javax.swing.JButton();

       // jButton2.setText("jButton2");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        AddProjectsPanel6.setBackground(new java.awt.Color(37, 38, 40));
        AddProjectsPanel6.setPreferredSize(new java.awt.Dimension(940, 535));


        AddTaskBtn.setBackground(new java.awt.Color(102, 102, 102));
        AddTaskBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddTaskBtn.setText("Add Task");
        AddTaskBtn.setPreferredSize(new java.awt.Dimension(158, 344));
        AddTaskBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new AddTasksToProjectsUI(project).setVisible(true);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("       Members");

        projectMembersList.setBackground(new java.awt.Color(102, 102, 102));
        projectMembersList.setForeground(new java.awt.Color(255, 255, 255));
        project = getProject(valueAt);

        for (Users member: project.getMembers()){
            System.out.println(member.getUser_name());
            membersList.add(member.getUser_email());
        }

        projectMembersList.setModel(new AbstractListModel<String>() {
            String[] strings = membersList.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(projectMembersList);

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("      Tasks");

        projectTaskList.setBackground(new java.awt.Color(102, 102, 102));
        projectTaskList.setForeground(new java.awt.Color(255, 255, 255));

        for (Task task: project.getTasks()){
            System.out.println(task.toString());
            tasksList.add(task.getTaskName());
        }
        projectTaskList.setModel(new AbstractListModel<String>() {
            String[] strings = tasksList.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });


        projectTaskList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        projectTaskList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        projectTaskList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {

            }
        });
        jScrollPane2.setViewportView(projectTaskList);

        AddNewMemberBtn.setBackground(new java.awt.Color(102, 102, 102));
        AddNewMemberBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddNewMemberBtn.setText("Add Member");
        AddNewMemberBtn.setMinimumSize(new java.awt.Dimension(158, 34));
        AddNewMemberBtn.setPreferredSize(new java.awt.Dimension(158, 34));
        AddNewMemberBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new AddMembersUI(project).setVisible(true);
            }
        });

        assignTaskBtn.setBackground(new java.awt.Color(102, 102, 102));
        assignTaskBtn.setForeground(new java.awt.Color(255, 255, 255));
        assignTaskBtn.setText("Assign Task");
        assignTaskBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=  projectMembersList.getSelectedIndex();
                int j = projectTaskList.getSelectedIndex();

                Task task = project.getTasks().get(j);
                AddTask.AddTasktoUser(task,membersList.get(i));

            }
        });

        removeMemberBtn.setBackground(new java.awt.Color(102, 102, 102));
        removeMemberBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeMemberBtn.setText("Remove Member");
        removeMemberBtn.setPreferredSize(new java.awt.Dimension(158, 34));
        removeMemberBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(projectMembersList.getSelectedIndex()>-1) {
                    project.removeMemberFromProject(projectMembersList.getSelectedValue());
                    System.out.println(projectMembersList.getSelectedValue());
                    membersList.remove(projectMembersList.getSelectedIndex());
                    projectMembersList.setModel(new AbstractListModel<String>() {
                        String[] strings = membersList.toArray(new String[0]);
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                    });
                }
            }
        });

        deleteTaskBtn.setBackground(new java.awt.Color(102, 102, 102));
        deleteTaskBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteTaskBtn.setText("Delete");
        deleteTaskBtn.setPreferredSize(new java.awt.Dimension(158, 344));
        deleteTaskBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int j = projectTaskList.getSelectedIndex();
                Task task = project.getTasks().get(j);
                task.removeTask();
            }
        });

        if(Users.currentUser.getRole().equalsIgnoreCase("manager")){
            AddNewMemberBtn.setVisible(true);
            assignTaskBtn.setVisible(true);
            AddTaskBtn.setVisible(true);
            removeMemberBtn.setVisible(true);
            deleteTaskBtn.setVisible(true);
            deleteProjectBtn.setVisible(true);
        }else{
            AddNewMemberBtn.setVisible(false);
            assignTaskBtn.setVisible(false);
            AddTaskBtn.setVisible(false);
            removeMemberBtn.setVisible(false);
            deleteTaskBtn.setVisible(false);
            deleteProjectBtn.setVisible(false);
        }

        deleteProjectBtn.setBackground(new java.awt.Color(102, 102, 102));
        deleteProjectBtn.setForeground(new java.awt.Color(252, 252, 252));
        deleteProjectBtn.setText("Delete Project");

        deleteProjectBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(project!=null)
                    project.removeProject();
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
                        .addComponent(AddTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(deleteTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(assignTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                        .addComponent(removeMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(AddNewMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))))
        );
        AddProjectsPanel6Layout.setVerticalGroup(
            AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddNewMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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
            .addGap(0, 522, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AddProjectsPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewMemberBtn;
    private javax.swing.JPanel AddProjectsPanel6;
    private javax.swing.JButton AddTaskBtn;
    private javax.swing.JButton assignTaskBtn;
    private javax.swing.JButton deleteTaskBtn;
    private javax.swing.JButton deleteProjectBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> projectMembersList;
    private javax.swing.JList<String> projectTaskList;
    private javax.swing.JButton removeMemberBtn;

}
