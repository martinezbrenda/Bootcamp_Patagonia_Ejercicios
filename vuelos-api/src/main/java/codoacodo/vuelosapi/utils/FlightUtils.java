package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.model.FlightDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FlightUtils {
    public List<Flight> detectOffers(List<Flight> flightList, float price){
        return flightList.stream().filter(flight -> flight.getPrice() < price).collect(Collectors.toList());
    }

    public FlightDTO flightMapper(Flight flight, double price){
        FlightDTO flightDTO = new FlightDTO(flight.getId(), flight.getOrigin(), flight.getDestination(), flight.getDepartureDate(),
                flight.getArrivalDate(), flight.getPrice() * price, flight.getFrequency());
        return  flightDTO;
    }
}
