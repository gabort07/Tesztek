package country;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WorldStatistics {
    private List<Country> countryList = new ArrayList<>();
    private HashMap<String, Country> countriesByISCode = new HashMap<>();
    private HashMap<String, ArrayList<City>> cityMap = new HashMap<>();

    public void setCountryList(ArrayList<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void readFiles(String citiesFile, String countriesFile) throws FileNotFoundException {
        Scanner scCity = new Scanner(new File(citiesFile));

        while (scCity.hasNextLine()) {
            String[] cityData = scCity.nextLine().split(",");
           if (cityData.length > 1) {
                String cCode = cityData[1];
                City city = new City(cityData[0], cCode, Integer.parseInt(cityData[2]));
                cityMap.putIfAbsent(cCode, new ArrayList<>());
                cityMap.get(cCode).add(city);
            }
        }
        Scanner scCountry = new Scanner(new File(countriesFile));
        ArrayList<Country> countriesList = new ArrayList<>();
        while (scCountry.hasNextLine()) {
            String[] countryData = scCountry.nextLine().split(",");
            String cCode = countryData[0];
            int independent;
            String ruler;
            if (!countryData[5].trim().equals("NULL")) {
                independent = Integer.parseInt(countryData[5].trim());
            } else {
                independent = 0;
            }

            if (countryData.length < 8) {
                ruler = "-";
            } else {
                ruler = countryData[7];
            }

            Country country = new Country(cCode, countryData[1], countryData[2], countryData[3], Double.parseDouble(countryData[4]), independent, Integer.parseInt(countryData[6]), ruler, cityMap.get(cCode));
            countriesList.add(country);
            countriesByISCode.put(cCode, country);

        }
        setCountryList(countriesList);
    }

    public void writePopDensity() {
        for (Country country : getCountryList()) {
            System.out.println(country.getCountryName() + ": " + country.getPopulationDensity());
        }
    }

    public void writeRuralPopulation() {
        for (Country country : getCountryList()) {
            System.out.println(country.getCountryName() + ": " + country.getRuralPopulation());
        }
    }

    public Country findCountryByISoCode(String isoCode) {
        return countriesByISCode.get(isoCode);
    }

    public ArrayList<String> getCountriesOfContinent(String continentName) {
        ArrayList<String> countryCodes = new ArrayList<>();
        for (Country country : countryList) {
            if (country.getContinentName().equals(continentName)) {
                countryCodes.add(country.getCountryCode());
            }
        }
        return countryCodes;
    }

    public HashSet<String> getCitiesOfCountry(String countryCode) {
        HashSet<String> citiesSet = new HashSet<>();
        for (City city : countriesByISCode.get(countryCode).getCitiesList()) {
            citiesSet.add(city.getCityName());
        }
        return citiesSet;
    }

    public int getAhmedCount() {
        int counter = 0;
        String[] nameParts = {"Hamad", "Ahmad", "Ahmed"};
        for (Country country : countryList) {
            String name = country.getNameOfPresident();
            if (name.contains(nameParts[0]) || name.contains(nameParts[1]) || name.contains(nameParts[2])) {
                counter++;
            }
        }
        return counter;
    }

    public String getPopularFirstLetter() {
        int max = 0;
        char letter = 'x';
        HashMap<Character, Integer> letterCounter = new HashMap<>();
        for (Country actual : countryList) {
            char code = actual.getCountryCode().charAt(0);
            if (letterCounter.containsKey(code)) {
                letterCounter.put(code, letterCounter.get(code) + 1);
            } else {
                letterCounter.put(code, 1);
            }
        }

        for (char c : letterCounter.keySet()) {
            if (letterCounter.get(c) > max) {
                max = letterCounter.get(c);
                letter = c;
            }
        }
        return Character.toString(letter);
    }

    public String lastIndependentCountry() {
        int year = 0;
        String code = "";
        for (Country country : countryList) {
            if (country.getGotIndependent() > year) {
                year = country.getGotIndependent();
                code = country.getCountryCode();
            }
        }
        return code;
    }

//    public void writePopulationPercentage(String city) {
//        City s;
//        for (Country actual : countryList) {
//            for (City actualCity : actual.getCitiesList()) {
//                if (actualCity.getCityName().equals(city)) {
//                    System.out.println(actualCity.getPopulationPercentage());
//                }
//            }
//        }
//    }


}
