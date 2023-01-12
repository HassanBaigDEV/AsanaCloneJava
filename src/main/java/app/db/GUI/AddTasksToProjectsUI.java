/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.db.GUI;

import app.db.Projects;
import app.db.Task;

import javax.swing.*;
import app.db.Date;


public class AddTasksToProjectsUI extends JFrame {

    public AddTasksToProjectsUI(Projects project) {
        initComponents(project);
    }

    @SuppressWarnings("unchecked")
        private void initComponents(Projects project) {

        AddProjectsPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        projectTaskNameLabel = new javax.swing.JLabel();
        projectTaskNameTxtField = new javax.swing.JTextField();
        projectTaskDueDateLabel = new javax.swing.JLabel();
        projectTaskDueDateDay = new javax.swing.JComboBox<Integer>();
        projectTaskDueDateMonth = new javax.swing.JComboBox<Integer>();
        projectTaskDueDateYear = new javax.swing.JComboBox<Integer>();
        projectTaskStartDateLabel = new javax.swing.JLabel();
        projectTaskStartDateDay = new JComboBox<Integer>();
        projectTaskStartDateMonth = new JComboBox<Integer>();
        projectTaskStartDateYear = new JComboBox<Integer>();
        AddProjectTaskBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddProjectsPanel6.setBackground(new java.awt.Color(37, 38, 40));
        AddProjectsPanel6.setPreferredSize(new java.awt.Dimension(940, 535));

        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Task");

        projectTaskNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectTaskNameLabel.setText("Task Name");

        projectTaskDueDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectTaskDueDateLabel.setText("Due Date");

        projectTaskDueDateDay.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}));
        projectTaskDueDateDay.setPreferredSize(new java.awt.Dimension(49, 36));

        projectTaskDueDateMonth.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[]  {1,2,3,4,5,6,7,8,9,10,11,12}));
            projectTaskDueDateMonth.setMinimumSize(new java.awt.Dimension(49, 36));

            projectTaskDueDateYear.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[] { 2023, 2024, 2025, 2026, }));
            projectTaskDueDateYear.setMinimumSize(new java.awt.Dimension(49, 36));

            projectTaskStartDateLabel.setForeground(new java.awt.Color(255, 255, 255));
            projectTaskStartDateLabel.setText("Start Date");

        projectTaskStartDateYear.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[] { 2023, 2024, 2025, 2026, }));
        projectTaskStartDateYear.setMinimumSize(new java.awt.Dimension(49, 36));

        projectTaskStartDateMonth.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[]  {1,2,3,4,5,6,7,8,9,10,11,12}));

        projectTaskStartDateDay.setModel(new javax.swing.DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}));
            projectTaskStartDateYear.setMinimumSize(new java.awt.Dimension(49, 36));

            AddProjectTaskBtn.setBackground(new java.awt.Color(102, 102, 102));
            AddProjectTaskBtn.setForeground(new java.awt.Color(255, 255, 255));
            AddProjectTaskBtn.setText("Add Task");
            AddProjectTaskBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Date startDate = new Date((Integer) projectTaskStartDateDay.getSelectedItem(),(Integer) projectTaskStartDateMonth.getSelectedItem(),(Integer) projectTaskStartDateYear.getSelectedItem());
                    Date dueDate = new Date((Integer) projectTaskDueDateDay.getSelectedItem(),(Integer) projectTaskDueDateMonth.getSelectedItem(),(Integer) projectTaskDueDateYear.getSelectedItem());

                    if(dueDate.getDifference(startDate)>0) {
                        Task task = new Task(project.getProjectName(), projectTaskNameTxtField.getText(),startDate ,dueDate );
                        project.addTasks(task);
                        setVisible(false);
                    }
                    else JOptionPane.showMessageDialog(null,"Due Date must be greater than Start Date");
                }
            });

            javax.swing.GroupLayout AddProjectsPanel6Layout = new javax.swing.GroupLayout(AddProjectsPanel6);
            AddProjectsPanel6.setLayout(AddProjectsPanel6Layout);
            AddProjectsPanel6Layout.setHorizontalGroup(
                AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectTaskDueDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectTaskNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                            .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                                    .addComponent(projectTaskStartDateLabel)
                                    .addGap(97, 97, 97))
                                .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                                    .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(projectTaskDueDateLabel)
                                        .addComponent(projectTaskNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                                    .addComponent(projectTaskStartDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)
                                    .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(projectTaskDueDateMonth, 0, 1, Short.MAX_VALUE)
                                        .addComponent(projectTaskStartDateMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(29, 29, 29)
                                    .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(projectTaskDueDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(projectTaskStartDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(AddProjectTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(115, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddProjectsPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(152, 152, 152))
            );
            AddProjectsPanel6Layout.setVerticalGroup(
                AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AddProjectsPanel6Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(72, 72, 72)
                    .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(projectTaskNameTxtField)
                        .addComponent(projectTaskNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(projectTaskDueDateLabel)
                        .addComponent(projectTaskDueDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectTaskDueDateMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(projectTaskDueDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)
                    .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AddProjectsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(projectTaskStartDateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectTaskStartDateMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectTaskStartDateYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(projectTaskStartDateLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                    .addComponent(AddProjectTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52))
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
                .addGap(0, 490, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddProjectsPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
            );

            pack();
        }


    private javax.swing.JButton AddProjectTaskBtn;
    private javax.swing.JPanel AddProjectsPanel6;
    private javax.swing.JLabel jLabel2;
    private JComboBox<Integer> projectTaskDueDateDay;
    private javax.swing.JLabel projectTaskDueDateLabel;
    private JComboBox<Integer> projectTaskDueDateMonth;
    private JComboBox<Integer> projectTaskDueDateYear;
    private javax.swing.JLabel projectTaskNameLabel;
    private javax.swing.JTextField projectTaskNameTxtField;
    private JComboBox<Integer> projectTaskStartDateDay;
    private javax.swing.JLabel projectTaskStartDateLabel;
    private JComboBox<Integer> projectTaskStartDateMonth;
    private JComboBox<Integer> projectTaskStartDateYear;

}
