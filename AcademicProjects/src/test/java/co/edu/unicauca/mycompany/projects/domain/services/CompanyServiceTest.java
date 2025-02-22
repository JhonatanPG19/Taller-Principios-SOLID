package co.edu.unicauca.mycompany.projects.domain.services;

import co.edu.unicauca.mycompany.projects.access.IReadCompanyRepository;
import co.edu.unicauca.mycompany.projects.access.ISaveCompanyRepository;
import co.edu.unicauca.mycompany.projects.domain.entities.Company;
import co.edu.unicauca.mycompany.projects.domain.entities.Sector;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompanyServiceTest {

    @Mock 
    private IReadCompanyRepository readRepositoryMock; // Mock del repositorio de solo lectura

    @Mock
    private ISaveCompanyRepository saveRepositoryMock; // Mock del repositorio de escritura

    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
        companyService = new CompanyService(readRepositoryMock, saveRepositoryMock); // Inicializa el servicio con ambos mocks
    }

    @Test
    void testSaveCompany_Failure() {
        Company newCompany = new Company("123459", "Empresa D","3434345", "www.mipagina4.com", Sector.SERVICES, "gerente4@gmail.com", "123");

        when(saveRepositoryMock.save(newCompany)).thenReturn(false); // Simula fallo

        boolean result = companyService.saveCompany(newCompany);

        assertFalse(result);
        verify(saveRepositoryMock, times(1)).save(newCompany);
    }
    
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

    @Test
    void testSaveCompany_ReturnsTrue() {
        // Crear una empresa de prueba
        Company newCompany = createCompany("123459", "Empresa D");

        // Simular el comportamiento del método save
        when(saveRepositoryMock.save(newCompany)).thenReturn(true);

        // Llamar al método
        boolean result = companyService.saveCompany(newCompany);

        // Verificación
        assertTrue(result);
        verify(saveRepositoryMock, times(1)).save(newCompany);
    }

    /**
     * Método auxiliar para crear una empresa con valores por defecto.
     */
    private Company createCompany(String nit, String name) {
        return new Company(nit, name, "3434343", "www.example.com", Sector.SERVICES, "gerente@example.com", "123");
    }
}