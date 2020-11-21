package country;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WorldStatistics worldStatistics = new WorldStatistics();
        worldStatistics.readFiles("files/varosok.txt", "files/orszagok.txt");

        System.out.println("2. Népsûrûség (fõ/km2)");
        worldStatistics.writePopDensity();

//        System.out.println("3. hány fõ él a felsorolt városokon kívül?");
//        worldStatistics.writeRuralPopulation();

        System.out.println("4. visszaadja egy ország összes adatát: ");
        System.out.println(worldStatistics.findCountryByISoCode("AFG").toString());

        System.out.println("5. visszaadja egy paraméterül kapott kontinens országainak az országkódjait: \n"
        + worldStatistics.getCountriesOfContinent("Asia").toString());

        System.out.println("6. visszaadja egy paraméterül kapott ország városainak a neveit \n"+
                worldStatistics.getCitiesOfCountry("AFG").toString());

        System.out.println("7. Hány országnak az államfõjének nevében szerepel “Hamad” vagy “Ahmad” vagy “Ahmed”? \n" +
                worldStatistics.getAhmedCount());

        System.out.println("8. Melyik betûvel kezdõdik a legtöbb országkód? \n" +
                worldStatistics.getPopularFirstLetter());

        System.out.println("9 Melyik ország nyerte el legkésõbb (a nyilvántartás szerint) a függetlenségét? \n" +
                worldStatistics.lastIndependentCountry());

//        System.out.println("10.  Visszaadja, hogy az adott város populációja hány százaléka az anyaország populációjának. \n");
//                worldStatistics.writePopulationPercentage("Araras");


    }
}
