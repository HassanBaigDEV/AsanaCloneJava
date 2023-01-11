/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.db.GUI;

import app.db.*;

import javax.swing.*;
import java.util.ArrayList;

import java.util.Objects;

public class AddProjectsUI extends JFrame {


    public AddProjectsUI() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        AddProjectsPanel = new javax.swing.JPanel();
        projectNameLabel = new javax.swing.JLabel();
        projectdueDateLabel = new javax.swing.JLabel();
        projectNameTxtField = new javax.swing.JTextField();
        projectStartDateLabel = new javax.swing.JLabel();
        submitProjectBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dueDateDay = new javax.swing.JComboBox<Integer>();
        dueDateMonth = new javax.swing.JComboBox<Integer>();
        dueDateYear = new javax.swing.JComboBox<Integer>();
        startDateYear = new JComboBox<Integer>();
        startDateMonth = new JComboBox<Integer>();
        startDateDay = new JComboBox<Integer>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AddProjectsPanel.setBackground(new java.awt.Color(37, 38, 40));
        AddProjectsPanel.setPreferredSize(new java.awt.Dimension(940, 535));


        projectNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectNameLabel.setText("Project Name");

        projectdueDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectdueDateLabel.setText("Due Date");

        projectStartDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectStartDateLabel.setText("Start Date");

        submitProjectBtn.setBackground(new java.awt.Color(102, 102, 102));
        submitProjectBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitProjectBtn.setText("Add Project");
        submitProjectBtn.setPreferredSize(new java.awt.Dimension(190, 37));
        submitProjectBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitProjectBtnMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Project Details");

        dueDateDay.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}));
        dueDateDay.setPreferredSize(new java.awt.Dimension(49, 36));

        dueDateMonth.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[]  {1,2,3,4,5,6,7,8,9,10,11,12}));
            dueDateMonth.setMinimumSize(new java.awt.Dimension(49, 36));

            dueDateYear.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[] { 2023, 2024, 2025, 2026, }));
            dueDateYear.setMinimumSize(new java.awt.Dimension(49, 36));

        startDateYear.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[]{2023, 2024, 2025, 2026,}));
        startDateYear.setMinimumSize(new java.awt.Dimension(49, 36));

        startDateMonth.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));

        startDateDay.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}));

            javax.swing.GroupLayout AddProjectsPanelLayout = new javax.swing.GroupLayout(AddProjectsPanel);
            AddProjectsPanel.setLayout(AddProjectsPanelLayout);
            AddProjectsPanelLayout.setHorizontalGroup(
                AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddProjectsPanelLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AddProjectsPanelLayout.createSequentialGroup()
                            .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(AddProjectsPanelLayout.createSequentialGroup()
                                    .addGap(147, 147, 147)
                                    .addComponent(dueDateDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddProjectsPanelLayout.createSequentialGroup()
                                    .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(projectNameLabel)
                                        .addGroup(AddProjectsPanelLayout.createSequentialGroup()
                                            .addComponent(projectStartDateLabel)
                                            .addGap(22, 22, 22))
                                        .addComponent(projectdueDateLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(75, 75, 75)
                                    .addComponent(startDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(24, 24, 24)
                            .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dueDateMonth, 0, 49, Short.MAX_VALUE)
                                .addComponent(startDateMonth, 0, 1, Short.MAX_VALUE))
                            .addGap(29, 29, 29)
                            .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dueDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(AddProjectsPanelLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(submitProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(AddProjectsPanelLayout.createSequentialGroup()
                    .addGap(207, 207, 207)
                    .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 181, Short.MAX_VALUE))
            );
            AddProjectsPanelLayout.setVerticalGroup(
                AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddProjectsPanelLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(68, 68, 68)
                    .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(projectNameLabel)
                        .addComponent(projectNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(projectdueDateLabel)
                        .addComponent(dueDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dueDateMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dueDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)
                    .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AddProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(projectStartDateLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                    .addComponent(submitProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(75, 75, 75))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 616, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddProjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 536, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddProjectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents


    private void submitProjectBtnMouseClicked(java.awt.event.MouseEvent evt) {
        ArrayList<Users> members = new ArrayList<>();

        ArrayList<Task> tasks = new ArrayList<>();
        try {
            @SuppressWarnings({"ConstantConditions", "MagicConstant"}) Date due = new Date ((Integer) dueDateDay.getSelectedItem(), (Integer) dueDateMonth.getSelectedItem(),(Integer) dueDateYear.getSelectedItem());
            @SuppressWarnings({"ConstantConditions", "MagicConstant"}) Date start = new Date((Integer) startDateDay.getSelectedItem(), (Integer) startDateMonth.getSelectedItem(), (Integer) startDateYear.getSelectedItem());

            if(due.getDifference(start)<0)
                throw new IllegalArgumentException("Due Date must be greater than Start Date");


            if (Objects.equals(projectNameTxtField.getText(), "")) {
                throw new IllegalArgumentException("INVALID NAME");
            }
            Projects project = new Projects(projectNameTxtField.getText(), due, start, members, tasks);
          //  project.getMembers().add(Users.currentUser);
            //Users.currentUser.getProjects().add(project.getProjectName());

//            project.AddMemberToProject(Users.currentUser);
//            Users.addProjecttoUser(project.getProjectName(),Users.currentUser.getUser_email());
            if (AddProjects.addProject(projectNameTxtField.getText(), project) > 0) {
                project.AddMemberToProject(Users.currentUser);
                Users.addProjecttoUser(project.getProjectName(), Users.currentUser.getUser_email());
                project.getMembers().add(Users.currentUser);
                new AddMembersUI(project).setVisible(true);
            }

            else
                JOptionPane.showMessageDialog(null, "NHIN HUA ADD PROJECT!!!!");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private int closeOperation() {
        return 2;
    }


    private void createProjectTasksBtnMouseClicked(java.awt.event.MouseEvent evt) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddProjectsPanel;
    private JComboBox<Integer> dueDateDay;
    private JComboBox<Integer> dueDateMonth;
    private JComboBox<Integer> dueDateYear;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTxtField;
    private javax.swing.JLabel projectStartDateLabel;
    private javax.swing.JLabel projectdueDateLabel;
    private JComboBox<Integer> startDateDay;
    private JComboBox<Integer> startDateMonth;
    private JComboBox<Integer> startDateYear;
    private javax.swing.JButton submitProjectBtn;
    // End of variables declaration//GEN-END:variables
}
