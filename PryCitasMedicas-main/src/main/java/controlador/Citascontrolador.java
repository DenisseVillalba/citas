package controlador;

import java.io.*;
import java.util.ArrayList;
import modelo.Citasmodelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class Citascontrolador {
    private ArrayList<Citasmodelo> citasmodelo;
    private static Citascontrolador instancia;
    private static final String ARCHIVO_CITAS = "citas.dat"; // Archivo para persistencia

    private Citascontrolador() {
        citasmodelo = cargarCitasDesdeArchivo();
    }

    public static Citascontrolador getintancia() {
        if (instancia == null) {
            instancia = new Citascontrolador();
        }
        return instancia;
    }

    public Citasmodelo guardar(PacienteModelo pm, MedicoModelo mm, EspecialidadModelo em, String descripcion, String fecha, String hora, String estado) {
        Citasmodelo cm = new Citasmodelo(pm, mm, em, descripcion, fecha, hora, estado);
        citasmodelo.add(cm);
        guardarCitasEnArchivo();
        return cm;
    }

    public ArrayList<Citasmodelo> listadoCompleto() {
        return citasmodelo;
    }

    private void guardarCitasEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CITAS))) {
            out.writeObject(citasmodelo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Citasmodelo> cargarCitasDesdeArchivo() {
        File archivo = new File(ARCHIVO_CITAS);
        if (!archivo.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_CITAS))) {
            return (ArrayList<Citasmodelo>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
