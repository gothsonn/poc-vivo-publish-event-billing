package com.accenture.PocVivoPublishEventBilling.utils;

import com.accenture.PocVivoPublishEventBilling.model.Account;
import com.accenture.PocVivoPublishEventBilling.model.FinancialAccountCreateEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
class ModelUtilsTest {
    @Test
    public void modelToStringBillFormatTest() {
        Account account = new Account();
        account.setId("123");
        account.setHref("http://www.google.com.br/");
        account.setDescription("Asdiuhsa UHADIUSAHDIUSAad saihdsaiu");
        account.setName("The Account");
        account.setBaseType(null);
        account.setSchemaLocation("local 1");
        account.setType("Type 1");

        String toString = ModelUtils.modelToString(account);

        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    id: ").append("123").append("\n");
        sb.append("    href: ").append("http://www.google.com.br/").append("\n");
        sb.append("    accountType: ").append("null").append("\n");
        sb.append("    description: ").append("Asdiuhsa UHADIUSAHDIUSAad saihdsaiu").append("\n");
        sb.append("    lastModified: ").append("null").append("\n");
        sb.append("    name: ").append("The Account").append("\n");
        sb.append("    state: ").append("null").append("\n");
        sb.append("    accountBalance: ").append("null").append("\n");
        sb.append("    accountRelationship: ").append("null").append("\n");
        sb.append("    contact: ").append("null").append("\n");
        sb.append("    creditLimit: ").append("null").append("\n");
        sb.append("    relatedParty: ").append("null").append("\n");
        sb.append("    taxExemption: ").append("null").append("\n");
        sb.append("    baseType: ").append("null").append("\n");
        sb.append("    schemaLocation: ").append("local 1").append("\n");
        sb.append("    type: ").append("Type 1").append("\n");
        sb.append("}");

        Assertions.assertEquals(sb.toString(), toString);
    }
}