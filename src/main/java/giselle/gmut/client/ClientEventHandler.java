package giselle.gmut.client;

import giselle.gmut.common.GravitationalModulatingUnitTweaks;
import giselle.gmut.common.content.gear.mekasuit.ModuleGravitationalModulatingAdditionalUnit;
import giselle.gmut.common.registries.GMUTModules;
import mekanism.api.gear.IModule;
import mekanism.common.content.gear.ModuleHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = GravitationalModulatingUnitTweaks.MODID,value = Side.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onFOVModifier(FOVUpdateEvent e) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;
        IModule<ModuleGravitationalModulatingAdditionalUnit> module = ModuleHelper.get().load(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST), GMUTModules.GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT);
        if (module != null && module.isEnabled()) {
            boolean fixFOV = module.getCustomInstance().getFixFOV().get();
            if (fixFOV) {
                e.setNewfov(1.0F);
            }
        }
    }

}
