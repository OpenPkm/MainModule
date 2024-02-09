package dev.cequell.openpkm.main_module.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;

@SuppressWarnings("unused")
@ApplicationScoped
public class MigrationConfigs {
    @Inject
    Flyway flyway;

    public void checkMigration() {
    }
}
