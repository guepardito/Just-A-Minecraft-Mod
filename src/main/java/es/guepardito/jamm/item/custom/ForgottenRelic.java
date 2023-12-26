package es.guepardito.jamm.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static es.guepardito.jamm.util.ItemUtils.addPlayerEffect;

public class ForgottenRelic extends Item {
    public ForgottenRelic(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if(!world.isRemote) {
            PlayerEntity playerEntity = context.getPlayer();

            forgottenRelicRandEffect(playerEntity);

            stack.damageItem(1, playerEntity, playerEntity1 -> playerEntity1.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> toolTip, ITooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            toolTip.add(new TranslationTextComponent("tooltip.jamm.forgotten_relic"));
        } else {
            toolTip.add(new TranslationTextComponent("tooltip.jamm.holdshift"));
        }

        super.addInformation(stack, world, toolTip, flag);
    }

    private void forgottenRelicRandEffect(PlayerEntity playerEntity) {
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
                addPlayerEffect(playerEntity, Effects.ABSORPTION);
                break;
            default:
                addPlayerEffect(playerEntity, Effects.LEVITATION, 400);
                break;
        }
    }
}
