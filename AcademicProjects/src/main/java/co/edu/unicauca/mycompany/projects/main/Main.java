
package co.edu.unicauca.mycompany.projects.main;

import co.edu.unicauca.mycompany.projects.access.Factory;
import co.edu.unicauca.mycompany.projects.access.IReadCompanyRepository;
import co.edu.unicauca.mycompany.projects.access.ISaveCompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.services.CompanyService;
import co.edu.unicauca.mycompany.projects.presentation.GUIMenu;
import javax.swing.JFrame;


/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Hacia futuro el tipo de repositorio lo podemos leer de un archivo plano
        // setup.properties, asi no tendriamos que recompilar la aplicación
        IReadCompanyRepository  readRepo = Factory.getInstance().getRepository("SQLITE");// Podria ir SQLITE
        if (readRepo == null) {
            throw new RuntimeException("No se encontró el repositorio 'ARRAYS'. Verifica la configuración de Factory.");
        }
        ISaveCompanyRepository writeRepo = (ISaveCompanyRepository) readRepo; // Cast si es necesario
        CompanyService service = new CompanyService(readRepo, writeRepo);
        GUIMenu instance = new GUIMenu(service);
        instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instance.setVisible(true);
    }
    
}
