package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private List<Flight> flightlist = new ArrayList<Flight>();

    public FlightService() {
        Flight flight1 = new Flight(1L, "Buenos Aires", "Cordoba", "24-02-2024", "25-02-2024", 89000, "Mensual");
        Flight flight2 = new Flight(2L, "Mendoza", "San Juan", "21-03-2024", "22-03-2024", 90000, "Anual");
        Flight flight3 = new Flight(3L, "La Rioja", "Chaco", "14-04-2024", "15-04-2024", 18000, "Semanal");
        Flight flight4 = new Flight(4L, "Santiago", "Valparaiso", "26-05-2024", "27-05-2024", 75000, "Mensual");
        Flight flight5 = new Flight(5L, "Lima", "Cusco", "18-06-2024", "19-06-2024", 120000, "Anual");
        Flight flight6 = new Flight(6L, "Quito", "Guayaquil", "30-07-2024", "31-07-2024", 60000, "Semanal");
        Flight flight7 = new Flight(7L, "Bogotá", "Medellín", "12-08-2024", "13-08-2024", 80000, "Mensual");
        Flight flight8 = new Flight(8L, "Caracas", "Maracaibo", "24-09-2024", "25-09-2024", 95000, "Anual");
        Flight flight9 = new Flight(9L, "Rio de Janeiro", "Sao Paulo", "06-10-2024", "07-10-2024", 70000, "Semanal");
        Flight flight10 = new Flight(10L, "Buenos Aires", "Santiago", "18-11-2024", "19-11-2024", 110000, "Mensual");
        Flight flight11 = new Flight(11L, "Lima", "Bogotá", "30-12-2024", "31-12-2024", 130000, "Anual");
        Flight flight12 = new Flight(12L, "Quito", "Rio de Janeiro", "12-01-2025", "13-01-2025", 85000, "Semanal");
        Flight flight13 = new Flight(13L, "São Paulo", "Brasilia", "24-02-2025", "25-02-2025", 95000, "Mensual");
        Flight flight14 = new Flight(14L, "Bogotá", "Lima", "26-03-2025", "27-03-2025", 110000, "Anual");
        Flight flight15 = new Flight(15L, "Quito", "Santiago", "18-04-2025", "19-04-2025", 80000, "Semanal");
        Flight flight16 = new Flight(16L, "Caracas", "Rio de Janeiro", "30-05-2025", "31-05-2025", 105000, "Mensual");
        Flight flight17 = new Flight(17L, "Buenos Aires", "Asunción", "12-06-2025", "13-06-2025", 85000, "Anual");
        Flight flight18 = new Flight(18L, "Lima", "Quito", "24-07-2025", "25-07-2025", 95000, "Semanal");
        Flight flight19 = new Flight(19L, "Santiago", "Bogotá", "06-08-2025", "07-08-2025", 120000, "Mensual");
        Flight flight20 = new Flight(20L, "Buenos Aires", "Caracas", "18-09-2025", "19-09-2025", 115000, "Anual");

        flightlist.add(flight1);
        flightlist.add(flight2);
        flightlist.add(flight3);
        flightlist.add(flight4);
        flightlist.add(flight5);
        flightlist.add(flight6);
        flightlist.add(flight7);
        flightlist.add(flight8);
        flightlist.add(flight9);
        flightlist.add(flight10);
        flightlist.add(flight11);
        flightlist.add(flight12);
        flightlist.add(flight13);
        flightlist.add(flight14);
        flightlist.add(flight15);
        flightlist.add(flight16);
        flightlist.add(flight17);
        flightlist.add(flight18);
        flightlist.add(flight19);
        flightlist.add(flight20);
    }

    public String HolaMundo() {
        return "Hola Mundo!";
    }

    public List<Flight> getAllFlights() {
        return flightlist;
    }

    public void addFlight(Flight flight){
        flightlist.add(flight);
    }

    public boolean updateFlight(Long id, Flight updatedFlight){
        for(Flight flight : flightlist){
            if (flight.getId().equals(id)){
                flight.setOrigin(updatedFlight.getOrigin());
                flight.setDestination(updatedFlight.getDestination());
                flight.setDepartureDate(updatedFlight.getDepartureDate());
                flight.setArrivalDate(updatedFlight.getArrivalDate());
                flight.setPrice(updatedFlight.getPrice());
                flight.setFrequency(updatedFlight.getFrequency());
                return true;
            }
        }
        return false;
    }
}

