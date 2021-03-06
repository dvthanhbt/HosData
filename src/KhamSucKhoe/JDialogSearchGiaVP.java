/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KhamSucKhoe;

import DataDB2.FillData;
import DataDB2.IntegerRenderer;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author bvndc
 */
public class JDialogSearchGiaVP extends javax.swing.JDialog {

    /**
     * Creates new form JDialogSearchGiaVP
     */
    ActionGiaVP actGiaVP = new ActionGiaVP();
    private String giaVPID;
    private String tenGiaVP;
    private Float giaTH;
    private TableRowSorter<TableModel> sorter;
    private DefaultTableModel tableModel;
    public JDialogSearchGiaVP(java.awt.Frame parent, boolean modal) {
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
        txtTenDichVu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGetDichVu = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh mục dịch vụ");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Tên dịch vụ:");

        txtTenDichVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenDichVuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenDichVuKeyReleased(evt);
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setFillsViewportHeight(true);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnGetDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PlayHS.png"))); // NOI18N
        btnGetDichVu.setText("Chọn dịch vụ");
        btnGetDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetDichVuActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GoToParentFolderHS.png"))); // NOI18N
        btnClose.setText("Đóng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDichVu)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(btnGetDichVu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetDichVu)
                    .addComponent(btnClose))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setGiaVPID("");
        setTenGiaVP("");
        setGiaTH(null);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            loadData();
            txtTenDichVu.setText(getGiaVPID());
            txtTenDichVuKeyReleased(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtTenDichVuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenDichVuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            jTable1.requestFocus();
        }
    }//GEN-LAST:event_txtTenDichVuKeyPressed

    private void btnGetDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDichVuActionPerformed
        if (jTable1.getSelectedRow() >= 0){
            setGiaVPID(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            setTenGiaVP(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            setGiaTH(Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()));
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn dịch vu!");
        }
    }//GEN-LAST:event_btnGetDichVuActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnGetDichVuActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void txtTenDichVuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenDichVuKeyReleased
        try {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtTenDichVu.getText()));
        } catch (Exception ex) {
           System.err.println("Bad regex pattern");
        }
    }//GEN-LAST:event_txtTenDichVuKeyReleased

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
            java.util.logging.Logger.getLogger(JDialogSearchGiaVP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogSearchGiaVP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogSearchGiaVP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogSearchGiaVP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogSearchGiaVP dialog = new JDialogSearchGiaVP(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnGetDichVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables

    public String getGiaVPID() {
        return giaVPID;
    }

    public void setGiaVPID(String giaVPID) {
        this.giaVPID = giaVPID;
    }

    public String getTenGiaVP() {
        return tenGiaVP;
    }

    public void setTenGiaVP(String tenGiaVP) {
        this.tenGiaVP = tenGiaVP;
    }

    private void loadData() throws Exception {
        String[] header = {"Mã số", "Tên dịch vu", "Đơn vị", "Đơn giá"};
        ResultSet rs = actGiaVP.getListGiaVP();
        FillData fillData = new FillData();
        fillData.fillDataJTable(jTable1, header, rs);
        TableCellRenderer tcr;
        tcr = new IntegerRenderer();
        jTable1.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tableModel = (DefaultTableModel) jTable1.getModel();
        sorter = new TableRowSorter<TableModel>(tableModel);
        jTable1.setRowSorter(sorter);
    }

    public Float getGiaTH() {
        return giaTH;
    }

    public void setGiaTH(Float giaTH) {
        this.giaTH = giaTH;
    }
}
