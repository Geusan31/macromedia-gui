/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package macromedia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Helios
 */
public class OrderDetail extends javax.swing.JFrame {

//    private JFrame frame;
////    private JPanel formContainer;
//    private JButton addButton;
//    private List<JPanel> orderForms = new ArrayList<>();
    /**
     * Creates new form OrderDetail
     */
    public OrderDetail() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        mainContainer = new javax.swing.JPanel();
        formContainer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNamaItem = new javax.swing.JTextField();
        txtHargaUnit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        scrollDeskripsi = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        txtFrek = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtPeriode = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        tambahOrder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 106, 255));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 102, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Next Step");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 106, 255));
        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mainContainer.setBackground(new java.awt.Color(204, 204, 204));

        formContainer.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nama Item");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Deskripsi");

        txtNamaItem.setBackground(new java.awt.Color(255, 255, 255));

        txtHargaUnit.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Harga Per Unit");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Qty");

        txtQty.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Order Detail");

        txtDeskripsi.setBackground(new java.awt.Color(255, 255, 255));
        txtDeskripsi.setColumns(1);
        txtDeskripsi.setForeground(new java.awt.Color(0, 0, 0));
        txtDeskripsi.setRows(1);
        txtDeskripsi.setTabSize(1);
        txtDeskripsi.setToolTipText("Message");
        scrollDeskripsi.setViewportView(txtDeskripsi);

        txtFrek.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Frek");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Periode");

        txtPeriode.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Discount");

        txtDiscount.setBackground(new java.awt.Color(255, 255, 255));
        txtDiscount.setColumns(6);

        javax.swing.GroupLayout formContainerLayout = new javax.swing.GroupLayout(formContainer);
        formContainer.setLayout(formContainerLayout);
        formContainerLayout.setHorizontalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addGroup(formContainerLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(398, 398, 398)
                        .addComponent(jLabel8))
                    .addGroup(formContainerLayout.createSequentialGroup()
                        .addComponent(txtNamaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtHargaUnit))
                    .addComponent(jLabel7)
                    .addGroup(formContainerLayout.createSequentialGroup()
                        .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formContainerLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(224, 224, 224)
                                .addComponent(jLabel17)
                                .addGap(205, 205, 205)
                                .addComponent(jLabel18))
                            .addGroup(formContainerLayout.createSequentialGroup()
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFrek, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollDeskripsi))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        formContainerLayout.setVerticalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formContainerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(scrollDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(6, 6, 6)
                .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFrek, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addComponent(formContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2877, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(mainContainer);

        tambahOrder.setBackground(new java.awt.Color(51, 51, 51));
        tambahOrder.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tambahOrder.setForeground(new java.awt.Color(0, 106, 255));
        tambahOrder.setText("Tambah Order Detail");
        tambahOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahOrderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tambahOrder)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(642, 642, 642)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tambahOrder)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        scrollPane.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new Create().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new Summary().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private int rowCounter = 0;
    private List<JPanel> formList = new ArrayList<>();
    private void tambahOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahOrderMouseClicked
        // TODO add your handling code here:
        // Panel pembungkus untuk setiap order detail
        tambahOrder.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        JPanel newForm = createNewFormContainer();

        // Simpan formContainer baru di dalam list agar bisa diakses nanti
        formList.add(newForm);

        // Tambahkan ke mainContainer
        GridBagConstraints gbcPanel = new GridBagConstraints();
        gbcPanel.gridx = 0;
        gbcPanel.gridy = rowCounter++;  // Susun ke bawah
        gbcPanel.weightx = 1.0;
        gbcPanel.fill = GridBagConstraints.HORIZONTAL;
        mainContainer.add(newForm, gbcPanel);

        // Paksa refresh tampilan
        mainContainer.setPreferredSize(new Dimension(mainContainer.getWidth(), mainContainer.getHeight() + 100));
        mainContainer.revalidate();
        mainContainer.repaint();
        System.out.println("FormContainer added! Total forms: " + formList.size());
    }//GEN-LAST:event_tambahOrderMouseClicked

    private JPanel createNewFormContainer() {
        JPanel formContainer = new JPanel(new GridBagLayout());
        formContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        formContainer.setBackground(Color.WHITE);

        // Label Order Detail
        JLabel orderDetailLabel = new JLabel("Order Detail");
        orderDetailLabel.setFont(new Font("Arial", Font.BOLD, 16));

        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 0;
        gbcLabel.gridy = 0;
        gbcLabel.insets = new Insets(10, 5, 5, 5);
        gbcLabel.anchor = GridBagConstraints.WEST;
        formContainer.add(orderDetailLabel, gbcLabel);

        // Panel untuk form input
        JPanel orderPanel = new JPanel(new GridBagLayout());
        orderPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Buat instance baru untuk setiap input field
        JTextField txtNamaItem = new JTextField(15);
        JTextField txtHargaUnit = new JTextField(10);
        JTextArea txtDeskripsi = new JTextArea(1, 1);
        txtDeskripsi.setLineWrap(true);
        txtDeskripsi.setWrapStyleWord(true);

        // Paksa ukuran tetap
        txtDeskripsi.setPreferredSize(new Dimension(200, 50));
        txtDeskripsi.setMinimumSize(new Dimension(200, 50));
        txtDeskripsi.setMaximumSize(new Dimension(200, 50));

        JScrollPane scrollDeskripsi = new JScrollPane(txtDeskripsi);
        scrollDeskripsi.setPreferredSize(new Dimension(200, 50));
        scrollDeskripsi.setMinimumSize(new Dimension(200, 50));
        scrollDeskripsi.setMaximumSize(new Dimension(200, 50));

        // Pastikan tidak ada efek layout yang menyebabkan perubahan ukuran
        scrollDeskripsi.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollDeskripsi.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE; // Jangan biarkan elemen meregang
        orderPanel.add(new JLabel("Deskripsi:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Hanya melebar, tidak bertambah tinggi
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        orderPanel.add(scrollDeskripsi, gbc);

        JTextField txtQty = new JTextField(5);
        JTextField txtFrek = new JTextField(5);
        JTextField txtPeriode = new JTextField(5);
        JTextField txtDiscount = new JTextField(5);

        // Tambahkan elemen-elemen ke orderPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        orderPanel.add(new JLabel("Nama Item:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(txtNamaItem, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        orderPanel.add(new JLabel("Harga Per Unit:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(txtHargaUnit, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        orderPanel.add(new JLabel("Deskripsi:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(scrollDeskripsi, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        orderPanel.add(new JLabel("Qty:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(txtQty, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        orderPanel.add(new JLabel("Frek:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(txtFrek, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        orderPanel.add(new JLabel("Periode:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(txtPeriode, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        orderPanel.add(new JLabel("Discount:"), gbc);
        gbc.gridx = 1;
        orderPanel.add(txtDiscount, gbc);

        // Tambahkan orderPanel ke formContainer
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.gridx = 0;
        gbcForm.gridy = 1;
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        formContainer.add(orderPanel, gbcForm);

        return formContainer;
    }

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
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel formContainer;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollDeskripsi;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel tambahOrder;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtFrek;
    private javax.swing.JTextField txtHargaUnit;
    private javax.swing.JTextField txtNamaItem;
    private javax.swing.JTextField txtPeriode;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
