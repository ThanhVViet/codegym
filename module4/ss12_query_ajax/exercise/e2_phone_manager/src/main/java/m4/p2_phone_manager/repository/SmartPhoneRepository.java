package m4.p2_phone_manager.repository;

import m4.p2_phone_manager.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;

public interface SmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
}
