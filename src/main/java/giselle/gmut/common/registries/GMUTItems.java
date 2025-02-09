package giselle.gmut.common.registries;

import giselle.gmut.common.GravitationalModulatingUnitTweaks;
import mekanism.common.Mekanism;
import mekanism.common.item.ItemModule;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(GravitationalModulatingUnitTweaks.MODID)
public class GMUTItems {

    public static final ItemModule GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT = new ItemModule(GMUTModules.GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT);

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.register(initModule(GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT));
    }


    public static Item initModule(ItemModule item) {
        String name = "module_" + item.getModuleData().getName();
        return item.setTranslationKey(name).setRegistryName(new ResourceLocation(GravitationalModulatingUnitTweaks.MODID, name)).setCreativeTab(Mekanism.tabMekanism);
    }

}
