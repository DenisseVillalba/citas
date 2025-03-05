/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.medicos;

import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteCoontrolador;
import javax.swing.JOptionPane;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

/**
 *
 * @author Laboratorios DCCO
 */
public class Ingresar extends javax.swing.JInternalFrame {

    EspecialidadControlador  ec=EspecialidadControlador.getInstancia();
   
    public Ingresar() {
        initComponents();
        
        for (EspecialidadModelo em : ec.listado()) {
            cbx_especialidades.addItem(em.getNombre());
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_edad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        cbx_sexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbx_especialidades = new javax.swing.JComboBox<>();

        jLabel1.setText("CEDULA");

        jLabel2.setText("NOMBRES");

        jLabel3.setText("EDAD");

        jLabel4.setText("SEXO");

        btn_guardar.setText("GUARDAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        cbx_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOMBRE", "MUJER" }));

        jLabel5.setText("ESPECIALIDAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cedula)
                                    .addComponent(txt_nombres)
                                    .addComponent(txt_edad)
                                    .addComponent(cbx_sexo, 0, 309, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_especialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbx_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btn_guardar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
        String cedula = txt_cedula.getText().trim();
    String nombres = txt_nombres.getText().trim();
    String edadTexto = txt_edad.getText().trim();
    String nombreEspecialidad = cbx_especialidades.getSelectedItem().toString();

    // Validar que todos los campos estén llenos
    if (cedula.isEmpty() || nombres.isEmpty() || edadTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Llenar todos los campos.");
        return;
    }

    // Validar que la cédula tenga exactamente 10 dígitos numéricos
    if (!cedula.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(this, "La cédula debe tener exactamente 10 dígitos numéricos.");
        return;
    }

    // Validar que la cédula no esté repetida
    MedicoControlador mc = MedicoControlador.getInstacia();
    if (mc.obtenercedula(cedula) != null) {
        JOptionPane.showMessageDialog(this, "La cédula ingresada ya existe. Ingrese una cédula diferente.");
        return;
    }

    // Validar que el nombre solo contenga letras
    if (!nombres.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
        return;
    }

    // Validar que la edad solo contenga números
    if (!edadTexto.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.");
        return;
    }

    int edad = Integer.parseInt(edadTexto);
    boolean sexo = cbx_sexo.getSelectedItem().toString().equals("HOMBRE");

    // Obtener la especialidad seleccionada
    EspecialidadControlador ec = EspecialidadControlador.getInstancia();
    EspecialidadModelo em_nombre = ec.obtenerPorNombre(nombreEspecialidad);

    // Guardar el médico
    MedicoModelo mm = mc.guardar(em_nombre, cedula, nombres, edad, sexo);

    JOptionPane.showMessageDialog(this, mm.getNombres() + " INGRESADO EXITOSAMENTE.");

    // Limpiar los campos después de guardar
    txt_cedula.setText("");
    txt_nombres.setText("");
    txt_edad.setText("");
    cbx_sexo.setSelectedIndex(0);
    cbx_especialidades.setSelectedIndex(0);
        
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbx_especialidades;
    private javax.swing.JComboBox<String> cbx_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
