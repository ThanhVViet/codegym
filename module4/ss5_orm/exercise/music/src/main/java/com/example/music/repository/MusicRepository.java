package com.example.music.repository;

import com.example.music.model.Music;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = entityManager.createQuery("from Music", Music.class);
        return query.getResultList();
    }

    @Override
    public Music findById(Long id) {
        return entityManager.find(Music.class, id);
    }

    @Override
    @Transactional
    public void save(Music music) {
        try {
           entityManager.persist(music);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public Music saveAndFlush(Music music) {
        music = entityManager.merge(music);
        entityManager.flush();
        return music;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Music Music = entityManager.find(Music.class, id);
        entityManager.remove(Music);
    }
}
