package org.example;


import org.flywaydb.core.Flyway;

public class Main {
    public static void initMigration() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./spacetravel", "sa", "")
                .load();
        flyway.migrate();
    }


    public static void main(String[] args) {
        initMigration();
        System.out.println("Flyway ініціював і заповнив БД");

    }
}