package com.khoapham.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private Integer id;
    private String name;
    private String artist;
    private String genre;
    private MultipartFile filePath;

    public SongForm(Integer id, String name, String artist, String genre, MultipartFile filePath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.filePath = filePath;
    }

    public SongForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MultipartFile getFilePath() {
        return filePath;
    }

    public void setFilePath(MultipartFile filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "SongForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", filePath=" + filePath +
                '}';
    }
}
