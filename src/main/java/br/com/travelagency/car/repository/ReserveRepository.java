package br.com.travelagency.car.repository;

import br.com.travelagency.car.enums.ServiceStatus;
import br.com.travelagency.car.model.Reserve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    List<Reserve> findByClientNameIgnoreCaseAndInitialDateOrServiceStatus(String clientName, LocalDate initialDate, ServiceStatus serviceStatus);
    
}
