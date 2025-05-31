package macromedia;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.util.Arrays;
import java.util.List;

public class Dashboard extends javax.swing.JFrame {

    public static List<String[]> projectList = new ArrayList<>();
    public static List<String[]> viewProjectList = new ArrayList<>();

    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        loadProjects();
    }

    public void loadProjects() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Hapus data lama agar tidak duplikat

        //projectList.add(projectData);
        for (int i = 0; i < CreateProject.projectList.size(); i++) {
            String[] project = CreateProject.projectList.get(i);
            if (project.length >= 5) {
                System.out.println("Project " + i + ": " + Arrays.toString(project));
                model.addRow(new Object[]{
                    project[0],
                    project[1],
                    project[2],
                    project[3],
                    project[4],
                    "Edit/Delete"
                });
            }
        }
        //projectList.add(projectData);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit: " + row);
                System.out.println("Edit: " + row);

                // Tampilkan log seperti sebelumnya
                System.out.println("======= LOG EDIT PROJECT =======");
                for (int i = 0; i < CreateProject.EditprojectList.size(); i++) {
                    String[] data = CreateProject.EditprojectList.get(i);
                    System.out.println("Data ke-" + (i + 1) + ": " + Arrays.toString(data));
                }

                System.out.println("======= ORDER DETAIL PROJECT =======");
                for (int i = 0; i < CreateProject.orderDetailList.size(); i++) {
                    List<String> detail = CreateProject.orderDetailList.get(i);
                    System.out.println("Order ke-" + (i + 1) + ": " + detail);
                }

                // Buka kembali form CreateProject dan isi data berdasarkan row
                CreateProject form = new CreateProject();
                form.setVisible(true);
                form.editProject(row);

                Dashboard.this.dispose(); // tutup dashboard

                System.out.println("======= LOG EDIT PROJECT =======");
                for (int i = 0; i < CreateProject.EditprojectList.size(); i++) {
                    String[] data = CreateProject.EditprojectList.get(i);
                    System.out.println("Data ke-" + (i + 1) + ":");
                    for (int j = 0; j < data.length; j++) {
                        System.out.println("  Kolom " + (j + 1) + ": " + data[j]);
                    }
                }
                System.out.println("================================");
                System.out.println("======= ORDER DETAIL PROJECT =======");
                for (int i = 0; i < CreateProject.orderDetailList.size(); i++) {
                    List<String> detail = CreateProject.orderDetailList.get(i);
                    System.out.println("Order ke-" + (i + 1) + ":");
                    for (int j = 0; j < detail.size(); j++) {
                        System.out.println("  Field " + (j + 1) + ": " + detail.get(j));
                    }
                }
                System.out.println("====================================");
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Delete: " + row);
                if (jTable2.isEditing()) {
                    jTable2.getCellEditor().stopCellEditing();
                }
                model.removeRow(row);
            }

            @Override
            public void onView(int row) {
                System.out.println("View: " + row);
                try {
                    if (row >= 0 && row < CreateProject.viewProjectList.size()) {
                        String[] projectDetails = CreateProject.viewProjectList.get(row);

                        StringBuilder message = new StringBuilder();
                        message.append("================ DETAIL PROYEK ================\n\n");

                        message.append(String.format("Nama Proyek          : %s\n", projectDetails.length > 0 && projectDetails[0] != null ? projectDetails[0] : "N/A"));
                        message.append(String.format("Tanggal Order        : %s\n", projectDetails.length > 1 && projectDetails[1] != null ? projectDetails[1] : "N/A"));
                        message.append(String.format("Tanggal Event        : %s\n", projectDetails.length > 2 && projectDetails[2] != null ? projectDetails[2] : "N/A"));
                        message.append(String.format("Kota Venue           : %s\n", projectDetails.length > 3 && projectDetails[3] != null ? projectDetails[3] : "N/A"));
                        message.append("\n");

                        message.append("--- Informasi Klien ---\n");
                        message.append(String.format("Nama Perusahaan      : %s\n", projectDetails.length > 4 && projectDetails[4] != null ? projectDetails[4] : "N/A"));
                        message.append(String.format("Nama Kontak          : %s\n", projectDetails.length > 6 && projectDetails[6] != null ? projectDetails[6] : "N/A")); // Menggunakan index 6 untuk Nama Kontak
                        message.append(String.format("Telepon Kontak       : %s\n", projectDetails.length > 5 && projectDetails[5] != null ? projectDetails[5] : "N/A")); // Menggunakan index 5 untuk Telepon
                        message.append("\n");

                        message.append("--- Catatan ---\n");
                        message.append(String.format("Catatan dari Klien   :\n%s\n", projectDetails.length > 8 && projectDetails[8] != null ? projectDetails[8] : "N/A")); // Menggunakan index 8
                        message.append("\n");

                        message.append("--- Detail Item (Pertama) ---\n");
                        message.append(String.format("Nama Item            : %s\n", projectDetails.length > 9 && projectDetails[9] != null ? projectDetails[9] : "N/A"));
                        message.append("\n"); 

                        message.append("==============================================\n");
                        JOptionPane.showMessageDialog(
                                null, // Parent component (null artinya di tengah layar)
                                message.toString(), // Pesan yang sudah dibangun
                                "Detail Proyek", // Judul dialog
                                JOptionPane.INFORMATION_MESSAGE // Tipe ikon
                        );

                    } else {
                        // Handle jika index tidak valid atau data tidak ditemukan
                        JOptionPane.showMessageDialog(
                                null,
                                "Data proyek tidak ditemukan untuk baris ini.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                } catch (Exception e) {
                    // Tangani error jika terjadi
                    e.printStackTrace(); // Cetak stack trace untuk debugging
                    JOptionPane.showMessageDialog(
                            null,
                            "Terjadi kesalahan saat menampilkan detail proyek: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        };

        jTable2.getColumn("Action").setCellRenderer(new TableActionCellRender());
        jTable2.getColumn("Action").setCellEditor(new TableActionCellEditor(event));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Makromedia");

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", "", ""}
            },
            new String [] {
                "Order Date", "Nama project", "Client Company", "Event Date", "Status", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(40);
        jScrollPane2.setViewportView(jTable2);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Project List");

        jButton13.setBackground(new java.awt.Color(51, 102, 255));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Add Project");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addContainerGap(851, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        new CreateProject().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
