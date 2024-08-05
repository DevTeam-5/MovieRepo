package member.services;

import member.domains.Member;
import member.dtos.ReservationDto;
import member.dtos.ScreenDto;
import member.dtos.TheaterDto;
import utility.Utility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    // 현재 상영하는 영화 조회

    public List<ScreenDto> getScreenMovie(int m_id) throws SQLException {
        // m_id 로 부터 t_id 얻기
        String checkSql = "select t_id, t_name, capacity, m_id from theater where m_id = " + m_id;
        TheaterDto theater = new TheaterDto();
        theater = Utility.readData(checkSql, new TheaterDto());

        List<ScreenDto> list = new ArrayList<>();
        String sql = "select s_id,start_time,current_capacity,t_id from Screen where start_time > NOW() and t_id = " + theater.getT_id();

        ScreenDto form = new ScreenDto();
        list = Utility.readListData(sql, form);

        return list;
    }

    // 영화 예매하기
    public void reservation(int s_id, int count) throws SQLException{
        String sql = "insert into Reservation(user_id,m_id,s_id,count) values(?,?,?,?)";


        ReservationDto form = new ReservationDto(); // insert 할때 사용할 form
        // int m_id = 성현님 코드에서 받아올것
        // int user_id = 관현님 코드에서 받아올것

//        form.setM_id(m_id);
//        form.setUser_id(user_id);
        form.setUser_id(1);
        form.setM_id(1);
        form.setCount(count);
        form.setS_id(s_id);

        ScreenDto checkForm = new ScreenDto(); // 남은좌석들을 확인할 form
        String checkSql = "select s_id,start_time,current_capacity,t_id from Screen where s_id = " + s_id;
        checkForm = Utility.readData(checkSql,new ScreenDto());

        if (checkForm.getCurrent_capacity() < count) {
            System.out.println("남은 좌석이 없습니다.");
        }else{
            Utility.writeData(sql, form);
            System.out.println("예약이 완료되었습니다");
        }

    }
}
