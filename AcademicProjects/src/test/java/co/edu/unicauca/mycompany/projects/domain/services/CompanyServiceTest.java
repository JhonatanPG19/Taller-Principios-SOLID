package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IReadCompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para CompanyService.
 * Se usa Mockito para simular el comportamiento del repositorio de lectura.
 */
public class CompanyServiceTest {
    
    @Mock 
    private IReadCompanyRepository readRepositoryMock; // Nuevo repositorio de solo lectura
// Nuevo repositorio de solo lectura
    
    private CompanyService companyService;

    @Test
    void testGetAllCompanies_ReturnsCompanies() {
        // Simulación de datos
        List<Company> companies = Arrays.asList(
            createCompany("123456", "Empresa A"),
            createCompany("123457", "Empresa B"),
            createCompany("123458", "Empresa C")
        );

        when(readRepositoryMock.listAll()).thenReturn(companies);

        // Llamado al método
        List<Company> result = companyService.getAllCompanies();

        // Verificación
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Empresa A", result.get(0).getName());
        assertEquals("Empresa B", result.get(1).getName());

        // Verifica que listAll() fue llamado una vez
        verify(readRepositoryMock, times(1)).listAll();
    }

    /**
     * Método auxiliar para crear una empresa con valores por defecto.
     */
    private Company createCompany(String nit, String name) {
        return new Company(nit, name, "3434343", "www.example.com", Sector.SERVICES, "gerente@example.com", "123");
    }
}
