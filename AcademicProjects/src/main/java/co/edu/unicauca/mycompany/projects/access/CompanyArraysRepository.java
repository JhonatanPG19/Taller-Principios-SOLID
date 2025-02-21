package co.edu.unicauca.mycompany.projects.access;

import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 * Implementación del repositorio con Arreglos
 *
 * @author Libardo, Julio
 */
public class CompanyArraysRepository implements ISaveCompanyRepository, IReadCompanyRepository {

    private List<Company> myArray;
    
    public CompanyArraysRepository(){
        this.myArray = CompanyArraysRepositoryInitialization.seed();
    }
    
    @Override
    public List<Company> listAll() {
        return myArray;
    }

    @Override
    public boolean save(Company newCompany) {
        if (!existsNit(newCompany.getNit())){
            myArray.add(newCompany);
            return true;
        }
        return false;
    }
    
    private boolean existsNit(String nit) {
        return myArray.stream().anyMatch(company -> company.getNit().equals(nit));
    }

}
