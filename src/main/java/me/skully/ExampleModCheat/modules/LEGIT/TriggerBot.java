package me.skully.ExampleModCheat.modules.LEGIT;



import me.skully.ExampleModCheat.modules.Module;
import me.skully.ExampleModCheat.utils.FriendsManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class TriggerBot extends Module {
    private Entity entity;

    public TriggerBot() {
        super("TriggerBot", Keyboard.KEY_N, Category.HACK);
    }


    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;


        if (objectMouseOver != null) {
            if (objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
                entity = objectMouseOver.entityHit;


                if (entity instanceof EntityPlayer && !FriendsManager.isFriend(entity.getUniqueID())) {
                    if (Minecraft.getMinecraft().player.getCooledAttackStrength(0) == 1) {
                        Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().player, entity);
                        Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
                        Minecraft.getMinecraft().player.resetCooldown();
                    }
                }
            }
        }
    }
}