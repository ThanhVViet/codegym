package m4.p2_phone_manager.service;

import lombok.AllArgsConstructor;
import m4.p2_phone_manager.model.SmartPhone;
import m4.p2_phone_manager.repository.SmartPhoneRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SmartPhoneService {
    private final SmartPhoneRepository smartPhoneRepository;

    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
