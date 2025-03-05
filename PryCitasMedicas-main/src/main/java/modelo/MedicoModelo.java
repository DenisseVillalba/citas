
package modelo;

public class MedicoModelo extends PacienteModelo{
    
    public EspecialidadModelo especialidadModelo;

    public MedicoModelo(EspecialidadModelo especialidadModelo, String cedula, String nombres, int edad, boolean sexo) {
        super(cedula, nombres, edad, sexo);
        this.especialidadModelo = especialidadModelo;
    }

    public EspecialidadModelo getEspecialidadModelo() {
        return especialidadModelo;
    }
    
    public void setEspecialidadModelo(EspecialidadModelo especialidadModelo) {
        this.especialidadModelo = especialidadModelo;
    }
    
    
}
