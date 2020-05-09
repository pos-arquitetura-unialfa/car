package br.com.travelagency.car.dto;

import br.com.travelagency.car.enums.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CarFilterDTOActive {
	
	private Long id;
    private String clientName;
    private String carModel;
    private String initialDate;
    private ServiceStatus serviceStatus;
    private BigDecimal dailyPrice;
    private String endDate;
   
}
