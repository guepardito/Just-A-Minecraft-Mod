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
            BlockState clickedBlock = world.getBlockState(context.getPos());

            rightClickOnCertainBlockState(clickedBlock, playerEntity);
            stack.damageItem(1, playerEntity, playerEntity1 -> playerEntity1.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, PlayerEntity playerEntity) {
        if (!playerEntity.isInvisible() && blockIsValidForInvisible(clickedBlock)) {
            // make player invisible for 10 secs
            doInvisibleEntity(playerEntity, 400);
        }
    }

    private boolean blockIsValidForInvisible(BlockState clickedBlock) {
        return clickedBlock.getBlock() == Blocks.GRASS_BLOCK;
    }

    public static void doInvisibleEntity(PlayerEntity player, int second) {
        player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, second));
    }
}
