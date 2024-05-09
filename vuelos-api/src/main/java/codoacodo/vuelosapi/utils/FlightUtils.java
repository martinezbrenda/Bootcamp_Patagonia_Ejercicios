package codoacodo.vuelosapi.utils;

import codoacodo.vuelosapi.model.Flight;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FlightUtils {
    public List<Flight> detectOffers(List<Flight> flightList, float price){
        /*List<Flight> cheaperFlights = new ArrayList<>();
        for (Flight flight : flightList){
            if(flight.getPrice() < price){
                cheaperFlights.add(flight);
            }
        }
        return cheaperFlights;*/
        return flightList.stream().filter(flight -> flight.getPrice() < price).collect(Collectors.toList());
    }
}
