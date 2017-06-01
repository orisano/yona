package yona.reflection;

public class TypeUtil {
    public enum Kind {
        INT_TYPE,
        DOUBLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        UNKNOWN_TYPE,
    }

    public static <T> Kind getKind(Class<T> type) {
        if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
            return Kind.INT_TYPE;
        }
        if (type.isAssignableFrom(double.class) || type.isAssignableFrom(Double.class)) {
            return Kind.DOUBLE_TYPE;
        }
        if (type.isAssignableFrom(boolean.class) || type.isAssignableFrom(Boolean.class)) {
            return Kind.BOOLEAN_TYPE;
        }
        if (type.isAssignableFrom(String.class)) {
            return Kind.STRING_TYPE;
        }
        return Kind.UNKNOWN_TYPE;
    }

}
