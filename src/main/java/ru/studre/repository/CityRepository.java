package ru.studre.repository;

import ru.studre.entity.City;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.studre.constants.Constants.CITY_DIRECTORY_FILE_PATH;

public class CityRepository {
    private final List<City> cities;

    public CityRepository() {
        cities = new ArrayList<>();
    }

    public List<City> getCities() throws IOException {
        return getCitiesFromCsvFile();
    }

    private List<City> getCitiesFromCsvFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(CITY_DIRECTORY_FILE_PATH)));

        System.out.println("Begin read the file...");

        while (true) {

            String[] dataLineOfCsvFile;
            try {
                dataLineOfCsvFile = bufferedReader.readLine().split(";");
            } catch (NullPointerException e) {
                System.out.println("End read the file");
                break;
            }

            try {
                cities.add(
                        new City(
                                Long.parseLong(dataLineOfCsvFile[0]),
                                dataLineOfCsvFile[1],
                                dataLineOfCsvFile[2],
                                dataLineOfCsvFile[3],
                                Integer.parseInt(dataLineOfCsvFile[4]),
                                dataLineOfCsvFile[5]
                        )
                );
            } catch (IndexOutOfBoundsException e) {
                System.out.println(Arrays.toString(dataLineOfCsvFile));
                e.printStackTrace();
            }
        }
        return cities;
    }
}