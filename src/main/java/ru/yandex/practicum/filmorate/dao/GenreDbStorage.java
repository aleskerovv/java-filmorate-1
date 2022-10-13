package ru.yandex.practicum.filmorate.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.yandex.practicum.filmorate.dao.utils.GenreMapping;
import ru.yandex.practicum.filmorate.exception.EntityNotFoundException;
import ru.yandex.practicum.filmorate.model.dictionary.Genre;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class GenreDbStorage {

    private final JdbcTemplate jdbcTemplate;

    public List<Genre> findAll() {
        String sqlQuery =
                "SELECT * " +
                "FROM genres " +
                "ORDER BY genre_id;";

        return jdbcTemplate.query(sqlQuery, GenreMapping::mapRowToGenre);
    }

    public Genre getById(Integer genreId) {
        String sqlQuery =
                "SELECT * " +
                "FROM genres " +
                "WHERE genre_id = ?;";

        try {
            return jdbcTemplate.queryForObject(sqlQuery, GenreMapping::mapRowToGenre, genreId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(String.format("Genre with ID %s does not exist", genreId));
        }
    }
}