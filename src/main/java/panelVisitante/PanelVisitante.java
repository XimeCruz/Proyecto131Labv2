package panelVisitante;

import MainWindow.MainWindow;
import estruc.museo.LSMuseo;
import estruc.museo.Museo;
import estruc.museo.NodoM;
import estruc.persona.LSVisitante;
import estruc.persona.NodoV;
import estruc.persona.Visitante;
import estruc.sala.LSSala;
import estruc.sala.Sala;
import estruc.produccion.LSProduccion;
import estruc.produccion.NodoP;
import estruc.sala.NodoS;
import estruc.produccion.Produccion;

/**
 *
 * @author Jeloska Chavez
 */
public class PanelVisitante extends javax.swing.JPanel {

    /**
     * Creates new form PanelVisitante
     */
    private MainWindow mainWindow;
    private LSMuseo museos;
    private int total;
    private int mujeres;
    private int hombres;

    public PanelVisitante() {
        initComponents();
    }

    public PanelVisitante(MainWindow mainWindow) {
        initComponents();
        this.mainWindow = mainWindow;
        museos = mainWindow.getListaMuseos();
        datosATabla();
        
        
    }

    public void datosATabla() {
        hombres = 0;
        mujeres = 0;
        total = 0;
        tabla.clearTable();
        NodoM r = museos.getP();
        while (r != null) {
            Museo mx = (Museo) r.getMuseo();
            String idMx = "(" + mx.getId() + ") " + mx.getNombre();

            LSSala lsx = mx.getListaSalas();
            NodoS w = lsx.getP();
            while (w != null) {
                Sala sx = w.getSala();

                LSProduccion lpx = sx.getListaProducciones();
                NodoP z = lpx.getP();
                while (z != null) {
                    Produccion px = z.getProduccion();
                    LSVisitante pvx = px.getListaVisitantes();

                    NodoV vaux = pvx.getP();
                    while (vaux != null) {
                        Visitante vx = vaux.getDato();
                        if (vx.getGenero().equals("F")) {
                            mujeres++;
                        } else {
                            hombres++;
                        }
                        visitanteAFila(vx, idMx, "" + sx.getIdSala(), px.getNombre());
                        vaux = vaux.getSig();
                        total++;
                    }
                    z = z.getSig();

                }

                w = w.getSig();
            }

            r = r.getSig();
        }
        totalPart.setText(String.format("%d", total));
        visitantesHombres.setText(String.format("%d", hombres));
        visitantesMujeres.setText(String.format("%d", mujeres));
        
    }

    //ci, edad, nombre, paterno, materno, genero    
    private void visitanteAFila(Visitante x, String idMuseo, String idSala, String nomProd) {
        Object[] arr = new Object[]{x.getNombre(), x.getApellido(), x.getCi(), x.getGenero(), x.getIdTicket(), idMuseo, idSala, nomProd};
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
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        totalPart = new javax.swing.JLabel();
        visitantesHombres = new javax.swing.JLabel();
        visitantesMujeres = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "CI", "Genero", "ID Ticket", "IDMuseo", "IDSala", "Produccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 104));
        jLabel16.setText("Visitantes");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 104));
        jLabel17.setText("Registrados");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 104));
        jLabel18.setText("Visitantes");

        totalPart.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        totalPart.setForeground(new java.awt.Color(0, 0, 0));
        totalPart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalPart.setText("asdf");

        visitantesHombres.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        visitantesHombres.setForeground(new java.awt.Color(0, 51, 204));
        visitantesHombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visitantesHombres.setText("H");

        visitantesMujeres.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        visitantesMujeres.setForeground(new java.awt.Color(255, 102, 255));
        visitantesMujeres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visitantesMujeres.setText("M");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 153));
        jLabel19.setText("Mujeres");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 104));
        jLabel20.setText("Hombres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPart)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(visitantesMujeres, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(visitantesHombres, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(totalPart, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visitantesHombres, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(visitantesMujeres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.CustomTable tabla;
    private javax.swing.JLabel totalPart;
    private javax.swing.JLabel visitantesHombres;
    private javax.swing.JLabel visitantesMujeres;
    // End of variables declaration//GEN-END:variables
}
