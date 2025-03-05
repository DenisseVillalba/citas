
package controlador;

import java.util.ArrayList;
import modelo.PacienteModelo;

public class PacienteCoontrolador {
   public ArrayList<PacienteModelo> pacienteModelosLista;
   private static PacienteCoontrolador instacia;

    private PacienteCoontrolador() {
        this.pacienteModelosLista = new ArrayList<>();
    }
    
    public static PacienteCoontrolador getInstacia(){
        if(instacia==null){
            instacia=new PacienteCoontrolador();
        }
        return instacia;
    }
    
    public PacienteModelo guardarDatos(String cedula, String nombres,int edad, boolean sexo){
        PacienteModelo modeloPaciente=new PacienteModelo(cedula, nombres, edad, sexo);
        pacienteModelosLista.add(modeloPaciente);
        return modeloPaciente;
    }
    
    
    public ArrayList<PacienteModelo> listadoCompleto(){
        return pacienteModelosLista;
    }
   
    public ArrayList<PacienteModelo> listadoCompletoPorCedula(String cedula){
        
        ArrayList<PacienteModelo> nuevoListado=new ArrayList<>();
        
        for (PacienteModelo pm : pacienteModelosLista) {
            if(pm.getCedula().contains(cedula)){
                nuevoListado.add(pm);
            }
        }
        return nuevoListado;
    }
    
    public  PacienteModelo obtenercedula(String Cedula){
        for (PacienteModelo pm : pacienteModelosLista) {
            if (pm.getCedula().equals(Cedula)) {
                
                return pm;
                
            }
            
        }
        return null;
    }
    
}


