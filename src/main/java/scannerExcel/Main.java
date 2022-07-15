package scannerExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.readFromFile();
    }

    private void readFromFile() {
        try {
            Scanner sc = new Scanner(new FileInputStream(("C:\\Users\\Евгений\\Desktop\\city_ru.csv")));
            while (sc.hasNextLine()) {
                String[] s = sc.nextLine().split(";");
                City city;

                if (s.length == 6) {
                    city = new City(s[1], s[2], s[3], Integer.parseInt(s[4]), s[5]);
                    System.out.println(city + "\n");
                }

                if (s.length != 6) {
                    city = new City(s[1], s[2], s[3], Integer.parseInt(s[4]), "NOT VALUE");
                    System.out.println(city + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class City {
        private final String name;
        private final String region;
        private final String district;
        private final Integer population;
        private final String foundation;

        public City(String name, String region, String district, Integer population, String foundation) {
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
                    ", population='" + population + '\'' +
                    ", foundation='" + foundation + '\'' +
                    '}';
        }
    }
}
