package es.guepardito.jamm.item;

import es.guepardito.jamm.block.JammBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class JammItemGroup {
    public static final ItemGroup JAMM_GROUP = new ItemGroup("Jamm") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(JammBlocks.FORGOTTEN_RELIC_BLOCK.get());
        }
    };
}
