package me.skully.ExampleModCheat.modules.FRIENDS;

import me.skully.ExampleModCheat.modules.Module;
import me.skully.ExampleModCheat.utils.FriendsManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class MCF extends Module {
    private Entity entity;
    private boolean isPressed = false;
    public MCF(){
        super("MCF", Keyboard.KEY_O,Category.LEGIT);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e){
        RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
        if(Mouse.isButtonDown(2)) {
            if(!isPressed) {
                isPressed = true;
                if (objectMouseOver != null) {
                    if (objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
                        entity = objectMouseOver.entityHit;
                        FriendsManager.toggleFriend(entity.getUniqueID());
                    }
                }
            }
        } else {
            isPressed = false;
        }
    }
}
