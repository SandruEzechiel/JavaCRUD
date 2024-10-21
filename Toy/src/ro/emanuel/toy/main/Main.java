package ro.emanuel.toy.main;

import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.toy.dao.ToyDAO;
import ro.emanuel.toy.pojo.Toy;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        
        ToyDAO.createToy(new Toy(0, "Spiderman", "figurina", 19.99));
        System.out.println("Toy creat!");

        
        Toy toy1 = ToyDAO.getToyById(1); 
        if (toy1 != null) {
            System.out.println("Obținut: " + toy1);
        }

      
        ToyDAO.updateToy(new Toy(1, "Spiderman Updated", "figurina", 24.99)); 
        System.out.println("Toy actualizat!");

        
        ArrayList<Toy> allToys = ToyDAO.getAllToys();
        System.out.println("Toate jucăriile:");
        for (Toy toy : allToys) {
            System.out.println(toy);
        }

       
        ToyDAO.deleteToy(1); 
        System.out.println("Toy șters!");
    }
}
