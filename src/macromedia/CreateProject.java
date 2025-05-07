package macromedia;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Box;
import javax.swing.JViewport;

public class CreateProject extends javax.swing.JFrame {

    private int editIndex = -1; // -1 indicates not in edit mode
    private CardLayout cardLayout;
    private JTextField projectNameField = new JTextField(15);
    private JTextField orderDateField = new JTextField(15);
    private JTextField singleDateField = new JTextField(15);
    private JTextField cityOfVanueField = new JTextField(15);
    private JTextField clientCompanyNameField = new JTextField(15);
    private JTextField contactPhoneField = new JTextField(15);
    private JTextField contactNameField = new JTextField(15);
    private JTextField projectManagerField = new JTextField(15);

    private int currentStep = 1;

    private JTextField namaItemField = new JTextField(15);
    private JTextField hargaPerUnitField = new JTextField(15);
    private JTextField deskripsiField = new JTextField(15);
    private JTextField qtyField = new JTextField(15);
    private JTextField frekField = new JTextField(15);
    private JTextField periodeField = new JTextField(15);
    private JTextField discountField = new JTextField(15);

    private JTextArea notesFromClientArea;
    private static final int MAX_CHARACTERS = 200;

    private JTextArea descriptionArea = new JTextArea(3, 20);

    private JTextArea summaryArea = new JTextArea(15, 50);

    private JButton nextButton;
    private JButton backButton;
    private JButton resetButton;

    private JPanel formContainer;
    private JScrollPane scrollPane;
    private int formCount = 0;

    public static List<String[]> projectList = new ArrayList<>();
    public static List<String[]> EditprojectList = new ArrayList<>();

    public static List<List<String>> orderDetailList = new ArrayList<>();
    public static List<String[]> viewProjectList = new ArrayList<>();

    public CreateProject() {
        setTitle("Multi-Step Form");
        setSize(1000, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createStep1(), "Step1");
        mainPanel.add(createStep2(), "Step2");
        mainPanel.add(createStep3(), "Step3");
        tambahOrderDetail();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = sdf.format(new Date());
        orderDateField.setText(todayDate);
        orderDateField.setEditable(false);

        JPanel buttonPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Reset di kiri
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Next & Back di kanan

        resetButton = new JButton("Reset");
        resetButton.setVisible(false);
        // leftPanel.add(resetButton);

        backButton = new JButton("Back");
        nextButton = new JButton("Next");
        rightPanel.add(backButton);
        rightPanel.add(nextButton);

        leftPanel.add(new JLabel(""));
        System.out.println("Step Saat ini: " + currentStep);

        if (currentStep == 2) {
            leftPanel.add(resetButton);
        }

        backButton.setEnabled(false);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validateInputs()) {
                    return;
                }
                if (currentStep == 2) {
                    if (!validateOrderDetails()) {
                        return;
                    }
                    generateSummary();
                }
                if (currentStep < 3) {
                    currentStep++;
                    nextButton.setText("Next");
                    System.out.println("Current Step: " + currentStep);
                    cardLayout.show(mainPanel, "Step" + currentStep);
                    updateButtonState();
                }
                if (currentStep == 3) {
                    saveProject();
                    nextButton.setText("Submit");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep > 1) {
                    currentStep--;
                    System.out.println("Current Step: " + currentStep);
                    cardLayout.show(mainPanel, "Step" + currentStep);
                    updateButtonState();
                }

                if (currentStep < 3) {
                    nextButton.setText("Next");
                }
            }
        });

        buttonPanel.add(leftPanel, BorderLayout.WEST);
        buttonPanel.add(rightPanel, BorderLayout.EAST);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        updateButtonState();

        setVisible(true);
    }

    private JPanel createStep1() {
        JPanel step1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel stepLabel1 = new JLabel("Step 1: Project Details", JLabel.LEFT);
        step1.add(stepLabel1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        step1.add(new JLabel("Project Name:"), gbc);

        gbc.gridy = 2;
        projectNameField.setColumns(50);
        projectNameField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        step1.add(projectNameField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        step1.add(new JLabel("Order Date:"), gbc);

        gbc.gridy = 2;
        orderDateField.setColumns(50);
        orderDateField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        orderDateField.setEditable(false);
        step1.add(orderDateField, gbc);

        // JLabel dateTypeLabel = new JLabel("Date Type:");
        // gbc.gridx = 0;
        // gbc.gridy = 3;
        // step1.add(dateTypeLabel, gbc);
        //
        //
        // JPanel radioPanel = new JPanel();
        // radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // singleDateRadio = new JRadioButton("Single Date");
        // multipleDateRadio = new JRadioButton("Multiple Dates");
        // dateGroup = new ButtonGroup();
        // dateGroup.add(singleDateRadio);
        // dateGroup.add(multipleDateRadio);
        //
        // radioPanel.add(singleDateRadio);
        // radioPanel.add(multipleDateRadio);
        // gbc.gridx = 0;
        // gbc.gridy = 4;
        // step1.add(radioPanel, gbc);
        JLabel eventDateLabel = new JLabel("Event Date:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        step1.add(eventDateLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        singleDateField.setColumns(50);
        singleDateField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        step1.add(singleDateField, gbc);

        // multipleDatePanel = new JPanel();
        // multipleDatePanel.setLayout(new BoxLayout(multipleDatePanel,
        // BoxLayout.Y_AXIS));
        // multipleDateFields = new ArrayList<>();
        //
        // addDateButton = new JButton("Add Another Date");
        // addDateButton.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // JTextField newDateField = new JTextField(20);
        // multipleDateFields.add(newDateField);
        // multipleDatePanel.add(newDateField);
        // multipleDatePanel.revalidate();
        // multipleDatePanel.repaint();
        // }
        // });
        //
        // gbc.gridy = 5;
        // step1.add(multipleDatePanel, gbc);
        //
        // gbc.gridy = 6;
        // step1.add(addDateButton, gbc);
        // addDateButton.setVisible(false);
        // singleDateRadio.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // singleDateField.setVisible(true);
        // multipleDatePanel.setVisible(false);
        // addDateButton.setVisible(false);
        // }
        // });
        //
        // multipleDateRadio.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // singleDateField.setVisible(false);
        // multipleDatePanel.setVisible(true);
        // addDateButton.setVisible(true);
        // }
        // });
        //
        // singleDateRadio.setSelected(true);
        // multipleDatePanel.setVisible(false);
        JLabel cityOfVanueLabel = new JLabel("City Of Vanue");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        step1.add(cityOfVanueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        cityOfVanueField.setColumns(50);
        cityOfVanueField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        step1.add(cityOfVanueField, gbc);

        JLabel clientCompanyName = new JLabel("Client Company Name");
        gbc.gridx = 1;
        gbc.gridy = 7;
        step1.add(clientCompanyName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        clientCompanyNameField.setColumns(50);
        clientCompanyNameField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        step1.add(clientCompanyNameField, gbc);

        JLabel contactPhone = new JLabel("Contact Phone");
        gbc.gridx = 0;
        gbc.gridy = 9;
        step1.add(contactPhone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        contactPhoneField.setColumns(50);
        contactPhoneField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        step1.add(contactPhoneField, gbc);

        JLabel contactName = new JLabel("Contact Name");
        gbc.gridx = 1;
        gbc.gridy = 9;
        step1.add(contactName, gbc);

        contactNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 10;
        contactNameField.setColumns(50);
        contactNameField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        step1.add(contactNameField, gbc);

        JLabel notesFromClientLabel = new JLabel("Notes From Client:");
        gbc.gridx = 0;
        gbc.gridy = 11;
        step1.add(notesFromClientLabel, gbc);

        notesFromClientArea = new JTextArea(5, 20);
        notesFromClientArea.setLineWrap(true);
        notesFromClientArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(notesFromClientArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        notesFromClientArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (notesFromClientArea.getText().length() >= MAX_CHARACTERS) {
                    evt.consume();
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        step1.add(scrollPane, gbc);

        JLabel responsibility = new JLabel("Responsibility");
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        step1.add(responsibility, gbc);

        JLabel projectManager = new JLabel("Project Manager");
        gbc.gridx = 0;
        gbc.gridy = 15;
        step1.add(responsibility, gbc);

        projectManagerField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 16;
        projectManagerField.setColumns(50);
        projectManagerField.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        step1.add(projectManagerField, gbc);

        return step1;
    }

    private JPanel createStep2() {
        JPanel step2 = new JPanel(new BorderLayout());

        formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(formContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(600, 300));
//
//        JLabel addLabel = new JLabel("<html><u>Tambah Order Detail</u></html>");
//        addLabel.setForeground(Color.BLUE);
//        addLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                tambahOrderDetail();
//            }
//        });

//        JButton resetButton = new JButton("Reset");
//        resetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                resetOrderDetails();
//            }
//        });
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> cardLayout.next(mainPanel));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        buttonPanel.add(addLabel);
//        buttonPanel.add(resetButton);

        step2.add(buttonPanel, BorderLayout.NORTH);
        step2.add(scrollPane, BorderLayout.CENTER);

        return step2;
    }

    private JPanel createStep3() {
        JPanel step3 = new JPanel(new BorderLayout());

        // summaryArea = new JTextArea(15, 50);
        summaryArea.setEditable(false);
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);

        JScrollPane summaryScrollPane = new JScrollPane(summaryArea);

        step3.add(new JLabel("Step 3: Summary"), BorderLayout.NORTH);
        step3.add(summaryScrollPane, BorderLayout.CENTER);

        return step3;
    }

    private void generateSummary() {
        // --- Mengambil data field utama proyek ---
        // Pengecekan inisialisasi field utama
        // Tambahkan pengecekan untuk semua field utama yang Anda gunakan
        if (projectNameField == null || orderDateField == null || singleDateField == null
                || cityOfVanueField == null || clientCompanyNameField == null || contactPhoneField == null
                || contactNameField == null || notesFromClientArea == null || summaryArea == null) {
            System.err.println("Error: Beberapa field utama belum diinisialisasi!");
            // Tampilkan pesan error ke pengguna
            JOptionPane.showMessageDialog(null, "Error: Form belum lengkap atau field belum diinisialisasi.", "Initialization Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mengambil data field utama dengan penanganan null
        String projectName = projectNameField.getText() != null ? projectNameField.getText() : "N/A";
        String orderDate = orderDateField.getText() != null ? orderDateField.getText() : "N/A"; // Diperbaiki
        String singleDate = singleDateField.getText() != null ? singleDateField.getText() : "N/A";
        String city = cityOfVanueField.getText() != null ? cityOfVanueField.getText() : "N/A";
        String clientCompanyName = clientCompanyNameField.getText() != null ? clientCompanyNameField.getText() : "N/A";
        String contactPhone = contactPhoneField.getText() != null ? contactPhoneField.getText() : "N/A";
        String contactName = contactNameField.getText() != null ? contactNameField.getText() : "N/A";
        String notesFromClient = notesFromClientArea.getText() != null ? notesFromClientArea.getText() : "N/A";

        StringBuilder summary = new StringBuilder();

        // --- Bagian Summary Proyek Utama (Rapi) ---
        summary.append("============= Ringkasan Proyek =============\n\n");
        summary.append("Nama Proyek          : ").append(projectName).append("\n");
        summary.append("Tanggal Order        : ").append(orderDate).append("\n");
        summary.append("Tanggal Single       : ").append(singleDate).append("\n");
        summary.append("Kota Venue           : ").append(city).append("\n\n");

        summary.append("Informasi Klien      :\n");
        summary.append("Perusahaan           : ").append(clientCompanyName).append("\n");
        summary.append("Nama Kontak          : ").append(contactName).append("\n");
        summary.append("Telepon Kontak       : ").append(contactPhone).append("\n\n");

        summary.append("Catatan dari Klien   :\n").append(notesFromClient).append("\n");
        summary.append("===========================================\n\n");

        // --- Bagian Detail Order (Menggunakan List<List<String>>) ---
        summary.append("============= Detail Order ============\n\n");

        // Mengakses List<List<String>> yang ada di kelas CreateProject
        List<List<String>> detailList = CreateProject.orderDetailList; // Ambil referensi listnya

        if (detailList == null || detailList.isEmpty()) {
            summary.append("(Tidak ada order detail yang ditambahkan)\n");
        } else {
            // Loop MELALUI LIST<LIST<STRING>>
            for (int i = 0; i < detailList.size(); i++) {
                List<String> detailData = detailList.get(i); // Ambil List<String> untuk detail ke-i

                // Pastikan inner list memiliki jumlah elemen yang diharapkan (minimal 7)
                final int EXPECTED_FIELD_COUNT = 7; // Sesuaikan jika jumlah field berbeda
                if (detailData != null && detailData.size() >= EXPECTED_FIELD_COUNT) {
                    // Ambil data dari List<String> menggunakan index
                    String namaItem = detailData.get(0) != null ? detailData.get(0) : "N/A";
                    String harga = detailData.get(1) != null ? detailData.get(1) : "N/A";
                    String description = detailData.get(2) != null ? detailData.get(2) : "N/A";
                    String qty = detailData.get(3) != null ? detailData.get(3) : "N/A";
                    String frek = detailData.get(4) != null ? detailData.get(4) : "N/A";
                    String periode = detailData.get(5) != null ? detailData.get(5) : "N/A";
                    String discount = detailData.get(6) != null ? detailData.get(6) : "N/A";

                    // Format data detail dengan label yang jelas
                    summary.append("--- Detail Ke-").append(i + 1).append(" ---\n");
                    summary.append("Nama Item      : ").append(namaItem).append("\n");
                    summary.append("Harga/Unit     : ").append(harga).append("\n");
                    summary.append("Quantity       : ").append(qty).append("\n");
                    summary.append("Frekuensi      : ").append(frek).append("\n");
                    summary.append("Periode        : ").append(periode).append("\n");
                    summary.append("Discount       : ").append(discount).append("\n");
                    summary.append("Deskripsi      :\n").append(description).append("\n"); // Deskripsi di baris baru
                    summary.append("---------------------------\n\n"); // Pemisah antar detail
                } else {
                    // Tangani kasus jika data mungkin tidak lengkap untuk entri ini
                    summary.append("--- Detail Ke-").append(i + 1).append(" (Data Tidak Lengkap/Format Salah) ---\n");
                    summary.append("Data Mentah: ").append(detailData).append("\n"); // Tampilkan data mentah untuk debugging
                    summary.append("---------------------------\n\n");
                    System.err.println("Warning: Data detail pada index " + i + " tidak lengkap atau formatnya salah.");
                }
            }
        }

        summary.append("============= Akhir Ringkasan =============");

        // --- Menampilkan Summary ---
        summaryArea.setText(summary.toString());

        // Optional: Mengatur kursor kembali ke awal teks area summary
        summaryArea.setCaretPosition(0);
    }

    private void tambahOrderDetail() {
        JPanel orderDetailPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        orderDetailPanel.add(new JLabel("Order Detail:"), gbc);

        gbc.gridy = 1;
        namaItemField.setToolTipText("Nama Item");
        orderDetailPanel.add(namaItemField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        orderDetailPanel.add(new JLabel("Harga per Unit:"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        hargaPerUnitField.setToolTipText("Harga Per Unit");
        orderDetailPanel.add(hargaPerUnitField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        orderDetailPanel.add(new JLabel("Description per Unit:"), gbc);

        // JTextArea descriptionArea = new JTextArea(3, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        descriptionArea.setToolTipText("Deskripsi");
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        gbc.gridy = 3;
        gbc.weighty = 0.1;
        orderDetailPanel.add(scrollPane, gbc);

        gbc.weighty = 0;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        orderDetailPanel.add(new JLabel("Qty"), gbc);

        gbc.gridy = 5;
        qtyField.setToolTipText("Qty");
        orderDetailPanel.add(qtyField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        orderDetailPanel.add(new JLabel("Frek"), gbc);

        gbc.gridy = 5;
        frekField.setToolTipText("Frek");
        orderDetailPanel.add(frekField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        orderDetailPanel.add(new JLabel("Periode"), gbc);

        gbc.gridy = 5;
        periodeField.setToolTipText("Periode");
        orderDetailPanel.add(periodeField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        orderDetailPanel.add(new JLabel("Discount"), gbc);

        gbc.gridy = 5;
        // JTextField discountField = new JTextField(15);
        discountField.setToolTipText("Discount");
        orderDetailPanel.add(discountField, gbc);

        formContainer.add(orderDetailPanel);
        formContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        formContainer.revalidate();
        formContainer.repaint();

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());

        formCount++;
    }

    private void resetOrderDetails() {
        formContainer.removeAll();
        formContainer.revalidate();
        formContainer.repaint();
        formCount = 0;
    }

    public void showGUI() {
        JFrame frame = new JFrame("Order Detail Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateButtonState() {
        backButton.setEnabled(currentStep > 1);
        resetButton.setVisible(currentStep == 2);
    }

    public void editProject(int index) {
        this.editIndex = index;
        if (index < 0 || index >= EditprojectList.size()) {
            System.err.println("Index project tidak valid");
            return;
        }

        // Ambil data utama
        String[] data = EditprojectList.get(index);

        // Isi ke field
        projectNameField.setText(data[0]);
        orderDateField.setText(data[1]);
        singleDateField.setText(data[2]);
        cityOfVanueField.setText(data[3]);
        clientCompanyNameField.setText(data[4]);
        contactPhoneField.setText(data[5]);
        contactNameField.setText(data[6]);
        notesFromClientArea.setText(data[7]);
        projectManagerField.setText(data[8]);

        // Set step langsung ke step 1
        currentStep = 1;
        cardLayout.show(mainPanel, "Step1");
        updateButtonState();

        // Hapus order detail form sebelumnya (jika ada)
        formContainer.removeAll();

        // Ambil order detail
        if (index < orderDetailList.size()) {
            List<String> detail = orderDetailList.get(index);

            // Order detail satuan panel
            int chunkSize = 7; // sesuai jumlah field per order
            for (int i = 0; i < detail.size(); i += chunkSize) {
                tambahOrderDetail(); // buat panel baru

                // Ambil field dalam panel terakhir
                JPanel panel = (JPanel) formContainer.getComponent(formContainer.getComponentCount() - 2);
                int fieldIndex = 0;

                for (Component c : panel.getComponents()) {
                    if (c instanceof JTextField textField) {
                        textField.setText(detail.get(i + fieldIndex));
                        fieldIndex++;
                    } else if (c instanceof JScrollPane scrollPane) {
                        Component view = ((JViewport) scrollPane.getComponent(0)).getView();
                        if (view instanceof JTextArea textArea) {
                            textArea.setText(detail.get(i + fieldIndex));
                            fieldIndex++;
                        }
                    }
                }
            }

            formContainer.revalidate();
            formContainer.repaint();
        }

        // Ubah tombol Next menjadi Submit langsung kalau ingin
        nextButton.setText("Next");
    }

    private void saveProject() {
        String[] projectData = {
            projectNameField.getText(),
            orderDateField.getText(),
            singleDateField.getText(),
            cityOfVanueField.getText(),
            clientCompanyNameField.getText(),
            contactPhoneField.getText(),
            contactNameField.getText(),
            notesFromClientArea.getText(),
            projectManagerField.getText()
        };

        List<String> orderDetailData = new ArrayList<>();
        for (Component comp : formContainer.getComponents()) {
            if (comp instanceof JPanel panel) {
                for (Component field : panel.getComponents()) {
                    if (field instanceof JTextField textField) {
                        orderDetailData.add(textField.getText());
                    } else if (field instanceof JScrollPane scrollPane) {
                        JTextArea textArea = (JTextArea) ((JViewport) scrollPane.getComponent(0)).getView();
                        orderDetailData.add(textArea.getText());
                    }
                }
            }
        }

        String[] viewProjectData = {
            projectNameField.getText(),
            orderDateField.getText(),
            singleDateField.getText(),
            cityOfVanueField.getText(),
            clientCompanyNameField.getText(),
            contactPhoneField.getText(),
            contactNameField.getText(),
            projectNameField.getText(),
            notesFromClientArea.getText(),
            namaItemField.getText(),
        };

        if (editIndex >= 0) {
            // replace existing data
            CreateProject.projectList.set(editIndex, projectData);
            CreateProject.EditprojectList.set(editIndex, projectData);
            CreateProject.orderDetailList.set(editIndex, orderDetailData);
        } else {
            // new entry
            CreateProject.projectList.add(projectData);
            CreateProject.EditprojectList.add(projectData);
            CreateProject.orderDetailList.add(orderDetailData);
            CreateProject.viewProjectList.add(viewProjectData);
        }

        JOptionPane.showMessageDialog(this, "Project berhasil disimpan!");
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dashboard.loadProjects();
        this.dispose();
    }

    private boolean validateInputs() {
        if (projectNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Project Name harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String orderDate = orderDateField.getText().trim();
        if (orderDate.isEmpty() || !isValidDate(orderDate)) {
            JOptionPane.showMessageDialog(this, "Order Date harus dalam format dd/MM/yyyy dan valid!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (clientCompanyNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Client Company harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String contactPhone = contactPhoneField.getText().trim();
        if (!contactPhone.matches("\\d{10,}")) { // Minimal 10 angka
            JOptionPane.showMessageDialog(this, "Contact Phone harus berupa angka dan minimal 10 digit!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (contactNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contact Name harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (projectManagerField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Project Manager harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String eventDate = singleDateField.getText().trim();
        if (eventDate.isEmpty() || !isValidDate(eventDate)) {
            JOptionPane.showMessageDialog(this, "Event Date harus dalam format dd/MM/yyyy dan valid!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; // Jika semua validasi lolos
    }
    
    
    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Pastikan hanya tanggal valid yang diterima

        try {
            sdf.parse(date); // parsing tanggal
            return true;
        } catch (ParseException e) {
            return false; // parsing gagal, format salah
        }
    }

    private boolean validateOrderDetails() {
        for (Component comp : formContainer.getComponents()) {
            if (comp instanceof JPanel panel) {
                JTextField namaItemField = null;
                JTextField hargaPerUnitField = null;
                JTextArea descriptionArea = null;
                JTextField qtyField = null;
                JTextField frekField = null;
                JTextField periodeField = null;
                JTextField discountField = null;

                for (Component field : panel.getComponents()) {
                    if (field instanceof JTextField textField) {
                        String placeholder = textField.getToolTipText(); // Pastikan no `null`
                        if (placeholder != null) {
                            switch (placeholder) {
                                case "Nama Item":
                                    namaItemField = textField;
                                    break;
                                case "Harga Per Unit":
                                    hargaPerUnitField = textField;
                                    break;
                                case "Qty":
                                    qtyField = textField;
                                    break;
                                case "Frek":
                                    frekField = textField;
                                    break;
                                case "Periode":
                                    periodeField = textField;
                                    break;
                                case "Discount":
                                    discountField = textField;
                                    break;
                            }
                        }
                    } else if (field instanceof JScrollPane scrollPane) {
                        Component view = ((JViewport) scrollPane.getComponent(0)).getView();
                        if (view instanceof JTextArea) {
                            descriptionArea = (JTextArea) view;
                        }
                    }
                }

                if (namaItemField == null || namaItemField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nama Item harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                if (hargaPerUnitField == null || hargaPerUnitField.getText().trim().isEmpty()
                        || !hargaPerUnitField.getText().matches("\\d+")
                        || Integer.parseInt(hargaPerUnitField.getText()) <= 0) {
                    JOptionPane.showMessageDialog(this, "Harga per Unit harus angka lebih dari 0!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                if (descriptionArea == null || descriptionArea.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Deskripsi harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                if (qtyField == null || qtyField.getText().trim().isEmpty()
                        || !qtyField.getText().matches("\\d+")
                        || (qtyField.getText().trim().length() > 0
                        && Integer.parseInt(qtyField.getText().trim()) <= 0)) {
                    JOptionPane.showMessageDialog(this, "Qty harus angka lebih dari 0!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                if (frekField == null || frekField.getText().trim().isEmpty()
                        || !frekField.getText().matches("\\d+")
                        || (frekField.getText().trim().length() > 0
                        && Integer.parseInt(frekField.getText().trim()) <= 0)) {
                    JOptionPane.showMessageDialog(this, "Frekuensi harus angka lebih dari 0!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                if (periodeField == null || periodeField.getText().trim().isEmpty()
                        || !periodeField.getText().matches("\\d+")
                        || (periodeField.getText().trim().length() > 0
                        && Integer.parseInt(periodeField.getText().trim()) <= 0)) {
                    JOptionPane.showMessageDialog(this, "Periode harus angka lebih dari 0!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                if (discountField != null && !discountField.getText().trim().isEmpty()
                        && !discountField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Discount harus berupa angka jika diisi!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        stepOne = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProjectName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        stepTwo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtProjectName1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        stepThree = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtProjectName2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        stepOne.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Nama Proyek");
        stepOne.add(jLabel1, "card2");

        txtProjectName.setToolTipText("");
        txtProjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectNameActionPerformed(evt);
            }
        });
        stepOne.add(txtProjectName, "card3");

        jLabel2.setText("Deskripsi Proyek");
        stepOne.add(jLabel2, "card4");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        stepOne.add(jScrollPane1, "card5");

        mainPanel.add(stepOne, "card2");

        stepTwo.setLayout(new java.awt.CardLayout());

        jLabel3.setText("Nama Proyek");
        stepTwo.add(jLabel3, "card2");

        txtProjectName1.setToolTipText("");
        txtProjectName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectName1ActionPerformed(evt);
            }
        });
        stepTwo.add(txtProjectName1, "card3");

        jLabel4.setText("Deskripsi Proyek");
        stepTwo.add(jLabel4, "card4");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        stepTwo.add(jScrollPane2, "card5");

        mainPanel.add(stepTwo, "card3");

        stepThree.setLayout(new java.awt.CardLayout());

        jLabel5.setText("Nama Proyek");
        stepThree.add(jLabel5, "card2");

        txtProjectName2.setToolTipText("");
        txtProjectName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjectName2ActionPerformed(evt);
            }
        });
        stepThree.add(txtProjectName2, "card3");

        jLabel6.setText("Deskripsi Proyek");
        stepThree.add(jLabel6, "card4");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        stepThree.add(jScrollPane3, "card5");

        mainPanel.add(stepThree, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(107, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProjectNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtProjectNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtProjectNameActionPerformed

    private void txtProjectName1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtProjectName1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtProjectName1ActionPerformed

    private void txtProjectName2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtProjectName2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtProjectName2ActionPerformed

    public static void main(String args[]) {

        SwingUtilities.invokeLater(() -> new CreateProject().setVisible(true));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel stepOne;
    private javax.swing.JPanel stepThree;
    private javax.swing.JPanel stepTwo;
    private javax.swing.JTextField txtProjectName;
    private javax.swing.JTextField txtProjectName1;
    private javax.swing.JTextField txtProjectName2;
    // End of variables declaration//GEN-END:variables
}
