package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.FlightException.FlightException;
import codoacodo.vuelosapi.configuration.FlightConfiguration;
import codoacodo.vuelosapi.model.Dolar;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.repository.FlightRepository;
import codoacodo.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightUtils flightUtils;
    @Autowired
    FlightConfiguration flightConfiguration;

    public String HolaMundo() {
        return "Hola Mundo!";
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }
    public List<Flight> addFlightList(List<Flight> flights){
        return flightRepository.saveAll(flights);
    }

    public Optional<Flight> updateFlight(Long id, Flight updatedFlight){
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if (existingFlight != null) {
            existingFlight.setOrigin(updatedFlight.getOrigin());
            existingFlight.setDestination(updatedFlight.getDestination());
            existingFlight.setDepartureDate(updatedFlight.getDepartureDate());
            existingFlight.setPrice(updatedFlight.getPrice());
            existingFlight.setFrequency(updatedFlight.getFrequency());

            flightRepository.save(existingFlight);
        } else {
            throw new FlightException("El vuelo con ID " + id + " no existe. No se puede actualizar.");
        }
        return flightRepository.findById(id);
    }

    public void deleteFlight(Long id){
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if(existingFlight != null)
            flightRepository.deleteById(id);
        else
            throw new FlightException("El vuelo con ID " + id + " no existe, no se puede eliminar");


    }

    public Optional<Flight> flightById (Long id){
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if(existingFlight != null)
            return Optional.of(existingFlight);
        else
            throw new FlightException("El vuelo con ID " + id + " no existe");

    }

    public List<Flight> getLessThan(float price){
        return flightUtils.detectOffers(flightRepository.findAll(),price);
    }

    public List <Dolar> getDolares(){
        return flightConfiguration.fetchDolares();
    }
    public Dolar getDolarCasa(String casa){
        return flightConfiguration.fetchDolarCasa(casa);
    }
}

