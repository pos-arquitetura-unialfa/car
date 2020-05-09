package br.com.travelagency.car.model;

import br.com.travelagency.car.enums.ServiceStatus;
import br.com.travelagency.car.enums.converter.ServiceStatusConverter;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "RESERVAS")

public class Reserve {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "MODELO_CARRO")
    private String carModel;

    @Column(name = "NOME_CLIENTE")
    private String clientName;

    @Column(name = "PRECO_DIARIA")
    private BigDecimal dailyPrice;

    @Column(name = "DATA_INICIO")
    private LocalDate initialDate;

    @Column(name = "DATA_FIM")
    private LocalDate endDate;

    @Convert(converter = ServiceStatusConverter.class)
    @Column(name = "STATUS_SERVICO")
    private ServiceStatus serviceStatus;

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", clientName='" + clientName + '\'' +
                ", dailyPrice=" + dailyPrice +
                ", initialDate=" + initialDate +
                ", endDate=" + endDate +
                '}';
    }
}
