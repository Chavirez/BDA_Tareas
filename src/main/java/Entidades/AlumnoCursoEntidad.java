/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tblAlumnoCurso")
public class AlumnoCursoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne (cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idAlumno", nullable  = false)
    private AlumnoEntidad alumnoEntidad;
    
    @ManyToOne (cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idCurso", nullable  = false)
    private CursoEntidad cursoEntidad;

    public AlumnoCursoEntidad() {
    }
    
     
    
    
    public AlumnoCursoEntidad(AlumnoEntidad alumnoEntidad, CursoEntidad cursoEntidad) {
        this.alumnoEntidad = alumnoEntidad;
        this.cursoEntidad = cursoEntidad;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoEntidad getAlumnoEntidad() {
        return alumnoEntidad;
    }

    public void setAlumnoEntidad(AlumnoEntidad alumnoEntidad) {
        this.alumnoEntidad = alumnoEntidad;
    }

    public CursoEntidad getCursoEntidad() {
        return cursoEntidad;
    }

    public void setCursoEntidad(CursoEntidad cursoEntidad) {
        this.cursoEntidad = cursoEntidad;
    }
    
    
}
