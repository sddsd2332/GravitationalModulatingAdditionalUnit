package giselle.gmut.client.key;

import giselle.gmut.common.GMUTLang;
import giselle.gmut.common.GravitationalModulatingUnitTweaks;
import giselle.gmut.common.content.gear.mekasuit.EntityModuleHelper;
import giselle.gmut.common.content.gear.mekasuit.ModuleGravitationalModulatingAdditionalUnit;
import giselle.gmut.common.network.to_server.PacketSwitchVerticalSpeedPacket.SwitchVerticalSpeedPacketMessage;
import giselle.gmut.common.registries.GMUTModules;
import mekanism.client.sound.SoundHandler;
import mekanism.common.MekanismSounds;
import mekanism.common.content.gear.Module;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GMUTKeyHandler extends MekKeyHandler {

    public static KeyBinding moduleVerticalSpeedSwitchKey = new KeyBinding(GMUTLang.KEY_VERTICAL_SPEED.getTranslationKey(), Keyboard.KEY_NONE, GMUTLang.KEY_CATAGORY.getTranslationKey());

    public static Builder BINDINGS = new Builder().addBinding(moduleVerticalSpeedSwitchKey, false);


    public GMUTKeyHandler() {
        super(BINDINGS);
        ClientRegistry.registerKeyBinding(moduleVerticalSpeedSwitchKey);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onTick(InputEvent event) {
        keyTick();
    }

    @Override
    public void keyDown(KeyBinding keyBinding, boolean b) {
        EntityPlayer player = FMLClientHandler.instance().getClient().player;
        if (player != null) {
            Module<ModuleGravitationalModulatingAdditionalUnit> module = EntityModuleHelper.findArmorEnabledModule(player, GMUTModules.GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT);
            if (module != null) {
                GravitationalModulatingUnitTweaks.packetHandler.sendToServer(new SwitchVerticalSpeedPacketMessage(player.isSneaking() ? -1 : +1));
                SoundHandler.playSound(MekanismSounds.HYDRAULIC);
            }
        }
    }

    @Override
    public void keyUp(KeyBinding keyBinding) {

    }
}
