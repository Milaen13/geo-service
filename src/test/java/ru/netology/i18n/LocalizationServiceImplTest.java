package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

    @Test
    public void testLocaleUsa() {

        LocalizationServiceImpl lsi= new LocalizationServiceImpl();
        Country test = Country.USA;
        String expected = "Welcome";
        String result = lsi.locale(test);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testLocaleRu() {

        LocalizationServiceImpl lsi = new LocalizationServiceImpl();
        Country test = Country.RUSSIA;
        String expected = "Добро пожаловать";
        String result = lsi.locale(test);
        Assertions.assertEquals(expected, result);
    }
}