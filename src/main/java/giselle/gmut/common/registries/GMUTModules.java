package giselle.gmut.common.registries;

import giselle.gmut.common.content.gear.mekasuit.ModuleGravitationalModulatingAdditionalUnit;
import mekanism.api.gear.ModuleData;
import mekanism.common.content.gear.ModuleHelper;
import net.minecraft.item.EnumRarity;

public class GMUTModules {

    public static final ModuleData<ModuleGravitationalModulatingAdditionalUnit> GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT = ModuleHelper.register("gravitational_modulating_additional_unit", ModuleGravitationalModulatingAdditionalUnit::new, builder -> builder.maxStackSize(1).rarity(EnumRarity.RARE));

}
