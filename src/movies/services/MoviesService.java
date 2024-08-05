package movies.services;

import movies.dtos.MoviesDto;
import utility.Utility;

import java.util.List;

public class MoviesService {

    //영화 전체 조회
    public List<MoviesDto> getMovies(){
        List<MoviesDto> movies= Utility.readListData( "SELECT m_id, title, director, genre, rel_date FROM movie" ,new MoviesDto());
        return movies;
    }
}
