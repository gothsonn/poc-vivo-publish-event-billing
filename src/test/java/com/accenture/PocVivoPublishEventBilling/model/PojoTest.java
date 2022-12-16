package com.accenture.PocVivoPublishEventBilling.model;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.*;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class PojoTest {
    // The package to test
    private static final String POJO_PACKAGE = "com.accenture.PocVivoPublishEventBilling.model";

    @Test
    public void pojoGetterSetterTest() {
        Validator validator = ValidatorBuilder.create()
                // Add Rules to validate structure for POJO_PACKAGE
                // See com.openpojo.validation.rule.impl for more ...
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                // Add Testers to validate behaviour for POJO_PACKAGE
                // See com.openpojo.validation.test.impl for more ...
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        validator.validate(POJO_PACKAGE, new FilterPackageInfo());
    }

    @Test
    void hashCodeAndEqualsShouldBehaveProperlyTest() {
        // Validate first that both equals and hashcode are both present
        Validator validator = ValidatorBuilder.create().with(new EqualsAndHashCodeMatchRule()).build();
        validator.validate(POJO_PACKAGE, new FilterPackageInfo());

        // Now validate that equals and hashcode work, are symmetric, etc.
        EqualsVerifier.simple().forPackage(POJO_PACKAGE).verify();
    }
}
