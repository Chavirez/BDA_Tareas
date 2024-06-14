/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Administrator
 */
public class AlumnoDTO {
    
    private String nombreCompleto;
    private String carrera;
    
    public AlumnoDTO(){}

    public AlumnoDTO(String nombreCompleto, String carrera) {
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
}
