package m4.p2_phone_manager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producer;
    private String model;
    private Double price;
}
