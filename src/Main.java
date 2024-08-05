import movies.dtos.MoviesDto;
import movies.services.MoviesService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // MovieService 인스턴스 생성
        MoviesService movieService = new MoviesService();

        // getAllMovies 메서드 호출하여 전체 영화 조회
        List<MoviesDto> movie = movieService.getMovies();

        // 조회된 영화 리스트 출력
        for (MoviesDto movies : movie) {
            System.out.println("ID: " + movies.getM_id());
            System.out.println("Title: " + movies.getTitle());
            System.out.println("Director: " + movies.getDirector());
            System.out.println("Genre: " + movies.getGenre());
            System.out.println("Release Date: " + movies.getRel_date());
            System.out.println("Publisher: " + movies.getPublisher());
            System.out.println("Rate: " + movies.getRate());
            System.out.println("Actors: " + movies.getActors());
            System.out.println("Attendance: " + movies.getAttendance());
            System.out.println("Duration: " + movies.getDuration());
            System.out.println("-----");
        }

        MoviesDto movieByTitle = movieService.findByTitle("Inception");
        System.out.println(movieByTitle.getTitle());

    }
}