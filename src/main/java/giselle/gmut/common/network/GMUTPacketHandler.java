package giselle.gmut.common.network;

import giselle.gmut.common.network.to_server.PacketSwitchVerticalSpeedPacket;
import giselle.gmut.common.network.to_server.PacketSwitchVerticalSpeedPacket.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class GMUTPacketHandler {

    public final SimpleNetworkWrapper netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("GravitationalModulatingUnitTweaks");


    public void initialize() {
        netHandler.registerMessage(PacketSwitchVerticalSpeedPacket.class, SwitchVerticalSpeedPacketMessage.class, 0, Side.SERVER);
    }

    public void sendToServer(IMessage message) {
        netHandler.sendToServer(message);
    }

}
