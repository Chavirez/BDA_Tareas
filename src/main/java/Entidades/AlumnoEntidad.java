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
@Table (name = "tblAlumnos")
public class AlumnoEntidad implements Serializable {
    
    @Id
    @Column (name = "idAlumno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "nombres",length = 50, nullable = false)
    private String nombres;
    
    @Column(name = "apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", length = 50, nullable = true)
    private String apellidoMaterno;
    
    @OneToMany(mappedBy = "alumno", cascade = {CascadeType.PERSIST})
    private List<DireccionEntidad> direcciones;
    
    @OneToMany(mappedBy = "alumnoEntidad", cascade = {CascadeType.PERSIST})
    private List<AlumnoCursoEntidad> cursos;
        
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idCarrera")
    private CarreraEntidad carrera;


    public AlumnoEntidad(){
    }
    
    public AlumnoEntidad(String nombre, String apellidoP, String apellidoM){
        this.nombres = nombre;
        this.apellidoPaterno = apellidoP;
        this.apellidoMaterno = apellidoM;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public List<DireccionEntidad> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionEntidad> direcciones) {
        this.direcciones = direcciones;
    }

    public CarreraEntidad getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraEntidad carrera) {
        this.carrera = carrera;
    }

    public List<AlumnoCursoEntidad> getCursos() {
        return cursos;
    }

    public void setCursos(List<AlumnoCursoEntidad> cursos) {
        this.cursos = cursos;
    }
    
    

    

    
    
}
