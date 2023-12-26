package es.guepardito.jamm.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

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
            toolTip.add(new TranslationTextComponent("tooltip.jamm.forgotten_relic_shift"));
        } else {
            toolTip.add(new TranslationTextComponent("tooltip.jamm.forgotten_relic"));
        }

        super.addInformation(stack, world, toolTip, flag);
    }

    public static void forgottenRelicRandEffect(PlayerEntity playerEntity) {
        switch (random.nextInt(5)) {
            case 1:
                addPlayerEffectDuration(playerEntity, Effects.INVISIBILITY, 400);
                break;
            case 2:
                addPlayerEffectDuration(playerEntity, Effects.FIRE_RESISTANCE, 400);
                break;
            case 3:
                addPlayerEffectDuration(playerEntity, Effects.RESISTANCE, 400);
                break;
            case 4:
                addPlayerEffect(playerEntity, Effects.ABSORPTION);
                break;
            default:
                addPlayerEffectDuration(playerEntity, Effects.LEVITATION, 400);
                break;
        }
    }

    public static void addPlayerEffectDuration(PlayerEntity player, Effect effect, int seconds) {
        player.addPotionEffect(new EffectInstance(effect, seconds));
    }

    public static void addPlayerEffect(PlayerEntity player, Effect effect) {
        player.addPotionEffect(new EffectInstance(effect));
    }
}
