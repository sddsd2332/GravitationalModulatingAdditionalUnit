package giselle.gmut.client;


import giselle.gmut.client.key.GMUTKeyHandler;
import giselle.gmut.common.CommonProxy;
import giselle.gmut.common.GravitationalModulatingUnitTweaks;
import giselle.gmut.common.registries.GMUTItems;
import mekanism.client.render.MekanismRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();
        new GMUTKeyHandler();
    }

    @Override
    public void registerItemRenders() {
        registerItemRender(GMUTItems.GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT);
    }

    public void registerItemRender(Item item) {
        MekanismRenderer.registerItemRender(GravitationalModulatingUnitTweaks.MODID, item);
    }
}
