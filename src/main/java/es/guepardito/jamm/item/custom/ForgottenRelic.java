package es.guepardito.jamm.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

public class ForgottenRelic extends Item {
    public ForgottenRelic(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if(!world.isRemote) {
            PlayerEntity playerEntity = context.getPlayer();

            rightClick(playerEntity);
            stack.damageItem(1, playerEntity, playerEntity1 -> playerEntity1.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClick(PlayerEntity playerEntity) {
        switch (random.nextInt(5)) {
            case 1:
                addPlayerEffect(playerEntity, Effects.INVISIBILITY, 400);
                break;
            case 2:
                addPlayerEffect(playerEntity, Effects.FIRE_RESISTANCE, 400);
                break;
            case 3:
                addPlayerEffect(playerEntity, Effects.RESISTANCE, 400);
                break;
            case 4:
                addPlayerEffect(playerEntity, Effects.ABSORPTION, 400);
            default:
                addPlayerEffect(playerEntity, Effects.LEVITATION, 400);
        }
    }

    public static void addPlayerEffect(PlayerEntity player, Effect effect, int second) {
        player.addPotionEffect(new EffectInstance(effect, second));
    }
}
