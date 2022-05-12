package com.khoapham.repository;

import com.khoapham.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
//    List<Song> findAll();
//
//    void save(Song song);
//
//    Song findById(int id);
//
//    void remove(int id);
}
