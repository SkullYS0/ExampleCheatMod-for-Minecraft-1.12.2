package me.skully.ExampleModCheat.listeners;

import me.skully.ExampleModCheat.commands.Command;
import me.skully.ExampleModCheat.utils.ChatUtils;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class commands {

    @SubscribeEvent
    public void onMessage(ClientChatEvent e) {
        for(Command cmd : Command.commands) {
            if(Objects.equals(e.getMessage() ,  cmd.getUsage())) {
                e.setCanceled(true);
                cmd.toggle();
            }
        }
    }

}
