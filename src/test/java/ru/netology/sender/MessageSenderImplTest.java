package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    @Test
    void testMowIp(){
        GeoService gs = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(gs.byIp("172.")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        LocalizationService ls = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(ls.locale(Country.RUSSIA)).thenReturn("Добро пожаловать!");
        MessageSenderImpl ms = new MessageSenderImpl(gs, ls);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        Assertions.assertEquals("Добро пожаловать!" ,ms.send(headers));
    }
    @Test
    void  testNyIp(){
        GeoService gs = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(gs.byIp("96.")).thenReturn(new Location("New York", Country.USA, null,  0));
        LocalizationService ls = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(ls.locale(Country.USA)).thenReturn("Hello!");
        MessageSenderImpl ms = new MessageSenderImpl(gs, ls);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        Assertions.assertEquals("Hello!" ,ms.send(headers));
    }
}