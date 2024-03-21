package codoacodo.vuelosapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight {
    private Long id;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private double price;
    private String frequency;
}
