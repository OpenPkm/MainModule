package dev.cequell.openpkm.enums;

import lombok.Getter;

import java.util.UUID;

public enum TypeSlugEnum {
    BUG("57f65056-6a64-45b5-8649-02b96e009ac9"),
    DRK("5f21849a-6fa5-45d2-b1e2-ada97215888a"),
    DRG("0e33fdd1-4f75-4c96-96b8-555e8391c314"),
    ELT("e35d733d-7e34-44ab-881d-2c68c86124f8"),
    FAI("ecfa8f98-c29a-4c06-845a-8a5c57b4998c"),
    FGT("046a843a-6823-4d2c-8983-19d5ba38ebe0"),
    FIR("b2284eab-586c-4320-ae6f-cc6db0cd60ea"),
    FLY("dcf324c1-9e37-4696-bef1-a513afc754e1"),
    GHO("73015e8d-d4a7-4a26-9b8b-24cb1d44fd2d"),
    GRS("604d2a58-230b-4c4b-a113-26619bbf6244"),
    GRN("36e42846-b4f0-4d1e-96b9-3a66122b8251"),
    ICE("f89e14b1-ed09-4ec7-9b91-3e0b96555d0b"),
    NOR("1657c673-c6df-4116-9a1e-6f3734bb7f69"),
    PSN("34df4853-382f-4c81-9dc0-a43e03d26eb6"),
    PSY("c6e06e6c-49d3-48d6-8fd4-e8abd0133bb2"),
    RCK("a4c89b29-18bc-4518-ad57-90035fde8f1a"),
    STE("0f88ad49-808a-4d14-81fd-fbf7d951734b"),
    WAT("7f5031c0-e075-4d0b-8320-a91b209e442c");

    @Getter
    private final UUID value;

    TypeSlugEnum(final String value) {
        this.value = UUID.fromString(value);
    }
}
