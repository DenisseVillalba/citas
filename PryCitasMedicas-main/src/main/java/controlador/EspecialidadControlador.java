
package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;

public class EspecialidadControlador {
    private ArrayList<EspecialidadModelo> especialidadModelos;
    private static EspecialidadControlador instancia;

    private EspecialidadControlador() {
        this.especialidadModelos = new ArrayList<>();
    }
    
    public static EspecialidadControlador getInstancia(){
        if(instancia == null){
            instancia = new EspecialidadControlador();
        }
        return instancia;
    }
    
    public EspecialidadModelo guardar(String id, String nombre){
        EspecialidadModelo modelo = new EspecialidadModelo(id, nombre);
        especialidadModelos.add(modelo);
        return modelo;
    }
    
    public ArrayList<EspecialidadModelo> listado(){
        return especialidadModelos;
    }
    
    public EspecialidadModelo obtenerPorId(String id){
        for (EspecialidadModelo especialidadModelo : especialidadModelos) {
            if (especialidadModelo.getId().equals(id)) {
                return especialidadModelo;
            }
        }
        return null;
    }
    public EspecialidadModelo obtenerPorNombre(String nombre) {
        for (EspecialidadModelo especialidadModelo : especialidadModelos) {
            if (especialidadModelo.getNombre().equalsIgnoreCase(nombre)) {
                return especialidadModelo;
            }
        }
        return null; // Retorna null si no encuentra coincidencias
    }
}
