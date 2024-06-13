/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrator
 */
@Entity
public class CursoEntidad implements Serializable {

    @Id
    @Column(name = "idCurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "CursoEntidad", cascade = {CascadeType.PERSIST})
    private List<AlumnoCursoEntidad> alumnos;

    public CursoEntidad() {

    }

    public CursoEntidad(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AlumnoCursoEntidad> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoCursoEntidad> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
    
}
