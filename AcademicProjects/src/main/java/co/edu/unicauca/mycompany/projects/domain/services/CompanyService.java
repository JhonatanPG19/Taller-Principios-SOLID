package co.edu.unicauca.mycompany.projects.domain.services;

//import co.edu.unicauca.mycompany.projects.access.ICompanyRepository;
import co.edu.unicauca.mycompany.projects.access.IReadCompanyRepository;
import co.edu.unicauca.mycompany.projects.access.ISaveCompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class CompanyService {

    private IReadCompanyRepository readRepository;
    private ISaveCompanyRepository saveRepository;

    public CompanyService(IReadCompanyRepository readRepo, ISaveCompanyRepository saveRepo) {
        this.readRepository = readRepo;
        this.saveRepository = saveRepo;
    }

    public List<Company> getAllCompanies() {
        return readRepository.listAll();
    }

    public boolean saveCompany(Company newCompany) {
        return saveRepository.save(newCompany);
    }

}
