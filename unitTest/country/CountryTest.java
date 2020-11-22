package country;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class CountryTest {

    WorldStatistics ws;

    @org.junit.Before
    public void setUp() throws Exception {
        ws = new WorldStatistics();
        String countryFile = "/home/progmatic/github/Tesztek/src/Countries/files/orszagok.txt";
        String cityFile = "/home/progmatic/github/Tesztek/src/Countries/files/varosok.txt";
        ws.readFiles(cityFile, countryFile);
    }

    @org.junit.Test
    public void testPopulationDensity() {
        Country test1 = new Country("code", "Name", "Continent", "Sub Continent",
                30.0, 1999, 300, "Chuck Norris", new ArrayList<>());
        Country test2 = new Country("code", "Name", "Continent", "Sub Continent", 0,
                0, 1000, "Bruce Willis", new ArrayList<>());
        Country test3 = new Country("code", "Name", "Continent", "Sub Continent", 70,
                0, 0, "Bruce Willis", new ArrayList<>());
        Assert.assertEquals(10, test1.getPopulationDensity(), 0);
        Assert.assertEquals(-1, test2.getPopulationDensity(), 0);
        Assert.assertEquals(-1, test3.getPopulationDensity(), 0);
        }

    @org.junit.Test
    public void testRuralPopulation() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Kabul", "AFG", 1780000));
        cities.add(new City("Qandahar", "AFG", 237500));
        cities.add(new City("Herat", "AFG", 186800));
        cities.add(new City("Mazar-e-Sharif", "AFG", 127800));

        Country country = new Country("AFG", "Afghanistan", "Asia", "Southern and Central Asia",
                652090.00, 1919, 22720000, "Mohammad Omer", cities);
        int inCities = 0;
        for (City city : cities) {
            inCities += city.getCityPopulation();
        }
        int rPop = country.getPopulation() - inCities;
        Country forTest = ws.findCountryByISoCode("AFG");
        Assert.assertEquals(rPop, forTest.getRuralPopulation(), 0);
    }

    @Test
    public void testAhmedCount() {
        int ahmeds = ws.getAhmedCount();
        Assert.assertEquals(7, ahmeds);
    }

    @Test
    public void testPopularFirstLetter() {
        String firstLetter = ws.getPopularFirstLetter();
        Assert.assertEquals("M", firstLetter);
    }

    @Test
    public void testLastIndependent() {
        String lastInd = ws.lastIndependentCountry();
        Assert.assertEquals("PLW", lastInd);
    }

    @Test
    public void testCountriesOfContinent() {
        List<String> countries = new ArrayList<>();
        countries.add("ATA");
        countries.add("ATF");
        countries.add("BVT");
        countries.add("HMD");
        countries.add("SGS");

        List<String> test = ws.getCountriesOfContinent("Antarctica");
        Assert.assertEquals(countries, test);
    }

    @Test
    public void testCountriesOfContinentIfNull() {
        List<String> countries = new ArrayList<>();
        List<String> test = ws.getCountriesOfContinent("kiscica");
        Assert.assertEquals(countries, test);
    }

    @Test
    public void testCitiesOfCountry() {
        Set<String> cities = new HashSet<>();
        cities.add("Luanda");
        cities.add("Huambo");
        cities.add("Lobito");
        cities.add("Benguela");
        cities.add("Namibe");

        Set<String> test = ws.getCitiesOfCountry("AGO");
        Assert.assertEquals(cities, test);

    }
}