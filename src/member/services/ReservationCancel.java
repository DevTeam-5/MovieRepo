package member.services;

import member.domains.Member;
import utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationCancel {

    public static int removeReservation(int r_id) throws SQLException {
        int result = 0;
        try {
            String sql = "DELETE r FROM Reservation r WHERE r_id = "+r_id;
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();

            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("에러1 발생");
            throw new RuntimeException(e);
        }

        return result;
    }

    public static int getReservationCapacity(int r_id) {
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT count FROM Reservation WHERE r_id = ?";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, r_id);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = rs.getInt("count");
                System.out.println(result);
            }
        } catch (SQLException e) {
            System.out.println("에러2 발생");
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, ps, conn);
        }

        return result;
    }

    public static int updateCapacity(int r_id) {
        int result = 0;
        int plusCapacity = getReservationCapacity(r_id);
        System.out.println(plusCapacity);
        try {
            String sql = "UPDATE Screen SET current_capacity = current_capacity + " + plusCapacity +
                    " WHERE s_id = (SELECT s_id FROM Reservation WHERE r_id = " + r_id + ")";

            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();

            System.out.println("업데이트 완료");

            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("에러3 발생");
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void ReservationCancel(int r_id) throws SQLException {
        updateCapacity(r_id);
        removeReservation(r_id);
    }
}