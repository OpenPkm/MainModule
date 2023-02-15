package dev.cequell.openpokemon.mainmodule.enums;

import java.util.UUID;

public enum TypeEnum {
    BUG("57F65056-6A64-45B5-8649-02B96E009AC9"),
    DARK("5F21849A-6FA5-45D2-B1E2-ADA97215888A"),
    DRAGON("0E33FDD1-4F75-4C96-96B8-555E8391C314"),
    ELECTRIC("E35D733D-7E34-44AB-881D-2C68C86124F8"),
    FAIRY("ECFA8F98-C29A-4C06-845A-8A5C57B4998C"),
    FIGHTING("046A843A-6823-4D2C-8983-19D5BA38EBE0"),
    FIRE("B2284EAB-586C-4320-AE6F-CC6DB0CD60EA"),
    FLYING("DCF324C1-9E37-4696-BEF1-A513AFC754E1"),
    GHOST("73015E8D-D4A7-4A26-9B8B-24CB1D44FD2D"),
    GRASS("604D2A58-230B-4C4B-A113-26619BBF6244"),
    GROUND("36E42846-B4F0-4D1E-96B9-3A66122B8251"),
    ICE("F89E14B1-ED09-4EC7-9B91-3E0B96555D0B"),
    NORMAL("1657C673-C6DF-4116-9A1E-6F3734BB7F69"),
    POISON("34DF4853-382F-4C81-9DC0-A43E03D26EB6"),
    PSYCHIC("C6E06E6C-49D3-48D6-8FD4-E8ABD0133BB2"),
    ROCK("A4C89B29-18BC-4518-AD57-90035FDE8F1A"),
    STEEL("0F88AD49-808A-4D14-81FD-FBF7D951734B"),
    WATER("7F5031C0-E075-4D0B-8320-A91B209E442C");

    private final UUID value;
    TypeEnum(final String value) {
        this.value = UUID.fromString(value);
    }

    public UUID getValue() {
        return this.value;
    }

    public static TypeEnum getByName(final String name) {
        if(name == null) return null;
        for (var cur : TypeEnum.values()) {
            if(cur.name().equals(name.toUpperCase())) return cur;
        }
        return null;
    }
}
