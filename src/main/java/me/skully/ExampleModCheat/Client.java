package me.skully.ExampleModCheat;

import me.skully.ExampleModCheat.commands.Command;
import me.skully.ExampleModCheat.listeners.commands;
import me.skully.ExampleModCheat.listeners.key;
import me.skully.ExampleModCheat.modules.FRIENDS.Friends;
import me.skully.ExampleModCheat.modules.FRIENDS.MCF;
import me.skully.ExampleModCheat.modules.LEGIT.HitBox;
import me.skully.ExampleModCheat.modules.LEGIT.TriggerBot;
import me.skully.ExampleModCheat.modules.Module;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CopyOnWriteArrayList;

@Mod(
        modid = "keystrokes",
        name = "KeyStrokes",
        version = "1.0-Release"
)
public class Client {
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList();
    public static Client INSTANCE;
    public static final String MODID = "examplecheatmod";
    public static final String NAME = "ExampleCheatMod";
    public static final String VERSION = "999";
    private static Logger logger;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        INSTANCE = this;
        this.initmod();

        Command.execcommads();
        MinecraftForge.EVENT_BUS.register(new commands());
        MinecraftForge.EVENT_BUS.register(new key());
    }

    public void initmod() {
        modules.add(new HitBox());
        modules.add(new TriggerBot());
        modules.add(new Friends());
        modules.add(new MCF());
    }

    public static void keyPress(int key) {
        for (Module m : modules) {
            if (m.getKey() == key) {
                m.toggle();
            }
        }
    }
}
