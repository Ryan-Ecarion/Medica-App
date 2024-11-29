/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel_AP;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class AP_Home extends javax.swing.JPanel {
    Connection conn;
    DefaultTableModel tableModel;

    public AP_Home() {
        initComponents();
        
        
        Nama_Users.setIcon(new FlatSVGIcon("Resource_AP_Home/icon-halo.svg", 30, 30));
        txt1.setIcon(new FlatSVGIcon("Resource_AP_Home/icon-selesai.svg", 23, 23));
        txt2.setIcon(new FlatSVGIcon("Resource_AP_Home/icon-terjadwal.svg", 23, 23));
        txt3.setIcon(new FlatSVGIcon("Resource_AP_Home/icon-batal.svg", 23, 23));
        txt4.setIcon(new FlatSVGIcon("Resource_AP_Home/icon-daftar.svg", 30, 30));
        Mascot1.setIcon(new FlatSVGIcon("Resource_AP_Home/Gosok.svg", 100, 100));
        Mascot2.setIcon(new FlatSVGIcon("Resource_AP_Home/Halo.svg", 70, 70));
        
        
        connectToDatabase();
        updateJLabels();
        loadTableData("");
        
        
        // Timer untuk memanggil update data setiap 2 detik
        Timer timer = new Timer(2000, e -> {
        updateJLabels();  // Update data di labels
        loadTableData(""); // Refresh data tabel
    });
    timer.start();  // Mulai timer
        
        
    }

    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medica", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateJLabels() {
        try {
            // Tanggal Hari Ini
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Tanggal_Hari_Ini.setText("Tanggal: " + formatter.format(now));

            // Menghitung data
            Statement stmt = conn.createStatement();
            ResultSet rs;

            // Total Dokter
            rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM dokter");
            if (rs.next()) {
                Total_Dokter.setText("" + rs.getInt("total"));
            }

            // Pasien Bulan Ini
            rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM jadwal_perawatan WHERE MONTH(tanggal) = MONTH(CURDATE())");
            if (rs.next()) {
                Pasien_Bulan_Ini.setText("" + rs.getInt("total"));
            }

            // Pasien Hari Ini
            rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM jadwal_perawatan WHERE DATE(tanggal) = CURDATE()");
            if (rs.next()) {
                Pasien_Hari_Ini.setText(" " + rs.getInt("total"));
            }

            // Selesai
            rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM jadwal_perawatan WHERE status = 'selesai'");
            if (rs.next()) {
                Selesai.setText(String.valueOf(rs.getInt("total")));
            }

            // Terjadwal
            rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM jadwal_perawatan WHERE status = 'terjadwal'");
            if (rs.next()) {
                Terjadwal.setText(String.valueOf(rs.getInt("total")));
            }

            // Dibatalkan
            rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM jadwal_perawatan WHERE status = 'dibatalkan'");
            if (rs.next()) {
                Dibatalkan.setText(String.valueOf(rs.getInt("total")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
}

    private void loadTableData(String query) {
        String sql = "SELECT p.nama AS pasien, jp.tanggal " +
                     "FROM jadwal_perawatan jp " +
                     "JOIN pasien p ON jp.id_pasien = p.id_pasien " +
             
                     query;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            tableModel = new DefaultTableModel(new Object[]{"Nama", "Tanggal"}, 0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("pasien"),
                    rs.getDate("tanggal"),
                });
            }
            Jadwal_Perawatan.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + ex.getMessage());
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Costum.PanelRound();
        Nama_Users = new javax.swing.JLabel();
        Tanggal_Hari_Ini = new javax.swing.JLabel();
        Mascot2 = new javax.swing.JLabel();
        panelRound2 = new Costum.PanelRound();
        panelRound5 = new Costum.PanelRound();
        Selesai = new javax.swing.JLabel();
        panelRound6 = new Costum.PanelRound();
        Terjadwal = new javax.swing.JLabel();
        panelRound7 = new Costum.PanelRound();
        Dibatalkan = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        panelRound3 = new Costum.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jadwal_Perawatan = new javax.swing.JTable();
        txt4 = new javax.swing.JLabel();
        panelRound4 = new Costum.PanelRound();
        panelRound8 = new Costum.PanelRound();
        Pasien_Hari_Ini = new javax.swing.JLabel();
        panelRound9 = new Costum.PanelRound();
        Pasien_Bulan_Ini = new javax.swing.JLabel();
        panelRound10 = new Costum.PanelRound();
        Total_Dokter = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Mascot1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(17, 137, 163));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nama_Users.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        Nama_Users.setForeground(new java.awt.Color(255, 255, 255));
        Nama_Users.setText("Halo, Admin");
        panelRound1.add(Nama_Users, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 48));

        Tanggal_Hari_Ini.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Tanggal_Hari_Ini.setForeground(new java.awt.Color(220, 220, 220));
        panelRound1.add(Tanggal_Hari_Ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 96, 200, 28));

        Mascot2.setText("Mascot");
        Mascot2.setPreferredSize(new java.awt.Dimension(80, 80));
        panelRound1.add(Mascot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 80, 80));

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 300, 130));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setBackground(new java.awt.Color(0, 153, 153));
        panelRound5.setRoundBottomLeft(40);
        panelRound5.setRoundBottomRight(40);
        panelRound5.setRoundTopLeft(40);
        panelRound5.setRoundTopRight(40);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Selesai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Selesai.setForeground(new java.awt.Color(255, 255, 255));
        Selesai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound5.add(Selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 50, 40));

        panelRound2.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 80, 50));

        panelRound6.setBackground(new java.awt.Color(153, 153, 0));
        panelRound6.setRoundBottomLeft(40);
        panelRound6.setRoundBottomRight(40);
        panelRound6.setRoundTopLeft(40);
        panelRound6.setRoundTopRight(40);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Terjadwal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Terjadwal.setForeground(new java.awt.Color(255, 255, 255));
        Terjadwal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound6.add(Terjadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 5, 60, 40));

        panelRound2.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 80, 50));

        panelRound7.setBackground(new java.awt.Color(255, 102, 102));
        panelRound7.setRoundBottomLeft(40);
        panelRound7.setRoundBottomRight(40);
        panelRound7.setRoundTopLeft(40);
        panelRound7.setRoundTopRight(40);
        panelRound7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dibatalkan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Dibatalkan.setForeground(new java.awt.Color(255, 255, 255));
        Dibatalkan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound7.add(Dibatalkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 60, 40));

        panelRound2.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 80, 50));

        txt3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        txt3.setForeground(new java.awt.Color(0, 102, 102));
        txt3.setText("Dibatalkan");
        panelRound2.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 187, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Status Pasien");
        panelRound2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 150, -1));

        txt2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        txt2.setForeground(new java.awt.Color(0, 102, 102));
        txt2.setText("Terjadwal");
        panelRound2.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 123, 110, -1));

        txt1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        txt1.setForeground(new java.awt.Color(0, 102, 102));
        txt1.setText("Selesai");
        panelRound2.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 61, 90, -1));

        add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 300, 250));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        Jadwal_Perawatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                " Nama Pasien", "Tanggal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Jadwal_Perawatan);

        txt4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        txt4.setForeground(new java.awt.Color(0, 102, 102));
        txt4.setText("Jadwal Perawatan");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt4)
                .addGap(66, 66, 66))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 340, 400));

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setBackground(new java.awt.Color(0, 153, 153));
        panelRound8.setRoundBottomLeft(40);
        panelRound8.setRoundBottomRight(40);
        panelRound8.setRoundTopLeft(40);

        Pasien_Hari_Ini.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Pasien_Hari_Ini.setForeground(new java.awt.Color(255, 255, 255));
        Pasien_Hari_Ini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(Pasien_Hari_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pasien_Hari_Ini, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound4.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 40, -1, -1));

        panelRound9.setBackground(new java.awt.Color(0, 153, 153));
        panelRound9.setRoundBottomLeft(40);
        panelRound9.setRoundBottomRight(40);
        panelRound9.setRoundTopLeft(40);

        Pasien_Bulan_Ini.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Pasien_Bulan_Ini.setForeground(new java.awt.Color(255, 255, 255));
        Pasien_Bulan_Ini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(Pasien_Bulan_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pasien_Bulan_Ini, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound4.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 141, -1, -1));

        panelRound10.setBackground(new java.awt.Color(0, 102, 153));
        panelRound10.setRoundBottomLeft(40);
        panelRound10.setRoundBottomRight(40);
        panelRound10.setRoundTopLeft(40);

        Total_Dokter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Total_Dokter.setForeground(new java.awt.Color(255, 255, 255));
        Total_Dokter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Total_Dokter, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Total_Dokter, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound4.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 242, -1, -1));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Total dokter:");
        panelRound4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 140, -1));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Total pasien (hari ini):");
        panelRound4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, -1));

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Total pasien (bulan ini):");
        panelRound4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 140, -1));

        Mascot1.setText("Mascot");
        Mascot1.setPreferredSize(new java.awt.Dimension(100, 100));
        panelRound4.add(Mascot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 200, 400));

        jPanel1.setBackground(new java.awt.Color(239, 242, 251));
        jPanel1.setLayout(new java.awt.CardLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 490));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dibatalkan;
    private javax.swing.JTable Jadwal_Perawatan;
    private javax.swing.JLabel Mascot1;
    private javax.swing.JLabel Mascot2;
    private javax.swing.JLabel Nama_Users;
    private javax.swing.JLabel Pasien_Bulan_Ini;
    private javax.swing.JLabel Pasien_Hari_Ini;
    private javax.swing.JLabel Selesai;
    private javax.swing.JLabel Tanggal_Hari_Ini;
    private javax.swing.JLabel Terjadwal;
    private javax.swing.JLabel Total_Dokter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Costum.PanelRound panelRound1;
    private Costum.PanelRound panelRound10;
    private Costum.PanelRound panelRound2;
    private Costum.PanelRound panelRound3;
    private Costum.PanelRound panelRound4;
    private Costum.PanelRound panelRound5;
    private Costum.PanelRound panelRound6;
    private Costum.PanelRound panelRound7;
    private Costum.PanelRound panelRound8;
    private Costum.PanelRound panelRound9;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    // End of variables declaration//GEN-END:variables
}
