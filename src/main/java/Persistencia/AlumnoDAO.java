/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.AlumnoCursoEntidad;
import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import Entidades.CursoEntidad;
import Entidades.DireccionEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    public void leer(){
    
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
 
        EntityManager entityManager = managerFactory.createEntityManager();
        
        String jpql = "Select a from AlumnoEntidad A";
        
        Query query = entityManager.createQuery(jpql);
        
        List<AlumnoEntidad> alumnos =  (List<AlumnoEntidad>) query.getResultList();
        
        for (AlumnoEntidad alumno : alumnos) {
            System.out.println(alumno);
        }

        System.out.println("Operación terminada correctamente");

        entityManager.close();
        managerFactory.close();        
        
    }
    
    public void leerPorID(long id){
    
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");
 
        EntityManager entityManager = managerFactory.createEntityManager();
        
        String jpql = "Select A from AlumnoEntidad A WHERE A.id= :alumno";
        
        Query query = entityManager.createQuery(jpql);
        
        query.setParameter("alumno", id);
        
        List<AlumnoEntidad> alumnos =  (List<AlumnoEntidad>) query.getResultList();
        
        for (AlumnoEntidad alumno : alumnos) {
            System.out.println(alumno);
        }

        System.out.println("Operación terminada correctamente");

        entityManager.close();
        managerFactory.close();        
        
    }
    
    public void leerCriteriaTodos() {
        // Paso 1: Crear una fábrica de administradores de entidades con la configuración "ConexionJPA"
        // La fábrica de administradores de entidades (EntityManagerFactory) es responsable de crear instancias de EntityManager.
        // La configuración "ConexionJPA" se refiere a los detalles de conexión definidos en el archivo de configuración (persistence.xml).
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");

        // Paso 2: Crear un administrador de entidades (EntityManager) a partir de la fábrica
        // El EntityManager es la interfaz principal que se utiliza para interactuar con el contexto de persistencia.
        EntityManager entityManager = managerFactory.createEntityManager();

        // Paso 3: Crear un CriteriaBuilder desde el EntityManager
        // El CriteriaBuilder es utilizado para construir consultas de Criteria API, 
        // que es una manera programática y segura de tipo para construir consultas.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Paso 4: Crear un CriteriaQuery para la entidad AlumnoEntidad
        // El CriteriaQuery define el tipo de resultado que se espera de la consulta, en este caso, una entidad de tipo AlumnoEntidad.
        CriteriaQuery<AlumnoEntidad> criteriaQuery = criteriaBuilder.createQuery(AlumnoEntidad.class);

        // Paso 5: Ejecutar la consulta y obtener el resultado
        // El método createQuery ejecuta la consulta construida y devuelve el resultado, en este caso List<AlumnoEntidad>.
        List<AlumnoEntidad> alumnos = entityManager.createQuery(criteriaQuery).getResultList();

        for (AlumnoEntidad alumno : alumnos) {
            System.out.println(alumno);
        }

        // Mostrar un mensaje de éxito indicando que la operación se completó correctamente
        System.out.println("Operación terminada correctamente");

        // Paso 6: Cerrar el administrador de entidades y la fábrica
        // Es importante cerrar el EntityManager y la EntityManagerFactory para liberar los recursos utilizados.
        entityManager.close();
        managerFactory.close();
    }
    
    public void leerCriteriaPorId(long id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("conexionJPA");

        EntityManager entityManager = managerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<AlumnoEntidad> criteriaQuery = criteriaBuilder.createQuery(AlumnoEntidad.class);

        Root<AlumnoEntidad> root = criteriaQuery.from(AlumnoEntidad.class);

        
        Predicate predicado = criteriaBuilder.equal(root.get("id"), id);
        
        criteriaQuery.where(predicado);
        
        List<AlumnoEntidad> alumnos = entityManager.createQuery(criteriaQuery).getResultList();

        for (AlumnoEntidad alumno : alumnos) {
            System.out.println(alumno);
        }

        System.out.println("Operación terminada correctamente");

        entityManager.close();
        managerFactory.close();
    }    
    
   }    

