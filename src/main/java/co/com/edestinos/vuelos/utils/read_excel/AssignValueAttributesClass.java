package co.com.edestinos.vuelos.utils.read_excel;

import java.lang.reflect.Field;

import static co.com.edestinos.vuelos.utils.static_information.StaticInformation.EXCEPTION_CONSTRUCTOR_EMPTY;

public class AssignValueAttributesClass {
    private AssignValueAttributesClass() {
        throw new IllegalStateException(EXCEPTION_CONSTRUCTOR_EMPTY);
    }

    public static void setAttribute(Object object, String fieldName, Object value) throws IllegalAccessException {

        for (Field field : object.getClass().getDeclaredFields()) {

            if (field.getName().equals(fieldName)) {
                field.setAccessible(true);
                field.set(object, value);
            }
        }

        for (Field field : object.getClass().getSuperclass().getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                field.setAccessible(true);
                field.set(object, value);
            }
        }
    }

}
