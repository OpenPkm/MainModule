package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.configs.DatabaseTestConfig;
import dev.cequell.openpkm.main_module.enums.PokemonMapTypeEnum;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

@QuarkusTest
@QuarkusTestResource(value = DatabaseTestConfig.class, restrictToAnnotatedClass = true)
class PokemonControllerTest {

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

        final var query = "getPokemonAsValueText(mode:%s,filterBy:{name:\\\"slowp\\\"}){value,label}".formatted(
                mode.name());

        // When/Then
        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{%s}"
                        }
                        """.formatted(query))
                .post("/ql")
                .then()
                .statusCode(200)
                .body(
                        "errors", nullValue(),
                        "data.getPokemonAsValueText.size()", is(2),

                        "data.getPokemonAsValueText[0].value", is(kantoneanSlowpokeId),
                        "data.getPokemonAsValueText[0].label", is(awaitedKantoneanSlowpokeLabel),

                        "data.getPokemonAsValueText[1].value", is(galarianSlowpokeId),
                        "data.getPokemonAsValueText[1].label", is(awaitedGalarianSlowpokeLabel));
    }

    @ParameterizedTest
    @EnumSource(PokemonMapTypeEnum.class)
    void asValueText_ByType(
            final PokemonMapTypeEnum mode
    ) {
        // When
        final var galarianSlowkingId = "84710839-7ea1-41a6-ba40-e32c8aca9940";

        final var awaitedGalarianSlowkingLabel =
            (mode == PokemonMapTypeEnum.ONLY_NAME) ? "Slowking" :
            (mode == PokemonMapTypeEnum.NAME_AND_VARIATION) ? "Slowking (Galarian form)" :
            (mode == PokemonMapTypeEnum.NATIONAL_NO_WITH_NAME_AND_VARIATION) ? "199 - Slowking (Galarian form)" :
            (mode == PokemonMapTypeEnum.REGIONAL_NO_WITH_NAME_AND_VARIATION) ? "326 - Slowking (Galarian form)" :
            null;

        final var query = "getPokemonAsValueText(mode:%s,filterBy:{name:\\\"slowk\\\",types:PSN,generationNo:Gen_IX}){value,label}".formatted(
                mode.name());

        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{%s}"
                        }
                        """.formatted(query))
                .post("/ql")
                .then()
                .statusCode(200)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonAsValueText.size()", is(1),
                        "data.getPokemonAsValueText[0].value", is(galarianSlowkingId),
                        "data.getPokemonAsValueText[0].label", is(awaitedGalarianSlowkingLabel));
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

        // When / Then
        final var query = "getPokemonAsValueText(mode:%s,filterBy:{primaryType:ELT,secondaryType:PSN,generationNo:Gen_IX}){value,label}".formatted(
                mode.name());

        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{%s}"
                        }
                        """.formatted(query))
                .post("/ql")
                .then()
                .statusCode(200)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonAsValueText.size()", is(3),

                        "data.getPokemonAsValueText[0].value", is(toxelId),
                        "data.getPokemonAsValueText[0].label", is(awaitedToxelLabel),

                        "data.getPokemonAsValueText[1].value", is(lowKeyToxtricityId),
                        "data.getPokemonAsValueText[1].label", is(awaitedLowKeyToxtricityLabel),

                        "data.getPokemonAsValueText[2].value", is(ampedToxtricityId),
                        "data.getPokemonAsValueText[2].label", is(awaitedAmpedToxtricityLabel));
    }

    @Test
    void byId() {
        // Given
        final var toxtricityLowKeyId = "59deb991-2c55-40dc-b697-da65e070c3a1";

        // When / Then
        final var query = "getPokemonById(id:\\\"%s\\\"){id,name,variation}".formatted(toxtricityLowKeyId);

        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{%s}"
                        }
                        """.formatted(query))
                .post("/ql")
                .then()
                .statusCode(200)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonById.id", is(toxtricityLowKeyId),
                        "data.getPokemonById.name", is("Toxtricity"),
                        "data.getPokemonById.variation", is("Low Key")
                );
    }

    @Test
    void byIdFailWithUnavailableId() {
        // Given
        final var wrongId = "00000000-0000-0000-0000-000000000000";

        // When / Then
        final var query = "getPokemonById(id:\\\"%s\\\"){id,name,variation}".formatted(wrongId);

        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{%s}"
                        }
                        """.formatted(query))
                .post("/ql")
                .then()
                .statusCode(200)
                .body(
                        "data.getPokemonById", nullValue(),

                        "errors.size()", is(1),
                        "errors[0].extensions.code", is("invalid-id"),
                        "errors[0].message", is("Id '%s' not found".formatted(wrongId))
                );
    }

    @Test
    void paged() {
        // Given
        final var size = 3;
        final var page = 2;

        // When / Then
        final var query = "getPokemonPaged(page:%d,size:%d,filterBy:{generationNo:Gen_IX,sortBy:REGIONAL_DEX_NO}){page,offset,data{id,name}}"
                .formatted(page, size);

        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{%s}"
                        }
                        """.formatted(query))
                .post("/ql")
                .then()
                .statusCode(200)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonPaged.page", is(page),
                        "data.getPokemonPaged.offset", is(page*size),
                        "data.getPokemonPaged.data.size()", is(size),

                        "data.getPokemonPaged.data[0].id", is("9c4b1aa8-d630-4510-b554-10c472d0a566"),
                        "data.getPokemonPaged.data[0].name", is("Quaxly"),

                        "data.getPokemonPaged.data[1].id", is("7c1637c1-38b6-4ba9-b738-28caebc1573a"),
                        "data.getPokemonPaged.data[1].name", is("Quaxwell"),

                        "data.getPokemonPaged.data[2].id", is("fcc6c84a-44b5-4480-bb62-4737c5c56c9e"),
                        "data.getPokemonPaged.data[2].name", is("Quaquaval")
                );
    }
}