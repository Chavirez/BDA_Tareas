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
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table (name = "tblDireccion")
public class DireccionEntidad implements Serializable {

    @Id
    @Column(name = "idDireccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    @Column(name = "calle", length = 50, nullable = false)
    private String calle;
    
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    
    @Column(name = "colonia", length = 50, nullable = false)
    private String colonia;
    
    @ManyToOne(cascade = {CascadeType.REMOVE})

    @JoinColumn(name = "idAlumno", nullable = false)
    private AlumnoEntidad alumno;
    
    public DireccionEntidad(){}

    public DireccionEntidad(String calle, String numero, String colonia, AlumnoEntidad alumno) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.alumno = alumno;
    }

    
    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }


    public AlumnoEntidad getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntidad alumno) {
        this.alumno = alumno;
    }

    
    
    
    
}
