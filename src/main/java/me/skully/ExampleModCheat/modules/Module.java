package me.skully.ExampleModCheat.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    public String name;
    public boolean toggled;
    public int keyCode;
    public Module.Category category;
    public Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, int key, Module.Category c) {
        this.name = name;
        this.keyCode = key;
        this.category = c;
    }

    public boolean isEnabled() {
        return this.toggled;
    }

    public int getKey() {
        return this.keyCode;
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public void setKey(int key) {
        this.keyCode = key;
    }

    public Module.Category getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            this.onEnable();
        } else {
            this.onDisable();
        }

    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {
            this.onEnable();
        } else {
            this.onDisable();
        }

    }

    public enum Category {
        LEGIT,
        HACK;
    }
}

