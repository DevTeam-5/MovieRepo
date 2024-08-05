package movies.dtos;

import global.Genre;

import java.util.Date;

//Moive 전체 조회하는 DTO 입니다.
public class MoviesDto {
    private int m_id;
    private String title;
    private String director;
    private Genre genre;
    private Date rel_date;

    public MoviesDto(){}//기본 생성자

    public int getM_id() {
        return m_id;
    }

    public String getTitle() {
        return title;
    }


    public String getDirector() {
        return director;
    }

    public Genre getGenre() {
        return genre;
    }


    public Date getRel_date() {
        return rel_date;
    }

}
//조회니까 setter는 안만들어도 될 것같아서 안만들었습니다.
