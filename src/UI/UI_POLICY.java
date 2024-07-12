/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Admin
 */
public class UI_POLICY extends javax.swing.JPanel {

    /**
     * Creates new form UI_POLICY
     */
    public UI_POLICY() throws SQLException {
        initComponents();
        loadTableNames(jcmb_tenbang);
        showAuditPolicies(Jtable_Policy);
    }
    private static Connection connection;

        static {
            // Mở kết nối đến cơ sở dữ liệu khi lớp được nạp
            connection = DAO.Dataservice.Getconnect();
        }
    public void createAuditPolicy(String policyName, String tableName, String actions) throws SQLException {
        // Chuẩn bị và thực thi stored procedure trong khối try-with-resources
        try (CallableStatement stmt = connection.prepareCall("{ call Proc_Create_Audit_Policy(?, ?, ?) }")) {
            stmt.setString(1, policyName);
            stmt.setString(2, tableName);
            stmt.setString(3, actions);
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Audit policy " + policyName + " created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



     public void showAuditPolicies(JTable table) throws SQLException {
        // Chuẩn bị và thực thi stored procedure
        CallableStatement stmt = connection.prepareCall("{ call Proc_Show_Audit_Policies(?) }");
        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.execute();
        
        // Lấy kết quả từ stored procedure
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        // Hiển thị kết quả trên JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Policy Name");
        model.addColumn("Audit Option");
        model.addColumn("Audit Condition");
        model.addColumn("Object Schema");
        
        while (rs.next()) {
            String policyName = rs.getString("POLICY_NAME");
            String auditOption = rs.getString("AUDIT_OPTION");
            String auditCondition = rs.getString("AUDIT_CONDITION");
            String objectSchema = rs.getString("OBJECT_SCHEMA");
            
            model.addRow(new Object[]{policyName, auditOption, auditCondition, objectSchema});
        }
        
        table.setModel(model);
        
        // Đóng kết nối và các tài nguyên
        rs.close();
        stmt.close();
    }

    public static void loadTableNames(JComboBox<String> comboBox) {
        try {
            CallableStatement stmt = connection.prepareCall("{call Proc_GetTableNamesForUser(?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();

            ResultSet rs = (ResultSet) stmt.getObject(1);

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

            while (rs.next()) {
                comboBoxModel.addElement(rs.getString("table_name"));
            }

            comboBox.setModel(comboBoxModel);

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void refreshTable() throws SQLException {
        showAuditPolicies(Jtable_Policy);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jcmb_tenbang = new javax.swing.JComboBox<>();
        txt_policyname = new javax.swing.JTextField();
        txt_policy_action = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Jtable_polict = new javax.swing.JScrollPane();
        Jtable_Policy = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÍ POLICY");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên Bảng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tên Của policy:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Hành động của policy");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Chú Thích về hành động");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("SELECT: Ghi lại mọi truy vấn SELECT thực hiện trên bảng hoặc đối tượng được chỉ định.\n\nINSERT: Ghi lại mọi truy vấn INSERT thực hiện để chèn dữ liệu mới vào bảng hoặc đối tượng được chỉ định.\n\nUPDATE: Ghi lại mọi truy vấn UPDATE thực hiện để cập nhật dữ liệu trong bảng hoặc đối tượng được chỉ định.\n\nDELETE: Ghi lại mọi truy vấn DELETE thực hiện để xóa dữ liệu khỏi bảng hoặc đối tượng được chỉ định.\n\nALTER: Ghi lại mọi truy vấn ALTER thực hiện để thay đổi cấu trúc của bảng hoặc đối tượng được chỉ định.\n\nCREATE: Ghi lại mọi truy vấn CREATE thực hiện để tạo mới các đối tượng trong cơ sở dữ liệu, chẳng hạn như bảng, chỉ mục, hoặc thủ tục.\n\nDROP: Ghi lại mọi truy vấn DROP thực hiện để xóa các đối tượng khỏi cơ sở dữ liệu.\n\nGRANT: Ghi lại mọi truy vấn GRANT thực hiện để cấp quyền cho người dùng hoặc vai trò trong cơ sở dữ liệu.\n\nREVOKE: Ghi lại mọi truy vấn REVOKE thực hiện để thu hồi quyền từ người dùng hoặc vai trò trong cơ sở dữ liệu.");
        jScrollPane1.setViewportView(jTextArea1);

        jcmb_tenbang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Tạo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Jtable_Policy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Jtable_polict.setViewportView(Jtable_Policy);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcmb_tenbang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_policyname)
                                .addComponent(txt_policy_action, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(Jtable_polict)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(294, 294, 294))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(txt_policyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcmb_tenbang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_policy_action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jtable_polict, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txt_policy_action.getText().equals("") || txt_policyname.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Thiếu Dữ Liệu");
} else {
            try {
                createAuditPolicy(txt_policyname.getText(), String.valueOf(jcmb_tenbang.getSelectedItem()), txt_policy_action.getText());
            } catch (SQLException ex) {
                Logger.getLogger(UI_POLICY.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable_Policy;
    private javax.swing.JScrollPane Jtable_polict;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> jcmb_tenbang;
    private javax.swing.JTextField txt_policy_action;
    private javax.swing.JTextField txt_policyname;
    // End of variables declaration//GEN-END:variables
}
