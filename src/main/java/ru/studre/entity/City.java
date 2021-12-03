package ru.studre.entity;

public class City {
    private final Long id;
    private final String name;
    private final String region;
    private final String district;
    private final Integer population;
    private final String foundation;

    public City(Long id, String name, String region, String district, Integer population, String foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }
}
