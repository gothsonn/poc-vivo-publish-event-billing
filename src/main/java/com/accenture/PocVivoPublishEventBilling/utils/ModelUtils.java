package com.accenture.PocVivoPublishEventBilling.utils;

import java.lang.reflect.Field;

public class ModelUtils {
    public static String modelToString(Object obj) {
        String className = obj.getClass().getSimpleName();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("class " + className + " {\n");

            Object property;
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                property = field.get(obj);
                sb.append("    ").append(field.getName()).append(": ").append(toIndentedString(property)).append("\n");
            }

            sb.append("}");
            return sb.toString();
        } catch(IllegalAccessException ex) {
            throw new RuntimeException("Error in toString of Object " + className + ": " + ex.getMessage());
        }
    }

    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
