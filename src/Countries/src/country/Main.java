package country;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WorldStatistics worldStatistics = new WorldStatistics();
        worldStatistics.readFiles("files/varosok.txt", "files/orszagok.txt");

        System.out.println("2. N�ps�r�s�g (f�/km2)");
        worldStatistics.writePopDensity();

//        System.out.println("3. h�ny f� �l a felsorolt v�rosokon k�v�l?");
//        worldStatistics.writeRuralPopulation();

        System.out.println("4. visszaadja egy orsz�g �sszes adat�t: ");
        System.out.println(worldStatistics.findCountryByISoCode("AFG").toString());

        System.out.println("5. visszaadja egy param�ter�l kapott kontinens orsz�gainak az orsz�gk�djait: \n"
        + worldStatistics.getCountriesOfContinent("Asia").toString());

        System.out.println("6. visszaadja egy param�ter�l kapott orsz�g v�rosainak a neveit \n"+
                worldStatistics.getCitiesOfCountry("AFG").toString());

        System.out.println("7. H�ny orsz�gnak az �llamf�j�nek nev�ben szerepel �Hamad� vagy �Ahmad� vagy �Ahmed�? \n" +
                worldStatistics.getAhmedCount());

        System.out.println("8. Melyik bet�vel kezd�dik a legt�bb orsz�gk�d? \n" +
                worldStatistics.getPopularFirstLetter());

        System.out.println("9 Melyik orsz�g nyerte el legk�s�bb (a nyilv�ntart�s szerint) a f�ggetlens�g�t? \n" +
                worldStatistics.lastIndependentCountry());

//        System.out.println("10.  Visszaadja, hogy az adott v�ros popul�ci�ja h�ny sz�zal�ka az anyaorsz�g popul�ci�j�nak. \n");
//                worldStatistics.writePopulationPercentage("Araras");


    }
}
