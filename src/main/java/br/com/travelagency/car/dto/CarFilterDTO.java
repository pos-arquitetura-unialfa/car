package br.com.travelagency.car.dto;

import br.com.travelagency.car.enums.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CarFilterDTO {

    private String clientName;
    private LocalDate initialDate;
    private ServiceStatus serviceStatus;

}
