package vista.citas;

import controlador.Citascontrolador;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteCoontrolador;
import modelo.Citasmodelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;
import javax.swing.*;

public class Ingresar extends javax.swing.JInternalFrame {

    private ListarCitas listarCitasInstance; // Referencia a ListarCitas
    
    PacienteCoontrolador pc = PacienteCoontrolador.getInstacia();
    EspecialidadControlador ec = EspecialidadControlador.getInstancia();
    MedicoControlador mc = MedicoControlador.getInstacia();
    Citascontrolador cc = Citascontrolador.getintancia();

    // 🔥 Constructor que recibe la instancia de ListarCitas
    public Ingresar(ListarCitas listarCitas) {
        this.listarCitasInstance = listarCitasInstance;
        initComponents();
        
        cargarPacienteAutomaticamente();
        cargarEspecialidadAutomaticamente();
        
        // Carga de médicos por especialidad
        cbx_especialidades.addActionListener(e -> {
            String nombreEspecialidad = cbx_especialidades.getSelectedItem().toString();
            if (!nombreEspecialidad.equals("SELECCIONE ESPECIALIDAD")) {
                cargarAutomaticamenteMedicos(nombreEspecialidad);
            }
        });
    }

    private void cargarAutomaticamenteMedicos(String especialidad) {
        cbx_medicos.removeAllItems();
        for (MedicoModelo medico : mc.listadoPorEspecialidad(especialidad)) {
            cbx_medicos.addItem(medico.getCedula() + " " + medico.getNombres());
        }
    }

    private void cargarPacienteAutomaticamente() {
        for (PacienteModelo paciente : pc.listadoCompleto()) {
            cbx_pacientes.addItem(paciente.getCedula() + " " + paciente.getNombres());
        }
    }

    private void cargarEspecialidadAutomaticamente() {
        cbx_especialidades.addItem("SELECCIONE ESPECIALIDAD");
        for (EspecialidadModelo especialidad : ec.listado()) {
            cbx_especialidades.addItem(especialidad.getNombre());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbx_pacientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbx_especialidades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbx_medicos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxestado = new javax.swing.JComboBox<>();

        jLabel1.setText("SELECIONA PACIENTE");

        jLabel2.setText("SELECION ESPECIALIDAD");

        jLabel3.setText("SELECIONE MEDICO");

        jLabel4.setText("OBSERVACIONES");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        jLabel5.setText("FECHA");

        jLabel6.setText("HORA");

        jLabel7.setText("dd/mm/aa");

        jLabel8.setText("hh:mm");

        btn_guardar.setText("GENERAR TURNO");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jLabel9.setText("ESTADO:");

        cbxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATENDIDO", "NO ATENDIDO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbx_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbx_especialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbx_medicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_hora))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)))
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbx_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbx_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_guardar)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
    String nombrePaciente = cbx_pacientes.getSelectedItem().toString();
        String[] pacientePartes = nombrePaciente.split(" ");
        String cedulaPaciente = pacientePartes[0];
        PacienteModelo pm = pc.obtenercedula(cedulaPaciente);

        String nombreMedico = cbx_medicos.getSelectedItem().toString();
        String[] medicoPartes = nombreMedico.split(" ");
        String cedulaMedico = medicoPartes[0];
        MedicoModelo mm = mc.obtenercedula(cedulaMedico);

        EspecialidadModelo em = mm.getEspecialidadModelo();
        String estado = cbxestado.getSelectedItem().toString(); 

        Citasmodelo cm = cc.guardar(pm, mm, em, txt_descripcion.getText(), txt_fecha.getText(), txt_hora.getText(), estado);

        JOptionPane.showMessageDialog(this, "CITA INGRESADA PARA EL DÍA: " + cm.getFecha() +
                " PARA LAS " + cm.getHora() +
                " CON EL MÉDICO " + cm.getMm().getNombres() +
                " Y LA ESPECIALIDAD " + cm.getEm().getNombre() +
                " ESTADO: " + cm.getEstado());

        if (listarCitasInstance != null) {
            listarCitasInstance.actualizarTablaCitas();
        }    
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbx_especialidades;
    private javax.swing.JComboBox<String> cbx_medicos;
    private javax.swing.JComboBox<String> cbx_pacientes;
    private javax.swing.JComboBox<String> cbxestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_hora;
    // End of variables declaration//GEN-END:variables
}
