package dev.cequell.openpkm.main_module.controllers;

import dev.cequell.openpkm.main_module.configs.DatabaseTestConfig;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(value = DatabaseTestConfig.class, restrictToAnnotatedClass = true)
class TypeControllerTest {

    @Test
    void all() {
        // When / Then
        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{getTypeAsValueText{id,name,slug}}"
                        }
                        """)
                .post("/ql")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", nullValue(),
                        "data.getTypeAsValueText.size()", is(18),

                        "data.getTypeAsValueText[0].id", is("57f65056-6a64-45b5-8649-02b96e009ac9"),
                        "data.getTypeAsValueText[0].name", is("Bug"),
                        "data.getTypeAsValueText[0].slug", is("BUG"),

                        "data.getTypeAsValueText[1].id", is("5f21849a-6fa5-45d2-b1e2-ada97215888a"),
                        "data.getTypeAsValueText[1].name", is("Dark"),
                        "data.getTypeAsValueText[1].slug", is("DRK"),

                        "data.getTypeAsValueText[2].id", is("0e33fdd1-4f75-4c96-96b8-555e8391c314"),
                        "data.getTypeAsValueText[2].name", is("Dragon"),
                        "data.getTypeAsValueText[2].slug", is("DRG"),

                        "data.getTypeAsValueText[3].id", is("e35d733d-7e34-44ab-881d-2c68c86124f8"),
                        "data.getTypeAsValueText[3].name", is("Electric"),
                        "data.getTypeAsValueText[3].slug", is("ELT"),

                        "data.getTypeAsValueText[4].id", is("ecfa8f98-c29a-4c06-845a-8a5c57b4998c"),
                        "data.getTypeAsValueText[4].name", is("Fairy"),
                        "data.getTypeAsValueText[4].slug", is("FAI"),

                        "data.getTypeAsValueText[5].id", is("046a843a-6823-4d2c-8983-19d5ba38ebe0"),
                        "data.getTypeAsValueText[5].name", is("Fighting"),
                        "data.getTypeAsValueText[5].slug", is("FGT"),

                        "data.getTypeAsValueText[6].id", is("b2284eab-586c-4320-ae6f-cc6db0cd60ea"),
                        "data.getTypeAsValueText[6].name", is("Fire"),
                        "data.getTypeAsValueText[6].slug", is("FIR"),

                        "data.getTypeAsValueText[7].id", is("dcf324c1-9e37-4696-bef1-a513afc754e1"),
                        "data.getTypeAsValueText[7].name", is("Flying"),
                        "data.getTypeAsValueText[7].slug", is("FLY"),

                        "data.getTypeAsValueText[8].id", is("73015e8d-d4a7-4a26-9b8b-24cb1d44fd2d"),
                        "data.getTypeAsValueText[8].name", is("Ghost"),
                        "data.getTypeAsValueText[8].slug", is("GHO"),

                        "data.getTypeAsValueText[9].id", is("604d2a58-230b-4c4b-a113-26619bbf6244"),
                        "data.getTypeAsValueText[9].name", is("Grass"),
                        "data.getTypeAsValueText[9].slug", is("GRS"),

                        "data.getTypeAsValueText[10].id", is("36e42846-b4f0-4d1e-96b9-3a66122b8251"),
                        "data.getTypeAsValueText[10].name", is("Ground"),
                        "data.getTypeAsValueText[10].slug", is("GRN"),

                        "data.getTypeAsValueText[11].id", is("f89e14b1-ed09-4ec7-9b91-3e0b96555d0b"),
                        "data.getTypeAsValueText[11].name", is("Ice"),
                        "data.getTypeAsValueText[11].slug", is("ICE"),

                        "data.getTypeAsValueText[12].id", is("1657c673-c6df-4116-9a1e-6f3734bb7f69"),
                        "data.getTypeAsValueText[12].name", is("Normal"),
                        "data.getTypeAsValueText[12].slug", is("NOR"),

                        "data.getTypeAsValueText[13].id", is("34df4853-382f-4c81-9dc0-a43e03d26eb6"),
                        "data.getTypeAsValueText[13].name", is("Poison"),
                        "data.getTypeAsValueText[13].slug", is("PSN"),

                        "data.getTypeAsValueText[14].id", is("c6e06e6c-49d3-48d6-8fd4-e8abd0133bb2"),
                        "data.getTypeAsValueText[14].name", is("Psychic"),
                        "data.getTypeAsValueText[14].slug", is("PSY"),

                        "data.getTypeAsValueText[15].id", is("a4c89b29-18bc-4518-ad57-90035fde8f1a"),
                        "data.getTypeAsValueText[15].name", is("Rock"),
                        "data.getTypeAsValueText[15].slug", is("RCK"),

                        "data.getTypeAsValueText[16].id", is("0f88ad49-808a-4d14-81fd-fbf7d951734b"),
                        "data.getTypeAsValueText[16].name", is("Steel"),
                        "data.getTypeAsValueText[16].slug", is("STE"),

                        "data.getTypeAsValueText[17].id", is("7f5031c0-e075-4d0b-8320-a91b209e442c"),
                        "data.getTypeAsValueText[17].name", is("Water"),
                        "data.getTypeAsValueText[17].slug", is("WAT")
                );
    }
}