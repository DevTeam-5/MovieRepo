package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.customException.CustomReflectionException;


public class Utility {

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    private static Converter converter = new Converter();


    /**
     * 쿼리에 담긴 컬럼'만' 가지고 있는 DTO 를 파라미터로 넘겨줘야함
     * @param query
     * @param dto
     * @return: 해당 객체 반환
     * @param <E>
     */
    public static <E> E readData(String query, E dto) {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return converter.getDataByDTO(rs, dto);

        } catch (SQLException | CustomReflectionException e) {
            e.printStackTrace();
            System.out.println("실패했습니다!");
        } finally {
            DBUtil.close(rs, ps, con);
        }
        return dto;
    }

    public static <E> List<E> readListData(String query, E dto) {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            List<E> returnValue = converter.getDataByList(rs, dto);
            return returnValue;

        } catch (SQLException | CustomReflectionException e) {
            e.printStackTrace();
            System.out.println("실패했습니다!");
        } finally {
            DBUtil.close(rs, ps, con);
        }
        return new ArrayList<>();
    }


    /**
     * 수정 시에는 항상 완전한 DTO 를 갈아끼우는 형태
     * @param query
     * @param form
     * @param <E>
     */
    public static <E> void writeData(String query, E form) {
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            converter.setData(ps, form);
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("실패했습니다!");
            return;
        }
        System.out.println("성공했습니다!");
    }
}
