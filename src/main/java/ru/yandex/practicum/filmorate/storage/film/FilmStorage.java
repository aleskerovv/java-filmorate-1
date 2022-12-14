package ru.yandex.practicum.filmorate.storage.film;

import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.Storage;

import java.util.List;

public interface FilmStorage extends Storage<Film> {

    void addLike(Film film, Long userId);

    void deleteLike(Film film, Long userId);

    List<Film> showMostPopularFilms(Integer count);

    void updateRate(Film film);

    List<Film> searchFilmByTitle(String filter);
}
