package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.configs.DatabaseTestConfig;
import dev.cequell.openpkm.main_module.enums.PokemonMapTypeEnum;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
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

        final var query = """
                getPokemonAsValueText(
                    mode:%s,
                    filterBy:{
                        name:\\\"slowp\\\"
                    }
                ){
                    value,
                    label
                }
                """.formatted(
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

        final var query = """
                getPokemonAsValueText(
                    mode:%s,
                    filterBy:{
                        name:\\\"slowk\\\",
                        types:PSN,
                        generationNo:Gen_IX
                    }
                ){
                    value,
                    label
                }
                """.formatted(
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
        final var query = """
                getPokemonAsValueText(
                    mode:%s,
                    filterBy:{
                        primaryType:ELT,
                        secondaryType:PSN,
                        generationNo:Gen_IX
                    }
                ){
                    value,
                    label
                }
                """.formatted(
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
        final var query = """
                getPokemonById(
                    id:\\\"%s\\\"
                ){
                    id,
                    name,
                    variation
                }
                """.formatted(wrongId);

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
    void pagedByGeneration() {
        // Given
        final var size = 3;
        final var page = 2;

        // When / Then
        final var query = """
                getPokemonPaged(
                    page:%d,
                    size:%d,
                    filterBy:{
                        generationNo:Gen_IX,
                        sortBy:REGIONAL_DEX_NO
                    }
                ){
                    page,
                    offset,
                    data{
                        id,
                        name
                    }
                }
                """
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
                .statusCode(HttpStatus.SC_OK)
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

    @Test
    void pagedByName() {
        // Given
        final var size = 10;
        final var page = 0;

        // When / Then
        final var query = """
                getPokemonPaged(
                    page:%d,
                    size:%d,
                    filterBy:{
                        name:\\\"mar\\\",
                        generationNo:Gen_IX,
                        sortBy:REGIONAL_DEX_NO
                    }
                ){
                    page,
                    offset,
                    data{
                        id,
                        name
                    }
                }
                """
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
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonPaged.page", is(page),
                        "data.getPokemonPaged.offset", is(page*size),
                        "data.getPokemonPaged.data.size()", is(5),

                        "data.getPokemonPaged.data[0].id", is("d06a69ab-7d92-421e-9109-365accf9c883"),
                        "data.getPokemonPaged.data[0].name", is("Marill"),

                        "data.getPokemonPaged.data[1].id", is("52b96269-d53f-44df-ad71-a962c113312c"),
                        "data.getPokemonPaged.data[1].name", is("Azumarill"),

                        "data.getPokemonPaged.data[2].id", is("d4a6dc63-5cc5-4760-8752-c638c3e5726f"),
                        "data.getPokemonPaged.data[2].name", is("Mareep"),

                        "data.getPokemonPaged.data[3].id", is("9f22cf38-4037-4ba0-b825-aaabcb082637"),
                        "data.getPokemonPaged.data[3].name", is("Armarouge"),

                        "data.getPokemonPaged.data[4].id", is("eb66fc45-d7b0-405e-9b22-8d77710f2b4c"),
                        "data.getPokemonPaged.data[4].name", is("Mareanie")
                );
    }

    @Test
    void pagedByClassification() {
        // Given
        final var size = 10;
        final var page = 0;

        // When / Then
        final var query = """
                getPokemonPaged(
                    page:%d,
                    size:%d,
                    filterBy:{
                        classification:\\\"tra\\\",
                        generationNo:Gen_IX,
                        sortBy:REGIONAL_DEX_NO
                    }
                ){
                    page,
                    offset,
                    data{
                        id,
                        name,
                        classification
                    }
                }
                """
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
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonPaged.page", is(page),
                        "data.getPokemonPaged.offset", is(page*size),
                        "data.getPokemonPaged.data.size()", is(3),

                        "data.getPokemonPaged.data[0].id", is("49cacb6e-24b3-452b-af34-5b9d8a86c654"),
                        "data.getPokemonPaged.data[0].name", is("Spidops"),
                        "data.getPokemonPaged.data[0].classification", is("Trap"),

                        "data.getPokemonPaged.data[1].id", is("c694ef54-3974-40a7-91bd-3f9bcc4bea9b"),
                        "data.getPokemonPaged.data[1].name", is("Ditto"),
                        "data.getPokemonPaged.data[1].classification", is("Transform"),

                        "data.getPokemonPaged.data[2].id", is("4f5b4e8b-9fc0-4c2c-807d-05edfadc1702"),
                        "data.getPokemonPaged.data[2].name", is("Gothitelle"),
                        "data.getPokemonPaged.data[2].classification", is("Astral Body")
                );
    }

    @Test
    void pagedByVariation() {
        // Given
        final var size = 10;
        final var page = 0;

        // When / Then
        final var query = """
                getPokemonPaged(
                    page:%d,
                    size:%d,
                    filterBy:{
                        variation:\\\"rot\\\",
                        generationNo:Gen_IX,
                        sortBy:REGIONAL_DEX_NO
                    }
                ){
                    page,
                    offset,
                    data{
                        id,
                        name,
                        variation
                    }
                }
                """
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
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonPaged.page", is(page),
                        "data.getPokemonPaged.offset", is(page*size),
                        "data.getPokemonPaged.data.size()", is(5),

                        "data.getPokemonPaged.data[0].id", is("fb01ac28-e8cc-400a-b2a0-e7fe175559b9"),
                        "data.getPokemonPaged.data[0].name", is("Rotom"),
                        "data.getPokemonPaged.data[0].variation", is("Frost Rotom"),

                        "data.getPokemonPaged.data[1].id", is("9c3f574e-c213-4cd9-af8f-dd5a206ab204"),
                        "data.getPokemonPaged.data[1].name", is("Rotom"),
                        "data.getPokemonPaged.data[1].variation", is("Heat Rotom"),

                        "data.getPokemonPaged.data[2].id", is("5d6b35c3-113c-4081-bc8c-d3a0e42b13c2"),
                        "data.getPokemonPaged.data[2].name", is("Rotom"),
                        "data.getPokemonPaged.data[2].variation", is("Mow Rotom"),

                        "data.getPokemonPaged.data[3].id", is("d6025ac9-d7e7-467c-864b-504e0e757449"),
                        "data.getPokemonPaged.data[3].name", is("Rotom"),
                        "data.getPokemonPaged.data[3].variation", is("Fan Rotom"),

                        "data.getPokemonPaged.data[4].id", is("ee0ec469-f918-4bb7-bb06-a5a86b3049c8"),
                        "data.getPokemonPaged.data[4].name", is("Rotom"),
                        "data.getPokemonPaged.data[4].variation", is("Wash Rotom")
                );
    }

    @Test
    void pagedByPrimaryType() {
        // Given
        final var size = 10;
        final var page = 0;

        // When / Then
        final var query = """
                getPokemonPaged(
                    page:%d,
                    size:%d,
                    filterBy:{
                        primaryType:FLY,
                        generationNo:Gen_IX,
                        sortBy:REGIONAL_DEX_NO
                    }
                ){
                    page,
                    offset,
                    data{
                        id,
                        name
                    }
                }
                """
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
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonPaged.page", is(page),
                        "data.getPokemonPaged.offset", is(page*size),
                        "data.getPokemonPaged.data.size()", is(7),

                        "data.getPokemonPaged.data[0].id", is("3a395a77-abd6-41f7-8fe6-26af1d0c0c8a"),
                        "data.getPokemonPaged.data[0].name", is("Rookidee"),

                        "data.getPokemonPaged.data[1].id", is("bdecf3ad-f44f-4b43-8d28-bfb55af18a4e"),
                        "data.getPokemonPaged.data[1].name", is("Corvisquire"),

                        "data.getPokemonPaged.data[2].id", is("63bc9c69-7461-4018-850a-7ba58fd96de9"),
                        "data.getPokemonPaged.data[2].name", is("Corviknight"),

                        "data.getPokemonPaged.data[3].id", is("18e7b985-1665-4d96-958e-c0c08a95f84a"),
                        "data.getPokemonPaged.data[3].name", is("Bombirdier"),

                        "data.getPokemonPaged.data[4].id", is("b3bf896e-bfaa-4703-8af7-8d34024db5f9"),
                        "data.getPokemonPaged.data[4].name", is("Noibat"),

                        "data.getPokemonPaged.data[5].id", is("c7edda85-7ffd-4052-a51b-55a67cc34d51"),
                        "data.getPokemonPaged.data[5].name", is("Noivern"),

                        "data.getPokemonPaged.data[6].id", is("7b0b2233-877f-45c4-93f4-c0d4e9d3b7a0"),
                        "data.getPokemonPaged.data[6].name", is("Flamigo")
                );
    }

    @Test
    void pagedBySecondaryType() {
        // Given
        final var size = 100;
        final var page = 0;

        // When / Then
        final var query = """
                getPokemonPaged(
                    page:%d,
                    size:%d,
                    filterBy:{
                        secondaryType:BUG,
                        generationNo:Gen_IX,
                        sortBy:REGIONAL_DEX_NO
                    }
                ){
                    page,
                    offset,
                    data{
                        id,
                        name
                    }
                }
                """
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
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonPaged.page", is(page),
                        "data.getPokemonPaged.offset", is(page*size),
                        "data.getPokemonPaged.data.size()", is(2),

                        "data.getPokemonPaged.data[0].id", is("6e8e98e5-cc8e-4225-8a86-a97f52e882b8"),
                        "data.getPokemonPaged.data[0].name", is("Snom"),

                        "data.getPokemonPaged.data[1].id", is("73007531-3383-4575-a241-806688d2fe03"),
                        "data.getPokemonPaged.data[1].name", is("Frosmoth")
                );
    }
}