package m4.p2_phone_manager.controller.rest;

import lombok.AllArgsConstructor;
import m4.p2_phone_manager.model.SmartPhone;
import m4.p2_phone_manager.service.SmartPhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/smartphones")
@AllArgsConstructor
public class SmartController {
    private final SmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> create(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> findAll() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> delete(@PathVariable Long id){
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (smartphoneOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        smartPhoneService.remove(id);

        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }
}
