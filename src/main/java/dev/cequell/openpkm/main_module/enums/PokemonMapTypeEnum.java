package dev.cequell.openpkm.main_module.enums;

import dev.cequell.openpkm.main_module.dto.ValueText;
import dev.cequell.openpkm.main_module.entities.PokemonEntity;
import dev.cequell.openpkm.main_module.interfaces.IPokemonMapValueText;
import dev.cequell.openpkm.main_module.interfaces.impl.NameAndVariationValueText;
import dev.cequell.openpkm.main_module.interfaces.impl.NationalNoWithNameAndVariationValueText;
import dev.cequell.openpkm.main_module.interfaces.impl.OnlyNameValueText;
import dev.cequell.openpkm.main_module.interfaces.impl.RegionalNoWithNameAndVariationValueText;

import java.util.UUID;

public enum PokemonMapTypeEnum {
    ONLY_NAME("onlyName", new OnlyNameValueText()),
    NAME_AND_VARIATION("nameVariation", new NameAndVariationValueText()),
    REGIONAL_NO_WITH_NAME_AND_VARIATION("regionalNameVariation", new RegionalNoWithNameAndVariationValueText()),
    NATIONAL_NO_WITH_NAME_AND_VARIATION("nationalNameVariation", new NationalNoWithNameAndVariationValueText()),
    ;

    private final String alias;
    private final IPokemonMapValueText impl;
    PokemonMapTypeEnum(
            final String alias,
            final IPokemonMapValueText impl
    ) {
        this.alias = alias;
        this.impl = impl;
    }

    public static PokemonMapTypeEnum of(String alias) {
        for (var cur : PokemonMapTypeEnum.values()) {
            if(cur.alias.equals(alias)) return cur;
        }
        return null;
    }

    public ValueText<UUID> execute(PokemonEntity entity) {
        return this.impl.execute(entity);
    }
    public String getAlias() {
        return this.alias;
    }
}
