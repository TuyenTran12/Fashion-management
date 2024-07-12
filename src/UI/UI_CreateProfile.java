/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import DAO.Dataservice;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LunChan
 */
public class UI_CreateProfile extends javax.swing.JPanel {
    

    /**
     * Creates new form UI_Profile
     */
    public UI_CreateProfile() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable_ListProfile.getModel();
        // Clear the table
        clearTable(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_CreateProfile = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_sessionPerUser = new javax.swing.JTextField();
        jTextField_passwordLifeTime = new javax.swing.JTextField();
        jTextField_FailedLoginAttempts = new javax.swing.JTextField();
        jTextField_PasswordLockTime = new javax.swing.JTextField();
        jTextField_PasswordGraceTime = new javax.swing.JTextField();
        jTextField_ProfileName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton_Exit = new javax.swing.JButton();
        jButton_Create = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ListProfile = new javax.swing.JTable();

        jLabel2.setText("SESSIONS_PER_USER :");

        jLabel3.setText("PASSWORD_LIFE_TIME :");

        jLabel4.setText("FAILED_LOGIN_ATTEMPTS :");

        jLabel5.setText("PASSWORD_LOCK_TIME :");

        jLabel6.setText("PASSWORD_GRACE_TIME :");

        jLabel7.setText("CREATE PROFILE :");

        javax.swing.GroupLayout jPanel_CreateProfileLayout = new javax.swing.GroupLayout(jPanel_CreateProfile);
        jPanel_CreateProfile.setLayout(jPanel_CreateProfileLayout);
        jPanel_CreateProfileLayout.setHorizontalGroup(
            jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CreateProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_CreateProfileLayout.createSequentialGroup()
                        .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_sessionPerUser, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_passwordLifeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_FailedLoginAttempts, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PasswordLockTime, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PasswordGraceTime, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_CreateProfileLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_ProfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel_CreateProfileLayout.setVerticalGroup(
            jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_CreateProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ProfileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_sessionPerUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_passwordLifeTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FailedLoginAttempts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PasswordLockTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_CreateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PasswordGraceTime))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tạo mới Profile");

        jButton_Exit.setText("Exit");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        jButton_Create.setText("Tạo");
        jButton_Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách profile được tạo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jTable_ListProfile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Create Profile", "Session_Per_User", "Password_Life_Time", "Failed_Login_Attempts", "Password_Lock_Time", "Password_Grace_Time"
            }
        ));
        jScrollPane1.setViewportView(jTable_ListProfile);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel_CreateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_CreateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_ExitActionPerformed

    private void jButton_CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateActionPerformed
        try {
            String profileName = jTextField_ProfileName.getText();
            String sessionPerUser = jTextField_sessionPerUser.getText();
            String passwordLifeTime = jTextField_passwordLifeTime.getText();
            String failedLoginAttempts = jTextField_FailedLoginAttempts.getText();
            String passwordLockTime = jTextField_PasswordLockTime.getText();
            String passwordGraceTime = jTextField_PasswordGraceTime.getText();

            // Gọi phương thức tạo mới profile từ service hoặc DAO layer
            createProfile(profileName, sessionPerUser, passwordLifeTime, failedLoginAttempts, passwordLockTime, passwordGraceTime);

             // Add the new profile to the table
            addProfileToTable(profileName, sessionPerUser, passwordLifeTime, failedLoginAttempts, passwordLockTime, passwordGraceTime);
        
            
            jTextField_ProfileName.setText("");
            jTextField_sessionPerUser.setText("");
            jTextField_passwordLifeTime.setText("");
            jTextField_FailedLoginAttempts.setText("");
            jTextField_PasswordLockTime.setText("");
            jTextField_PasswordGraceTime.setText("");
            jTextField_ProfileName.requestFocus();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tạo mới profile.");
        }
    }//GEN-LAST:event_jButton_CreateActionPerformed

    private void clearTable(DefaultTableModel model) {
        model.setRowCount(0);
    }

    
    private void createProfile(String profileName, String sessionPerUser, String passwordLifeTime, 
            String failedLoginAttempts, String passwordLockTime, String passwordGraceTime) {
        try {
            Connection conn = Dataservice.Getconnect();
            CallableStatement stmt = conn.prepareCall("{call sys.Proc_create_new_profile(?, ?, ?, ?, ?, ?)}");
            
            stmt.setString(1, profileName);
            stmt.setString(2, sessionPerUser);
            stmt.setString(3, passwordLifeTime);
            stmt.setString(4, failedLoginAttempts);
            stmt.setString(5, passwordLockTime);
            stmt.setString(6, passwordGraceTime);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Tạo mới profile thành công.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addProfileToTable(String profileName, String sessionPerUser, String passwordLifeTime, 
            String failedLoginAttempts, String passwordLockTime, String passwordGraceTime) {
        DefaultTableModel model = (DefaultTableModel) jTable_ListProfile.getModel();
        model.addRow(new Object[]{profileName, sessionPerUser, passwordLifeTime, failedLoginAttempts, 
            passwordLockTime, passwordGraceTime});
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Create;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_CreateProfile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ListProfile;
    private javax.swing.JTextField jTextField_FailedLoginAttempts;
    private javax.swing.JTextField jTextField_PasswordGraceTime;
    private javax.swing.JTextField jTextField_PasswordLockTime;
    private javax.swing.JTextField jTextField_ProfileName;
    private javax.swing.JTextField jTextField_passwordLifeTime;
    private javax.swing.JTextField jTextField_sessionPerUser;
    // End of variables declaration//GEN-END:variables
}
