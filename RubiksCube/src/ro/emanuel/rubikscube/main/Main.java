package ro.emanuel.rubikscube.main;

import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.rubikscube.dao.RubiksCubeDAO;
import ro.emanuel.rubikscube.pojo.RubiksCube;

public class Main {

    public static void main(String[] args) throws SQLException {
        
           
            RubiksCubeDAO.createRubiksCube("Rubik", 0.5, 6);
            System.out.println("Rubik's Cube creat!");

            
            RubiksCube rubik1 = RubiksCubeDAO.getRubiksCubeById(1);
            if (rubik1 != null) {
                System.out.println("Obținut: " + rubik1);
            }

            
            RubiksCubeDAO.updateRubiksCube(1, "Rubik Updated", 0.55, 6);
            System.out.println("Rubik's Cube actualizat!");

        
            ArrayList<RubiksCube> allCubes = RubiksCubeDAO.getAllRubiksCubes();
            for (RubiksCube cube : allCubes) {
                System.out.println(cube);
            }

        
            RubiksCubeDAO.deleteRubiksCube(1);
            System.out.println("Rubik's Cube șters!");

       
        
    }
}
