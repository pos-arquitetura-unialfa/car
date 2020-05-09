package br.com.travelagency.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.travelagency.car.dto.CarFilterDTO;
import br.com.travelagency.car.enums.ServiceStatus;
import br.com.travelagency.car.model.Reserve;
import br.com.travelagency.car.repository.ReserveRepository;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveRepository repository;

    @Override
    public List<Reserve> findByFilter(CarFilterDTO filter) {
        return repository.findByClientNameIgnoreCaseAndInitialDateOrServiceStatus(filter.getClientName(), filter.getInitialDate(), filter.getServiceStatus());
    }

    @Override
    @Transactional
    public Reserve reserve(Reserve reserve) {
        reserve.setServiceStatus(ServiceStatus.REQUEST);
        return repository.save(reserve);
    }
    
     @Transactional
    public void updateServiceStatus(Long id) {
		
    Reserve reserve =  repository.findById(id).get();
		 
    reserve.setServiceStatus(ServiceStatus.CONFIRM);
		 
     repository.save(reserve);
		
    }

}
