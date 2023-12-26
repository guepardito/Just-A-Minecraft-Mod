package es.guepardito.jamm.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BluestoneDust extends JammItem {
    public BluestoneDust(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> toolTip, ITooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            toolTip.add(new TranslationTextComponent("tooltip.jamm.bluestone_dust"));
        } else {
            toolTip.add(new TranslationTextComponent("tooltip.jamm.holdshift"));
        }

        super.addInformation(stack, world, toolTip, flag);
    }
}
