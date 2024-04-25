package codoacodo.vuelosapi.repository;

import codoacodo.vuelosapi.model.Flight;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class flightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private static Flight flight;

    @BeforeAll
    public static void setUp(){
        flight = new Flight("COR","EZE","12-04-2024","12-04-2024",300,"Mensual");
    }
    @Test
    void saveFlightTest(){
        
    }
}
