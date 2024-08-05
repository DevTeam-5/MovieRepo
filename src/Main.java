import java.sql.Date;
import java.sql.Time;
import java.util.List;

import global.Genre;
import movies.dtos.MoviesDto;
import movies.services.MoviesService;
import utility.DBUtil;

public class Main {
    public static void main(String[] args) {
        // MoviesService 인스턴스 생성
        MoviesService moviesService = new MoviesService();

        // Create 테스트
        MoviesDto newMovie = new MoviesDto();
        newMovie.setTitle("Inception");
        newMovie.setDirector("Christopher Nolan");
        newMovie.setGenre(Genre.ACTION);
        newMovie.setRel_date(Date.valueOf("2010-07-16"));
        newMovie.setPublisher("Warner Bros");
        newMovie.setRate(8.8);
        newMovie.setActors("Leonardo DiCaprio, Joseph Gordon-Levitt");
        newMovie.setAttendance(5000000);
        newMovie.setDuration(Time.valueOf("02:28:00"));
        moviesService.createMovie(newMovie);

    }
}