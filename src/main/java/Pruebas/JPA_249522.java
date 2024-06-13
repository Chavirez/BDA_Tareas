/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Pruebas;

import Persistencia.AlumnoDAO;

/**
 *
 * @author Administrator
 */
public class JPA_249522 {

    public static void main(String[] args) {
        
        AlumnoDAO a = new AlumnoDAO();
        a.guardarConRelacionCurso();
        System.out.println("Hello World!");
    }
}
