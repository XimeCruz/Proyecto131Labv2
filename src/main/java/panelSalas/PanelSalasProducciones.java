/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelSalas;

import MainWindow.MainWindow;
import estruc.museo.LSMuseo;
import estruc.museo.Museo;
import estruc.museo.NodoM;
import estruc.persona.NodoV;
import estruc.produccion.NodoP;
import estruc.sala.NodoS;
import estruc.sala.Sala;

/**
 *
 * @author jeloskaisabel
 */
public class PanelSalasProducciones extends javax.swing.JPanel {

    /**
     * Creates new form PanelSalasProducciones
     */
    private MainWindow mainWindow;
    private LSMuseo museos;

    public PanelSalasProducciones() {
        initComponents();
    }

    public PanelSalasProducciones(MainWindow mainWindow) {
        initComponents();
        this.mainWindow = mainWindow;
        museos = mainWindow.getListaMuseos();
        
        datosATabla("Producciones");
        
    }

    public int buscarMayorProducciones() {
        int may = 0;
        NodoM q = museos.getP();
        while (q != null) {
            Museo museo = (Museo) q.getMuseo();
            NodoS r = museo.getListaSalas().getP();
            while (r != null) {
                Sala sx = (Sala) r.getSala();
                if (sx.getListaProducciones().nroNodos() >= may) {
                    may = sx.getListaProducciones().nroNodos();
                }
                r = r.getSig();
            }
            q = q.getSig();

        }
        return may;
    }

    public int contarVisitantes(Sala sx) {
        NodoP r = sx.getListaProducciones().getP();
        int c = 0;
        while (r != null) {
            c += r.getProduccion().getListaVisitantes().nroNodos();
            r = r.getSig();
        }
        return c;
    }

    public int contarArtistas(Sala sx) {
        NodoP r = sx.getListaProducciones().getP();
        int c = 0;
        while (r != null) {
            c += r.getProduccion().getListaArtistas().nroNodos();
            r = r.getSig();
        }
        return c;

    }

    public int buscarMayorVisitantes() {
        int may = 0;
        NodoM q = museos.getP();
        while (q != null) {
            Museo museo = (Museo) q.getMuseo();
            NodoS r = museo.getListaSalas().getP();
            while (r != null) {
                Sala sx = (Sala) r.getSala();
                int nv = contarVisitantes(sx);
                if (nv >= may) {
                    may = nv;
                }
                r = r.getSig();
            }
            q = q.getSig();

        }
        return may;
    }

    public int buscarMayorArtistas() {
        int may = 0;
        NodoM q = museos.getP();
        while (q != null) {
            Museo museo = (Museo) q.getMuseo();
            NodoS r = museo.getListaSalas().getP();
            while (r != null) {
                Sala sx = (Sala) r.getSala();
                int nv = contarArtistas(sx);
                if (nv >= may) {
                    may = nv;
                }
                r = r.getSig();
            }
            q = q.getSig();

        }
        return may;
    }

    public void datosATabla(String criterio) {
        tabla.clearTable();
        int may = 0;
        if (criterio.equals("Producciones")) {
            may = buscarMayorProducciones();
        } else if (criterio.equals("Visitantes")) {
            may = buscarMayorVisitantes();
        } else if (criterio.equals("Artistas")) {
            may = buscarMayorArtistas();
        }
        NodoM q = museos.getP();
        
        while (q != null) {
            Museo museo = (Museo) q.getMuseo();
            NodoS r = museo.getListaSalas().getP();
            while (r != null) {
                Sala sx = (Sala) r.getSala();
                int np = sx.getListaProducciones().nroNodos();
                int nv = contarVisitantes(sx);
                int na = contarArtistas(sx);
                boolean sw = false;
                if (criterio.equals("Producciones")) {
                    if(np == may)
                        sw = true;
                } else if (criterio.equals("Visitantes")) {
                    if(nv == may)
                        sw = true;
                } else if (criterio.equals("Artistas")) {
                    if(na == may)
                        sw = true;
                }
                if (sw) {
                    SalaAFila(sx, museo.getId(), np, na, nv);
                    
                }
                r = r.getSig();
            }
            q = q.getSig();

        }
    }

    /*private String nombre, idSala;
    private int capacidad;
    private LDNormal listaProducciones;*/
    private void SalaAFila(Sala x, String idMuseo, int np, int na, int nv) {
        Object[] arr = new Object[]{x.getNombre(), x.getIdSala(), x.getCapacidad(), idMuseo, np,na,nv};
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

        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboBoxCriterio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new componentes.CustomTable();

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 104));
        jLabel17.setText("Salas");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 104));
        jLabel16.setText("Salas con mayor:");

        comboBoxCriterio.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxCriterio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producciones", "Artistas", "Visitantes" }));
        comboBoxCriterio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxCriterioItemStateChanged(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "ID Sala", "Capacidad", "ID", "Nro. Producciones", "Nro. Artistas", "Nro. Visitantes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(174, 174, 174)
                        .addComponent(jLabel16)
                        .addGap(40, 40, 40)
                        .addComponent(comboBoxCriterio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxCriterioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCriterioItemStateChanged
        // TODO add your handling code here:
        datosATabla(comboBoxCriterio.getSelectedItem().toString());

    }//GEN-LAST:event_comboBoxCriterioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxCriterio;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.CustomTable tabla;
    // End of variables declaration//GEN-END:variables
}
