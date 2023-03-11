package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.configs.DatabaseTestConfig;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

@QuarkusTest
@QuarkusTestResource(value = DatabaseTestConfig.class, restrictToAnnotatedClass = true)
class GenControllerTest {

    @Test
    void getAll() {
        // Given
        final var generationCount = 9;

        // When / Then
        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{getAllGenerations{value: id,label: name}}"
                        }
                        """)
                .post("/ql")
                .then()
                .statusCode(200)
                .body(
                        "errors", nullValue(),
                        "data.getAllGenerations.size()", is(generationCount),

                        "data.getAllGenerations[0].value", is("379d54a3-aad5-4c64-87ff-b0db89666de0"),
                        "data.getAllGenerations[0].label", is("Gen I"),

                        "data.getAllGenerations[1].value", is("0a35e22d-e3a9-42d3-9c13-eef777f385d6"),
                        "data.getAllGenerations[1].label", is("Gen II"),

                        "data.getAllGenerations[2].value", is("bb1568a7-0594-4812-9345-955b6c0d40aa"),
                        "data.getAllGenerations[2].label", is("Gen III"),

                        "data.getAllGenerations[3].value", is("889e7640-d182-40ad-ab33-d314613f4829"),
                        "data.getAllGenerations[3].label", is("Gen IV"),

                        "data.getAllGenerations[4].value", is("a8a8a689-c93a-457f-8835-48e0df017883"),
                        "data.getAllGenerations[4].label", is("Gen V"),

                        "data.getAllGenerations[5].value", is("cfe277d0-a625-46bb-a0b0-479c39c595a7"),
                        "data.getAllGenerations[5].label", is("Gen VI"),

                        "data.getAllGenerations[6].value", is("3c34491f-8737-4542-b1c6-da9c2afdbb83"),
                        "data.getAllGenerations[6].label", is("Gen VII"),

                        "data.getAllGenerations[7].value", is("b92e86b5-2aa3-44be-b2af-574ce8487ede"),
                        "data.getAllGenerations[7].label", is("Gen VIII"),

                        "data.getAllGenerations[8].value", is("7352b9ab-cf24-4272-8b9d-b28824d6e4d6"),
                        "data.getAllGenerations[8].label", is("Gen IX"));
    }
}