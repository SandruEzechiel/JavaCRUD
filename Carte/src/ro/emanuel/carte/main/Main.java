package ro.emanuel.carte.main;

import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.carte.dao.CarteDAO;
import ro.emanuel.carte.pojo.Carte;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        CarteDAO.createCarte("Harry Potter", "J.K. Rowling", 39.99);
        System.out.println("Carte creată!");

        Carte carte1 = CarteDAO.getCarteById(1);
        if (carte1 != null) {
            System.out.println("Obținut: " + carte1);
        }

        CarteDAO.updateCarte(1, "Harry Potter Actualizat", "J.K. Rowling", 29.99);
        System.out.println("Carte actualizată!");

        ArrayList<Carte> toateCartile = CarteDAO.getAllCarti();
        System.out.println("Toate cărțile:");
        for (Carte carte : toateCartile) {
            System.out.println(carte);
        }

        CarteDAO.deleteCarte(1);
        System.out.println("Carte ștearsă!");
    }
}
