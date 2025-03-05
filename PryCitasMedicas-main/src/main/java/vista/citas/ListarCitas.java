package vista.citas;

import controlador.Citascontrolador;
import modelo.Citasmodelo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListarCitas extends javax.swing.JInternalFrame {
    private Citascontrolador cc = Citascontrolador.getintancia();

    public ListarCitas() {
        initComponents();
        actualizarTablaCitas();
    }

    public void actualizarTablaCitas() {
        DefaultTableModel modelo = (DefaultTableModel) tblListadoCitas.getModel();
        modelo.setRowCount(0);

        List<Citasmodelo> citas = cc.listadoCompleto();
        for (Citasmodelo cita : citas) {
            modelo.addRow(new Object[]{
                cita.getFecha(), cita.getHora(),
                cita.getEm().getNombre(), cita.getMm().getNombres(), cita.getMm().getCedula(),
                cita.getPm().getNombres(), cita.getPm().getCedula(),
                cita.getEstado(), cita.getDescripcion()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bxcfiltrarestado = new javax.swing.JComboBox<>();
        bcxfiltrarpaciente = new javax.swing.JComboBox<>();
        bcxfiltrarespecialidad = new javax.swing.JComboBox<>();
        bcxfiltrarmedicos = new javax.swing.JComboBox<>();
        txtfiltrarporfecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnbuscador = new javax.swing.JButton();
        ContenedorCitas = new javax.swing.JScrollPane();
        tblListadoCitas = new javax.swing.JTable();

        jLabel1.setText("FILTRAR POR ESTADO:");

        jLabel2.setText("FILTRAR POR PACIENTE:");

        jLabel3.setText("FILTRAR POR ESPECIALIDADES:");

        jLabel4.setText("FILTRAR POR MEDICOS:");

        jLabel5.setText("FILTRAR POR FECHA ESPECIFICA:");

        bxcfiltrarestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATENDIDO ", "NO ATENDIDO" }));

        jLabel6.setText("BUSCADOR ");

        btnbuscador.setText("BUSCAR");
        btnbuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscadorActionPerformed(evt);
            }
        });

        tblListadoCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FECHA", "HORA", "ESPECIALIDAD", "NOMBRE MEDICO", "CEDULA MEDICO ", "NOMBRE PACIENTE", "CEDULA PACIENTE", "ATENDIDO", "OBSERVACIONES"
            }
        ));
        ContenedorCitas.setViewportView(tblListadoCitas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(60, 60, 60)
                            .addComponent(bxcfiltrarestado, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtfiltrarporfecha))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bcxfiltrarpaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bcxfiltrarespecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bcxfiltrarmedicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ContenedorCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(bxcfiltrarestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(bcxfiltrarpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(bcxfiltrarespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addComponent(bcxfiltrarmedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtfiltrarporfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnbuscador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContenedorCitas, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscadorActionPerformed
    actualizarTablaCitas();
    }//GEN-LAST:event_btnbuscadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ContenedorCitas;
    private javax.swing.JComboBox<String> bcxfiltrarespecialidad;
    private javax.swing.JComboBox<String> bcxfiltrarmedicos;
    private javax.swing.JComboBox<String> bcxfiltrarpaciente;
    private javax.swing.JButton btnbuscador;
    private javax.swing.JComboBox<String> bxcfiltrarestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTable tblListadoCitas;
    private javax.swing.JTextField txtfiltrarporfecha;
    // End of variables declaration//GEN-END:variables
}
