package movies.services;

import movies.dtos.MoviesDto;
import utility.Utility;

import java.util.List;

public class MoviesService {

    //영화 전체 조회
    public List<MoviesDto> getMovies(){
        List<MoviesDto> movies= Utility.readListData( "SELECT m_id, title, director, genre, rel_date, publisher, rate, actors, attendance, duration FROM movie" ,new MoviesDto());
        return movies;
    }

    public MoviesDto findByTitle(String title) {
        // SQL 쿼리 문자열을 동적으로 생성
        String query = "SELECT m_id, title, director, genre, rel_date, publisher, rate, actors, attendance, duration FROM movie WHERE title='" + title + "'";
        MoviesDto movies = Utility.readData(query, new MoviesDto());
        return movies;
    }

    public List<MoviesDto> findByDirector(String director) {
        String query = "SELECT m_id, title, director, genre, rel_date, publisher, rate, actors, attendance, duration FROM movie WHERE director='" + director + "'";
        List<MoviesDto> movies = Utility.readListData(query, new MoviesDto());
        return movies;
    }

    public List<MoviesDto> findByGenre(String genre) {
        String query = "SELECT m_id, title, director, genre, rel_date, publisher, rate, actors, attendance, duration FROM movie WHERE genre='" + genre + "'";
        List<MoviesDto> movies = Utility.readListData(query, new MoviesDto());
        return movies;
    }
}
