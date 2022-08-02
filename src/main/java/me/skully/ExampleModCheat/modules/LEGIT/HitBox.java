package me.skully.ExampleModCheat.modules.LEGIT;

import me.skully.ExampleModCheat.modules.Module;
import me.skully.ExampleModCheat.utils.FriendsManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class HitBox extends Module {
    public float size = 0.6F;
    public float fsize = 0.01F;

    public HitBox() {
        super("HitBox", Keyboard.KEY_H, Category.LEGIT);
    }

    @SubscribeEvent
    public void onUpdate(RenderWorldLastEvent e) {
        if (this.toggled) {

            for (EntityPlayer player : mc.world.playerEntities) {
                if(FriendsManager.isFriend(player.getUniqueID())) {
                    player.setEntityBoundingBox(new AxisAlignedBB(player.posX - fsize,
                            player.getEntityBoundingBox().minY,
                            player.posZ - fsize,
                            player.posX + fsize,
                            player.getEntityBoundingBox().maxY,
                            player.posZ + fsize));
                }
                if (player != null && player != mc.player) {
                    player.setEntityBoundingBox(new AxisAlignedBB(
                            player.posX - size,
                            player.getEntityBoundingBox().minY,
                            player.posZ - size,
                            player.posX + size,
                            player.getEntityBoundingBox().maxY,
                            player.posZ + size
                    ));
                }
            }
        } else {
            for (EntityPlayer player : mc.world.playerEntities) {
                if (player != null && player != mc.player) {
                    player.setEntityBoundingBox(new AxisAlignedBB(
                            player.posX - 0.3F,
                            player.getEntityBoundingBox().minY,
                            player.posZ - 0.3F,
                            player.posX + 0.3F,
                            player.getEntityBoundingBox().maxY,
                            player.posZ + 0.3F
                    ));
                }
            }
        }
    }
}