package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("{id}")
    public Flight flightById(@PathVariable(name = "id") Long id){
        return flightService.flightById(id);
    }
    @PostMapping("/add")
    public void addFlight (@RequestBody Flight flight){
        flightService.addFlight(flight);
    }

    @PutMapping("/update/{id}")
    public void updateFlight(@PathVariable Long id, @RequestBody Flight flight){
        flightService.updateFlight(id,flight);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
       flightService.deleteFlight(id);
    }

}
