package country;

public class City  {
    private String cityName;
    private String countryCode;
    private int cityPopulation;

    public City(String cityName, String countryCode, int cityPopulation) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.cityPopulation = cityPopulation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", cityPopulation=" + cityPopulation +
                '}';
    }

//    public double getPopulationPercentage() {
//        if (getPopulation() == 0 || getCityPopulation() == 0) {
//            return -1;
//        }
//        return (double) getCityPopulation() / getPopulation() * 100;
//    }
}
