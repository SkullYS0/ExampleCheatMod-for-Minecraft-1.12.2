package me.skully.ExampleModCheat.modules.FRIENDS;

import me.skully.ExampleModCheat.modules.Module;
import me.skully.ExampleModCheat.utils.FriendsManager;
import org.lwjgl.input.Keyboard;

public class Friends extends Module {
    public Friends(){
        super("Friends", Keyboard.KEY_M, Category.LEGIT);
    }
    @Override
    public void onEnable(){
        FriendsManager.doCheck = true;
    }
    @Override
    public void onDisable(){
        FriendsManager.doCheck = false;
    }
}
