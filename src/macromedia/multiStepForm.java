/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package macromedia;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import org.w3c.dom.UserDataHandler;

/**
 *
 * @author Helios
 */
public class multiStepForm extends javax.swing.JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private int currentStep = 0; // Step saat ini
    private JProgressBar progressBar; // (UPDATED) Progress Bar
    private ProjectData projectData; // (UPDATED) Objek untuk menyimpan data
    private JLabel stepLabel; // (UPDATED) Label untuk nama step
    private final String[] stepNames = {"Project Detail", "Order Detail", "Summary"}; // (UPDATED)

    public multiStepForm() {
        setTitle("Multi Step Form");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        projectData = new ProjectData(); // (UPDATED) Inisialisasi objek penyimpanan data

        // Tambahkan step panel ke mainPanel
        mainPanel.add(createProjectDetail(), "Step1");
        mainPanel.add(createOrderDetail(), "Step2");
        mainPanel.add(createSummary(), "Step3");
        // (UPDATED) Label nama step
        stepLabel = new JLabel(stepNames[currentStep], SwingConstants.CENTER);
        stepLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // (UPDATED) Progress Bar
        progressBar = new JProgressBar(0, 2);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        // (UPDATED) Panel utama dengan Label + Progress Bar di atas
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(stepLabel, BorderLayout.NORTH);
        topPanel.add(progressBar, BorderLayout.SOUTH);

        // (UPDATED) Progress Bar
        progressBar = new JProgressBar(0, 2);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        // (UPDATED) Panel utama dengan Progress Bar di atas
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(progressBar, BorderLayout.NORTH);
        containerPanel.add(mainPanel, BorderLayout.CENTER);

        add(containerPanel);
        setVisible(true);
    }

    // (UPDATED) Method untuk update progress bar
    private void updateProgressBar() {
        progressBar.setValue(currentStep);
        stepLabel.setText(stepNames[currentStep]); // Ubah teks nama step
    }

    // Step 1: Project Detail
    private JPanel createProjectDetail() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("Nama Proyek:");
        JTextField nameField = new JTextField(20);
        JLabel descLabel = new JLabel("Deskripsi Proyek:");
        JTextArea descArea = new JTextArea(4, 20);
        JButton nextButton = new JButton("Next");

        nextButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String description = descArea.getText().trim();
            if (name.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                projectData.setProjectName(name);
                projectData.setProjectDescription(description);
                cardLayout.next(mainPanel);
                currentStep++;
                updateProgressBar();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(descLabel);
        inputPanel.add(new JScrollPane(descArea));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    // Step 2: Order Detail
    private JPanel createOrderDetail() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel unitLabel = new JLabel("Jumlah Unit:");
        JTextField unitField = new JTextField(5);
        JLabel priceLabel = new JLabel("Harga per Unit:");
        JTextField priceField = new JTextField(10);
        JLabel discountLabel = new JLabel("Diskon (%):");
        JTextField discountField = new JTextField(5);
        JLabel taxLabel = new JLabel("Pajak (%):");
        JTextField taxField = new JTextField(5);

        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");

        prevButton.addActionListener(e -> {
            cardLayout.previous(mainPanel);
            currentStep--;
            updateProgressBar();
        });

        nextButton.addActionListener(e -> {
            try {
                int units = Integer.parseInt(unitField.getText().trim());
                double price = Double.parseDouble(priceField.getText().trim());
                double discount = Double.parseDouble(discountField.getText().trim());
                double tax = Double.parseDouble(taxField.getText().trim());

                if (units <= 0 || price <= 0 || discount < 0 || tax < 0) {
                    throw new NumberFormatException();
                }

                projectData.setUnits(units);
                projectData.setPricePerUnit(price);
                projectData.setDiscount(discount);
                projectData.setTax(tax);

                cardLayout.next(mainPanel);
                currentStep++;
                updateProgressBar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(unitLabel);
        inputPanel.add(unitField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(discountLabel);
        inputPanel.add(discountField);
        inputPanel.add(taxLabel);
        inputPanel.add(taxField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    // Step 3: Summary
    private JPanel createSummary() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea summaryArea = new JTextArea(8, 30);
        summaryArea.setEditable(false);
        JButton prevButton = new JButton("Previous");
        JButton finishButton = new JButton("Finish");

        prevButton.addActionListener(e -> {
            cardLayout.previous(mainPanel);
            currentStep--;
            updateProgressBar();
        });

        finishButton.addActionListener(e -> {
            double totalPrice = projectData.calculateFinalPrice();
            summaryArea.setText(
                    "Project Name: " + projectData.getProjectName() + "\n"
                    + "Project Description: " + projectData.getProjectDescription() + "\n\n"
                    + "Units: " + projectData.getUnits() + "\n"
                    + "Price per Unit: Rp" + projectData.getPricePerUnit() + "\n"
                    + "Discount: " + projectData.getDiscount() + "%\n"
                    + "Tax: " + projectData.getTax() + "%\n"
                    + "Final Price: Rp" + totalPrice
            );
            JOptionPane.showMessageDialog(this, "Data Anda telah disimpan!", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(finishButton);

        panel.add(new JScrollPane(summaryArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(multiStepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(multiStepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(multiStepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(multiStepForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(multiStepForm::new);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new multiStepForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class ProjectData {

    private String projectName;
    private String projectDescription;
    private int units;
    private double pricePerUnit;
    private double discount;
    private double tax;

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public void setProjectDescription(String desc) {
        this.projectDescription = desc;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setPricePerUnit(double price) {
        this.pricePerUnit = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double calculateFinalPrice() {
        double subtotal = units * pricePerUnit;
        double discountAmount = subtotal * (discount / 100);
        double taxAmount = (subtotal - discountAmount) * (tax / 100);
        return subtotal - discountAmount + taxAmount;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public int getUnits() {
        return units;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }
}
