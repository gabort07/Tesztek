package country;

import java.util.List;

public class Country {
    private String continentName;
    private String subContinent;
    private String countryCode;
    private String countryName;
    private double area;
    private int gotIndependent;
    private int population;
    private String nameOfPresident;
    private List<City> citiesList;

    public Country(String countryCode, String countryName, String continentName, String subContinent, double area, int gotIndependent, int population, String nameOfPresident, List<City> cityList) {
        this.countryCode = countryCode;
        this.continentName = continentName;
        this.subContinent = subContinent;
        this.countryName = countryName;
        this.area = area;
        this.gotIndependent = gotIndependent;
        this.population = population;
        this.nameOfPresident = nameOfPresident;
        this.citiesList = cityList;
    }



    public String getContinentName() {
        return continentName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getGotIndependent() {
        return gotIndependent;
    }

    public String getNameOfPresident() {
        return nameOfPresident;
    }

    public List<City> getCitiesList() {
        return this.citiesList;
    }

    public double getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getPopulationDensity() {
        double density = -1;
        if (getPopulation() == 0 || getArea() == 0) {
            return density;
        }
        return getPopulation() / getArea();
    }

    public double getRuralPopulation() {
        int cityPopulation = 0;
        for (City actualCity : getCitiesList()) {
            cityPopulation += actualCity.getCityPopulation();
        }
        return (double) population - cityPopulation;
    }


    @Override
    public String toString() {
        return "Country{" +
                "continentName='" + continentName + '\'' +
                ", subContinent='" + subContinent + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", area=" + area +
                ", gotIndependent=" + gotIndependent +
                ", population=" + population +
                ", nameOfPresident='" + nameOfPresident + '\'' +
                ", citiesList=" + citiesList +
                '}';
    }
}
