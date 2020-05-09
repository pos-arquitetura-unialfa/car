package br.com.travelagency.car.service;

import java.util.List;

import br.com.travelagency.car.dto.CarFilterDTO;
import br.com.travelagency.car.model.Reserve;


public interface ReserveService {

    List<Reserve> findByFilter(CarFilterDTO filter);

    Reserve reserve(Reserve reserve);

	//void updateServiceStatus(Long id);
    

}
