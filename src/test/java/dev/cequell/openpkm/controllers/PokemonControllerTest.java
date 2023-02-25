package dev.cequell.openpkm.controllers;

import dev.cequell.openpkm.configs.DatabaseTestConfig;
import dev.cequell.openpkm.enums.PokemonMapTypeEnum;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(value = DatabaseTestConfig.class, restrictToAnnotatedClass = true)
class PokemonControllerTest {

    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = "INVALID_MODE")
    void asValueText_FailWhenNoModeIsSelected(String mode) {
        given()
                .when()
                .queryParam("mode", mode)
                .get("/pokemon/AsValueText")
                .then()
                .statusCode(500);
    }

    @ParameterizedTest
    @EnumSource(PokemonMapTypeEnum.class)
    void asValueText_ByName(
            final PokemonMapTypeEnum mode
    ) {
        // Given
        final var kantoneanSlowpokeId = "5b04a3c4-7b3e-4bbb-9877-f9de33f45eb9";
        final var galarianSlowpokeId = "e88128d5-0522-4f59-88f8-21cc9811c301";

        final var awaitedKantoneanSlowpokeLabel =
                (mode == PokemonMapTypeEnum.ONLY_NAME) ? "Slowpoke" :
                (mode == PokemonMapTypeEnum.NAME_AND_VARIATION) ? "Slowpoke" :
                (mode == PokemonMapTypeEnum.NATIONAL_NO_WITH_NAME_AND_VARIATION) ? "79 - Slowpoke" :
                (mode == PokemonMapTypeEnum.REGIONAL_NO_WITH_NAME_AND_VARIATION) ? "324 - Slowpoke" :
                null;
        final var awaitedGalarianSlowpokeLabel =
                (mode == PokemonMapTypeEnum.ONLY_NAME) ? "Slowpoke" :
                (mode == PokemonMapTypeEnum.NAME_AND_VARIATION) ? "Slowpoke (Galarian form)" :
                (mode == PokemonMapTypeEnum.NATIONAL_NO_WITH_NAME_AND_VARIATION) ? "79 - Slowpoke (Galarian form)" :
                (mode == PokemonMapTypeEnum.REGIONAL_NO_WITH_NAME_AND_VARIATION) ? "324 - Slowpoke (Galarian form)" :
                null;

        // When/Then
        given()
                .when()
                .queryParam("mode", mode.getAlias())
                .queryParam("gen", 9)
                .queryParam("name", "slowp")
                .get("/pokemon/AsValueText")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(2),
                        "[0].value", is(kantoneanSlowpokeId),
                        "[0].label", is(awaitedKantoneanSlowpokeLabel),
                        "[1].value", is(galarianSlowpokeId),
                        "[1].label", is(awaitedGalarianSlowpokeLabel));
    }

    @ParameterizedTest
    @EnumSource(PokemonMapTypeEnum.class)
    void asValueText_ByType(
            final PokemonMapTypeEnum mode
    ) {
        final var galarianSlowkingId = "84710839-7ea1-41a6-ba40-e32c8aca9940";

        final var awaitedGalarianSlowkingLabel =
            (mode == PokemonMapTypeEnum.ONLY_NAME) ? "Slowking" :
            (mode == PokemonMapTypeEnum.NAME_AND_VARIATION) ? "Slowking (Galarian form)" :
            (mode == PokemonMapTypeEnum.NATIONAL_NO_WITH_NAME_AND_VARIATION) ? "199 - Slowking (Galarian form)" :
            (mode == PokemonMapTypeEnum.REGIONAL_NO_WITH_NAME_AND_VARIATION) ? "326 - Slowking (Galarian form)" :
            null;

        given()
                .when()
                .queryParam("mode", mode.getAlias())
                .queryParam("gen", 9)
                .queryParam("name", "slowk")
                .queryParam("type", "PSN")
                .get("/pokemon/AsValueText")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(1),
                        "[0].value", is(galarianSlowkingId),
                        "[0].label", is(awaitedGalarianSlowkingLabel));
    }

    @ParameterizedTest
    @EnumSource(PokemonMapTypeEnum.class)
    void asValueText_ByPrimaryAndSecondaryType(
            final PokemonMapTypeEnum mode
    ) {
        // Given
        final var toxelId = "2c532728-87e9-44e4-961c-7ce07b7f5d7f";
        final var ampedToxtricityId = "344b1e06-dd9c-48d1-9f5a-c5aa287cedba";
        final var lowKeyToxtricityId = "59deb991-2c55-40dc-b697-da65e070c3a1";

        final var awaitedToxelLabel =
            (mode == PokemonMapTypeEnum.ONLY_NAME) ? "Toxel" :
            (mode == PokemonMapTypeEnum.NAME_AND_VARIATION) ? "Toxel" :
            (mode == PokemonMapTypeEnum.NATIONAL_NO_WITH_NAME_AND_VARIATION) ? "848 - Toxel" :
            (mode == PokemonMapTypeEnum.REGIONAL_NO_WITH_NAME_AND_VARIATION) ? "198 - Toxel" :
            null;
        final var awaitedAmpedToxtricityLabel =
            (mode == PokemonMapTypeEnum.ONLY_NAME) ? "Toxtricity" :
            (mode == PokemonMapTypeEnum.NAME_AND_VARIATION) ? "Toxtricity (Amped form)" :
            (mode == PokemonMapTypeEnum.NATIONAL_NO_WITH_NAME_AND_VARIATION) ? "849 - Toxtricity (Amped form)" :
            (mode == PokemonMapTypeEnum.REGIONAL_NO_WITH_NAME_AND_VARIATION) ? "199 - Toxtricity (Amped form)" :
            null;
        final var awaitedLowKeyToxtricityLabel =
            (mode == PokemonMapTypeEnum.ONLY_NAME) ? "Toxtricity" :
            (mode == PokemonMapTypeEnum.NAME_AND_VARIATION) ? "Toxtricity (Low Key form)" :
            (mode == PokemonMapTypeEnum.NATIONAL_NO_WITH_NAME_AND_VARIATION) ? "849 - Toxtricity (Low Key form)" :
            (mode == PokemonMapTypeEnum.REGIONAL_NO_WITH_NAME_AND_VARIATION) ? "199 - Toxtricity (Low Key form)" :
            null;

        // When/Then
        given()
                .when()
                .queryParam("mode", mode.getAlias())
                .queryParam("gen", 9)
                .queryParam("primary", "ELT")
                .queryParam("secondary", "PSN")
                .get("/pokemon/AsValueText")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(3),
                        "[0].value", is(toxelId),
                        "[0].label", is(awaitedToxelLabel),
                        "[1].value", is(lowKeyToxtricityId),
                        "[1].label", is(awaitedLowKeyToxtricityLabel),
                        "[2].value", is(ampedToxtricityId),
                        "[2].label", is(awaitedAmpedToxtricityLabel));
    }
}