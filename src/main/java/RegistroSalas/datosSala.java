/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package RegistroSalas;

/**
 *
 * @author Jeloska Chavez
 */
public class datosSala extends javax.swing.JPanel {
    private String id;

    /**
     * Creates new form datosSala
     */
    public datosSala(String id) {
        this.id = id;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreSala = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        capacidadSala = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        idSala = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(218, 228, 232));

        jPanel1.setBackground(new java.awt.Color(218, 228, 232));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sala", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 0, 104))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 104));
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 41, -1, -1));

        nombreSala.setBackground(new java.awt.Color(218, 228, 232));
        nombreSala.setBorder(null);
        nombreSala.setCaretColor(new java.awt.Color(0, 0, 104));
        jPanel1.add(nombreSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 27, 292, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 104));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 67, 292, 16));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 104));
        jLabel2.setText("Capacidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 93, -1, -1));

        capacidadSala.setBackground(new java.awt.Color(218, 228, 232));
        capacidadSala.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        capacidadSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        capacidadSala.setBorder(null);
        capacidadSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capacidadSalaActionPerformed(evt);
            }
        });
        jPanel1.add(capacidadSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 87, 96, 32));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 104));
        jLabel38.setText("ID:");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 93, -1, -1));

        idSala.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idSala.setForeground(new java.awt.Color(0, 0, 104));
        idSala.setText("ID");
        idSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idSalaMouseClicked(evt);
            }
        });
        jPanel1.add(idSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 91, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void idSalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idSalaMouseClicked

        idSala.setText(id);
    }//GEN-LAST:event_idSalaMouseClicked

    private void capacidadSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capacidadSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capacidadSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> capacidadSala;
    private javax.swing.JRadioButton idSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nombreSala;
    // End of variables declaration//GEN-END:variables
}
