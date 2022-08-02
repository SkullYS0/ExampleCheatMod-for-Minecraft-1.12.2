package me.skully.ExampleModCheat.listeners;

import me.skully.ExampleModCheat.Client;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.io.File;
import java.io.IOException;

public class key {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) throws IOException {

        if (Keyboard.isKeyDown(Keyboard.getEventKey())) {
                if (Keyboard.getEventKey() != 0) {
                    Client.INSTANCE.keyPress(Keyboard.getEventKey());
                }
        }
    }
}