/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonatan
 */
public class CompanyArraysRepositoryInitialization {
    
    //Funcion qpara retornar la lista de empresas previamente inicializadas
    //...
    public static List<Company> seed(){
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("012-12-22", "Lacteos Popayan", "313234123", "www.lacteospopayan.com", Sector.SERVICES, "gerentelacteos@gmail.com", "123"));
        companies.add(new Company("323-12-56", "Electromillonaria", "314334334", "www.electromillonaria.com", Sector.TECHNOLOGY, "electromillonaria@gmail.com", "123"));
        companies.add(new Company("867-223-444", "S&P", "3142342344", "www.SP.com", Sector.TECHNOLOGY, "syp@gmail.com", "123"));
        companies.add(new Company("456-1222-2233", "Solutions", "311454789", "www.solutions.com", Sector.HEALTH, "solutions@gmail.com", "123"));
        return companies;
    }
}
