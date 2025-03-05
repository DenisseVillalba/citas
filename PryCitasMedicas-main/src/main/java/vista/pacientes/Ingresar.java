package vista.pacientes;

import controlador.PacienteCoontrolador;
import javax.swing.JOptionPane;
import modelo.PacienteModelo;
import vista.citas.ListarCitas;


public class Ingresar extends javax.swing.JInternalFrame {

    
    public Ingresar() {
        initComponents();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(cbx_sexo, 0, 309, Short.MAX_VALUE))))
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
                .addGap(26, 26, 26)
                .addComponent(btn_guardar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
    String cedula = txt_cedula.getText().trim();
    String nombres = txt_nombres.getText().trim();
    String edadTexto = txt_edad.getText().trim();
    String sexoSeleccionado = cbx_sexo.getSelectedItem().toString();

    // Verificar que todos los campos estén llenos
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
    PacienteCoontrolador pacienteCoontrolador = PacienteCoontrolador.getInstacia();
    if (pacienteCoontrolador.obtenercedula(cedula) != null) {
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
    boolean sexo = sexoSeleccionado.equals("HOMBRE");

    // Validar coherencia entre nombre y sexo
    if ((sexo && nombres.matches(".*[aA]na|.*[oO]lga|.*[eE]lena")) || 
        (!sexo && nombres.matches(".*[jJ]uan|.*[cC]arlos|.*[pP]edro"))) {
        JOptionPane.showMessageDialog(this, "El sexo seleccionado no coincide con el nombre ingresado.");
        return;
    }

    // Guardar el paciente si todas las validaciones pasan
    PacienteModelo pm = pacienteCoontrolador.guardarDatos(cedula, nombres, edad, sexo);

    JOptionPane.showMessageDialog(this, pm.getNombres() + " INGRESADO EXITOSAMENTE.");

    // Limpiar campos después de guardar
    txt_cedula.setText("");
    txt_nombres.setText("");
    txt_edad.setText("");
    cbx_sexo.setSelectedIndex(0);
        
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbx_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
