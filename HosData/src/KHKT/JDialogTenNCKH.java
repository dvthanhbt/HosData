/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KHKT;

import DataDB2.*;
import NhanSu.*;
import java.awt.Frame;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author bvndc
 */
public class JDialogTenNCKH extends javax.swing.JDialog {

    /**
     * Creates new form JDialogTenNCKH
     */
    private String nckhID;
    private String maNV;
    
    ActionLoaiNC actLoaiNC = new ActionLoaiNC();
    ActionHe actHe = new ActionHe();
    ActionCap actCap = new ActionCap();
    ActionLoaiNV actLoaiNV = new ActionLoaiNV();
    ActionTacGia actTG = new ActionTacGia();
    ActionNhanVien actNV = new ActionNhanVien();
    ActionTenNCKH actTenNCKH = new ActionTenNCKH();
    
    ArrayList<LoaiNC> lstLoaiNC;
    ArrayList<He> lstHe;
    ArrayList<Cap> lstCap;
    ArrayList<LoaiNV> lstLoaiNV;
    
    TenNCKH tenNCKH;
    TacGia tacGia;
    
    public JDialogTenNCKH(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboLoaiNC = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboHe = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboCap = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTenNCKH = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtKhaNangUD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtKinhPhi = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNgayDK = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboLoaiNV = new javax.swing.JComboBox();
        btnSub = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCLose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cập nhật tên nghiên cứu khoa học");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Năm:");

        jLabel2.setText("Loại nghiên cứu:");

        cboLoaiNC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Hệ:");

        cboHe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Cấp:");

        cboCap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Tên đề tài:");

        jScrollPane1.setAutoscrolls(true);

        txtTenNCKH.setColumns(20);
        txtTenNCKH.setRows(5);
        jScrollPane1.setViewportView(txtTenNCKH);

        jLabel6.setText("Khả năng và địa chỉ áp dụng:");

        jLabel7.setText("Thời gian thực hiện:");

        jLabel8.setText("Dự kiến kinh phí:");

        txtKinhPhi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel9.setText("Ngày ĐK:");

        txtNgayDK.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tác giả thực hiện:"));

        jLabel10.setText("Tên tác giả:");

        txtTacGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTacGiaFocusLost(evt);
            }
        });

        jLabel11.setText("Chuyên môn:");

        cboLoaiNV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RightsRestrictedHS.png"))); // NOI18N
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AddTableHS.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setFillsViewportHeight(true);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSub))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSub)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(cboLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NewDocumentHS.png"))); // NOI18N
        btnNew.setText("Thêm");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/saveHS.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DeleteHS.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCLose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GoToParentFolderHS.png"))); // NOI18N
        btnCLose.setText("Đóng");
        btnCLose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLoseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboLoaiNC, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboHe, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboCap, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKhaNangUD)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKinhPhi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCLose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboLoaiNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKhaNangUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtKinhPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnCLose))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCLoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLoseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCLoseActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtNam.setText(String.valueOf(LocalDate.now().getYear()));
        txtNgayDK.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        try {
            loadData();
            showNCKH();
        } catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtTacGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTacGiaFocusLost
        try {
            if (txtTacGia.getText().trim().length() == 0) {
                maNV = "";
                return;
            }
            ResultSet rs = actNV.getListNhanVien(txtTacGia.getText());
            rs.last();
            if (rs.getRow() > 0){
                if (rs.getRow() > 1){
                    JDialogSearchNhanVien frm = new JDialogSearchNhanVien((Frame) this.getParent(), true);
                    rs.first();
                    frm.loadData();
                    frm.setVisible(true);
                    txtTacGia.setText(frm.getHoTen());
                    maNV = frm.getMaNV();
                }
                else {
                    rs.first();
                    txtTacGia.setText(rs.getString("HoTen"));
                    maNV = rs.getString("MaNV");
                }
            }
            else {
                maNV = "";
                txtTacGia.setText("");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }    }//GEN-LAST:event_txtTacGiaFocusLost

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            txtTenNCKH.setText("");
            txtKhaNangUD.setText("");
            txtThoiGian.setText("");
            txtKinhPhi.setText("");
            txtNam.setText(String.valueOf(LocalDate.now().getYear()));
            txtNgayDK.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            setNckhID("");
            loadTacGia();
            txtTenNCKH.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNewActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (getNckhID().length() == 0) return;
        if (JOptionPane.showConfirmDialog(null, "Xoá đề tài, sáng kiến hiện tại phải không?", "Nghiên cứu khoa học", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            actTenNCKH.deleteTenNCKH(getNckhID());
            btnNewActionPerformed(evt);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!kiemTra()) return;
        try {
            tenNCKH = new TenNCKH(nckhID, 
                    lstLoaiNC.get(cboLoaiNC.getSelectedIndex()).getLoaiNCID(),
                    lstHe.get(cboHe.getSelectedIndex()).getHeID(),
                    lstCap.get(cboCap.getSelectedIndex()).getCapID(),
                    txtTenNCKH.getText(), 
                    txtThoiGian.getText(), 
                    txtKhaNangUD.getText(), 
                    Float.parseFloat(txtKinhPhi.getText().trim().length() == 0? "0" : txtKinhPhi.getText()), 
                    Integer.parseInt(txtNam.getText()), 
                    Date.valueOf(LocalDate.parse(txtNgayDK.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))), 
                    0, null, "", 0);
            nckhID = actTenNCKH.saveTenNCKH(tenNCKH);
        } catch (Exception e){
            e.printStackTrace();
        }
        btnNew.requestFocus();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            btnSaveActionPerformed(null);
            if (txtTacGia.getText().trim().length() == 0) return;
            tacGia = new TacGia(nckhID, maNV, lstLoaiNV.get(cboLoaiNV.getSelectedIndex()).getLoaiNVID(), 0);
            actTG.saveTacGia(tacGia);
            txtTacGia.setText("");
            maNV = "";
            loadTacGia();
            txtTacGia.requestFocus();
        } catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        try {
            maNV = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            actTG.deleteTacGia(nckhID, maNV);
            maNV = "";
            loadTacGia();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSubActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogTenNCKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogTenNCKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogTenNCKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogTenNCKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogTenNCKH dialog = new JDialogTenNCKH(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }

                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCLose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSub;
    private javax.swing.JComboBox cboCap;
    private javax.swing.JComboBox cboHe;
    private javax.swing.JComboBox cboLoaiNC;
    private javax.swing.JComboBox cboLoaiNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtKhaNangUD;
    private javax.swing.JFormattedTextField txtKinhPhi;
    private javax.swing.JTextField txtNam;
    private javax.swing.JFormattedTextField txtNgayDK;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextArea txtTenNCKH;
    private javax.swing.JTextField txtThoiGian;
    // End of variables declaration//GEN-END:variables

    public String getNckhID() {
        return nckhID;
    }

    public void setNckhID(String nckhID) {
        this.nckhID = nckhID;
    }

    private void loadData() throws Exception {
        loadLoaiNC();
        loadHe();
        loadCap();
        loadLoaiNV();
        loadTacGia();
    }
    private void loadLoaiNC() throws Exception{
        lstLoaiNC = actLoaiNC.getAllLoaiNC();
        cboLoaiNC.removeAllItems();
        for (LoaiNC dt:lstLoaiNC){
            cboLoaiNC.addItem(dt.getTenLoaiNC());
        }
    }
    private void loadHe() throws Exception{
        lstHe = actHe.getAllHe();
        cboHe.removeAllItems();
        for (He dt:lstHe){
            cboHe.addItem(dt.getTenHe());
        }
    }
    private void loadCap() throws Exception{
        lstCap = actCap.getAllCap();
        cboCap.removeAllItems();
        for (Cap dt:lstCap){
            cboCap.addItem(dt.getTenCap());
        }
    }
    private void loadLoaiNV() throws Exception{
        lstLoaiNV = actLoaiNV.getAllLoaiNV();
        cboLoaiNV.removeAllItems();
        for (LoaiNV dt:lstLoaiNV){
            cboLoaiNV.addItem(dt.getTenLoaiNV());
        }
    }
    private void loadTacGia() throws Exception{
        String[] header = {"Mã số", "Tác giả", "Khoa, Phòng"};
        FillData fillData = new FillData();
        fillData.fillDataJTable(jTable1, header, actTG.getListTacGia(getNckhID()));
    }

    private boolean kiemTra() {
        if (txtNam.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Chưa nhập năm đề tài, sáng kiến!");
            txtNam.requestFocus();
            return false;
        }
        if (txtTenNCKH.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Chưa nhập tên đề tài, sáng kiến!");
            txtTenNCKH.requestFocus();
            return false;
        }
        if (txtNgayDK.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Chưa nhập ngày đăng ký đề tài sáng kiến!");
            txtNgayDK.requestFocus();
            return false;
        }
        return true;
    }

    private void showNCKH() throws SQLException {
        if (getNckhID() == null) return;
        try {
            tenNCKH = actTenNCKH.getTenNCKH(getNckhID());
            txtNam.setText(String.valueOf(tenNCKH.getNam()));
            cboLoaiNC.setSelectedIndex(actLoaiNC.getIndexLoaiNC(lstLoaiNC, tenNCKH.getLoaiNCID()));
            cboHe.setSelectedIndex(actHe.getIndexHe(lstHe, tenNCKH.getHeID()));
            cboCap.setSelectedIndex(actCap.getIndexCap(lstCap, tenNCKH.getCapID()));
            txtTenNCKH.setText(tenNCKH.getTenNCKH());
            txtKhaNangUD.setText(tenNCKH.getKhaNangUD());
            txtThoiGian.setText(tenNCKH.getThoiGian());
            txtKinhPhi.setText(String.valueOf(tenNCKH.getKinhPhi()));
            txtNgayDK.setText(tenNCKH.getNgayDK().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            loadTacGia();
        } catch (Exception ex) {
            Logger.getLogger(JDialogTenNCKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
