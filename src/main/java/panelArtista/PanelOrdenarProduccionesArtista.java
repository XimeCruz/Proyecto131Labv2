/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelArtista;

import MainWindow.MainWindow;
import estruc.Pilas.Pila;
import estruc.museo.LSMuseo;
import estruc.museo.Museo;
import estruc.museo.NodoM;
import estruc.persona.Artista;
import estruc.persona.LSArtista;
import estruc.persona.NodoA;
import estruc.persona.NodoV;
import estruc.produccion.LSProduccion;
import estruc.produccion.NodoP;
import estruc.sala.NodoS;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jeloska Chavez
 */
public class PanelOrdenarProduccionesArtista extends javax.swing.JPanel {

    /**
     * Creates new form PanelOrdenarProduccionesArtista
     */
    private Pila pilaArtistas, pilaProducciones, pilaValorProducciones;
    private LSMuseo listaMuseos;
    private MainWindow mainWindow;

    public PanelOrdenarProduccionesArtista(MainWindow mainWindow) {
        initComponents();
        this.mainWindow = mainWindow;
        pilaArtistas = new Pila(200);
        pilaProducciones = new Pila(200);
        pilaValorProducciones = new Pila(200);
        listaMuseos = mainWindow.getListaMuseos();
        NodoM r = listaMuseos.getP();
        //System.out.println("Nombre P"+r.getMuseo().getNombre());
        while (r != null) {
            NodoS w = r.getMuseo().getListaSalas().getP();
            System.out.println("Museo: " + r.getMuseo().getNombre());
            while (w != null) {
                NodoP z = w.getSala().getListaProducciones().getP();
                System.out.println("Sala: " + w.getSala().getNombre());
                while (z != null) {
                    NodoA s = z.getProduccion().getListaArtistas().getP();
                    System.out.println("Produccion: " + z.getProduccion().getNombre());
                    while (s != null) {
                        pilaArtistas.adicionar(s.getDato());
                        System.out.println(s.getDato().getNombre());
                        s = s.getSig();
                    }
                    z = z.getSig();

                }
                w = w.getSig();

            }
            r = r.getSig();
        }
        llenarPilaProducciones();
        System.out.println("antes de ordnena");
        Pila aux = new Pila(500);

        while (!pilaArtistas.esVacia()) {
            Artista px = (Artista) pilaArtistas.eliminar();
            aux.adicionar(px);
            System.out.println("\t" + px.getNombre());
        }
        pilaArtistas.vaciar(aux);

        pilaProducciones.mostrar();
        pilaValorProducciones.mostrar();

        ordenarArtistas("Nro. Producciones");
        //System.out.println("Producciones");

        datosATabla();

    }

    public boolean buscarArtista(LSArtista la, int ci) {
        NodoA r = la.getP();
        while (r != null) {
            if (r.getDato().getCi() == ci) {
                return true;
            }
            r = r.getSig();
        }
        return false;
    }

    public int contarProducciones(LSProduccion lp, int ci) {
        int c = 0;
        NodoP r = lp.getP();
        while (r != null) {
            if (buscarArtista(r.getProduccion().getListaArtistas(), ci)) {
                c++;
            }
            r = r.getSig();
        }
        return c;
    }

    public int contarProducciones(LSMuseo lm, int ci) {
        int c = 0;
        NodoM r = lm.getP();
        while (r != null) {
            NodoS w = r.getMuseo().getListaSalas().getP();
            while (w != null) {
                c += contarProducciones(w.getSala().getListaProducciones(), ci);
                w = w.getSig();
            }
            r = r.getSig();
        }
        return c;
    }

    //valor 
    public double contarValorProducciones(LSProduccion lp, int ci) {
        double t = 0;
        NodoP r = lp.getP();
        while (r != null) {
            if (buscarArtista(r.getProduccion().getListaArtistas(), ci)) {
                t += r.getProduccion().getListaVisitantes().nroNodos() * r.getProduccion().getPrecio();
            }
            r = r.getSig();
        }
        return t;
    }

    public double calcularValorProducciones(LSMuseo lm, int ci) {
        double t = 0;
        NodoM r = lm.getP();
        while (r != null) {
            NodoS w = r.getMuseo().getListaSalas().getP();
            while (w != null) {
                t += contarValorProducciones(w.getSala().getListaProducciones(), ci);
                w = w.getSig();
            }
            r = r.getSig();
        }
        return t;
    }

    public void llenarPilaProducciones() {
        Pila aux = new Pila(pilaArtistas.nElem());
        while (!pilaArtistas.esVacia()) {
            Artista ax = (Artista) pilaArtistas.eliminar();
            aux.adicionar(ax);
            int nProd = contarProducciones(listaMuseos, ax.getCi());
            double valProd = calcularValorProducciones(listaMuseos, ax.getCi());

            pilaProducciones.adicionar(nProd);
            pilaValorProducciones.adicionar(valProd);
        }

        pilaArtistas.vaciar(aux);

    }

    public void ordenarArtistas(String criterio) {
        Pila auxProd1 = new Pila(pilaProducciones.nElem());
        Pila auxProd2 = new Pila(pilaProducciones.nElem());
        Pila auxArt1 = new Pila(pilaArtistas.nElem());
        Pila auxArt2 = new Pila(pilaArtistas.nElem());
        Pila auxValProd1 = new Pila(pilaValorProducciones.nElem());
        Pila auxValProd2 = new Pila(pilaValorProducciones.nElem());
        while (!pilaArtistas.esVacia()) {
            int mayProd = -1;
            double mayValProd = -1;
            boolean sw = true;
            while (!pilaArtistas.esVacia()) {
                double tx = (double) pilaValorProducciones.eliminar();
                int nx = (int) pilaProducciones.eliminar();
                Artista ax = (Artista) pilaArtistas.eliminar();
                if (criterio.equals("Nro. Producciones")) {
                    if (mayProd < nx) {
                        mayProd = nx;
                        
                        /*if (mayProd != nx) {
                            int np =(int) auxProd2.eliminar();
                            Artista artista = (Artista) auxArt2.eliminar();
                            double valor = (double ) auxValProd2.eliminar();
                            auxArt1.adicionar(artista);
                            auxProd1.adicionar(np);
                            auxValProd1.adicionar(valor);
                            while (mayProd != np) {
                                int np 
                                auxArt1.adicionar(auxArt2.eliminar());
                                auxProd1.adicionar(auxProd2.eliminar());
                                auxValProd1.adicionar(auxValProd2.eliminar());
                            }
                        }*/
                        if (!auxArt2.esVacia()&&!sw) {
                            auxArt1.adicionar(auxArt2.eliminar());
                            auxProd1.adicionar(auxProd2.eliminar());
                            auxValProd1.adicionar(auxValProd2.eliminar());
                        }

                        auxArt2.adicionar(ax);
                        auxProd2.adicionar(nx);
                        auxValProd2.adicionar(tx);
                        sw = false;

                    } else {
                        auxArt1.adicionar(ax);
                        auxProd1.adicionar(nx);
                        auxValProd1.adicionar(tx);
                    }
                } else {
                    if (mayValProd < tx) {
                        mayValProd = tx;
                        /*if (mayValProd != tx) {
                            while (mayValProd != nx) {

                                auxArt1.adicionar(auxArt2.eliminar());
                                auxProd1.adicionar(auxProd2.eliminar());
                                auxValProd1.adicionar(auxValProd2.eliminar());
                            }
                        }*/
                        if (!auxArt2.esVacia() && !sw) {
                            auxArt1.adicionar(auxArt2.eliminar());
                            auxProd1.adicionar(auxProd2.eliminar());
                            auxValProd1.adicionar(auxValProd2.eliminar());
                        }
                        auxArt2.adicionar(ax);
                        auxProd2.adicionar(nx);
                        auxValProd2.adicionar(tx);
                        sw = false;

                    } else {
                        auxArt1.adicionar(ax);
                        auxProd1.adicionar(nx);
                        auxValProd1.adicionar(tx);
                    }
                }
                System.out.println("rec");
                //auxValProd2.mostrar();
                auxProd2.mostrar();

            }
            pilaArtistas.vaciar(auxArt1);
            pilaProducciones.vaciar(auxProd1);
            pilaValorProducciones.vaciar(auxValProd1);

        }
        pilaArtistas.vaciar(auxArt2);
        System.out.println("Ordenado por: " + criterio);
        Pila aux = new Pila(500);

        while (!pilaArtistas.esVacia()) {
            Artista px = (Artista) pilaArtistas.eliminar();
            aux.adicionar(px);
            System.out.println("\t" + px.getNombre());
        }
        pilaArtistas.vaciar(aux);

        pilaProducciones.vaciar(auxProd2);
        pilaValorProducciones.vaciar(auxValProd2);
        pilaProducciones.mostrar();
        pilaValorProducciones.mostrar();

    }

    public void datosATabla() {
        tabla.clearTable();
        Pila auxProd = new Pila(pilaProducciones.nElem());
        Pila auxArt = new Pila(pilaArtistas.nElem());
        Pila auxValProd = new Pila(pilaValorProducciones.nElem());
        while (!pilaArtistas.esVacia()) {
            Artista artista = (Artista) pilaArtistas.eliminar();
            int nProd = (int) pilaProducciones.eliminar();
            double vProd = (double) pilaValorProducciones.eliminar();
            auxProd.adicionar(nProd);
            auxArt.adicionar(artista);
            auxValProd.adicionar(vProd);
            ArtistaAFila(artista, nProd, vProd);
        }
        pilaArtistas.vaciar(auxArt);
        pilaProducciones.vaciar(auxProd);
        pilaValorProducciones.vaciar(auxValProd);
    }//nombre, tipo, direccion, circuito

    private void ArtistaAFila(Artista x, int nProd, double vProd) {
        Object[] arr = new Object[]{x.getCi(), x.getNombre(), x.getApellido(), x.getGenero(), nProd, vProd};
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
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboBoxOrdenar = new javax.swing.JComboBox<>();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CI", "Nombre", "Apellidos", "Género", "Nro. Producciones", "Ganancia neta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 104));
        jLabel17.setText("Artistas");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 104));
        jLabel16.setText("Buscar:");

        comboBoxOrdenar.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nro. Producciones", "Ganancia neta" }));
        comboBoxOrdenar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxOrdenarItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(comboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(comboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxOrdenarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxOrdenarItemStateChanged
        // TODO add your handling code here:
        ordenarArtistas(comboBoxOrdenar.getSelectedItem().toString());
        datosATabla();
    }//GEN-LAST:event_comboBoxOrdenarItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxOrdenar;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.CustomTable tabla;
    // End of variables declaration//GEN-END:variables
}
