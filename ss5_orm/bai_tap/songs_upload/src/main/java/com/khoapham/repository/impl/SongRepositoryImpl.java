package com.khoapham.repository.impl;

import com.khoapham.model.Song;
import com.khoapham.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {
    private List<Song> songs = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        Integer id = (int) (Math.random() * 100);
        song.setId(id);

        songs.add(song);

    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }

    @Override
    public void update(int id, Song song) {
        for (Song p : songs) {
            if (p.getId() == id) {
                p = song;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getId() == id) {
                songs.remove(i);
                break;
            }
        }
    }
}
