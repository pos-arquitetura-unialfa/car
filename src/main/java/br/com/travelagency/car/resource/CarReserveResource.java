package br.com.travelagency.car.resource;

import br.com.travelagency.car.dto.CarFilterDTO;
import br.com.travelagency.car.enums.ServiceStatus;
import br.com.travelagency.car.model.Reserve;
import br.com.travelagency.car.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/carReserves")
public class CarReserveResource {

    @Autowired
    private ReserveService reserveService;

    @GetMapping
    private List<Reserve> find(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate initialDate, @RequestParam(required = false) ServiceStatus serviceStatus) {
        return this.reserveService.findByFilter(new CarFilterDTO(clientName, initialDate, serviceStatus));
    }

    @PostMapping
    public Reserve reserve(@RequestBody Reserve reserve){
        return this.reserveService.reserve(reserve);
    }

}
