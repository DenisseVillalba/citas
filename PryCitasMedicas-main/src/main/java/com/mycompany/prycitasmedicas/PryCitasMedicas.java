package com.mycompany.prycitasmedicas;

import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteCoontrolador;
import vista.PantallaPrincipal;

public class PryCitasMedicas {

    public static void main(String[] args) {
       
        PacienteCoontrolador pc = PacienteCoontrolador.getInstacia();
        EspecialidadControlador ec = EspecialidadControlador.getInstancia();
        MedicoControlador mc = MedicoControlador.getInstacia();
        
        
        PantallaPrincipal pp = new PantallaPrincipal();
        pp.setVisible(true);
        pp.setLocationRelativeTo(null);
    }
}