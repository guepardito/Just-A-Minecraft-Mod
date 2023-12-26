package es.guepardito.jamm.util;

import es.guepardito.jamm.Jamm;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class JammTags {
    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> FORGOTTEN_RELIC_CLICKABLE_BLOCKS = createTag("forgotten_relic_clickable_blocks");
        private static Tags.IOptionalNamedTag<Block>  createTag(String name) {
            return BlockTags.createOptional(new ResourceLocation(Jamm.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block>  createForgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        private static Tags.IOptionalNamedTag<Item>  createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(Jamm.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item>  createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
