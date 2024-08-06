package member.dtos;

import java.time.LocalDateTime;

public class ScreenDto {
    private int s_id;
    private LocalDateTime start_time;
    private int current_capacity;
    private int t_id;

    public ScreenDto() {
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public int getCurrent_capacity() {
        return current_capacity;
    }

    public void setCurrent_capacity(int current_capacity) {
        this.current_capacity = current_capacity;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "ScreenDto{" +
                "s_id=" + s_id +
                ", start_time=" + start_time +
                ", current_capacity=" + current_capacity +
                ", t_id=" + t_id +
                '}';
    }
}
