package me.skully.ExampleModCheat.commands;

import me.skully.ExampleModCheat.commands.EXAMPLE.ExampleCommand;
import net.minecraftforge.common.MinecraftForge;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Command {

    public static CopyOnWriteArrayList<Command> commands = new CopyOnWriteArrayList();
    private String name;
    private String description;
    private String usage;

    private Category category;
    private boolean toggle;
    public String getUsage() {
        return usage;
    }

    public Command(String name, String description, String usage, Category category){
        this.name = name;
        this.description = description;
        this.usage = usage;

        this.category = category;
    }

    public void send(){MinecraftForge.EVENT_BUS.register(this);}

    public void toggle(){
        this.toggle = !toggle;
        if(toggle) {
            send();
        }else{
            send();
        }
    }

    public enum Category {
        EXAMPLE,
        BOTS;

    }

    public static void execcommads(){
        commands.add(new ExampleCommand());
    }

}
