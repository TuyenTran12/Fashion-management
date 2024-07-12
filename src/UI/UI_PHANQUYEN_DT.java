package UI;

import DAO.Dataservice;
import UI.UI_SEETABLE;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import oracle.jdbc.OracleTypes;

public class UI_PHANQUYEN_DT extends javax.swing.JPanel {
    public UI_PHANQUYEN_DT() {
        initComponents();
        new UI_SEETABLE().setVisible(true);  
        
    }    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        btnGrant = new javax.swing.JButton();
        btnRevoke = new javax.swing.JButton();
        btnSeeTable = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("USERS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("ĐỐI TƯỢNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("CÁC QUYỀN");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT USER" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT TABLES" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", " ", "INSERT", " ", "UPDATE", " ", "DELETE", " ", "EXECUTE", " ", "ALTER", " ", "INDEX", " ", "REFERENCES", " ", "ALL", " ", "GRANT OPTION" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("ĐỐI TƯỢNG CẤP");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("LỰA CHỌN ĐỐI TƯỢNG");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TABLE", "PROCUDURE" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("( XEM BẢNG )");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("CHỌN ĐỐI TƯỢNG");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "ROLE" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel6)
                                    .addGap(212, 212, 212))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2))
                                    .addGap(62, 62, 62)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox4, 0, 125, Short.MAX_VALUE)
                                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(574, 574, 574))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnGrant.setText("GRANT");
        btnGrant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrantActionPerformed(evt);
            }
        });

        btnRevoke.setText("REVOKE");
        btnRevoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevokeActionPerformed(evt);
            }
        });

        btnSeeTable.setText("XEM TABLE");
        btnSeeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGrant, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206)
                .addComponent(btnRevoke, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrant, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRevoke, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean isComboBoxLoaded = false;
    private boolean isComboBoxLoaded2 = false;
    private boolean isComboBoxLoaded3 = false;
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Object selectedItem = jComboBox2.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded2) {
        LoadCacDoiTuong();
        isComboBoxLoaded2 = true; // Đánh dấu là đã chạy LoadCacDoiTuong()
    }  
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnGrantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrantActionPerformed
        ResultSet rs = null;
        CallableStatement cs = null;
        CallableStatement cs2 = null;
        Connection con = null;                    
        try{  
            con = Dataservice.Getconnect();
            String user_name = jComboBox1.getSelectedItem().toString();
            String table_name = jComboBox2.getSelectedItem().toString();
            String permission = jComboBox3.getSelectedItem().toString();
            String doi_tuong_cap = jComboBox4.getSelectedItem().toString();
            cs = con.prepareCall("{CALL admin1.proc_grant_object_privilege(?, ?, ?, ?)}");
            
            cs.setString(1, table_name);
            cs.setString(2, user_name);
            cs.setString(3, doi_tuong_cap);
            cs.setString(4, permission);
                // Thực thi stored procedure
            cs.execute();
            System.out.println("GRANT "+permission+" ON "+user_name+"."+table_name+ " TO "+doi_tuong_cap);   
            JOptionPane.showMessageDialog(null, "Cấp quyền cho user thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);  
            }
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (cs != null) cs.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Cấp quyền thất bại", "Thất bại", JOptionPane.ERROR_MESSAGE);
                }
            }
        

    }//GEN-LAST:event_btnGrantActionPerformed
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Lấy item được chọn trong JComboBox
        Object selectedItem = jComboBox1.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded) {
                LoadUserChu();
                isComboBoxLoaded = true; // Đánh dấu là đã chạy LoadCacDoiTuong()
    }          
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnRevokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevokeActionPerformed
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;                    
        try{  
            con = Dataservice.Getconnect();
            String user_name = jComboBox1.getSelectedItem().toString();
            String table_name = jComboBox2.getSelectedItem().toString();
            String permission = jComboBox3.getSelectedItem().toString();
            String doi_tuong_cap = jComboBox4.getSelectedItem().toString();
            cs = con.prepareCall("{CALL admin1.proc_REVOKE_object_privilege(?, ?, ?, ?)}");
            
            cs.setString(1, table_name);
            cs.setString(2, user_name);
            cs.setString(3, doi_tuong_cap);
            cs.setString(4, permission);
                // Thực thi stored procedure
            cs.execute();
            System.out.println("REVOKE "+permission+" ON "+user_name+"."+table_name+ " FROM "+doi_tuong_cap);
            JOptionPane.showMessageDialog(null, "Thu hồi cho user thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);  
            
            }
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (cs != null) cs.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Thu hồi thất bại", "Thất bại", JOptionPane.ERROR_MESSAGE);
                }
            }
    }//GEN-LAST:event_btnRevokeActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // Lấy item được chọn trong JComboBox
        Object selectedItem = jComboBox1.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded3) {
                LoadUserCanCap();
                isComboBoxLoaded3 = true; // Đánh dấu là đã chạy LoadCacDoiTuong()
    }     
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void btnSeeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeTableActionPerformed
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;   
        try {
            con = Dataservice.Getconnect();   
            String name = jComboBox4.getSelectedItem().toString();
                // Tạo CallableStatement và đăng ký tham số
                cs = con.prepareCall("{CALL PROC_PHANQUYENDT(?, ?)}");
                cs.setString(1, name);
                cs.registerOutParameter(2, OracleTypes.CURSOR);

                // Thực thi stored procedure
                cs.execute();

                // Lấy kết quả từ tham số OUT
                rs = (ResultSet) cs.getObject(2);

                // Hiển thị kết quả trong jTable1
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Đóng kết nối và giải phóng tài nguyên
        finally {
            try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }//GEN-LAST:event_btnSeeTableActionPerformed
    private void LoadUserChu() {
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;   
    try {
        con = Dataservice.Getconnect();
        // Tạo CallableStatement và đăng ký tham số
        cs = con.prepareCall("{CALL admin1.PROC_list_admins(?)}");

        cs.registerOutParameter(1, OracleTypes.CURSOR); // Đăng ký tham số đầu ra

        // Thực thi stored procedure
        cs.execute();

        // Lấy kết quả từ tham số đầu ra
        rs = (ResultSet) cs.getObject(1);

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Lặp qua kết quả và thêm vào JComboBox
        while (rs.next()) {
            String admin = rs.getString("USERNAME");
            comboBoxModel.addElement(admin);
        }jComboBox1.setModel(comboBoxModel);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (cs != null) cs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
    private void LoadUserCanCap() {
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;   
    try {
        con = Dataservice.Getconnect();
        // Tạo CallableStatement và đăng ký tham số
        int selectValue = jComboBox6.getSelectedIndex();
        if(selectValue == 0){
        cs = con.prepareCall("{CALL admin1.PROC_list_admins(?)}");

        cs.registerOutParameter(1, OracleTypes.CURSOR);

        // Thực thi stored procedure
        cs.execute();

        // Lấy kết quả từ tham số đầu ra
        rs = (ResultSet) cs.getObject(1);

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Lặp qua kết quả và thêm vào JComboBox
        while (rs.next()) {
            String admin = rs.getString("USERNAME");
            comboBoxModel.addElement(admin);
        }jComboBox4.setModel(comboBoxModel);
        }else if(selectValue == 1){
           cs = con.prepareCall("{CALL PROC_list_roles(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR); // Đăng ký tham số đầu ra

            // Thực thi stored procedure
            cs.execute();

            // Lấy kết quả từ tham số đầu ra
            rs = (ResultSet) cs.getObject(1);


            // Lặp qua kết quả và thêm vào JComboBox
            while (rs.next()) {
                String admin = rs.getString("ROLE");
                jComboBox4.addItem(admin);
            } 
        
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (cs != null) cs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
    
    private void LoadCacDoiTuong() {
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;

try {
    int selectValue = jComboBox5.getSelectedIndex();
    if(selectValue == 0){
        con = Dataservice.Getconnect();    
        String name = jComboBox1.getSelectedItem().toString();
        // Tạo CallableStatement và đăng ký tham số
        cs = con.prepareCall("{CALL admin1.PROC_XEM_USER_TABLES(?,?)}");
        cs.setString(1, name);
        cs.registerOutParameter(2, OracleTypes.CURSOR); // Đăng ký tham số đầu ra

        // Thực thi stored procedure
        cs.execute();

        // Lấy kết quả từ tham số đầu ra
        rs = (ResultSet) cs.getObject(2);


        // Lặp qua kết quả và thêm vào JComboBox
        while (rs.next()) {
            String admin = rs.getString("TABLE_NAME");
            jComboBox2.addItem(admin);
        }
    }else if (selectValue == 1){
        con = Dataservice.Getconnect();    
        String name = jComboBox1.getSelectedItem().toString();
        // Tạo CallableStatement và đăng ký tham số
        cs = con.prepareCall("{CALL admin1.proc_view_user_procedures(?, ?)}");
        cs.setString(1, name);
        cs.registerOutParameter(2, OracleTypes.CURSOR);
        
        // Thực thi stored procedure
        cs.execute();

        // Lấy kết quả từ tham số đầu ra
        rs = (ResultSet) cs.getObject(2);

        // Lặp qua kết quả và thêm vào JComboBox
        while (rs.next()) {
            String admin = rs.getString("object_name");
            jComboBox2.addItem(admin);
        }     
    }
} catch (Exception e) {
    System.out.println(e.getMessage());
} finally {
    try {
        if (rs != null) rs.close();
        if (cs != null) cs.close();
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
}
    


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrant;
    private javax.swing.JButton btnRevoke;
    private javax.swing.JButton btnSeeTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
