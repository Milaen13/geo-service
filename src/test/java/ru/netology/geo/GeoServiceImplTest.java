package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import static ru.netology.geo.GeoServiceImpl.MOSCOW_IP;
import static ru.netology.geo.GeoServiceImpl.NEW_YORK_IP;



public class GeoServiceImplTest {

    @Test
    public void testByIpNull() {

        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
        String testIp = "0.0.0.0";
        Location expectedLocation = null;
        Location resultLocation = geoServiceImpl.byIp(testIp);
        Assertions.assertEquals(expectedLocation, resultLocation);
    }

    @Test
    public void testByIpMow() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(MOSCOW_IP)).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Location location = geoServiceImpl.byIp(MOSCOW_IP);
        Country country = location.getCountry();
        Assertions.assertEquals(country, Country.RUSSIA);
    }

    @Test
    public void testByIpNy() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(NEW_YORK_IP)).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Location location = geoServiceImpl.byIp(NEW_YORK_IP);
        Country country = location.getCountry();
        Assertions.assertEquals(country, Country.USA);
    }
}