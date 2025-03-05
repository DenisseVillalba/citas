package modelo;

import java.io.Serializable;

public class Citasmodelo implements Serializable {
    private PacienteModelo pm;
    private MedicoModelo mm;
    private EspecialidadModelo em;
    private String descripcion;
    private String fecha;
    private String hora;
    private String estado;

    public Citasmodelo(PacienteModelo pm, MedicoModelo mm, EspecialidadModelo em, String descripcion, String fecha, String hora, String estado) {
        this.pm = pm;
        this.mm = mm;
        this.em = em;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public PacienteModelo getPm() { return pm; }
    public void setPm(PacienteModelo pm) { this.pm = pm; }

    public MedicoModelo getMm() { return mm; }
    public void setMm(MedicoModelo mm) { this.mm = mm; }

    public EspecialidadModelo getEm() { return em; }
    public void setEm(EspecialidadModelo em) { this.em = em; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
