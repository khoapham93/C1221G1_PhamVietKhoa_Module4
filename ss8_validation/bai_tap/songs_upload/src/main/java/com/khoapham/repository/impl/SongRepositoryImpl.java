package com.khoapham.repository.impl;

import com.khoapham.model.Song;
import com.khoapham.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery = BaseRepository.entityManager
                .createQuery("select s from Song as s", Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        if (song.getId() == null) {
            BaseRepository.entityManager.persist(song);
        } else {
            BaseRepository.entityManager.merge(song);

        }
        entityTransaction.commit();
    }

    @Override
    public Song findById(int id) {
        return BaseRepository.entityManager.find(Song.class, id);
    }

    @Override
    public void remove(int id) {
        Song song = findById(id);
        if (song != null) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(song);
            entityTransaction.commit();
        }

    }
}
