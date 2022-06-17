/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelMuseo;

import MainWindow.MainWindow;
import estruc.museo.LSMuseo;
import estruc.museo.Museo;
import estruc.museo.NodoM;

/**
 *
 * @author Jeloska Chavez
 */
public class PanelMuseo extends javax.swing.JPanel {
    

    /**
     * Creates new form panelMuseo
     */
    private MainWindow mainWindow;
    private LSMuseo museos;
    public PanelMuseo() {
        initComponents();
    }
    public PanelMuseo(MainWindow mainWindow){
        initComponents();
        this.mainWindow = mainWindow;
        museos = mainWindow.getListaMuseos();
        datosATabla();
    }
    
    public void datosATabla(){
        tabla.clearTable();
        
        NodoM q = museos.getP();
        while(q != null){
            Museo museo = (Museo)q.getMuseo();
            MuseoAFila(museo);
            q = q.getSig();
        }
    }//nombre, tipo, direccion, circuito
    private void MuseoAFila(Museo x){
        Object[] arr = new Object[]{x.getId(),x.getNombre(), x.getTipo(), x.getDireccion(), x.getCircuito(), x.getListaSalas().nroNodos()};
        tabla.addRow(arr);
        
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
        tabla = new componentes.CustomTable();
        jLabel1 = new javax.swing.JLabel();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Direccion", "Circuito", "Nro. Salas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setText("Panel Museo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.CustomTable tabla;
    // End of variables declaration//GEN-END:variables
}
