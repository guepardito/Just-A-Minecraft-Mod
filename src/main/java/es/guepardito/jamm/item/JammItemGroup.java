package es.guepardito.jamm.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class JammItemGroup {
    public static final ItemGroup JAMM_GROUP = new ItemGroup("Jamm") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(JammItems.BLUESTONE_DUST.get());
        }
    };
}
