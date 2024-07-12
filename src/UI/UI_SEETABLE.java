package UI;


import DAO.Dataservice;
import GUI.GUI_CREATE_CHITIETHOADON;
import GUI.GUI_CREATE_HOADON;
import GUI.GUI_CREATE_KHACHHANG;
import GUI.GUI_CREATE_SAPNPHAM;
import GUI.GUI_CREATE_TTT;
import java.sql.Connection;
import  net.proteanit.sql.DbUtils;
import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;



/**
 *
 * @author ACER
 */
public class UI_SEETABLE extends javax.swing.JPanel {
    
    public UI_SEETABLE() {
        initComponents();
        tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);
    }
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_SEETABLE().setVisible(true);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(757, 404));

        jButton1.setText("XEM BẢNG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("XOÁ DỮ LIỆU BẢNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("THÊM DỮ LIỆU BẢNG");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("LƯU BẢNG");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(getBackground());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("XEM THÔNG TIN CỦA BẢNG");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel1)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT TABLES" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT USER" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("TABLE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("USERS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;
        
        private DefaultTableModel tableModel;

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;       
        try {
            con = Dataservice.Getconnect();   
            String current_user = Dataservice.user;
            String user_name = jComboBox1.getSelectedItem().toString();
            String selectedValue = jComboBox2.getSelectedItem().toString();
            
            int rowCount = getCountRows(con);
            if(selectedValue.equals("CHITIETHOADON")){
            // Hiển thị thông báo với số lượng dòng
            String message = "Số lượng dòng trong bảng 'chitiethoadon': " + rowCount;
            JOptionPane.showMessageDialog(this, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            // Tạo CallableStatement và đăng ký tham số
            cs = con.prepareCall("{CALL ADMIN1.PROC_BAI3(?, ?, ?, ?)}");
            cs.setString(1, user_name);
            cs.setString(2, selectedValue);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.setString(4, current_user);

            // Thực thi stored procedure
            cs.execute();

            // Lấy kết quả từ tham số OUT
            rs = (ResultSet) cs.getObject(3);

            // Hiển thị kết quả trong jTable1
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
         catch (Exception e) {
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        int selectedColumn = 0;
        String columnName = jTable1.getColumnName(selectedColumn);
        String id = jTable1.getValueAt(selectedRow, 0).toString();
        String current_user = Dataservice.user;
        String user_name = jComboBox1.getSelectedItem().toString();
        try {
            // Thực hiện kết nối cơ sở dữ liệu Oracle
            con = Dataservice.Getconnect(); 
            // Gọi stored procedure PROC_DELETE_DATA
            String sql = "{ call admin1.PROC_DELETE_DATA(?, ?, ?, ?, ?) }";
            String selectedValue = jComboBox2.getSelectedItem().toString();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, selectedValue);
            statement.setString(2, id);
            statement.setString(3, columnName);
            statement.setString(4, current_user);
            statement.setString(5, user_name);            
            statement.execute();

            // Xoá dòng dữ liệu trong mô hình JTable
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow);
            
            // Đóng kết nối và thông báo thành công
            statement.close();
            JOptionPane.showMessageDialog(null, "Đã xoá dòng dữ liệu thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xoá dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String selectedValue = jComboBox2.getSelectedItem().toString();
        if(selectedValue.equals("KHACHHANG")){
            GUI.GUI_CREATE_KHACHHANG create_KH = new GUI_CREATE_KHACHHANG();
            create_KH.setVisible(true);
        }else if(selectedValue.equals("CHITIETHOADON")){
            GUI.GUI_CREATE_CHITIETHOADON create_KH = new GUI_CREATE_CHITIETHOADON();
            create_KH.setVisible(true);
        }else if(selectedValue.equals("SANNPHAM")){
            GUI.GUI_CREATE_SAPNPHAM create_KH = new GUI_CREATE_SAPNPHAM();
            create_KH.setVisible(true);
        }else if(selectedValue.equals("HOADON")){
            GUI.GUI_CREATE_HOADON create_KH = new GUI_CREATE_HOADON();
            create_KH.setVisible(true);
        }else if(selectedValue.equals("TTT")){
            GUI.GUI_CREATE_TTT create_KH = new GUI_CREATE_TTT();
            create_KH.setVisible(true);
        }
        System.out.println(selectedValue);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Object cellValue = model.getValueAt(row, column);
            }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Object selectedItem = jComboBox2.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded2) {
            LoadCacDoiTuong();
            isComboBoxLoaded2 = true; // Đánh dấu là đã chạy LoadCacDoiTuong()
        }

    }//GEN-LAST:event_jComboBox2ActionPerformed
    private boolean isComboBoxLoaded = false;
    private boolean isComboBoxLoaded2 = false;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Lấy item được chọn trong JComboBox
        Object selectedItem = jComboBox1.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded) {
            LoadUserChu();
            isComboBoxLoaded = true; // Đánh dấu là đã chạy LoadCacDoiTuong()
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
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
    private void LoadCacDoiTuong() {
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;

try {
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
    private int getCountRows(Connection con) throws SQLException {
        int rowCount = 0;
        String sql = "BEGIN ? := admin1.count_rows(); END;";

        CallableStatement cs = con.prepareCall(sql);
        cs.registerOutParameter(1, java.sql.Types.INTEGER);
        cs.execute();

        rowCount = cs.getInt(1);

        cs.close();
        return rowCount;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
