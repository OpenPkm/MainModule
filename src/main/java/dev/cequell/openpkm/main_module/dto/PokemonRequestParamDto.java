package dev.cequell.openpkm.main_module.dto;

import dev.cequell.openpkm.main_module.enums.GenerationEnum;
import dev.cequell.openpkm.main_module.enums.PokemonFieldEnum;
import dev.cequell.openpkm.main_module.enums.TypeSlugEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PokemonRequestParamDto {
    public Integer nationalDexNo;
    public Integer regionalDexNo;
    public String name;
    public String classification;
    public String variation;
    public GenerationEnum generationNo;
    public TypeSlugEnum primaryType;
    public TypeSlugEnum secondaryType;
    public List<TypeSlugEnum> types;
    public PokemonFieldEnum sortBy;
    public Boolean reverseOrder;
}
