package com.ipn.academico.crud;

import java.io.Serializable;
import java.util.Date;

public class ProgramaAcademico implements Serializable {
    private Long idProgramaAcademico;
    private String nombre;
    private String descripcion;
    private Date fecha;

    public ProgramaAcademico() {}

    public ProgramaAcademico(Long id, String nombre, String descripcion, Date fecha) {
        this.idProgramaAcademico = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getIdProgramaAcademico() { return idProgramaAcademico; }
    public void setIdProgramaAcademico(Long id) { this.idProgramaAcademico = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "ProgramaAcademico{" + "id=" + idProgramaAcademico + ", nombre='" + nombre + '\'' + 
               ", descripcion='" + descripcion + '\'' + ", fecha=" + fecha + '}';
    }
}
