package utility;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.customException.CustomReflectionException;

public class Converter {

    /**
     *
     * E form : DTO 객체 전달 (ex. new MovieDTO() )
     * List<> 필요한 경우에는 다른 메서드 사용?
     */
    public <E> E getDataByDTO(ResultSet resultSet, E form) throws SQLException {
        Class<?> clazz = form.getClass();
        Field[] fields = clazz.getDeclaredFields();

        while (resultSet.next()) {
            try {
                mapToDTO(resultSet, form, fields);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new CustomReflectionException();
            }
        }

        return form;
    }

    public <E> List<E> getDataByList(ResultSet resultSet, E form)
            throws SQLException {
        Class<?> clazz = form.getClass();
        Field[] fields = clazz.getDeclaredFields();

        List<E> forms = new ArrayList<>();

        while (resultSet.next()) {
            try {
                mapToDTO(resultSet, form, fields);
                forms.add(form);
                form = (E) clazz.getDeclaredConstructor().newInstance();
            }  catch (InvocationTargetException | IllegalAccessException | InstantiationException |
                      NoSuchMethodException e) {
                e.printStackTrace();
                throw new CustomReflectionException();
            }
        }
        return forms;
    }

    private <E> void mapToDTO(ResultSet resultSet, E form, Field[] fields)
            throws SQLException, IllegalAccessException {
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = resultSet.getObject(field.getName());

            if (field.getType().isEnum() && value instanceof String) {
                // Enum 타입 필드에 문자열 값을 Enum으로 변환
                String enumValue = (String) value;
                @SuppressWarnings("unchecked")
                Class<? extends Enum> enumClass = (Class<? extends Enum>) field.getType();
                value = Enum.valueOf(enumClass, enumValue);
            }

            field.set(form, value);
        }
    }


    public <E> void setData(PreparedStatement ps, E form) throws IllegalAccessException, SQLException {
        Class<?> clazz = form.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 1; i <= fields.length; i++) {
            fields[i - 1].setAccessible(true);
            ps.setObject(i, fields[i - 1].get(form));
        }
        ps.executeUpdate();
    }
}
