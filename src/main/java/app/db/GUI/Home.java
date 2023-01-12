/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.db.GUI;

import app.db.PriorityQueue;
import app.db.Projects;
import app.db.Task;
import app.db.Users;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//import java.util.PriorityQueue;

import static app.db.Projects.getProject;

public class Home extends JFrame {
    ArrayList<String> recentTasks = new ArrayList<>();
    ArrayList<String> priorityTasks = new ArrayList<>();
    ArrayList<String> priorityProjects= new ArrayList<>();
    PriorityQueue<String> priorityTasksPQ = new PriorityQueue<>();
    PriorityQueue<String>  priorityProjectsPQ = new PriorityQueue<>();


    public Home() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jSplitPane = new javax.swing.JSplitPane();
        NavBar = new javax.swing.JPanel();
        homeLabel = new javax.swing.JLabel();
        mytasks = new javax.swing.JLabel();
        projectsBtn = new javax.swing.JLabel();
        LogOut = new javax.swing.JLabel();
        HomePanel = new javax.swing.JPanel();
        priorityTasksPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        priorityTasksList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        Projects = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        priorityProjectsList = new javax.swing.JList<>();
        People = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        recentTasksLists = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        MyTasksPanel = new javax.swing.JPanel();
        myTasksScrollPane = new javax.swing.JScrollPane();
        MyTasksTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CompletedLabel = new javax.swing.JLabel();
        completedTasksNo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Pending = new javax.swing.JLabel();
        PendingTasksNo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        OverDue = new javax.swing.JLabel();
        OverDueTasksNo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ProjectsPanel = new javax.swing.JPanel();
        projectsPanelScrollPane = new javax.swing.JScrollPane();
        projectsTable = new javax.swing.JTable();
        addNewProjectBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        int completed=0;
        int pending = 0;
        int overdue=0;

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NavBar.setBackground(new java.awt.Color(66, 66, 68));
        NavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        homeLabel.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        homeLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel.setText("Home");
        homeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeLabelMouseClicked(evt);
            }
        });

        mytasks.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        mytasks.setForeground(new java.awt.Color(255, 255, 255));
        mytasks.setText("My Tasks");

        mytasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mytasksMouseClicked(evt);
            }
        });

        projectsBtn.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        projectsBtn.setForeground(new java.awt.Color(255, 255, 255));
        projectsBtn.setText("Projects");
        projectsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectsBtnMouseClicked(evt);
            }
        });

        LogOut.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("Log Out");

        LogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginUI().setVisible(true);
            }
        });

        javax.swing.GroupLayout NavBarLayout = new javax.swing.GroupLayout(NavBar);
        NavBar.setLayout(NavBarLayout);
        NavBarLayout.setHorizontalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogOut)
                    .addComponent(projectsBtn)
                    .addComponent(mytasks)
                    .addComponent(homeLabel))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        NavBarLayout.setVerticalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(homeLabel)
                .addGap(37, 37, 37)
                .addComponent(mytasks)
                .addGap(36, 36, 36)
                .addComponent(projectsBtn)
                .addGap(29, 29, 29)
                .addComponent(LogOut)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(NavBar);

        HomePanel.setBackground(new java.awt.Color(37, 38, 40));
        HomePanel.setPreferredSize(new java.awt.Dimension(938, 663));

        priorityTasksPanel.setBackground(new java.awt.Color(102, 102, 102));
        priorityTasksPanel.setForeground(new java.awt.Color(91, 91, 91));
        priorityTasksPanel.setAutoscrolls(true);
        priorityTasksPanel.setPreferredSize(new java.awt.Dimension(120, 135));

        priorityTasksList.setBackground(new java.awt.Color(102, 102, 102));
        priorityTasksList.setBorder(null);
        priorityTasksList.setForeground(new java.awt.Color(255, 255, 255));

        for(Task task:Users.currentUser.getTasks()){
            //System.out.println(task.toString());
            String taskName = task.getTaskName();
            priorityTasksPQ.push(taskName,task.getTaskDueDate().getDifference(java.time.LocalDate.now()));
        }
        for(int i=0;i<=5;++i){
            if(priorityTasksPQ.peek()!=null) {
                priorityTasks.add(priorityTasksPQ.peek());
                priorityTasksPQ.pop();
            }
        }
        priorityTasksList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = priorityTasks.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(priorityTasksList);

        jLabel5.setFont(new java.awt.Font("Sitka Heading", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("   Piority Tasks ");

        javax.swing.GroupLayout priorityTasksPanelLayout = new javax.swing.GroupLayout(priorityTasksPanel);
        priorityTasksPanel.setLayout(priorityTasksPanelLayout);
        priorityTasksPanelLayout.setHorizontalGroup(
            priorityTasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(priorityTasksPanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        priorityTasksPanelLayout.setVerticalGroup(
            priorityTasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, priorityTasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Projects.setBackground(new java.awt.Color(102, 102, 102));
        Projects.setAutoscrolls(true);

        jLabel6.setFont(new java.awt.Font("Sitka Heading", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Piority Projects");

        priorityProjectsList.setBackground(new java.awt.Color(102, 102, 102));
        priorityProjectsList.setBorder(null);
        priorityProjectsList.setForeground(new java.awt.Color(255, 255, 255));

        for(String projectName:Users.currentUser.getProjects()){
            Projects project = app.db.Projects.getProject(projectName);
            if(project.getDueDate()!=null)
            priorityProjectsPQ.push(projectName,project.getDueDate().getDifference(java.time.LocalDate.now()));
        }
        for(int i=0;i<=5;++i){
            if(priorityProjectsPQ.peek()!=null) {
                priorityProjects.add(priorityProjectsPQ.peek());
                priorityProjectsPQ.pop();
            }
        }
        priorityProjectsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = priorityProjects.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(priorityProjectsList);

        javax.swing.GroupLayout ProjectsLayout = new javax.swing.GroupLayout(Projects);
        Projects.setLayout(ProjectsLayout);
        ProjectsLayout.setHorizontalGroup(
            ProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectsLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        ProjectsLayout.setVerticalGroup(
            ProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        People.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Sitka Heading", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));


        jLabel7.setText("      Recent Tasks and Projects");

        recentTasksLists.setBackground(new java.awt.Color(102, 102, 102));
        recentTasksLists.setBorder(null);
        recentTasksLists.setForeground(new java.awt.Color(255, 255, 255));

            recentTasks.add("TASKS:");
        for(int i=1;i<4;++i){
            try{
                recentTasks.add(Users.currentUser.getTasks().get((Users.currentUser.getTasks().size())-i).getTaskName());
            }catch (IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
                break;
            }
        }
        recentTasks.add("  ");
        recentTasks.add("PROJECTS:");
        for(int i=1;i<4;++i){
            try{
                recentTasks.add(Users.currentUser.getProjects().get(Users.currentUser.getProjects().size()-i));
            }catch (IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
                break;
            }
        }

        recentTasksLists.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = recentTasks.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(recentTasksLists);

        javax.swing.GroupLayout PeopleLayout = new javax.swing.GroupLayout(People);
        People.setLayout(PeopleLayout);
        PeopleLayout.setHorizontalGroup(
            PeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeopleLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PeopleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        PeopleLayout.setVerticalGroup(
            PeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeopleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("             Asan");

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(People, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HomePanelLayout.createSequentialGroup()
                        .addComponent(priorityTasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(Projects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(120, 120, 120))
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(329, 329, 329))
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Projects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priorityTasksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(People, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(HomePanel);

        MyTasksPanel.setBackground(new java.awt.Color(37, 38, 40));

        MyTasksTable.setBackground(new java.awt.Color(102, 102, 102));
        MyTasksTable.setForeground(new java.awt.Color(255, 255, 255));

        String[][] obj2 = new String[Users.currentUser.getTasks().size()][5];
        System.out.println(Users.currentUser.toString());

        System.out.println(Users.currentUser.getTasks().size());


        for (int j = 0; j < Users.currentUser.getTasks().size(); ++j) {
            obj2[j][0] = Users.currentUser.getTasks().get(j).getTaskName();
        }
        for (int j = 0; j < Users.currentUser.getTasks().size(); ++j) {
            Task task = Users.currentUser.getTasks().get(j);
            obj2[j][1] = task.getTaskDueDate().toString();
        }
        for (int j = 0; j < Users.currentUser.getTasks().size(); ++j) {
            Task task = Users.currentUser.getTasks().get(j);
            obj2[j][2] = task.getTaskStartDate().toString();
        }
        for (int j = 0; j < Users.currentUser.getTasks().size(); ++j) {
            Task task = Users.currentUser.getTasks().get(j);
            obj2[j][3] = task.getStatus();
        }


        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.addItem("To Do");
        comboBox2.addItem("Completed");
        comboBox2.addItem("OverDue");

        //noinspection rawtypes
        MyTasksTable.setModel(new javax.swing.table.DefaultTableModel(
                obj2,

                new String [] {
                        "Name", "Due Date", "Start Date","Current Status"," Change Status"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class, java.lang.Object.class, String.class,comboBox2.getClass()
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false,false,true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn testColumn = MyTasksTable.getColumnModel().getColumn(4);
        testColumn.setCellEditor(new DefaultCellEditor(comboBox2));

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = MyTasksTable.getSelectedRow();
                System.out.println(row);
                int col= 0;
                if(row>=0) {
                    System.out.println(MyTasksTable.getModel().getValueAt(row,col));
                    if(comboBox2.getSelectedItem()!=null) {
                        Users.currentUser.getTasks().get(row).setStatus(comboBox2.getSelectedItem().toString(), Users.currentUser.getUser_email());
                        System.out.println(comboBox2.getSelectedItem().toString());
                    }
                }
            }
        });

        MyTasksTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MyTasksTable.setGridColor(new java.awt.Color(0, 0, 0));
        MyTasksTable.setRowHeight(28);
        MyTasksTable.setRowMargin(10);
        MyTasksTable.setRowSelectionAllowed(false);
        MyTasksTable.setShowGrid(true);
        myTasksScrollPane.setViewportView(MyTasksTable);



        for (int j = 0; j < Users.currentUser.getTasks().size(); ++j) {
            Task task = Users.currentUser.getTasks().get(j);
            switch (task.getStatus()) {
                case "to do" -> ++pending;
                case "overdue" -> ++overdue;
                case "completed" -> ++completed;
            }

        }

        CompletedLabel.setText("Completed");


        completedTasksNo.setText(String.valueOf(completed));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(CompletedLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(completedTasksNo)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CompletedLabel)
                .addGap(18, 18, 18)
                .addComponent(completedTasksNo)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        Pending.setText("Pending");

        PendingTasksNo.setText(String.valueOf(pending));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PendingTasksNo)
                    .addComponent(Pending))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pending)
                .addGap(18, 18, 18)
                .addComponent(PendingTasksNo)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        OverDue.setText("Over Due");

        OverDueTasksNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OverDueTasksNo.setText(String.valueOf(overdue));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OverDueTasksNo)
                    .addComponent(OverDue))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OverDue)
                .addGap(18, 18, 18)
                .addComponent(OverDueTasksNo)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("           My Tasks");

        javax.swing.GroupLayout MyTasksPanelLayout = new javax.swing.GroupLayout(MyTasksPanel);
        MyTasksPanel.setLayout(MyTasksPanelLayout);
        MyTasksPanelLayout.setHorizontalGroup(
            MyTasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyTasksPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(MyTasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myTasksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MyTasksPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addGap(69, 69, 69))
            .addGroup(MyTasksPanelLayout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MyTasksPanelLayout.setVerticalGroup(
            MyTasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyTasksPanelLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(myTasksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MyTasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        ProjectsPanel.setBackground(new java.awt.Color(37, 38, 40));
        ProjectsPanel.setPreferredSize(new java.awt.Dimension(938, 666));


        String[][] obj = new String[Users.currentUser.getProjects().size()][5];
        System.out.println(Users.currentUser.toString());

        //projectsTable.setColumnModel(app.db.Projects.allProjects.toArray());
        for (int j = 0; j < Users.currentUser.getProjects().size(); ++j) {
            obj[j][0] = Users.currentUser.getProjects().get(j);
        }
        for (int j = 0; j < Users.currentUser.getProjects().size(); ++j) {
            Projects project = getProject(Users.currentUser.getProjects().get(j));
            // System.out.println(project.toString());
            if(project.getDueDate()!=null)
                 obj[j][1] = project.getDueDate().toString();
        }
        for (int j = 0; j < Users.currentUser.getProjects().size(); ++j) {
            Projects project = getProject(Users.currentUser.getProjects().get(j));
            obj[j][2] = project.getStartDate().toString();
        }

        for (int j = 0; j < Users.currentUser.getProjects().size(); ++j) {
            Projects project = getProject(Users.currentUser.getProjects().get(j));
            obj[j][3] = project.getStatus();
        }


        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("To Do");
        comboBox.addItem("Completed");
        comboBox.addItem("OverDue");


        projectsTable.setBackground(new java.awt.Color(102, 102, 102));
        projectsTable.setForeground(new java.awt.Color(255, 255, 255));
        projectsTable.setModel(new javax.swing.table.DefaultTableModel(
                obj,

                new String [] {
                        "Name", "Due Date", "Start Date","Current Status","Change Status"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class, java.lang.Object.class, String.class,comboBox.getClass()
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false,false,true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

        });

        TableColumn testColumn2 = projectsTable.getColumnModel().getColumn(4);
        testColumn2.setCellEditor(new DefaultCellEditor(comboBox));

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = projectsTable.getSelectedRow();
                System.out.println(row);
                int col= 0;
                if(row>=0) {
                    Projects project = app.db.Projects.getProject(projectsTable.getModel().getValueAt(row, col).toString());
                    if(comboBox.getSelectedItem()!=null)
                        project.setStatus(comboBox.getSelectedItem().toString());
                }
            }
        });

        projectsTable.setColumnSelectionAllowed(false);
        projectsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        projectsTable.setGridColor(new java.awt.Color(0, 0, 0));
        projectsTable.setShowGrid(true);
        projectsTable.setSurrendersFocusOnKeystroke(true);
        projectsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectsTableMouseClicked(evt);
            }
        });
        projectsPanelScrollPane.setViewportView(projectsTable);
        projectsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        addNewProjectBtn.setBackground(new java.awt.Color(102, 102, 102));
        addNewProjectBtn.setForeground(new java.awt.Color(252, 252, 252));
        addNewProjectBtn.setText("Add New Project");
        addNewProjectBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewProjectBtnMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("           My Tasks");

        javax.swing.GroupLayout ProjectsPanelLayout = new javax.swing.GroupLayout(ProjectsPanel);
        ProjectsPanel.setLayout(ProjectsPanelLayout);
        ProjectsPanelLayout.setHorizontalGroup(
            ProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectsPanelLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(ProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addNewProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectsPanelScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(ProjectsPanelLayout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProjectsPanelLayout.setVerticalGroup(
            ProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProjectsPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(projectsPanelScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(addNewProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        if(Users.currentUser.getRole().equalsIgnoreCase("manager")){
            addNewProjectBtn.setVisible(true);

        }else addNewProjectBtn.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 96, Short.MAX_VALUE)
                    .addComponent(MyTasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 97, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ProjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(MyTasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ProjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        MyTasksPanel.getAccessibleContext().setAccessibleParent(jSplitPane);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void setRightComponent(Component comp){
        jSplitPane.setRightComponent(comp);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSplitPane))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSplitPane)
                                .addContainerGap())
        );

    }
    private void mytasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mytasksMouseClicked
                // TODO add your handling code here:
                //getContentPane().remove(Home);
        if(HomePanel.isVisible()){
            HomePanel.setVisible(false);
        }
        else if(ProjectsPanel.isVisible()){
            ProjectsPanel.setVisible(false);
        }
        jSplitPane.setRightComponent(MyTasksPanel);
        MyTasksPanel.setVisible(true);
         
    }//GEN-LAST:event_mytasksMouseClicked

    private void homeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLabelMouseClicked
        // TODO add your handling code here:

        if(MyTasksPanel.isVisible()){
            MyTasksPanel.setVisible(false);
            //jSplitPane2.remove(MyTasksPanel);
        }else if (ProjectsPanel.isVisible()){
            ProjectsPanel.setVisible(false);
            //jSplitPane2.remove(HomePanel);
        }
        jSplitPane.setRightComponent(HomePanel);
        HomePanel.setVisible(true);
    }//GEN-LAST:event_homeLabelMouseClicked


    private void projectsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectsBtnMouseClicked
        // TODO add your handling code here:

        if(MyTasksPanel.isVisible()){
            MyTasksPanel.setVisible(false);
            //jSplitPane2.remove(MyTasksPanel);
        }
        else if(HomePanel.isVisible()){
            HomePanel.setVisible(false);
            //jSplitPane2.remove(HomePanel);
        }
        jSplitPane.setRightComponent(ProjectsPanel);
        ProjectsPanel.setVisible(true);
    }//GEN-LAST:event_projectsBtnMouseClicked

    private void projectsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectsTableMouseClicked
        // TODO add your handling code here:
          int row = projectsTable.rowAtPoint(evt.getPoint());
        int col = projectsTable.columnAtPoint(evt.getPoint());
        System.out.println(row);
        System.out.println(col);
        if (row >= 0 && col == 0) {
            System.out.println(projectsTable.getModel().getValueAt(row,col));
            new ProjectDetailsUI(projectsTable.getModel().getValueAt(row,col).toString()).setVisible(true);
    }

//        int column = 0;
//        int row = jTable1.getSelectedRow();
//        String value = jTable1.getModel().getValueAt(row, column).toString();
//        System.out.println(row);
//        System.out.println(value);
            
           


    }

    private void addNewProjectBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewProjectBtnMouseClicked
        // TODO add your handling code here:
        addNewProjectBtn.setEnabled(false);
        new AddProjectsUI().setVisible(true);

    }





    private javax.swing.JLabel CompletedLabel;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JLabel LogOut;
    private javax.swing.JPanel MyTasksPanel;
    private javax.swing.JTable MyTasksTable;
    private javax.swing.JPanel NavBar;
    private javax.swing.JLabel OverDue;
    private javax.swing.JLabel OverDueTasksNo;
    private javax.swing.JLabel Pending;
    private javax.swing.JLabel PendingTasksNo;
    private javax.swing.JPanel People;
    private javax.swing.JPanel Projects;
    private javax.swing.JPanel ProjectsPanel;
    private javax.swing.JButton addNewProjectBtn;
    private javax.swing.JLabel completedTasksNo;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JScrollPane myTasksScrollPane;
    private javax.swing.JLabel mytasks;
    private javax.swing.JList<String> priorityProjectsList;
    private javax.swing.JList<String> priorityTasksList;
    private javax.swing.JPanel priorityTasksPanel;
    private javax.swing.JLabel projectsBtn;
    private javax.swing.JScrollPane projectsPanelScrollPane;
    private javax.swing.JTable projectsTable;
    private javax.swing.JList<String> recentTasksLists;

    
}
