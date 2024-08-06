package member.services;

import member.dtos.ReservationDto;
import utility.Utility;

import java.util.List;

public class ReservaionService {

    public List<ReservationDto> getReservation(){
        String query = "SELECT m.name , r.count, t.t_name , mv.title ,r.r_id , r.user_id, r.m_id, r.s_id " +
                "FROM reservation r " +
                "JOIN member m ON r.user_id = m.u_id " +
                "JOIN movie mv ON r.m_id = mv.m_id " +
                "JOIN theater t ON mv.m_id = t.m_id ";

        List<ReservationDto> reservation= Utility.readListData( query,new ReservationDto());
        return reservation;
    }
}
