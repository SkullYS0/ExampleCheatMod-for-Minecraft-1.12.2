package me.skully.ExampleModCheat.utils;

import me.skully.ExampleModCheat.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtils {

    static final String prefix = "§6§l" + Client.NAME + "§f| ";
    static Minecraft mc = Minecraft.getMinecraft();

    public static void sendMessage(String message){
        mc.player.sendMessage(new TextComponentString(prefix + message));
    }

}
