package dev.cequell.openpkm.main_module.configs;

import io.quarkus.logging.Log;
import org.flywaydb.core.Flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MigrationConfigs {
    // You can Inject the object if you want to use it manually
    @Inject
    Flyway flyway;

    public void checkMigration() {
        Log.info(flyway.info().current().getVersion().toString());
    }
}
