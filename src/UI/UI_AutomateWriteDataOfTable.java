/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author LunChan
 */
public class UI_AutomateWriteDataOfTable extends javax.swing.JPanel {

    /**
     * Creates new form UI_AutomateWriteDataOfTable
     */
    public UI_AutomateWriteDataOfTable() {
        initComponents();
        String selectedTableName = (String) jComboBox_TableName.getSelectedItem();
        // Call the method with the selected table name
        ShowDataAuditTrailReport(jTable_AutomateWriteData, selectedTableName);
        loadObjectNames();
        
        jComboBox_TableName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy tên bảng được chọn từ JComboBox
                String selectedTableName = (String) jComboBox_TableName.getSelectedItem();
                // Lọc dữ liệu trong JTable dựa trên tên bảng được chọn
                filterTableData(selectedTableName);
            }
        });
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
        jTable_AutomateWriteData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_TableName = new javax.swing.JComboBox<>();

        jTable_AutomateWriteData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Người dùng", "Bảng", "Sự kiện", "Thời gian"
            }
        ));
        jScrollPane1.setViewportView(jTable_AutomateWriteData);

        jLabel1.setText("Bảng:");

        jComboBox_TableName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_TableName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_TableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void ShowDataAuditTrailReport(JTable table, String tableName) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        try (CallableStatement cstmt = connection.prepareCall("{call sys.Proc_GetAuditTrailByTableName(?, ?)}")) {
            // Set input parameter for the stored procedure (table name)
            cstmt.setString(1, tableName);
            // Set output parameter for the stored procedure
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            // Execute the stored procedure
            cstmt.execute();
            // Retrieve the result set from the stored procedure
            try (ResultSet rs = (ResultSet) cstmt.getObject(2)) {
                // Populate the JTable model with data
                while (rs.next()) {
                    Object[] rowData = new Object[]{
                        rs.getString("db_user"),
                        rs.getString("object_name"),
                        rs.getString("sql_text"),
                        rs.getString("extended_timestamp")
                        // Add more columns if needed
                    };
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            // Display user-friendly error message
            JOptionPane.showMessageDialog(null, "An error occurred while retrieving audit trail data: " 
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Log the exception for debugging
        }
    }
    
    private void loadObjectNames() {
        try {
            // Call the stored procedure
            try (CallableStatement cstmt = connection.prepareCall("{call sys.Proc_GetObjectNames(?)}")) {
                // Register the OUT parameter for the cursor
                cstmt.registerOutParameter(1, OracleTypes.CURSOR);
                // Execute the stored procedure
                cstmt.execute();
                // Retrieve the result set from the stored procedure
                try (ResultSet rs = (ResultSet) cstmt.getObject(1)) {
                    // Clear existing items in jComboBox_TableName
                    jComboBox_TableName.removeAllItems();
                    // Populate jComboBox_TableName with object_name values
                    while (rs.next()) {
                        String objectName = rs.getString("object_name");
                        if (objectName.equalsIgnoreCase("SanPham") || objectName.equalsIgnoreCase("HoaDon")) {
                            jComboBox_TableName.addItem(objectName);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while loading object names: " 
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    private void filterTableData(String selectedTableName) {
        DefaultTableModel model = (DefaultTableModel) jTable_AutomateWriteData.getModel();
        model.setRowCount(0); // Clear existing data

        try (CallableStatement cstmt = connection.prepareCall("{call sys.Proc_GetAuditTrailByTableName(?, ?)}")) {
            // Thiết lập tham số đầu vào cho stored procedure
            cstmt.setString(1, selectedTableName);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            // Thực thi stored procedure
            cstmt.execute();
            // Lấy dữ liệu từ stored procedure
            try (ResultSet rs = (ResultSet) cstmt.getObject(2)) {
                // Populate JTable model with filtered data
                while (rs.next()) {
                    Object[] rowData = new Object[]{
                        rs.getString("db_user"),
                        rs.getString("object_name"),
                        rs.getString("sql_text"),
                        rs.getString("extended_timestamp")
                        // Add more columns if needed
                    };
                    model.addRow(rowData);
                }
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ SQL
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi xảy ra khi lọc dữ liệu: " 
                    + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox_TableName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_AutomateWriteData;
    // End of variables declaration//GEN-END:variables
}
