package codegym.vn.service;

import codegym.vn.entity.Nasa;
import codegym.vn.repo.INasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NasaServiceImpl implements INasaService{
    @Autowired
    INasaRepository iNasaRepository;

    @Override
    public List<Nasa> findAll() {
        return (List<Nasa>) iNasaRepository.findAll();
    }

    @Override
    public boolean create(Nasa nasa) {
        iNasaRepository.save(nasa);
        return true;
    }
}
