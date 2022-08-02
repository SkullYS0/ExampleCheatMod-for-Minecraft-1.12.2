package me.skully.ExampleModCheat.commands.EXAMPLE;

import me.skully.ExampleModCheat.commands.Command;
import me.skully.ExampleModCheat.utils.ChatUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExampleCommand extends Command {

    public ExampleCommand(){
        super("ExampleCommand", "ExampleDescription", "cmd", Category.EXAMPLE);
    }

    @Override
    public void send(){
        ChatUtils.sendMessage("ПРИНЯЛ");
    }

}
