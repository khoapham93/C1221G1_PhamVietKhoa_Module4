package com.khoapham.service.impl;

import com.khoapham.model.Song;
import com.khoapham.repository.ISongRepository;
import com.khoapham.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return this.iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return this.iSongRepository.findById(id);
    }

    @Override
    public void update(int id, Song song) {
        this.iSongRepository.update(id,song);
    }

    @Override
    public void remove(int id) {
        this.iSongRepository.remove(id);
    }

}
