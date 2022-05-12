package com.khoapham.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class SongFormDto implements Validator {
    private Integer id;

    @NotBlank(message = "Name {name.empty}")
    private String name;

    @NotBlank(message = "Artist {name.empty}")
    private String artist;

    @NotBlank(message = "Genre {name.empty}")
    private String genre;


    private MultipartFile filePath;

    public SongFormDto(Integer id, String name, String artist, String genre, MultipartFile filePath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.filePath = filePath;
    }

    public SongFormDto(String name, String artist, String genre, MultipartFile filePath) {

        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.filePath = filePath;
    }

    public SongFormDto() {
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
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String regexSpecialChar = "^(\\p{L}|\\d)+( (\\p{L}|\\d)+)*$";
        String regexSpecialCharAcceptComa = "^(\\p{L}|\\d|,)+( (\\p{L}|\\d|,)+)*$";
        SongFormDto songFormDto = (SongFormDto) target;
        if (songFormDto.getName().length() > 800) {
            errors.rejectValue("name", "name.length");
        }
        if (!songFormDto.getName().matches(regexSpecialChar)) {
            errors.rejectValue("name", "name.char");
        }

        if (songFormDto.getArtist().length() > 300) {
            errors.rejectValue("artist", "artist.length");
        }
        if (!songFormDto.getArtist().matches(regexSpecialChar)) {
            errors.rejectValue("artist", "name.char");
        }

        if (songFormDto.getGenre().length() > 1000) {
            errors.rejectValue("genre", "genre.length");
        }
        if (!songFormDto.getGenre().matches(regexSpecialCharAcceptComa)) {
            errors.rejectValue("genre", "name.char");
        }

    }
}
