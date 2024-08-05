package movies.services;

import java.sql.Date;
import java.util.List;

import movies.dtos.MoviesDto;
import utility.Utility;

public class MoviesService {

    // Create
    public void createMovie(MoviesDto movie) {
        String query = "INSERT INTO Movies (title, director, genre, rel_date, publisher, rate, actors, attendance, duration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Utility.writeData(query, movie);
    }

    // Read
    public MoviesDto getMovie(int id) {
        String query = "SELECT * FROM Movies WHERE m_id = " + id;
        return Utility.readData(query, new MoviesDto());
    }

    // Update
    public void updateMovie(MoviesDto movie) {
        String query = "UPDATE Movies SET title = ?, director = ?, genre = ?, rel_date = ?, publisher = ?, rate = ?, actors = ?, attendance = ?, duration = ? WHERE m_id = ?";
        Utility.writeData(query, movie);
    }

    // Delete
    public void deleteMovie(int id) {
        String query = "DELETE FROM Movies WHERE m_id = " + id;
        MoviesDto movie = new MoviesDto(); // 기본 객체를 생성하여 파라미터로 전달
        Utility.writeData(query, movie);
    }

    // List all movies
    public List<MoviesDto> listAllMovies() {
        String query = "SELECT * FROM Movies";
        return Utility.readListData(query, new MoviesDto());
    }
}