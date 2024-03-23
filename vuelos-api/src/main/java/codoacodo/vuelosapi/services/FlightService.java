package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.FlightException.FlightException;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public String HolaMundo() {
        return "Hola Mundo!";
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void addFlight(Flight flight){
        flightRepository.save(flight);
    }
    public void addFlight(List<Flight> flights){
        flightRepository.saveAll(flights);
    }

    public void updateFlight(Long id, Flight updatedFlight){
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
    }

    public void deleteFlight(Long id){
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if(existingFlight != null)
            flightRepository.deleteById(id);
        else
            throw new FlightException("El vuelo con ID " + id + " no existe, no se puede eliminar");


    }

    public Flight flightById (Long id){
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if(existingFlight != null)
            return existingFlight;
        else
            throw new FlightException("El vuelo con ID " + id + " no existe");

    }
}

