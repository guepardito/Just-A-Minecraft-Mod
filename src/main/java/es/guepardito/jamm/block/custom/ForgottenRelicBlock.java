package es.guepardito.jamm.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ForgottenRelicBlock  extends Block {
    public ForgottenRelicBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        if (!world.isRemote()) {
            if (hand == Hand.MAIN_HAND) {
                System.out.println("Rightclicked on main hand!");
            }
            if (hand == Hand.OFF_HAND) {
                System.out.println("Rightclicked on off hand!");
            }
        }
        return super.onBlockActivated(blockState, world, blockPos, player, hand, blockRayTraceResult);
    }

    @Override
    public void onBlockClicked(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity) {
        if (!world.isRemote()) {
            System.out.println("Leftclicked a Forgotten Relick Block");
        }

        super.onBlockClicked(blockState, world, blockPos, playerEntity);
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        lightEntityOnFire(entity, 5);
        super.onEntityWalk(world, pos, entity);
    }

    public static void lightEntityOnFire(Entity entity, int seconds) {
        entity.setFire(seconds);
    }
}