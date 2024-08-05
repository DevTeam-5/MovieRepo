package movies.dtos;

import global.Genre;

import java.sql.Time;
import java.util.Date;

//Moive 전체 조회하는 DTO 입니다.
public class MoviesDto {
    private int m_id;
    private String title;
    private String director;
    private Genre genre;
    private Date rel_date;
    private String publisher;
    private double rate;
    private String actors;
    private int attendance;
    private Time duration;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getRel_date() {
        return rel_date;
    }

    public void setRel_date(Date rel_date) {
        this.rel_date = rel_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
