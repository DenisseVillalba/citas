
package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class MedicoControlador {
    ArrayList<MedicoModelo>  medicoModelos;
    private static MedicoControlador instacia;

    private MedicoControlador() {
        this.medicoModelos = new ArrayList<>();
    }
    
    public static MedicoControlador getInstacia(){
         if(instacia==null){
            instacia=new MedicoControlador();
        }
        return instacia;
    }
    
    public MedicoModelo guardar(EspecialidadModelo em,String cedula,String nombres,int edad,boolean  sexo){
        MedicoModelo mm=new MedicoModelo(em, cedula, nombres, edad, sexo);
        medicoModelos.add(mm);
        return mm;
    }
    
    
    public ArrayList<MedicoModelo> listadoCompleto(){
        return medicoModelos;
    }
    
    
    public ArrayList<MedicoModelo> listadoPorEspecialidad(String n_e){
        
         ArrayList<MedicoModelo> nuevoListado=new ArrayList<>();
        
        for (MedicoModelo md : medicoModelos) {
            if(md.getEspecialidadModelo().getNombre().contains(n_e)){
                nuevoListado.add(md);
            }
        }
        return nuevoListado;
    }
    
    public  MedicoModelo obtenercedula(String Cedula){
        for (MedicoModelo mm :medicoModelos) {
            if (mm.getCedula().equals(Cedula)) {
                
                return mm;
                
            }
            
        }
        return null;
    }
    
    
   
}
