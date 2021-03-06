package com.eam.vista.Administrador;

import com.eam.controlador.CtlCarga;
import com.eam.controlador.CtlRuta;
import com.eam.controlador.Main;
import com.eam.modelo.Carga;
import com.eam.modelo.Itinerario;
import com.eam.modelo.Mail;
import com.eam.modelo.Report_EstadoCarga;
import com.eam.modelo.Report_FacturacionDiaria;
import com.eam.modelo.Reporte;
import com.eam.modelo.Ruta;
import com.eam.vista.Cliente.FrmSeleccionFecha;
import com.eam.vista.FrmPrincipal;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public final class FrmAdministrador extends javax.swing.JFrame {

    CtlRuta controRuta;
    CtlCarga controCarga;

    public FrmAdministrador(java.awt.Frame parent) {
        initComponents();
        controRuta = new CtlRuta();
        controCarga = new CtlCarga();
        listarRuta("ACTIVO");
        listarCargaActiva("ACTIVO");
        listarTiposReportes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOrigen_Rutas = new javax.swing.JTextField();
        txtDestino_Rutas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCapacidadTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar_Ruta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRutasActivas = new javax.swing.JTable();
        btnGenerarItinerario_Ruta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAsociarCarga = new javax.swing.JButton();
        btnRegistrar_Ruta3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCargasActivas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCargasRutas = new javax.swing.JTable();
        btnSalir_Ruta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbReportes = new javax.swing.JComboBox<>();
        btnGenerar_Reporte = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        dtcFecha = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrador");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rutas");

        jLabel3.setText("Origen:");

        txtOrigen_Rutas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOrigen_RutasKeyTyped(evt);
            }
        });

        jLabel4.setText("Destino:");

        txtCapacidadTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCapacidadTotalKeyTyped(evt);
            }
        });

        jLabel5.setText("Capacidad Total:");

        btnRegistrar_Ruta.setText("Registrar");
        btnRegistrar_Ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_RutaActionPerformed(evt);
            }
        });

        tblRutasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRutasActivas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRutasActivasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRutasActivas);

        btnGenerarItinerario_Ruta.setText("Generar itinerario");
        btnGenerarItinerario_Ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarItinerario_RutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrigen_Rutas)
                                    .addComponent(txtCapacidadTotal)
                                    .addComponent(txtDestino_Rutas)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 158, Short.MAX_VALUE)
                        .addComponent(btnRegistrar_Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarItinerario_Ruta)
                        .addGap(107, 107, 107))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOrigen_Rutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDestino_Rutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCapacidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar_Ruta, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnGenerarItinerario_Ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cargas");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cargas Activas");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cargas Rutas");

        btnAsociarCarga.setText("Asociar Carga");
        btnAsociarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsociarCargaActionPerformed(evt);
            }
        });

        btnRegistrar_Ruta3.setText("Quitar Carga");
        btnRegistrar_Ruta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_Ruta3ActionPerformed(evt);
            }
        });

        tblCargasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblCargasActivas);

        tblCargasRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblCargasRutas);

        btnSalir_Ruta.setText("Salir");
        btnSalir_Ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir_RutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsociarCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRegistrar_Ruta3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(btnSalir_Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAsociarCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar_Ruta3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir_Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbReportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReportesActionPerformed(evt);
            }
        });

        btnGenerar_Reporte.setText("Generar");
        btnGenerar_Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar_ReporteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Reportes");

        dtcFecha.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnGenerar_Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbReportes, 0, 357, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addComponent(dtcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerar_Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrar_RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_RutaActionPerformed
        String origen = txtOrigen_Rutas.getText().trim();
        String destino = txtDestino_Rutas.getText().trim();
        String capacidadTotal = txtCapacidadTotal.getText().trim();
        Date fechaPartida = new Date();
        String estado = "ACTIVO";

        if (!(origen.isEmpty() || destino.isEmpty() || capacidadTotal.isEmpty())) {
            boolean respuesta = false;
            try {
                respuesta = controRuta.registrarRuta(origen, destino, new BigDecimal(capacidadTotal), estado, fechaPartida);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "[" + e + "]" + " Ha surgido un error, por favor consulte al ingeniero Nicolas Cabitiva");
            }
            if (respuesta) {
                JOptionPane.showMessageDialog(this, "Se ha registrado con exito");
                listarRuta(estado);
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Ha surgido un error al momento de registrar");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        }
    }//GEN-LAST:event_btnRegistrar_RutaActionPerformed

    private void tblRutasActivasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRutasActivasMouseClicked
        int i = tblRutasActivas.getSelectedRow();
        i = Integer.parseInt(tblRutasActivas.getValueAt(i, 0) + "");
        System.out.println(i);

        listarCargaRuta(i + "");
    }//GEN-LAST:event_tblRutasActivasMouseClicked

    private void btnGenerar_ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar_ReporteActionPerformed
        int tipoReporte = cbReportes.getSelectedIndex();
        Date fecha = dtcFecha.getDate();
        switch (tipoReporte) {
            case 0:
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de reporte.");
                return;
            case 1:
                JOptionPane.showMessageDialog(this, "Seleccione la fecha de terminacion del reporte.");
                FrmSeleccionFecha ventanaSeleccionFecha = new FrmSeleccionFecha(this, true, fecha);
                ventanaSeleccionFecha.setLocationRelativeTo(null);
                ventanaSeleccionFecha.setVisible(true);
                break;
            case 2:
                Reporte estadoCarga = new Report_EstadoCarga();
                estadoCarga.generarReporte();
                break;
            case 3:
                Reporte facturacion = new Report_FacturacionDiaria(fecha);
                facturacion.generarReporte();
                break;
            default:
                throw new AssertionError("Error en la seleccion del reporte opcion invalida");
        }
        cbReportes.setSelectedIndex(0);
        dtcFecha.setEnabled(false);
    }//GEN-LAST:event_btnGenerar_ReporteActionPerformed

    private void btnAsociarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsociarCargaActionPerformed
        try {
            int i = tblRutasActivas.getSelectedRow();
            int x = tblCargasActivas.getSelectedRow();
            i = Integer.parseInt(tblRutasActivas.getValueAt(i, 0) + "");
            x = Integer.parseInt(tblCargasActivas.getValueAt(x, 0) + "");

            Carga c = controCarga.traerCarga(x);
            Ruta r = controRuta.traerruta(i);
            Double valor = Double.parseDouble(r.getCapacidadTotal() + "");
            Double valor1 = Double.parseDouble(c.getPeso() + "");

            if (valor1 <= (valor - controRuta.calcularTarifaTotal(r))) {
                controCarga.asociarRuta(c, r);
                listarCargaActiva("ACTIVO");
                listarCargaRuta(i + "");
            } else {
                JOptionPane.showMessageDialog(null, "La carga sobrepasa la ruta");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una carga y/o una ruta " + e);
        }


    }//GEN-LAST:event_btnAsociarCargaActionPerformed

    private void cbReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReportesActionPerformed
        int tipoReporte = cbReportes.getSelectedIndex();
        if (tipoReporte == 3 || tipoReporte == 1) {
            dtcFecha.setEnabled(true);
        } else {
            dtcFecha.setEnabled(false);
        }
    }//GEN-LAST:event_cbReportesActionPerformed

    private void btnRegistrar_Ruta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_Ruta3ActionPerformed
        try {
            int i = tblCargasRutas.getSelectedRow();
            i = Integer.parseInt(tblCargasRutas.getValueAt(i, 0) + "");
            int x = tblRutasActivas.getSelectedRow();
            x = Integer.parseInt(tblRutasActivas.getValueAt(x, 0) + "");
            Carga c = controCarga.traerCarga(i);
            controCarga.quitarRuta(c);

            listarCargaActiva("ACTIVO");
            listarCargaRuta(x + "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una carga y/o una ruta");
        }
    }//GEN-LAST:event_btnRegistrar_Ruta3ActionPerformed

    private void btnGenerarItinerario_RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarItinerario_RutaActionPerformed
        int i = tblRutasActivas.getSelectedRow();
        if (i >= 0) {
            i = Integer.parseInt(tblRutasActivas.getValueAt(i, 0) + "");
            Itinerario itinerario = new Itinerario();
            if (itinerario.generarItinerario(controRuta.traerruta(i))) {
                JOptionPane.showMessageDialog(this, "Las cargas de esta ruta han zarpado.");
                listarRuta("ACTIVO");
                Mail mail = new Mail();
                mail.generarMail(itinerario);
                tblCargasRutas.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                        },
                        new String[]{
                            "Title 1", "Title 2", "Title 3", "Title 4"
                        }
                ));
            } else {
                JOptionPane.showMessageDialog(this, "El barco no ha zarpado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una ruta de la tabla.");
        }
    }//GEN-LAST:event_btnGenerarItinerario_RutaActionPerformed
    private void btnSalir_RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir_RutaActionPerformed
        this.dispose();
        FrmPrincipal frmprincipal = new FrmPrincipal();
        frmprincipal.setLocationRelativeTo(null);
        frmprincipal.setVisible(true);
    }//GEN-LAST:event_btnSalir_RutaActionPerformed

    private void txtOrigen_RutasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrigen_RutasKeyTyped

    }//GEN-LAST:event_txtOrigen_RutasKeyTyped

    private void txtCapacidadTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapacidadTotalKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCapacidadTotalKeyTyped

    public void listarRuta(String estado) {
        tblRutasActivas.setModel(controRuta.listarRutas(estado));
    }

    private void listarCargaActiva(String estado) {
        tblCargasActivas.setModel(controCarga.listarCargas(estado, "estado"));
    }

    private void listarCargaRuta(String estado) {
        tblCargasRutas.setModel(controCarga.listarCargas(estado, "rutaIdruta.idruta"));
    }

    private void Limpiar() {
        txtCapacidadTotal.setText("");
        txtDestino_Rutas.setText("");
        txtOrigen_Rutas.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsociarCarga;
    private javax.swing.JButton btnGenerarItinerario_Ruta;
    private javax.swing.JButton btnGenerar_Reporte;
    private javax.swing.JButton btnRegistrar_Ruta;
    private javax.swing.JButton btnRegistrar_Ruta3;
    private javax.swing.JButton btnSalir_Ruta;
    private javax.swing.JComboBox<String> cbReportes;
    private com.toedter.calendar.JCalendar dtcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblCargasActivas;
    private javax.swing.JTable tblCargasRutas;
    private javax.swing.JTable tblRutasActivas;
    private javax.swing.JTextField txtCapacidadTotal;
    private javax.swing.JTextField txtDestino_Rutas;
    private javax.swing.JTextField txtOrigen_Rutas;
    // End of variables declaration//GEN-END:variables

    private void listarTiposReportes() {
        cbReportes.removeAllItems();
        cbReportes.addItem("Seleccione el tipo de reporte");
        for (Reporte.tiposReportes reporte : Reporte.tiposReportes.values()) {
            cbReportes.addItem(reporte.toString());
        }
    }
}
