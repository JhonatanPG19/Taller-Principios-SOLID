package co.edu.unicauca.mycompany.projects.access;

import java.util.List;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Implementación del repositorio con Sqlite
 *
 * @author Libardo, Julio
 */



public class CompanySqliteRepository implements ISaveCompanyRepository, IReadCompanyRepository {
    private final String url = "jdbc:sqlite:mycompany.db"; // Cambia el nombre de la base de datos si es necesario

    public CompanySqliteRepository(){
            initializeDatabase();
            List<Company> companies = new ArrayList<>();
        companies.add(new Company("012-12-22", "Lacteos Popayan", "313234123", "www.lacteospopayan.com", Sector.SERVICES, "gerentelacteos@gmail.com", "123"));
        companies.add(new Company("323-12-56", "Electromillonaria", "314334334", "www.electromillonaria.com", Sector.TECHNOLOGY, "electromillonaria@gmail.com", "123"));
        companies.add(new Company("867-223-444", "S&P", "3142342344", "www.SP.com", Sector.TECHNOLOGY, "syp@gmail.com", "123"));
        companies.add(new Company("456-1222-2233", "Solutions", "311454789", "www.solutions.com", Sector.HEALTH, "solutions@gmail.com", "123"));
        for(Company each: companies){
            save(each);
        }
    }
 
    private void initializeDatabase() {
        // SQL statement to create the "company" table if it does not already 
        // exist
        String sql = "CREATE TABLE IF NOT EXISTS company (" +
        "nit TEXT PRIMARY KEY, " +
        "name TEXT NOT NULL, " +
        "phone TEXT, "+
        "pageWeb TEXT, "+
        "sector TEXT, "+
        "email TEXT, " +
        "password TEXT" +
        ")";
        // Try-with-resources ensures the connection and statement 
        // are closed automatically
        try (Connection connection = DriverManager.getConnection (url); 
        Statement statement = connection.createStatement()) {
        // Execute the SQL statement to create the table 
        statement.execute(sql);
        System.out.println("Database initialized successfully.");
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(Company newCompany) {
        String sql = "INSERT INTO company(nit, name, phone, pageWeb, sector, email, password) VALUES(?, ?, ?, ?, ?, ?, ?)";
    
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, newCompany.getNit());
            preparedStatement.setString(2, newCompany.getName());
            preparedStatement.setString(3, newCompany.getPhone());
            preparedStatement.setString(4, newCompany.getPageWeb());
            preparedStatement.setString(5, newCompany.getSector().toString());
            preparedStatement.setString(6, newCompany.getEmail());
            preparedStatement.setString(7, newCompany.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Retorna true si se insertó correctamente

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false si hubo un error
        }
    }

    @Override
    public List<Company> listAll() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM company";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String nit = resultSet.getString("nit");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String pageWeb = resultSet.getString("pageWeb");
                Sector sector = Sector.valueOf(resultSet.getString("sector")); // Asumiendo que Sector es un enum
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Company company = new Company(nit, name, phone, pageWeb, sector, email, password);
                companies.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companies; // Retorna la lista de empresas
    }

   
}
