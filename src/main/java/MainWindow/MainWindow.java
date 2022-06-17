/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MainWindow;

import RegistroSalas.RegistroSalas;
import estruc.museo.LSMuseo;
import estruc.museo.Museo;
import estruc.museo.NodoM;
import estruc.persona.Artista;
import estruc.persona.LSArtista;
import estruc.persona.LSVisitante;
import estruc.persona.Visitante;
import estruc.produccion.LSProduccion;
import estruc.produccion.NodoP;
import estruc.produccion.Produccion;
import estruc.sala.LSSala;
import estruc.sala.NodoS;
import estruc.sala.Sala;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import panelArtista.PanelArtista;
import panelMuseo.BuscarMuseoPanel;

import panelMuseo.PanelMuseo;
import panelProduccion.PanelProduccion;
import panelSalas.PanelSalas;
import panelSalas.PanelSalasProducciones;
import panelVisitante.PanelVisitante;
import persistencia.ArchReg;

public final class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     *
     */
    private int mouseX, mouseY;
    private PanelMuseo panel2;
    private PanelArtista panel3;
    private PanelVisitante panel5;
    private PanelProduccion panel4;
    private BuscarMuseoPanel buscarPanelMuseo;
    private PanelSalas panelSalas;
    private PanelSalasProducciones panelSalasProducciones;
 
    //listas
    private LSMuseo listaMuseos = new LSMuseo();
    //private LSArtista listaArtistas;
    //private LSProduccion listaProducciones;
    private String id;

    // archivo de persistencia
    private ArchReg arch = new ArchReg("dataReal.txt");
    public MainWindow() throws IOException {
        initComponents();
        //arch.crear();
        arch.listarEstructuras();
        cargarEstructurasArchivo();
        //cargarEstructuras();
        //guardarEstructurasArchivo();
        cargarPaneles();

        
        //agregarMuseosComboBox();
        //arch.crear();

    }

    public LSMuseo getListaMuseos() {
        return listaMuseos;
    }

    public void setListaMuseos(LSMuseo listaMuseos) {
        this.listaMuseos = listaMuseos;
    }

    public PanelSalas getPanelSalas() {
        return panelSalas;
    }

    public void setPanelSalas(PanelSalas panelSalas) {
        this.panelSalas = panelSalas;
    }
    
    public PanelMuseo getPanel2() {
        return panel2;
    }

    public void setPanel2(PanelMuseo panel2) {
        this.panel2 = panel2;
    }

    public void cargarEstructuras() {
        
        Visitante vi1= new Visitante(6789878, "Ximena", "Cruz", "F", 1);
        Visitante vi2= new Visitante(2458484, "Ivan", "Suarez", "M", 2);
        Visitante vi3= new Visitante(5894612, "Ivon", "Pinto", "F", 3);
        Visitante vi4= new Visitante(1547896, "Joel", "Fernandez", "M", 4);
        Visitante vi5= new Visitante(1236454, "Diana", "Colque", "F", 5);
        Visitante vi6= new Visitante(8456123, "Sara", "Burgoa", "F", 6);
        Visitante vi7= new Visitante(8945613, "Libardo", "Valencia", "M", 7);
        Visitante vi8= new Visitante(7845963, "Alan", "Altamirano", "M", 8);
        
        LSVisitante lSVisitante = new LSVisitante();
        lSVisitante.adiFinal(vi1);
        lSVisitante.adiFinal(vi2);
        lSVisitante.adiFinal(vi3);
        lSVisitante.adiFinal(vi4);
        lSVisitante.adiFinal(vi5);
        lSVisitante.adiFinal(vi6);
        lSVisitante.adiFinal(vi7);
        lSVisitante.adiFinal(vi8);
        
        Artista a1 = new Artista(6789878, "Julian", "Montenegro", "M", "Pintor");
        Artista a2 = new Artista(2489567, "Maria", "Valdez", "F", "Pintor");
        Artista a3 = new Artista(7889456, "Eva", "Sanchez", "F", "Pintor");
        Artista a4 = new Artista(1569845, "Josue", "Barrios", "M", "Pintor");
        Artista a5 = new Artista(9568716, "Erick", "Tancara", "M", "Pintor");
        Artista a6 = new Artista(6578945, "Christian", "Monrroy", "M", "Pintor");
        Artista a7 = new Artista(3987456, "Maira", "Vasquez", "F", "Pintor");
        Artista a8 = new Artista(9874563, "Ruben", "Lima", "M", "Pintor");
        
        LSArtista lSArtista = new LSArtista();
        lSArtista.adiFinal(a1);
        lSArtista.adiFinal(a2);
        lSArtista.adiFinal(a3);
        lSArtista.adiFinal(a4);
        lSArtista.adiFinal(a5);
        lSArtista.adiFinal(a6);
        lSArtista.adiFinal(a7);
        lSArtista.adiFinal(a8);
        
        lSArtista.mostrar();
        lSVisitante.mostrar();
        Produccion p11 = new Produccion("Teatro", "24/12/2021", "14:00", "Teatro", 20, 3.50);
        p11.setListaArtistas(lSArtista);
        p11.setListaVisitantes(lSVisitante);
        listaMuseos = new LSMuseo();
        p11.mostrar();

        //String nombre, String tipo, String direccion, String circuito, int id
        Museo m1 = new Museo("San Francisco", "Cultural", "Av. Principal", "Sopocachi S1", "S1-1");
        Museo m2 = new Museo("Artypica", "Arte", "Av. Principal", "Centro C1", "C1-2");
        //String nombre, String idSala, int capacidad, LDNormal listaProducciones
        Sala s11 = new Sala("Principal", "S1-1-1", 40);
        LSSala lSSala = new LSSala();
        lSSala.adiFinal(s11);
        //String nombre, String fecha, String hora, String tipo, int nroEntradas, double precio
        /*Produccion pro;
        pro = new Produccion("Teatro", "24/12/2021", "14:00", "Teatro", 20, 3.50);
        
        listaProducciones.adiFinal(pro);
        s11.setListaProducciones(listaProducciones);*/
        
        LSProduccion lSProduccion = new LSProduccion();
        lSProduccion.adiFinal(p11);
        s11.setListaProducciones(lSProduccion);
        
        //int ci, String nombre, String apellido, String genero, String tipo
        //Artista a11 = new Artista(1264, "Camila", "Ana", "F", "Escritora");
        //Visitante v11 = new Visitante(1264, "Camila", "Ana", "F", 3);

        
        /*LSVisitante lSVisitante = new LSVisitante();
        listaArtistas.adiFinal(a11);
        lSVisitante.adiFinal(v11);
        pro.setListaArtistas(listaArtistas);
        pro.setListaVisitantes(lSVisitante);*/
        m1.setListaSalas(lSSala);
        listaMuseos.adiFinal(m1);
        listaMuseos.adiFinal(m2);
        listaMuseos.mostrar();
        //listaMuseos.mostrar();
        /*listaProducciones.mostrar();
        listaArtistas.mostrar();*/

    }

    public void cargarPaneles() {
        panel2 = new PanelMuseo(this);
        panel3 = new PanelArtista(this);
        panel4 = new PanelProduccion(this);
        panel5 = new PanelVisitante(this);
        panelSalas = new PanelSalas(this);
        buscarPanelMuseo = new BuscarMuseoPanel(this);
        panelSalasProducciones = new PanelSalasProducciones(this);
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    void reset() {
        nombreMuseo.setText("");
        direccionMuseo.setText("");
        tipoMuseo.setSelectedIndex(0);
        circuitoMuseo.setSelectedIndex(0);
        idMuseo.setSelected(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNameAdm = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btn8 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        btn7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        centrePanel = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        addMuseum = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        updateMuseum = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        deleteMuseum = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        museumDetails = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        addArtist = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        detailsArtist = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        updateArtist = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        deleteArtist = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        p1_addMuseumPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        nombreMuseo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        direccionMuseo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        tipoMuseo = new javax.swing.JComboBox<>();
        circuitoMuseo = new javax.swing.JComboBox<>();
        agregarMuseoBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        agregarSalasBtn1 = new javax.swing.JButton();
        idMuseo = new javax.swing.JRadioButton();
        p1_addProduccionPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        nombreProduccion = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        salirBtn1 = new javax.swing.JButton();
        agregarProduccion = new javax.swing.JButton();
        fechaProduccion = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        comboBoxMuseos = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        precioProduccion = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        tipoProduccion = new javax.swing.JComboBox<>();
        minutoProduccion = new javax.swing.JSpinner();
        jLabel51 = new javax.swing.JLabel();
        horaProduccion = new javax.swing.JSpinner();
        nroEntradasProduccion = new javax.swing.JSpinner();
        jLabel52 = new javax.swing.JLabel();
        comboBoxSalas = new javax.swing.JComboBox<>();
        p11 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        addArtista = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        updateMuseum1 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        deleteArtista = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        verArtista = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        addVisitante = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        verVisitante = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        updateVisitante = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        deleteVisitante = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        p11_addArtistaPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        apellidoArtista = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        salirBtn2 = new javax.swing.JButton();
        agregarProduccion1 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        comboBoxMuseosArtista = new javax.swing.JComboBox<>();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel81 = new javax.swing.JLabel();
        comboBoxSalasArtista = new javax.swing.JComboBox<>();
        nombreArtista = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel84 = new javax.swing.JLabel();
        ciArtista = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        comboBoxProduccionesArtista = new javax.swing.JComboBox<>();
        generoArtista = new javax.swing.JComboBox<>();
        jLabel79 = new javax.swing.JLabel();
        categoriaArtista = new javax.swing.JComboBox<>();
        p11_addVisitantePanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        apellidoVisitante = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        salirBtn3 = new javax.swing.JButton();
        agregarVisitante = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        comboBoxMuseosVisitante = new javax.swing.JComboBox<>();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel83 = new javax.swing.JLabel();
        comboBoxSalasVisitante = new javax.swing.JComboBox<>();
        nombreVisitante = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel86 = new javax.swing.JLabel();
        ciVisitante = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        comboBoxProduccionesVisitante = new javax.swing.JComboBox<>();
        generoVisitante = new javax.swing.JComboBox<>();
        jLabel90 = new javax.swing.JLabel();
        idTicket = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 2, new java.awt.Color(153, 153, 153)));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(0, 0, 104));
        sidePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sidePanelMouseDragged(evt);
            }
        });
        sidePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sidePanelMousePressed(evt);
            }
        });
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setToolTipText("");
        sidePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 5, 130, 67));

        lblNameAdm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNameAdm.setForeground(new java.awt.Color(255, 204, 0));
        lblNameAdm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameAdm.setText("Nombre");
        sidePanel.add(lblNameAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 130, 15));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrador");
        sidePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 130, 15));

        btn1.setBackground(new java.awt.Color(0, 0, 51));
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        btn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 130, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tablero");
        btn1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 10));

        sidePanel.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 160, 124, 60));

        btn2.setBackground(new java.awt.Color(0, 0, 51));
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        btn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Museos");
        btn2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 10));

        sidePanel.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 220, 124, 60));

        btn3.setBackground(new java.awt.Color(0, 0, 51));
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });
        btn3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 130, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Artistas");
        btn3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 10));

        sidePanel.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 280, 124, 60));

        btn4.setBackground(new java.awt.Color(0, 0, 51));
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });
        btn4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 130, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Producciones");
        btn4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 10));

        sidePanel.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 340, 124, 60));

        btn5.setBackground(new java.awt.Color(0, 0, 51));
        btn5.setBorder(new javax.swing.border.MatteBorder(null));
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ver Perfil");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout btn5Layout = new javax.swing.GroupLayout(btn5);
        btn5.setLayout(btn5Layout);
        btn5Layout.setHorizontalGroup(
            btn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );
        btn5Layout.setVerticalGroup(
            btn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        sidePanel.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 30));

        btn6.setBackground(new java.awt.Color(0, 0, 51));
        btn6.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cerrar Sesión");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(255, 255, 255)));
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout btn6Layout = new javax.swing.GroupLayout(btn6);
        btn6.setLayout(btn6Layout);
        btn6Layout.setHorizontalGroup(
            btn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
        btn6Layout.setVerticalGroup(
            btn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        sidePanel.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 124, 30));

        btn8.setBackground(new java.awt.Color(0, 0, 51));
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });
        btn8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn8.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 130, 30));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Salas");
        btn8.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 10));

        sidePanel.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 460, 124, 60));

        btn7.setBackground(new java.awt.Color(0, 0, 51));
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
        });
        btn7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 130, 30));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Visitantes");
        btn7.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 10));

        sidePanel.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 400, 124, 60));

        mainPanel.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 600));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 2, new java.awt.Color(153, 153, 153)));
        headerPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerPanelMouseDragged(evt);
            }
        });
        headerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerPanelMousePressed(evt);
            }
        });
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("X");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        headerPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 5, 25, 25));

        mainPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 900, 35));

        centrePanel.setLayout(new java.awt.CardLayout());

        p1.setBackground(new java.awt.Color(218, 228, 232));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bienvenido");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Sección de Museos");

        jLabel16.setText("i");

        addMuseum.setBackground(new java.awt.Color(255, 255, 255));
        addMuseum.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        addMuseum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMuseum.setName(""); // NOI18N
        addMuseum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMuseumMouseClicked(evt);
            }
        });
        addMuseum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("icono");
        addMuseum.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 0));
        jLabel19.setText("Agregar Museo");
        addMuseum.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        updateMuseum.setBackground(new java.awt.Color(255, 255, 255));
        updateMuseum.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        updateMuseum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("icono");
        updateMuseum.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 255));
        jLabel21.setText("Actualizar Museo");
        updateMuseum.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        deleteMuseum.setBackground(new java.awt.Color(255, 255, 255));
        deleteMuseum.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        deleteMuseum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMuseumMouseClicked(evt);
            }
        });
        deleteMuseum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("icono");
        deleteMuseum.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("Ver Salas");
        deleteMuseum.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        museumDetails.setBackground(new java.awt.Color(255, 255, 255));
        museumDetails.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        museumDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                museumDetailsMouseClicked(evt);
            }
        });
        museumDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("icono");
        museumDetails.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 204, 204));
        jLabel25.setText("Ver Museo");
        museumDetails.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        addArtist.setBackground(new java.awt.Color(255, 255, 255));
        addArtist.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        addArtist.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addArtistMouseClicked(evt);
            }
        });
        addArtist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 0));
        jLabel27.setText("Agregar Producción");
        addArtist.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("icono");
        addArtist.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 80, 80));

        detailsArtist.setBackground(new java.awt.Color(255, 255, 255));
        detailsArtist.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        detailsArtist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("icono");
        detailsArtist.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 204, 204));
        jLabel29.setText("Ver Producción");
        detailsArtist.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        updateArtist.setBackground(new java.awt.Color(255, 255, 255));
        updateArtist.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        updateArtist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("icono");
        updateArtist.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 255));
        jLabel31.setText("Actualizar Producción");
        updateArtist.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Sección de Artistas");

        deleteArtist.setBackground(new java.awt.Color(255, 255, 255));
        deleteArtist.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        deleteArtist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("icono");
        deleteArtist.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("Eliminar Producción");
        deleteArtist.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel34.setText("i");

        jLabel74.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 104));
        jLabel74.setText("❯");
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(p1Layout.createSequentialGroup()
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16)))
                                .addGap(280, 280, 280))
                            .addGroup(p1Layout.createSequentialGroup()
                                .addComponent(addMuseum, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateMuseum, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteMuseum, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(museumDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74)))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(addArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detailsArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel74))
                .addGap(20, 20, 20)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMuseum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateMuseum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteMuseum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(museumDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        centrePanel.add(p1, "card2");

        p1_addMuseumPanel.setBackground(new java.awt.Color(218, 228, 232));

        jPanel1.setBackground(new java.awt.Color(218, 228, 232));
        jPanel1.setForeground(new java.awt.Color(0, 0, 104));

        jPanel2.setBackground(new java.awt.Color(0, 0, 104));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 104));
        jLabel35.setText("Nombre");

        nombreMuseo.setBackground(new java.awt.Color(218, 228, 232));
        nombreMuseo.setBorder(null);
        nombreMuseo.setCaretColor(new java.awt.Color(0, 0, 104));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 104));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 104));
        jLabel36.setText("Dirección");

        direccionMuseo.setBackground(new java.awt.Color(218, 228, 232));
        direccionMuseo.setBorder(null);
        direccionMuseo.setCaretColor(new java.awt.Color(0, 0, 104));
        direccionMuseo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionMuseoActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 0, 104));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 104));
        jLabel37.setText("Tipo");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 104));
        jLabel38.setText("ID:");

        tipoMuseo.setBackground(new java.awt.Color(218, 228, 232));
        tipoMuseo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipoMuseo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arte", "Historia natural", "Arqueológico", "Monográficos", "Histórico", "Ciencia y tecnología", "Agricultura" }));
        tipoMuseo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMuseoActionPerformed(evt);
            }
        });

        circuitoMuseo.setBackground(new java.awt.Color(218, 228, 232));
        circuitoMuseo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        circuitoMuseo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centro 1 - C1", "Centro 2 - C2", "Centro 3 - C3", "Centro 4 - C3", "Sopocachi 1 - S1", "Sopocachi 2 - S2", "Sopocachi 3 - S3", "Sopocachi 4 - S4", "Miraflores 1 - M1", "Miraflores 2 - M2", "Miraflores 3 - M3", "Miraflores 4 - M4", "Zona Sur 1 - Z1", "Zona Sur 2 -Z2", "Zona Sur 3 - Z3", "Zona Sur 4 - Z4", "Zona Sur 5 - Z5", "Zona Sur 6 - Z6" }));
        circuitoMuseo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circuitoMuseoActionPerformed(evt);
            }
        });

        agregarMuseoBtn.setBackground(new java.awt.Color(0, 0, 104));
        agregarMuseoBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregarMuseoBtn.setForeground(new java.awt.Color(255, 255, 255));
        agregarMuseoBtn.setText("Agregar Museo");
        agregarMuseoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarMuseoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMuseoBtnActionPerformed(evt);
            }
        });

        salirBtn.setBackground(new java.awt.Color(255, 0, 51));
        salirBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salirBtn.setForeground(new java.awt.Color(255, 255, 255));
        salirBtn.setText("Salir");
        salirBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 104));
        jLabel39.setText("Circuito");

        agregarSalasBtn1.setBackground(new java.awt.Color(255, 51, 0));
        agregarSalasBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregarSalasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        agregarSalasBtn1.setText("Agregar Salas");
        agregarSalasBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarSalasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSalasBtn1ActionPerformed(evt);
            }
        });

        idMuseo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idMuseo.setForeground(new java.awt.Color(0, 0, 104));
        idMuseo.setText("ID");
        idMuseo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idMuseoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel35)
                                    .addComponent(jSeparator2)
                                    .addComponent(nombreMuseo, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3)
                                    .addComponent(direccionMuseo, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tipoMuseo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(circuitoMuseo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(agregarMuseoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(agregarSalasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(18, 18, 18)
                                .addComponent(idMuseo)))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(direccionMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(tipoMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circuitoMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(idMuseo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarMuseoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarSalasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p1_addMuseumPanelLayout = new javax.swing.GroupLayout(p1_addMuseumPanel);
        p1_addMuseumPanel.setLayout(p1_addMuseumPanelLayout);
        p1_addMuseumPanelLayout.setHorizontalGroup(
            p1_addMuseumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1_addMuseumPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        p1_addMuseumPanelLayout.setVerticalGroup(
            p1_addMuseumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        centrePanel.add(p1_addMuseumPanel, "card7");

        p1_addProduccionPanel.setBackground(new java.awt.Color(218, 228, 232));

        jPanel4.setBackground(new java.awt.Color(218, 228, 232));
        jPanel4.setForeground(new java.awt.Color(0, 0, 104));

        jPanel5.setBackground(new java.awt.Color(0, 0, 104));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 104));
        jLabel40.setText("Nombre");

        nombreProduccion.setBackground(new java.awt.Color(218, 228, 232));
        nombreProduccion.setBorder(null);
        nombreProduccion.setCaretColor(new java.awt.Color(0, 0, 104));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 104));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 104));
        jLabel41.setText("Hora");

        salirBtn1.setBackground(new java.awt.Color(255, 0, 51));
        salirBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salirBtn1.setForeground(new java.awt.Color(255, 255, 255));
        salirBtn1.setText("Salir");
        salirBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salirBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtn1ActionPerformed(evt);
            }
        });

        agregarProduccion.setBackground(new java.awt.Color(0, 0, 104));
        agregarProduccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregarProduccion.setForeground(new java.awt.Color(255, 255, 255));
        agregarProduccion.setText("Agregar ");
        agregarProduccion.setActionCommand("Agregar \nProducción");
        agregarProduccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProduccionActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 104));
        jLabel45.setText("Museo");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 104));
        jLabel46.setText("Fecha");

        comboBoxMuseos.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxMuseos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxMuseos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxMuseosItemStateChanged(evt);
            }
        });
        comboBoxMuseos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMuseosActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 104));
        jLabel47.setText("Nro. Entradas");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 104));
        jLabel48.setText("Bs.");

        precioProduccion.setBackground(new java.awt.Color(218, 228, 232));
        precioProduccion.setBorder(null);
        precioProduccion.setCaretColor(new java.awt.Color(0, 0, 104));

        jSeparator5.setForeground(new java.awt.Color(255, 51, 0));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 104));
        jLabel49.setText("Precio");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 104));
        jLabel50.setText("Sala");

        tipoProduccion.setBackground(new java.awt.Color(218, 228, 232));
        tipoProduccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipoProduccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concierto", "Sinfonía", "Presentación de arte", "Conversatorio", "Visita Guiada", "Proyección escénica", "Presentaciones de libro", " " }));
        tipoProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoProduccionActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 104));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText(":");
        jLabel51.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel51.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 104));
        jLabel52.setText("Tipo");

        comboBoxSalas.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxSalas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxSalas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSalasItemStateChanged(evt);
            }
        });
        comboBoxSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSalasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreProduccion)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxMuseos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarProduccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nroEntradasProduccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salirBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(precioProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel50)
                            .addComponent(comboBoxSalas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel40)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(fechaProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(horaProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(minutoProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tipoProduccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horaProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutoProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel52)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxMuseos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(precioProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(nroEntradasProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout p1_addProduccionPanelLayout = new javax.swing.GroupLayout(p1_addProduccionPanel);
        p1_addProduccionPanel.setLayout(p1_addProduccionPanelLayout);
        p1_addProduccionPanelLayout.setHorizontalGroup(
            p1_addProduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1_addProduccionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        p1_addProduccionPanelLayout.setVerticalGroup(
            p1_addProduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        centrePanel.add(p1_addProduccionPanel, "card7");

        p11.setBackground(new java.awt.Color(218, 228, 232));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Bienvenido");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setText("Sección de Museos");

        jLabel54.setText("i");

        addArtista.setBackground(new java.awt.Color(255, 255, 255));
        addArtista.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        addArtista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addArtistaMouseClicked(evt);
            }
        });
        addArtista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("icono");
        addArtista.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 153, 0));
        jLabel56.setText("Agregar Artista");
        addArtista.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        updateMuseum1.setBackground(new java.awt.Color(255, 255, 255));
        updateMuseum1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        updateMuseum1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("icono");
        updateMuseum1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 255));
        jLabel58.setText("Actualizar Artista");
        updateMuseum1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        deleteArtista.setBackground(new java.awt.Color(255, 255, 255));
        deleteArtista.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        deleteArtista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("icono");
        deleteArtista.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 0, 0));
        jLabel60.setText("Calcular Valor Obras");
        deleteArtista.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        verArtista.setBackground(new java.awt.Color(255, 255, 255));
        verArtista.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        verArtista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("icono");
        verArtista.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 204, 204));
        jLabel62.setText("Ver Artista");
        verArtista.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        addVisitante.setBackground(new java.awt.Color(255, 255, 255));
        addVisitante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        addVisitante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addVisitanteMouseClicked(evt);
            }
        });
        addVisitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addVisitanteKeyPressed(evt);
            }
        });
        addVisitante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 153, 0));
        jLabel64.setText("Agregar Visitante");
        addVisitante.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("icono");
        addVisitante.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 80, 80));

        verVisitante.setBackground(new java.awt.Color(255, 255, 255));
        verVisitante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        verVisitante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("icono");
        verVisitante.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 204, 204));
        jLabel67.setText("Ver Visitante");
        verVisitante.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        updateVisitante.setBackground(new java.awt.Color(255, 255, 255));
        updateVisitante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        updateVisitante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("icono");
        updateVisitante.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 255));
        jLabel69.setText("Actualizar Visitante");
        updateVisitante.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setText("Sección de Artistas");

        deleteVisitante.setBackground(new java.awt.Color(255, 255, 255));
        deleteVisitante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(153, 153, 153)));
        deleteVisitante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("icono");
        deleteVisitante.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 0, 0));
        jLabel72.setText("Eliminar Vistante");
        deleteVisitante.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel73.setText("i");

        jLabel75.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 104));
        jLabel75.setText("❮");
        jLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel75MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout p11Layout = new javax.swing.GroupLayout(p11);
        p11.setLayout(p11Layout);
        p11Layout.setHorizontalGroup(
            p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p11Layout.createSequentialGroup()
                            .addComponent(jLabel70)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel73))
                        .addGroup(p11Layout.createSequentialGroup()
                            .addComponent(addVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(updateVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(deleteVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(verVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(p11Layout.createSequentialGroup()
                        .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(p11Layout.createSequentialGroup()
                                .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44)
                                    .addGroup(p11Layout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel54)))
                                .addGap(280, 280, 280))
                            .addGroup(p11Layout.createSequentialGroup()
                                .addComponent(addArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateMuseum1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(verArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        p11Layout.setVerticalGroup(
            p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateMuseum1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        centrePanel.add(p11, "card2");

        p11_addArtistaPanel.setBackground(new java.awt.Color(218, 228, 232));

        jPanel6.setBackground(new java.awt.Color(218, 228, 232));
        jPanel6.setForeground(new java.awt.Color(0, 0, 104));

        jPanel7.setBackground(new java.awt.Color(0, 0, 104));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 104));
        jLabel43.setText("Nombre");

        apellidoArtista.setBackground(new java.awt.Color(218, 228, 232));
        apellidoArtista.setBorder(null);
        apellidoArtista.setCaretColor(new java.awt.Color(0, 0, 104));
        apellidoArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoArtistaActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(0, 0, 104));

        salirBtn2.setBackground(new java.awt.Color(255, 0, 51));
        salirBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salirBtn2.setForeground(new java.awt.Color(255, 255, 255));
        salirBtn2.setText("Salir");
        salirBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salirBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtn2ActionPerformed(evt);
            }
        });

        agregarProduccion1.setBackground(new java.awt.Color(0, 0, 104));
        agregarProduccion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregarProduccion1.setForeground(new java.awt.Color(255, 255, 255));
        agregarProduccion1.setText("Agregar ");
        agregarProduccion1.setActionCommand("Agregar \nProducción");
        agregarProduccion1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarProduccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProduccion1ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 104));
        jLabel76.setText("Museo");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 104));
        jLabel77.setText("Apellido");

        comboBoxMuseosArtista.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxMuseosArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxMuseosArtista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxMuseosArtistaItemStateChanged(evt);
            }
        });
        comboBoxMuseosArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMuseosArtistaActionPerformed(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(255, 51, 0));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 104));
        jLabel81.setText("Género");

        comboBoxSalasArtista.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxSalasArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxSalasArtista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSalasArtistaItemStateChanged(evt);
            }
        });
        comboBoxSalasArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSalasArtistaActionPerformed(evt);
            }
        });

        nombreArtista.setBackground(new java.awt.Color(218, 228, 232));
        nombreArtista.setBorder(null);
        nombreArtista.setCaretColor(new java.awt.Color(0, 0, 104));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 104));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 0, 104));
        jLabel84.setText("CI");

        ciArtista.setBackground(new java.awt.Color(218, 228, 232));
        ciArtista.setBorder(null);
        ciArtista.setCaretColor(new java.awt.Color(0, 0, 104));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 104));
        jLabel85.setText("Sala");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 104));
        jLabel78.setText("Produccion");

        comboBoxProduccionesArtista.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxProduccionesArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxProduccionesArtista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxProduccionesArtistaItemStateChanged(evt);
            }
        });
        comboBoxProduccionesArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProduccionesArtistaActionPerformed(evt);
            }
        });

        generoArtista.setBackground(new java.awt.Color(218, 228, 232));
        generoArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        generoArtista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));
        generoArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generoArtistaActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 104));
        jLabel79.setText("Categoría");

        categoriaArtista.setBackground(new java.awt.Color(218, 228, 232));
        categoriaArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        categoriaArtista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artista plásticos", "Artista musicales", "Artista visuales", "Artista conceptuales", "Artista de performance", "Artista marciales", "Artista digitales", "Artista bíblico", "Artista autodidacta", "Artista autónomo", "Artista profesional liberal", "Artista comercial", "Artista urbano", "Artista local", "Artista emergente" }));
        categoriaArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaArtistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreArtista, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellidoArtista, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregarProduccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel77)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel84)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                            .addComponent(ciArtista)))
                                    .addComponent(comboBoxMuseosArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxSalasArtista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel81)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(generoArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(salirBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel85))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(72, 72, 72))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel78)
                            .addComponent(comboBoxProduccionesArtista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel79)
                            .addComponent(categoriaArtista, 0, 389, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidoArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(ciArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81)
                    .addComponent(generoArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoriaArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel85))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMuseosArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSalasArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addComponent(comboBoxProduccionesArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarProduccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout p11_addArtistaPanelLayout = new javax.swing.GroupLayout(p11_addArtistaPanel);
        p11_addArtistaPanel.setLayout(p11_addArtistaPanelLayout);
        p11_addArtistaPanelLayout.setHorizontalGroup(
            p11_addArtistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p11_addArtistaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        p11_addArtistaPanelLayout.setVerticalGroup(
            p11_addArtistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        centrePanel.add(p11_addArtistaPanel, "card7");

        p11_addVisitantePanel.setBackground(new java.awt.Color(218, 228, 232));

        jPanel8.setBackground(new java.awt.Color(218, 228, 232));
        jPanel8.setForeground(new java.awt.Color(0, 0, 104));

        jPanel9.setBackground(new java.awt.Color(0, 0, 104));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 104));
        jLabel63.setText("Nombre");

        apellidoVisitante.setBackground(new java.awt.Color(218, 228, 232));
        apellidoVisitante.setBorder(null);
        apellidoVisitante.setCaretColor(new java.awt.Color(0, 0, 104));
        apellidoVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoVisitanteActionPerformed(evt);
            }
        });

        jSeparator10.setForeground(new java.awt.Color(0, 0, 104));

        salirBtn3.setBackground(new java.awt.Color(255, 0, 51));
        salirBtn3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salirBtn3.setForeground(new java.awt.Color(255, 255, 255));
        salirBtn3.setText("Salir");
        salirBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salirBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtn3ActionPerformed(evt);
            }
        });

        agregarVisitante.setBackground(new java.awt.Color(0, 0, 104));
        agregarVisitante.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregarVisitante.setForeground(new java.awt.Color(255, 255, 255));
        agregarVisitante.setText("Agregar ");
        agregarVisitante.setActionCommand("Agregar \nProducción");
        agregarVisitante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        agregarVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarVisitanteActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 104));
        jLabel80.setText("Museo");

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 104));
        jLabel82.setText("Apellido");

        comboBoxMuseosVisitante.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxMuseosVisitante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxMuseosVisitante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxMuseosVisitanteItemStateChanged(evt);
            }
        });
        comboBoxMuseosVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMuseosVisitanteActionPerformed(evt);
            }
        });

        jSeparator11.setForeground(new java.awt.Color(255, 51, 0));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 104));
        jLabel83.setText("Género");

        comboBoxSalasVisitante.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxSalasVisitante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxSalasVisitante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSalasVisitanteItemStateChanged(evt);
            }
        });
        comboBoxSalasVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSalasVisitanteActionPerformed(evt);
            }
        });

        nombreVisitante.setBackground(new java.awt.Color(218, 228, 232));
        nombreVisitante.setBorder(null);
        nombreVisitante.setCaretColor(new java.awt.Color(0, 0, 104));

        jSeparator12.setForeground(new java.awt.Color(0, 0, 104));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 104));
        jLabel86.setText("CI");

        ciVisitante.setBackground(new java.awt.Color(218, 228, 232));
        ciVisitante.setBorder(null);
        ciVisitante.setCaretColor(new java.awt.Color(0, 0, 104));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 104));
        jLabel87.setText("Sala");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 104));
        jLabel88.setText("Produccion");

        comboBoxProduccionesVisitante.setBackground(new java.awt.Color(218, 228, 232));
        comboBoxProduccionesVisitante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxProduccionesVisitante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxProduccionesVisitanteItemStateChanged(evt);
            }
        });
        comboBoxProduccionesVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProduccionesVisitanteActionPerformed(evt);
            }
        });

        generoVisitante.setBackground(new java.awt.Color(218, 228, 232));
        generoVisitante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        generoVisitante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));
        generoVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generoVisitanteActionPerformed(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 0, 104));
        jLabel90.setText("Id Ticket");

        idTicket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idTicket.setForeground(new java.awt.Color(0, 0, 104));
        idTicket.setText("ID Ticket");
        idTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idTicketMouseClicked(evt);
            }
        });
        idTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreVisitante, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellidoVisitante, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregarVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel80)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel82)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel86)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator11, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                            .addComponent(ciVisitante)))
                                    .addComponent(comboBoxMuseosVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxSalasVisitante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel83)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(generoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(salirBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel87))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(72, 72, 72))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxProduccionesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addGap(18, 18, 18)
                                .addComponent(idTicket)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(ciVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83)
                    .addComponent(generoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel87))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMuseosVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSalasVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxProduccionesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(idTicket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout p11_addVisitantePanelLayout = new javax.swing.GroupLayout(p11_addVisitantePanel);
        p11_addVisitantePanel.setLayout(p11_addVisitantePanelLayout);
        p11_addVisitantePanelLayout.setHorizontalGroup(
            p11_addVisitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p11_addVisitantePanelLayout.setVerticalGroup(
            p11_addVisitantePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        centrePanel.add(p11_addVisitantePanel, "card7");

        mainPanel.add(centrePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 35, 769, 560));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked
    private void onClick(JPanel panel) {
        panel.setBackground(new Color(0, 153, 204));
    }

    private void onLeaveClick(JPanel panel) {
        panel.setBackground(new Color(0, 0, 51));
    }

    private void setPanel(Component panel) {
        centrePanel.removeAll();
        centrePanel.add(panel);
        centrePanel.repaint();
        centrePanel.revalidate();
    }
    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
        // TODO add your handling code here:
        onClick(btn1);
        onLeaveClick(btn2);
        onLeaveClick(btn3);
        onLeaveClick(btn4);
        onLeaveClick(btn5);
        onLeaveClick(btn7);
        onLeaveClick(btn8);

        // cambiando panel on click
        setPanel(p1);

    }//GEN-LAST:event_btn1MouseClicked

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        // TODO add your handling code here:
        onLeaveClick(btn1);
        onClick(btn2);
        onLeaveClick(btn3);
        onLeaveClick(btn4);
        onLeaveClick(btn5);
        onLeaveClick(btn7);
        onLeaveClick(btn8);
        // cambiando panel on click
        setPanel(panel2);

    }//GEN-LAST:event_btn2MouseClicked

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        // TODO add your handling code here:
        onLeaveClick(btn1);
        onLeaveClick(btn2);
        onClick(btn3);
        onLeaveClick(btn4);
        onLeaveClick(btn5);
        onLeaveClick(btn7);
        onLeaveClick(btn8);
        // cambiando panel on click
        setPanel(panel3);
    }//GEN-LAST:event_btn3MouseClicked

    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        // TODO add your handling code here:
        onLeaveClick(btn1);
        onLeaveClick(btn2);
        onLeaveClick(btn3);
        onClick(btn4);
        onLeaveClick(btn5);
        onLeaveClick(btn7);
        onLeaveClick(btn8);
        // cambiando panel on click
        setPanel(panel4);
    }//GEN-LAST:event_btn4MouseClicked

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
        // TODO add your handling code here:
        onLeaveClick(btn1);
        onLeaveClick(btn2);
        onLeaveClick(btn3);
        onLeaveClick(btn4);
        onClick(btn5);
        onLeaveClick(btn7);
        onLeaveClick(btn8);
        // cambiando panel on click
        //setPanel(p5);
    }//GEN-LAST:event_btn5MouseClicked

    private void sidePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_sidePanelMouseDragged

    private void sidePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_sidePanelMousePressed

    private void headerPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_headerPanelMouseDragged

    private void headerPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerPanelMousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_headerPanelMousePressed

    private void tipoMuseoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMuseoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoMuseoActionPerformed

    private void direccionMuseoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionMuseoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionMuseoActionPerformed

    private void circuitoMuseoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circuitoMuseoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_circuitoMuseoActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        // TODO add your handling code here:

        /*p1_addMuseumPanel.setVisible(false);
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        reset();*/

    }//GEN-LAST:event_salirBtnActionPerformed

    private void addMuseumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMuseumMouseClicked
        // TODO add your handling code here:
        setPanel(p1_addMuseumPanel);
    }//GEN-LAST:event_addMuseumMouseClicked

    private void agregarMuseoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMuseoBtnActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null, "¿Está seguro de agregar el museo?", "Add Record", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {

                // Obtener datos de los campos de texto
                String nombre, direccion, tipo, circuito, id;
                nombre = nombreMuseo.getText();
                direccion = direccionMuseo.getText();
                tipo = tipoMuseo.getSelectedItem().toString();
                circuito = circuitoMuseo.getSelectedItem().toString();
                id = idMuseo.getText();
                // Validacion de campos no vacios
                if (nombre.equals("") || direccion.equals("") || tipo.equals("") || circuito.equals("")) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos",
                            "Error al registrar el museo", JOptionPane.ERROR_MESSAGE);

                } else {
                    Museo mx = new Museo(nombre, tipo, direccion, circuito, id);
                    LSSala listaSalas = new LSSala();
                    mx.setListaSalas(listaSalas);
                    listaMuseos.adiFinal(mx);
                    panel2.datosATabla();
                    panelSalas.datosATabla();
                    JOptionPane.showMessageDialog(null, "Museo registrado exitosamente");
                    //reset();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_agregarMuseoBtnActionPerformed

    private void agregarSalasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSalasBtn1ActionPerformed
        NodoM r = listaMuseos.getP();
        while (r.getSig() != null) {
            r = r.getSig();
        }
        Museo mx = (Museo) r.getMuseo();
        RegistroSalas registroSalas = new RegistroSalas(idMuseo.getText(), mx.getListaSalas(), this);
        registroSalas.setVisible(true);
    }//GEN-LAST:event_agregarSalasBtn1ActionPerformed

    private void idMuseoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMuseoMouseClicked
        // TODO add your handling code here:
        String textId1 = circuitoMuseo.getSelectedItem().toString().substring(circuitoMuseo.getSelectedItem().toString().length() - 2);

        String textId = textId1 + "-" + String.format("%d", listaMuseos.nroNodos()+ 1);
        id = textId;
        //textId.concat(String.valueOf((listaMuseos.nElem())));
        idMuseo.setText(textId);

    }//GEN-LAST:event_idMuseoMouseClicked

    private void salirBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtn1ActionPerformed
        // TODO add your handling code here:
        /*p1_addProduccionPanel.setVisible(false);
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        reset();*/
    }//GEN-LAST:event_salirBtn1ActionPerformed

    private void agregarProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProduccionActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "¿Está seguro de agregar la producción?", "Add Record", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {

                // Obtener datos de los campos de texto
                String nombre, tipo, hora, fecha;
                int nroEntradas = 0;
                double precio;
                nombre = nombreProduccion.getText();
                hora = horaProduccion.getValue().toString() + ":" + minutoProduccion.getValue().toString();
                nroEntradas = (int) nroEntradasProduccion.getValue();
                precio = Double.parseDouble(precioProduccion.getText());
                tipo = tipoProduccion.getSelectedItem().toString();
                Date date = fechaProduccion.getDate();
                fecha = DateFormat.getDateInstance().format(date);
                // Validacion de campos no vacios
                if (nombre.equals("") || hora.equals("") || tipo.equals("") || fecha.equals("")) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos",
                            "Error al registrar el museo", JOptionPane.ERROR_MESSAGE);

                } else {
                    //String nombre, String fecha, String hora, String tipo, String horario, int nroEntradas, double precio
                    Produccion px = new Produccion(nombre, fecha, hora, tipo, nroEntradas, precio);
                    LSArtista listArtistas = new LSArtista();
                    LSVisitante listaVisitantes = new LSVisitante();

                    px.setListaArtistas(listArtistas);
                    px.setListaVisitantes(listaVisitantes);
                    agregarProduccionASala(comboBoxMuseos.getSelectedItem().toString(), comboBoxSalas.getSelectedItem().toString(), px);
                    //listaProducciones.adiFin(px);
                    panel4.datosATabla();
                    JOptionPane.showMessageDialog(null, "Producción registrada exitosamente");
                    //reset();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_agregarProduccionActionPerformed

    public void agregarProduccionASala(String IdMuseo, String IdSala, Produccion x) {
        NodoM r = listaMuseos.getP();
        boolean sw = false;
        while (r != null && !sw) {
            Museo mx = (Museo) r.getMuseo();
            String idMx = "(" + mx.getId() + ") " + mx.getNombre();
            if (idMx.equals(IdMuseo)) {
                NodoS w = mx.getListaSalas().getP();
                while (w != null && !sw) {
                    Sala sx = (Sala) w.getSala();
                    if (sx.getIdSala().equals(IdSala)) {
                        System.out.println("produccion agregada");
                        sx.getListaProducciones().adiFinal(x);
                        sw = true;
                    } else {
                        w = w.getSig();
                    }
                }
            } else {
                r = r.getSig();
            }
        }

    }
    
    
    private void comboBoxMuseosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMuseosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMuseosActionPerformed

    private void tipoProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoProduccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoProduccionActionPerformed
    private void agregarMuseosComboBox() {
        comboBoxMuseos.removeAllItems();
        NodoM q = listaMuseos.getP();
        while (q != null) {
            Museo mx = (Museo) q.getMuseo();
            comboBoxMuseos.addItem("(" + mx.getId() + ") " + mx.getNombre()); // adiciona cadena a combobox
            q = q.getSig();
        }
    }
    private void addArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addArtistMouseClicked
        // TODO add your handling code here:
        agregarMuseosComboBox();
        setPanel(p1_addProduccionPanel);
    }//GEN-LAST:event_addArtistMouseClicked

    private void comboBoxSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSalasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSalasActionPerformed

    private void comboBoxSalasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSalasItemStateChanged
        // TODO add your handling code here:
        //"("+mx.getId()+") "+mx.getNombre()


    }//GEN-LAST:event_comboBoxSalasItemStateChanged

    private void comboBoxMuseosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMuseosItemStateChanged
        // TODO add your handling code here:
        if (comboBoxMuseos.getSelectedIndex() != -1) {
            comboBoxSalas.removeAllItems();
            NodoM r = listaMuseos.getP();
            while (r != null) {
                Museo mx = (Museo) r.getMuseo();
                String idMx = "(" + mx.getId() + ") " + mx.getNombre();
                if (idMx.equals(comboBoxMuseos.getSelectedItem().toString())) {
                    System.out.println("Activado");
                    LSSala lsx = mx.getListaSalas();
                    NodoS w = lsx.getP();
                    while (w != null) {
                        Sala sx = (Sala) w.getSala();
                        comboBoxSalas.addItem(sx.getIdSala());
                        w = w.getSig();
                    }
                    break;
                } else {
                    r = r.getSig();
                }

            }

        }
    }//GEN-LAST:event_comboBoxMuseosItemStateChanged

    private void addArtistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addArtistaMouseClicked
        // TODO add your handling code here:
        agregarMuseosArtistaComboBox();
        setPanel(p11_addArtistaPanel);
    }//GEN-LAST:event_addArtistaMouseClicked

    private void addVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addVisitanteMouseClicked
        // TODO add your handling code here:
        agregarMuseosVisitanteComboBox();
        setPanel(p11_addVisitantePanel);
    }//GEN-LAST:event_addVisitanteMouseClicked

    private void jLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseClicked
        // TODO add your handling code here:
        setPanel(p1);
    }//GEN-LAST:event_jLabel75MouseClicked

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // TODO add your handling code here:
        setPanel(p11);
    }//GEN-LAST:event_jLabel74MouseClicked

    private void salirBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirBtn2ActionPerformed

    private void agregarProduccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProduccion1ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "¿Está seguro de agregar al artista?", "Add Record", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {

                // Obtener datos de los campos de texto
                String nombre, apellido, genero, categoria, tipo;
                int ci = Integer.parseInt(ciArtista.getText());
                nombre = nombreArtista.getText();
                apellido = apellidoArtista.getText();
                genero = generoArtista.getSelectedItem().toString();
                tipo = categoriaArtista.getSelectedItem().toString();

                // Validacion de campos no vacios
                if (nombre.equals("") || apellido.equals("") || genero.equals("") || tipo.equals("") || ciArtista.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos",
                            "Error al registrar el artista", JOptionPane.ERROR_MESSAGE);

                } else {
                    //int ci, String nombre, String apellido, String genero, String tipo
                    Artista ax = new Artista(ci, nombre, apellido, genero, tipo);
                    agregarArtistaAProduccion(comboBoxMuseosArtista.getSelectedItem().toString(), comboBoxSalasArtista.getSelectedItem().toString(), comboBoxProduccionesArtista.getSelectedItem().toString(), ax);
                    //listaProducciones.adiFin(px);

                    panel3.datosATabla();
                    JOptionPane.showMessageDialog(null, "Artista registrado exitosamente");
                    //reset();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }//GEN-LAST:event_agregarProduccion1ActionPerformed
    private void agregarMuseosArtistaComboBox() {
        comboBoxMuseosArtista.removeAllItems();
        NodoM q = listaMuseos.getP();
        while (q != null) {
            Museo mx = (Museo) q.getMuseo();
            comboBoxMuseosArtista.addItem("(" + mx.getId() + ") " + mx.getNombre()); // adiciona cadena a combobox
            q = q.getSig();
        }
    }

    private void agregarMuseosVisitanteComboBox() {
        comboBoxMuseosVisitante.removeAllItems();
        NodoM q = listaMuseos.getP();
        while (q != null) {
            Museo mx = (Museo) q.getMuseo();
            comboBoxMuseosVisitante.addItem("(" + mx.getId() + ") " + mx.getNombre()); // adiciona cadena a combobox
            q = q.getSig();
        }
    }

    private void agregarArtistaAProduccion(String idMuseo, String idSala, String nombreProduccion, Artista x) {
        NodoM r = listaMuseos.getP();
        boolean sw = false;
        while (r != null && !sw) {
            Museo mx = (Museo) r.getMuseo();
            String idMx = "(" + mx.getId() + ") " + mx.getNombre();
            if (idMx.equals(idMuseo)) {
                LSSala lsx = mx.getListaSalas();
                NodoS w = lsx.getP();
                while (w != null && !sw) {
                    Sala sx = (Sala) w.getSala();
                    if (idSala.equals(sx.getIdSala())) {
                        LSProduccion lpx = sx.getListaProducciones();
                        NodoP z = lpx.getP();
                        while (z != null && !sw) {
                            Produccion px = (Produccion) z.getProduccion();
                            if (px.getNombre().equals(nombreProduccion)) {
                                px.getListaArtistas().adiFinal(x);
                                System.out.println("Se logro");
                                sw = true;
                            } else {
                                z = z.getSig();
                            }

                        }

                    }

                    w = w.getSig();
                }

            } else {
                r = r.getSig();
            }
        }

    }
    private void comboBoxMuseosArtistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMuseosArtistaItemStateChanged
        if (comboBoxMuseosArtista.getSelectedIndex() != -1) {
            comboBoxSalasArtista.removeAllItems();
            NodoM r = listaMuseos.getP();
            while (r != null) {
                Museo mx = (Museo) r.getMuseo();
                String idMx = "(" + mx.getId() + ") " + mx.getNombre();
                if (idMx.equals(comboBoxMuseosArtista.getSelectedItem().toString())) {
                    LSSala lsx = mx.getListaSalas();
                    NodoS w = lsx.getP();
                    while (w != null) {
                        Sala sx = (Sala) w.getSala();
                        comboBoxSalasArtista.addItem(sx.getIdSala());
                        w = w.getSig();
                    }
                    break;
                } else {
                    r = r.getSig();
                }

            }

        }
    }//GEN-LAST:event_comboBoxMuseosArtistaItemStateChanged

    private void comboBoxMuseosArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMuseosArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMuseosArtistaActionPerformed

    private void comboBoxSalasArtistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSalasArtistaItemStateChanged
        // TODO add your handling code here:
        comboBoxProduccionesArtista.removeAllItems();
        if (comboBoxSalasArtista.getSelectedIndex() != -1) {
            boolean sw = false;

            NodoM r = listaMuseos.getP();
            System.out.println("Entra1");
            while (r != null && !sw) {
                Museo mx = (Museo) r.getMuseo();
                String idMx = "(" + mx.getId() + ") " + mx.getNombre();
                if (idMx.equals(comboBoxMuseosArtista.getSelectedItem().toString())) {
                    System.out.println("Entra2");
                    LSSala lsx = mx.getListaSalas();
                    NodoS w = lsx.getP();
                    while (w != null && !sw) {
                        Sala sx = (Sala) w.getSala();
                        if (comboBoxSalasArtista.getSelectedItem().equals(sx.getIdSala())) {
                            sw = true;
                            System.out.println("Entra3");
                            LSProduccion lpx = sx.getListaProducciones();
                            NodoP z = lpx.getP();
                            while (z != null) {
                                System.out.println("Escribe");
                                Produccion px = (Produccion) z.getProduccion();
                                System.out.println("crea");
                                comboBoxProduccionesArtista.addItem(px.getNombre());
                                System.out.println("Escribedesp");
                                z = z.getSig();

                            }

                        } else {
                            w = w.getSig();
                        }
                    }

                } else {
                    r = r.getSig();
                }

            }

        }

    }//GEN-LAST:event_comboBoxSalasArtistaItemStateChanged

    private void comboBoxSalasArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSalasArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSalasArtistaActionPerformed

    private void comboBoxProduccionesArtistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxProduccionesArtistaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProduccionesArtistaItemStateChanged

    private void comboBoxProduccionesArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProduccionesArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProduccionesArtistaActionPerformed

    private void generoArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generoArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generoArtistaActionPerformed

    private void apellidoArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoArtistaActionPerformed

    private void categoriaArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaArtistaActionPerformed

    private void generoVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generoVisitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generoVisitanteActionPerformed

    private void comboBoxProduccionesVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProduccionesVisitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProduccionesVisitanteActionPerformed

    private void comboBoxProduccionesVisitanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxProduccionesVisitanteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProduccionesVisitanteItemStateChanged

    private void comboBoxSalasVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSalasVisitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSalasVisitanteActionPerformed

    private void comboBoxSalasVisitanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSalasVisitanteItemStateChanged
        comboBoxProduccionesVisitante.removeAllItems();
        if (comboBoxSalasVisitante.getSelectedIndex() != -1) {
            boolean sw = false;
            NodoM r = listaMuseos.getP();
            while (r != null && !sw) {
                Museo mx = (Museo) r.getMuseo();
                String idMx = "(" + mx.getId() + ") " + mx.getNombre();
                if (idMx.equals(comboBoxMuseosVisitante.getSelectedItem().toString())) {
                    LSSala lsx = mx.getListaSalas();
                    NodoS w = lsx.getP();
                    while (w != null && !sw) {
                        Sala sx = (Sala) w.getSala();
                        if (comboBoxSalasVisitante.getSelectedItem().equals(sx.getIdSala())) {
                            LSProduccion lpx = sx.getListaProducciones();
                            NodoP z = lpx.getP();
                            sw = true;
                            while (z != null) {
                                Produccion px = (Produccion) z.getProduccion();
                                comboBoxProduccionesVisitante.addItem(px.getNombre());
                                z = z.getSig();

                            }

                        } else {
                            w = w.getSig();
                        }
                    }

                } else {
                    r = r.getSig();
                }

            }

        }

    }//GEN-LAST:event_comboBoxSalasVisitanteItemStateChanged
    
    private void comboBoxMuseosVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMuseosVisitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMuseosVisitanteActionPerformed
    private void agregarVisitanteAProduccion(String idMuseo, String idSala, String nombreProduccion, Visitante x){
        NodoM r = listaMuseos.getP();
        boolean sw = false;
        while (r != null && !sw) {
            Museo mx = (Museo) r.getMuseo();
            String idMx = "(" + mx.getId() + ") " + mx.getNombre();
            if (idMx.equals(idMuseo)) {
                LSSala lsx = mx.getListaSalas();
                NodoS w = lsx.getP();
                while (w != null && !sw) {
                    Sala sx = (Sala) w.getSala();
                    if (idSala.equals(sx.getIdSala())) {
                        LSProduccion lpx = sx.getListaProducciones();
                        NodoP z = lpx.getP();
                        while (z != null && !sw) {
                            Produccion px = (Produccion) z.getProduccion();
                            if (px.getNombre().equals(nombreProduccion)) {
                                px.getListaVisitantes().adiFinal(x);
                                System.out.println("Se logro");
                                sw = true;
                            } else {
                                z = z.getSig();
                            }

                        }

                    }

                    w = w.getSig();
                }

            } else {
                r = r.getSig();
            }
        }
    }
    private void comboBoxMuseosVisitanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMuseosVisitanteItemStateChanged
        if (comboBoxMuseosVisitante.getSelectedIndex() != -1) {
            comboBoxSalasVisitante.removeAllItems();
            NodoM r = listaMuseos.getP();
            while (r != null) {
                Museo mx = (Museo) r.getMuseo();
                String idMx = "(" + mx.getId() + ") " + mx.getNombre();
                if (idMx.equals(comboBoxMuseosVisitante.getSelectedItem().toString())) {
                    LSSala lsx = mx.getListaSalas();
                    NodoS w = lsx.getP();
                    while (w != null) {
                        Sala sx = (Sala) w.getSala();
                        comboBoxSalasVisitante.addItem(sx.getIdSala());
                        w = w.getSig();
                    }
                    break;
                } else {
                    r = r.getSig();
                }

            }

        }
    }//GEN-LAST:event_comboBoxMuseosVisitanteItemStateChanged

    private void agregarVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarVisitanteActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null, "¿Está seguro de agregar al visitante?", "Add Record", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {

                // Obtener datos de los campos de texto
                String nombre, apellido, genero;
                int ci = Integer.parseInt(ciVisitante.getText());
                nombre = nombreVisitante.getText();
                apellido = apellidoVisitante.getText();
                genero = generoVisitante.getSelectedItem().toString();
                int idT = Integer.parseInt(idTicket.getText());
                // Validacion de campos no vacios
                if (nombre.equals("") || apellido.equals("") || genero.equals("") || ciVisitante.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos",
                            "Error al registrar el visitante", JOptionPane.ERROR_MESSAGE);

                } else {
                    //int ci, String nombre, String apellido, String genero, String tipo
                    Visitante vx = new Visitante(ci, nombre, apellido, genero, idT);
                    agregarVisitanteAProduccion(comboBoxMuseosVisitante.getSelectedItem().toString(), comboBoxSalasVisitante.getSelectedItem().toString(), comboBoxProduccionesVisitante.getSelectedItem().toString(), vx);
                    //listaProducciones.adiFin(px);

                    panel5.datosATabla();
                    JOptionPane.showMessageDialog(null, "Visitante registrado exitosamente");
                    //reset();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
        

    }//GEN-LAST:event_agregarVisitanteActionPerformed

    private void salirBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirBtn3ActionPerformed

    private void apellidoVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoVisitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoVisitanteActionPerformed

    private void idTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idTicketMouseClicked
        // TODO add your handling code here:
        NodoM r = listaMuseos.getP();
        boolean sw = false;
        while (r != null && !sw) {
            Museo mx = (Museo) r.getMuseo();
            String idMx = "(" + mx.getId() + ") " + mx.getNombre();
            if (idMx.equals(comboBoxMuseosVisitante.getSelectedItem().toString())) {
                System.out.println("Entra1");
                LSSala lsx = mx.getListaSalas();
                NodoS w = lsx.getP();
                while (w != null && !sw) {
                    Sala sx = (Sala) w.getSala();
                    if ((comboBoxSalasVisitante.getSelectedItem().toString()).equals(sx.getIdSala())) {
                        System.out.println("Entra2");
                        LSProduccion lpx = sx.getListaProducciones();
                        NodoP z = lpx.getP();
                        while (z != null && !sw) {
                            Produccion px = (Produccion) z.getProduccion();
                            if (px.getNombre().equals(comboBoxProduccionesVisitante.getSelectedItem().toString())) {
                                System.out.println("Entra3");
                                int idT = px.getListaVisitantes().nroNodos()+1;
                                idTicket.setText(String.format("%d", idT));
                                sw = true;
                            } else {
                                z = z.getSig();
                            }

                        }

                    }

                    w = w.getSig();
                }

            } else {
                r = r.getSig();
            }
        }
        
    }//GEN-LAST:event_idTicketMouseClicked

    public void cargarEstructurasArchivo() throws IOException{
        LinkedList<Object> estruct = arch.leerEstructuras();
        ListIterator<Object> it = estruct.listIterator();
        int c = 0;
        while(it.hasNext()){
            if (c == 0)
                listaMuseos = (LSMuseo) it.next();
            //else if (c == 1)
            //    listaArtistas = (LSArtista) it.next();
            c++;
        }
    }
    public void guardarEstructurasArchivo() throws IOException{
        LinkedList<Object> estruct = new LinkedList<>();
        estruct.addLast(listaMuseos);
        //estruct.addLast(listaArtistas);
        arch.guardarEstructuras(estruct);
    }
    
    private void addVisitanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addVisitanteKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_addVisitanteKeyPressed

    private void idTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTicketActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_idTicketActionPerformed

    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
        // TODO add your handling code here:
        onLeaveClick(btn1);
        onLeaveClick(btn2);
        onLeaveClick(btn3);
        onLeaveClick(btn4);
        onClick(btn7);
        onLeaveClick(btn8);
        setPanel(panel5);
    }//GEN-LAST:event_btn7MouseClicked

    private void museumDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_museumDetailsMouseClicked
        // TODO add your handling code here:
        setPanel(buscarPanelMuseo);
        
    }//GEN-LAST:event_museumDetailsMouseClicked

    private void deleteMuseumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMuseumMouseClicked
        // TODO add your handling code here:
        setPanel(panelSalasProducciones);
        
    }//GEN-LAST:event_deleteMuseumMouseClicked

    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        // TODO add your handling code here:
        onLeaveClick(btn1);
        onLeaveClick(btn2);
        onLeaveClick(btn3);
        onLeaveClick(btn4);
        onLeaveClick(btn7);
        onClick(btn8);
        setPanel(panelSalas);
    }//GEN-LAST:event_btn8MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            guardarEstructurasArchivo();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addArtist;
    private javax.swing.JPanel addArtista;
    private javax.swing.JPanel addMuseum;
    private javax.swing.JPanel addVisitante;
    private javax.swing.JButton agregarMuseoBtn;
    private javax.swing.JButton agregarProduccion;
    private javax.swing.JButton agregarProduccion1;
    private javax.swing.JButton agregarSalasBtn1;
    private javax.swing.JButton agregarVisitante;
    private javax.swing.JTextField apellidoArtista;
    private javax.swing.JTextField apellidoVisitante;
    private javax.swing.JPanel btn1;
    private javax.swing.JPanel btn2;
    private javax.swing.JPanel btn3;
    private javax.swing.JPanel btn4;
    private javax.swing.JPanel btn5;
    private javax.swing.JPanel btn6;
    private javax.swing.JPanel btn7;
    private javax.swing.JPanel btn8;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categoriaArtista;
    private javax.swing.JPanel centrePanel;
    private javax.swing.JTextField ciArtista;
    private javax.swing.JTextField ciVisitante;
    private javax.swing.JComboBox<String> circuitoMuseo;
    private javax.swing.JComboBox<String> comboBoxMuseos;
    private javax.swing.JComboBox<String> comboBoxMuseosArtista;
    private javax.swing.JComboBox<String> comboBoxMuseosVisitante;
    private javax.swing.JComboBox<String> comboBoxProduccionesArtista;
    private javax.swing.JComboBox<String> comboBoxProduccionesVisitante;
    private javax.swing.JComboBox<String> comboBoxSalas;
    private javax.swing.JComboBox<String> comboBoxSalasArtista;
    private javax.swing.JComboBox<String> comboBoxSalasVisitante;
    private javax.swing.JPanel deleteArtist;
    private javax.swing.JPanel deleteArtista;
    private javax.swing.JPanel deleteMuseum;
    private javax.swing.JPanel deleteVisitante;
    private javax.swing.JPanel detailsArtist;
    private javax.swing.JTextField direccionMuseo;
    private com.toedter.calendar.JDateChooser fechaProduccion;
    private javax.swing.JComboBox<String> generoArtista;
    private javax.swing.JComboBox<String> generoVisitante;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JSpinner horaProduccion;
    private javax.swing.JRadioButton idMuseo;
    private javax.swing.JRadioButton idTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblNameAdm;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSpinner minutoProduccion;
    private javax.swing.JPanel museumDetails;
    private javax.swing.JTextField nombreArtista;
    private javax.swing.JTextField nombreMuseo;
    private javax.swing.JTextField nombreProduccion;
    private javax.swing.JTextField nombreVisitante;
    private javax.swing.JSpinner nroEntradasProduccion;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p11;
    private javax.swing.JPanel p11_addArtistaPanel;
    private javax.swing.JPanel p11_addVisitantePanel;
    private javax.swing.JPanel p1_addMuseumPanel;
    private javax.swing.JPanel p1_addProduccionPanel;
    private javax.swing.JTextField precioProduccion;
    private javax.swing.JButton salirBtn;
    private javax.swing.JButton salirBtn1;
    private javax.swing.JButton salirBtn2;
    private javax.swing.JButton salirBtn3;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JComboBox<String> tipoMuseo;
    private javax.swing.JComboBox<String> tipoProduccion;
    private javax.swing.JPanel updateArtist;
    private javax.swing.JPanel updateMuseum;
    private javax.swing.JPanel updateMuseum1;
    private javax.swing.JPanel updateVisitante;
    private javax.swing.JPanel verArtista;
    private javax.swing.JPanel verVisitante;
    // End of variables declaration//GEN-END:variables
}
