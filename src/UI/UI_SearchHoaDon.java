/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author LunChan
 */
public class UI_SearchHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form UI_SearchHoaDon
     */
    public UI_SearchHoaDon() {
        initComponents();        
        loadHoaDonDataToTable(jTable_SearchHoaDon);
        loadMaKHMtoComboBox();
        
        jComboBox_MaKH.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedMaKH = jComboBox_MaKH.getSelectedItem().toString();
            timKiemHoaDonTheoMaKH(selectedMaKH);
        }
    });
        loadHoaDonDataToTable(jTable_SearchHoaDon);
    }
    
    private static Connection connection;

    static {
        // Mở kết nối đến cơ sở dữ liệu khi lớp được nạp
        connection = DAO.Dataservice.Getconnect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_SearchHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton_Refesh = new javax.swing.JButton();
        jComboBox_MaKH = new javax.swing.JComboBox<>();

        jTable_SearchHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã NV", "Mã KH", "Ngày bán", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(jTable_SearchHoaDon);

        jLabel1.setText("Mã khách hàng:");

        jButton_Refesh.setText("Refesh");
        jButton_Refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefeshActionPerformed(evt);
            }
        });

        jComboBox_MaKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_MaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_MaKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton_Refesh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefeshActionPerformed
        loadHoaDonDataToTable(jTable_SearchHoaDon);
    }//GEN-LAST:event_jButton_RefeshActionPerformed

    private void jComboBox_MaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_MaKHActionPerformed
        
    }//GEN-LAST:event_jComboBox_MaKHActionPerformed

    private void loadMaKHMtoComboBox() {
        try (CallableStatement cstmt = connection.prepareCall("{call Proc_GetAllMaKH(?)}")) {
            // Đăng ký tham số đầu ra kiểu CURSOR
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Thực hiện cuộc gọi stored procedure
            cstmt.execute();

            // Lấy CURSOR từ tham số đầu ra
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            // Xóa tất cả các item cũ trong combobox
            jComboBox_MaKH.removeAllItems();

            // Thêm mã khách hàng vào combobox
            while (rs.next()) {
                String maKH = rs.getString(1); // Lấy cột đầu tiên từ kết quả truy vấn
                jComboBox_MaKH.addItem(maKH);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void timKiemHoaDonTheoMaKH(String maKH) {
        try (CallableStatement cstmt = connection.prepareCall("{call Proc_SearchHoaDonByMaKH(?, ?)}")) {
            cstmt.setString(1, maKH);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);

            // Thực hiện truy vấn
            cstmt.execute();

            // Lấy CURSOR từ tham số đầu ra
            ResultSet resultSet = (ResultSet) cstmt.getObject(2);

            // Xóa tất cả các dòng trong bảng jTable_SearchHoaDon
            DefaultTableModel model = (DefaultTableModel) jTable_SearchHoaDon.getModel();
            model.setRowCount(0);

            // Đổ dữ liệu từ kết quả truy vấn vào bảng
            while (resultSet.next()) {
                String maHD = resultSet.getString("MaHD");
                String maNV = resultSet.getString("MaNV");
                String ngayBan = resultSet.getString("NgayBan");
                double tongTien = resultSet.getDouble("TongTien");

                // Thêm dòng mới vào bảng
                model.addRow(new Object[]{maHD, maNV, maKH, ngayBan, tongTien});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadHoaDonDataToTable(JTable table) {
        try (CallableStatement cstmt = connection.prepareCall("{call Proc_GetAllHoaDon(?)}")) {
            // Đăng ký tham số đầu ra kiểu CURSOR
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Thực hiện cuộc gọi stored procedure
            cstmt.execute();
            // Lấy CURSOR từ tham số đầu ra
            ResultSet resultSet = (ResultSet) cstmt.getObject(1);
            // Xóa tất cả các dòng trong bảng jTable_SearchHoaDon
            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã HD", "Mã NV", "Mã KH", "Ngày bán", "Tổng tiền"}, 0);
            model.setRowCount(0);

            // Đổ dữ liệu từ kết quả truy vấn vào bảng
            while (resultSet.next()) {
                String maKH = resultSet.getString("MaKH");
                // Thêm vào JComboBox nếu chưa tồn tại
                if (!containsItem(maKH, jComboBox_MaKH)) {
                    jComboBox_MaKH.addItem(maKH);
                }
                String maHD = resultSet.getString("MaHD");
                String maNV = resultSet.getString("MaNV");
                String ngayBan = resultSet.getString("NgayBan");
                double tongTien = resultSet.getDouble("TongTien");
                // Thêm dòng mới vào bảng
                model.addRow(new Object[]{maHD, maNV, maKH, ngayBan, tongTien});
            }
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private boolean containsItem(String item, JComboBox<String> comboBox) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (item.equals(comboBox.getItemAt(i))) {
                return true;
            }
        }
        return false;
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Refesh;
    private javax.swing.JComboBox<String> jComboBox_MaKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_SearchHoaDon;
    // End of variables declaration//GEN-END:variables
}
