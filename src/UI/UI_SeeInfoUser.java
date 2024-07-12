package UI;

import DAO.Dataservice;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class UI_SeeInfoUser extends javax.swing.JPanel {

    
    public UI_SeeInfoUser() {
        initComponents();
    }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Created Date", "Expiration Date", "Status", "Last Login", "Profile"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SEE USER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT USER" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("USERS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(361, 361, 361))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            con = Dataservice.Getconnect();
            cs = con.prepareCall("{CALL admin1.PROC_GetUserInfo(?, ?)}");
            String selectedValue = jComboBox1.getSelectedItem().toString();
            cs.setString(1, selectedValue); 

            cs.registerOutParameter(2, OracleTypes.CURSOR); // Đăng ký tham số out là một CURSOR

            cs.execute();

            rs = ((OracleCallableStatement) cs).getCursor(2); // Lấy thông tin CURSOR từ tham số out

            // Tạo đối tượng DefaultTableModel với các cột tương ứng
            // Lấy TableModel từ jtable1
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

            // Xóa các hàng cũ trong TableModel (nếu có)
            tableModel.setRowCount(0);

            // Thêm dữ liệu từ ResultSet vào TableModel
            while (rs.next()) {
                String username = rs.getString("username");
                Date createdDate = rs.getDate("created");
                Date expirationDate = rs.getDate("expiry_date");
                String status = rs.getString("account_status");
                Date lastLogin = rs.getDate("last_login");
                String profileName = rs.getString("profile");

                // Thêm hàng mới vào TableModel
                tableModel.addRow(new Object[]{username, createdDate, expirationDate, status, lastLogin, profileName});
            }

            // Cập nhật JTable để hiển thị dữ liệu mới
            tableModel.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
}
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean isComboBoxLoaded = false;
    private boolean isComboBoxLoaded2 = false;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Lấy item được chọn trong JComboBox
        Object selectedItem = jComboBox1.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded) {
            loadAdminsToComboBox();
            isComboBoxLoaded = true; // Đánh dấu là đã chạy LoadCacDoiTuong()
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    private void loadAdminsToComboBox() {
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;   
    try {
        con = Dataservice.Getconnect();
        // Tạo CallableStatement và đăng ký tham số
        cs = con.prepareCall("{CALL PROC_list_admins(?)}");

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
