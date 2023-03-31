package dev.cequell.openpkm.main_module.configs;

import org.flywaydb.core.Flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@SuppressWarnings("unused")
@ApplicationScoped
public class MigrationConfigs {
    @Inject
    Flyway flyway;

    public void checkMigration() {
    }
}
