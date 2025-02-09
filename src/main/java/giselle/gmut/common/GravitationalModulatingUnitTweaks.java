package giselle.gmut.common;


import giselle.gmut.common.network.GMUTPacketHandler;
import giselle.gmut.common.registries.GMUTItems;
import giselle.gmut.common.registries.GMUTModules;
import gravitationalmodulatingunittweaks.gravitationalmodulatingunittweaks.Tags;
import io.netty.buffer.ByteBuf;
import mekanism.common.Mekanism;
import mekanism.common.MekanismItems;
import mekanism.common.Version;
import mekanism.common.base.IModule;
import mekanism.common.config.MekanismConfig;
import mekanism.common.content.gear.ModuleHelper;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = GravitationalModulatingUnitTweaks.MODID, useMetadata = true)
@Mod.EventBusSubscriber()
public class GravitationalModulatingUnitTweaks implements IModule {

    public static final String MODID = Tags.MOD_ID;

    public static Version versionNumber = new Version(999, 999, 999);
    public static final GMUTPacketHandler packetHandler = new GMUTPacketHandler();

    @SidedProxy(clientSide = "giselle.gmut.client.ClientProxy", serverSide = "giselle.gmut.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(GravitationalModulatingUnitTweaks.MODID)
    public static GravitationalModulatingUnitTweaks instance;

    @Override
    public Version getVersion() {
        return versionNumber;
    }

    @Override
    public String getName() {
        return "Gravitational Modulating Additional Unit";
    }

    @Override
    public void writeConfig(ByteBuf byteBuf, MekanismConfig mekanismConfig) {

    }

    @Override
    public void readConfig(ByteBuf byteBuf, MekanismConfig mekanismConfig) {

    }

    @Override
    public void resetClient() {

    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Register to receive subscribed events
        MinecraftForge.EVENT_BUS.register(this);
        packetHandler.initialize();
        proxy.init();
        imcQueue();
        Mekanism.logger.info("Loaded Gravitational Modulating Additional Unit module.");
    }

    private void imcQueue() {
        ModuleHelper.get().setSupported(MekanismItems.MEKASUIT_BODYARMOR, GMUTModules.GRAVITATIONAL_MODULATING_ADDITIONAL_UNIT);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GMUTItems.registerItems(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        proxy.registerItemRenders();
    }
}
