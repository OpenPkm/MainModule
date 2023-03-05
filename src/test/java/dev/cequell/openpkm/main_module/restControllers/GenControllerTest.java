package dev.cequell.openpkm.main_module.restControllers;

import dev.cequell.openpkm.main_module.configs.DatabaseTestConfig;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(value = DatabaseTestConfig.class, restrictToAnnotatedClass = true)
class GenControllerTest {

    @Test
    void getAllAsValueText() {
        given()
                .when().get("/gen/AsValueText")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(9),

                        "[0].value", is("379d54a3-aad5-4c64-87ff-b0db89666de0"),
                        "[0].label", is("Gen I"),

                        "[1].value", is("0a35e22d-e3a9-42d3-9c13-eef777f385d6"),
                        "[1].label", is("Gen II"),

                        "[2].value", is("bb1568a7-0594-4812-9345-955b6c0d40aa"),
                        "[2].label", is("Gen III"),

                        "[3].value", is("889e7640-d182-40ad-ab33-d314613f4829"),
                        "[3].label", is("Gen IV"),

                        "[4].value", is("a8a8a689-c93a-457f-8835-48e0df017883"),
                        "[4].label", is("Gen V"),

                        "[5].value", is("cfe277d0-a625-46bb-a0b0-479c39c595a7"),
                        "[5].label", is("Gen VI"),

                        "[6].value", is("3c34491f-8737-4542-b1c6-da9c2afdbb83"),
                        "[6].label", is("Gen VII"),

                        "[7].value", is("b92e86b5-2aa3-44be-b2af-574ce8487ede"),
                        "[7].label", is("Gen VIII"),

                        "[8].value", is("7352b9ab-cf24-4272-8b9d-b28824d6e4d6"),
                        "[8].label", is("Gen IX"));
    }
}