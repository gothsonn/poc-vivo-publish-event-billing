package com.accenture.PocVivoPublishEventBilling.model;

import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@SpringBootTest
class SetPropertyReturningObjectTest {
    private static final String POJO_PACKAGE = "com.accenture.PocVivoPublishEventBilling.model";

    //Testa models que possuem metodos com nomes iguais a de uma propriedade que setam a propriedade
    //e retornam o model com a propriedade alterada

    @Test
    public void setPropertyReturningObjectTest() throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        List<PojoClass> pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE,
                new FilterPackageInfo());

        Object obj, returnObj, newPropertyValue;
        Field modifiedField;
        for (PojoClass pojoClass:pojoClasses){
            for (Method metodo:pojoClass.getClazz().getDeclaredMethods()){
                if (isValidTestMethod(pojoClass.getClazz(), metodo)){
                    obj = RandomFactory.getRandomValue(pojoClass.getClazz());
                    newPropertyValue = RandomFactory.getRandomValue(metodo.getParameterTypes()[0]);
                    returnObj = metodo.invoke(obj, newPropertyValue);
                    modifiedField = pojoClass.getClazz().getDeclaredField(metodo.getName());
                    modifiedField.setAccessible(true);

                    Assertions.assertEquals(modifiedField.get(obj), modifiedField.get(returnObj));
                    Assertions.assertEquals(obj, returnObj);
                }
            }
        }
    }

    private Boolean isValidTestMethod(Class clazz, Method metodo){
        for (Field field:clazz.getDeclaredFields()){
            if (field.getName().equals(metodo.getName())){
                Assertions.assertEquals(
                        metodo.getReturnType(), clazz,
                        "Métodos com nome de uma propriedade devem setar a propriedade e retornar uma referencia do objeto"
                );

                Assertions.assertEquals(
                        1, metodo.getParameterTypes().length,
                        "Métodos com nome de uma propriedade devem conter somente um parametro"
                );

                return true;
            }
        }
        return false;
    }
}
