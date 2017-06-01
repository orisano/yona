package yona.orm;

import yona.reflection.TypeUtil;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {
    public Mapper(){}

    public <T> T fromResultSet(ResultSet resultSet, Class<T> type) throws SQLException {
        try {
            T obj = type.newInstance();
            for (Field field : type.getDeclaredFields()) {
                if (!field.isAnnotationPresent(Column.class)) {
                    continue;
                }
                Column annotation = field.getAnnotation(Column.class);
                String label = annotation.value();

                field.setAccessible(true);
                switch (TypeUtil.getKind(field.getType())) {
                    case INT_TYPE:
                        field.set(obj, resultSet.getInt(label));
                        break;
                    case DOUBLE_TYPE:
                        field.set(obj, resultSet.getDouble(label));
                        break;
                    case STRING_TYPE:
                        field.set(obj, resultSet.getString(label));
                        break;
                    case BOOLEAN_TYPE:
                        field.set(obj, resultSet.getBoolean(label));
                        break;
                    case UNKNOWN_TYPE:
                        break;
                }
            }
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
