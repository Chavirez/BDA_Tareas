/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */

@Entity
@Table (name="tblCarrera")
public class CarreraEntidad implements Serializable {

    @Id
    @Column(name = "idCarrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrera;
    
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @OneToOne(mappedBy = "carrera")
    private AlumnoEntidad alumno;
    
    public CarreraEntidad(){}

    public CarreraEntidad( String nombre, AlumnoEntidad alumno) {
        this.alumno = alumno;
        this.nombre = nombre;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AlumnoEntidad getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntidad alumno) {
        this.alumno = alumno;
    }

    
    
}
