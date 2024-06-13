/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpa_249522;

import Entidades.AlumnoCursoEntidad;
import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import Entidades.CursoEntidad;
import Entidades.DireccionEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Administrator
 */
public class AlumnoDAO {
    
    public AlumnoDAO(){}
    
    public void guardar(){
    
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
    EntityManager entityManager = managerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    AlumnoEntidad alumno = new  AlumnoEntidad("Santiago","Sanchez","Chavira");
    entityManager.persist(alumno);
    entityManager.getTransaction().commit();
    entityManager.close();
    managerFactory.close();
    }
    
    public void modificar(long id){
    
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
    EntityManager entityManager = managerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    AlumnoEntidad alumno = entityManager.find(AlumnoEntidad.class, id);
    
    alumno.setApellidoMaterno("Materno");
    alumno.setApellidoPaterno("Paterno");
    alumno.setNombres("Nombres");
    
    entityManager.persist(alumno);
    entityManager.getTransaction().commit();
    entityManager.close();
    managerFactory.close();
    }

    public void eliminar(long id){
    
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
    EntityManager entityManager = managerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    AlumnoEntidad alumno = entityManager.find(AlumnoEntidad.class, id);
    
    entityManager.remove(alumno);
    entityManager.getTransaction().commit();
    entityManager.close();
    managerFactory.close();
    }        
    
    public void guardarConRelacion(){
    
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
    EntityManager entityManager = managerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    AlumnoEntidad alumno = new  AlumnoEntidad("Santiago","Sanchez","Chavira");
    
    List<DireccionEntidad> direcciones = new ArrayList<>();
    DireccionEntidad direccionUNO = 
            new DireccionEntidad("Calle", "Numero", "Colonia", alumno);
    direcciones.add(direccionUNO);
    
    
    alumno.setDirecciones(direcciones);
    
    entityManager.persist(alumno);
    entityManager.getTransaction().commit();
    entityManager.close();
    managerFactory.close();
    }
        
public void guardarConRelacionCarrera(){
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
    
    EntityManager entityManager = managerFactory.createEntityManager();
    
    entityManager.getTransaction().begin();
    
    AlumnoEntidad alumno = new AlumnoEntidad("Romina","Meza","Galindo");
    
    List<DireccionEntidad> direcciones = new ArrayList<>();
    
    DireccionEntidad direccionUNO= new DireccionEntidad("Paseo","012","Miravalle", alumno);
    
    direcciones.add(direccionUNO);
    
    DireccionEntidad direccionDOS= new DireccionEntidad("Nainari","1015","Miravalle", alumno);
    
    direcciones.add(direccionDOS);
    
    CarreraEntidad carreraUNO = new CarreraEntidad("Nutricion", alumno);
    
    alumno.setCarrera(carreraUNO);
    
    alumno.setDirecciones(direcciones);
    
    entityManager.persist(alumno);
        
    entityManager.getTransaction().commit();
        
    System.out.println("Operacion terminada exitosamente");
        
    entityManager.close();
        
    managerFactory.close();
}
    
public void guardarConRelacionCurso(){
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
    
    EntityManager entityManager = managerFactory.createEntityManager();
    
    entityManager.getTransaction().begin();
    
    AlumnoEntidad alumno = new AlumnoEntidad("Santiago","Sanchez","Chavira");
    
    List<DireccionEntidad> direcciones = new ArrayList<>();
    
    DireccionEntidad direccionUNO= new DireccionEntidad("Paseo2","012","Miravalle", alumno);
    
    direcciones.add(direccionUNO);
    
    DireccionEntidad direccionDOS= new DireccionEntidad("Nainari2","1015","Miravalle", alumno);
    
    direcciones.add(direccionDOS);
    
    CarreraEntidad carreraUNO = new CarreraEntidad("Software", alumno);
    
    CursoEntidad cursoUNO = new CursoEntidad("BDA");
    
    AlumnoCursoEntidad acUNO = new AlumnoCursoEntidad(alumno, cursoUNO);
    
    alumno.setCarrera(carreraUNO);
    
    alumno.setDirecciones(direcciones);
    
    entityManager.persist(acUNO);
        
    entityManager.getTransaction().commit();
        
    System.out.println("Operacion terminada exitosamente");
        
    entityManager.close();
        
    managerFactory.close();
}    
    
}    

