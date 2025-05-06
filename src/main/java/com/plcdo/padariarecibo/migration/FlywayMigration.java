package com.plcdo.padariarecibo.migration;


import org.flywaydb.core.Flyway;

public class FlywayMigration {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")
                .locations("classpath:/db/migration")
                .load();

        flyway.migrate();
    }

}
