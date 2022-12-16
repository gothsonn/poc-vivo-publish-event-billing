package com.accenture.PocVivoPublishEventBilling.model;

import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@SpringBootTest
class ContructorTest {
    // The package to test
    private static final String POJO_PACKAGE = "com.accenture.PocVivoPublishEventBilling.model";

    @Test
    public void defaultConstructorTest()  throws InvocationTargetException, InstantiationException, IllegalAccessException {
        List<PojoClass> pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE,
                new FilterPackageInfo());

        for (PojoClass pojoClass:pojoClasses){
            for (Constructor constructor:pojoClass.getClazz().getDeclaredConstructors()){
                testConstructor(constructor);
            }
        }
    }

    private void testConstructor(Constructor constructor) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //cria parametros randomicos para o construtor
        Object[] paramArray = this.getRandonParansForConstructor(constructor);

        Object newObj = constructor.newInstance(paramArray);
        Assertions.assertNotNull(newObj);
    }

    private Object[] getRandonParansForConstructor(Constructor constructor){
        Object[] paramArray = new Object[constructor.getParameterTypes().length];
        int i = 0;
        for (Class paramClass: constructor.getParameterTypes()){
            paramArray[i] = RandomFactory.getRandomValue(paramClass);
            i++;
        }
        return paramArray;
    }
}
