package codegym.vn.repository;

import codegym.vn.entity.Nasa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NasaRepositoryImpl implements NasaRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Nasa> findAll() {
        return entityManager.createQuery("select n from Nasa n").getResultList();
    }

    @Override
    public boolean create(Nasa nasa) {
        entityManager.persist(nasa);
        return true;
    }
}
