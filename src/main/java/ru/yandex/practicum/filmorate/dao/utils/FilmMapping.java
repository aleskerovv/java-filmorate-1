package ru.yandex.practicum.filmorate.dao.utils;

import lombok.AllArgsConstructor;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.dictionary.Mpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class FilmMapping {

    public static Map<String, Object> mapFilmToRow(Film film) {
        Map<String, Object> values = new HashMap<>();
        values.put("film_name", film.getName());
        values.put("description", film.getDescription());
        values.put("release_date", film.getReleaseDate());
        values.put("duration", film.getDuration());
        values.put("rate", film.getRate());
        values.put("mpa_id", film.getMpa().getId());
        return values;
    }

    public static Film mapRowToFilm(ResultSet rs, int rowNum) throws SQLException {
        return new Film()
                .setId(rs.getLong("film_id"))
                .setName(rs.getString("film_name"))
                .setDescription(rs.getString("description"))
                .setReleaseDate(rs.getDate("release_date").toLocalDate())
                .setDuration(rs.getLong("duration"))
                .setRate(rs.getInt("rate"))
                .setMpa(new Mpa()
                        .setId(rs.getInt("mpa_id"))
                        .setName(rs.getString("mpa_name")));
    }
}
