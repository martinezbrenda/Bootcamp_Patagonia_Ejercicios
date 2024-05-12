package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.model.Dolar;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.model.FlightDTO;
import codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @GetMapping("/HolaMundo")
    public String HolaMundo(){
        return flightService.HolaMundo();
    }
    @GetMapping("/list")
    public List<FlightDTO> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("{id}")
    public Optional<Flight> lightById(@PathVariable(name = "id") Long id){
        return flightService.flightById(id);
    }

    @GetMapping("/less/{price}")
    public List<Flight> getLessThan(@PathVariable(name = "price") Long price){
        return flightService.getLessThan(price);
    }

    @PostMapping("/add")
    public Flight addFlight (@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }

    @GetMapping("/dolares")
    public List<Dolar> getDolares(){
        return flightService.getDolares();
    }

    @GetMapping("/dolar/{casa}")
    public Dolar getDolarCasa(@PathVariable(name = "casa") String casa){
        return flightService.getDolarCasa(casa);
    }

    @GetMapping("/dolar")
    public double getDolar(){
        return flightService.getDolarTarjeta();
    }

    @PostMapping("/addList")
    public List<Flight> addFlightList (@RequestBody List<Flight> flights){
        return flightService.addFlightList(flights);
    }

    @PutMapping("/update/{id}")
    public Optional<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight){
        return flightService.updateFlight(id,flight);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
       flightService.deleteFlight(id);
    }

}
