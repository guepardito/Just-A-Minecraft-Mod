package es.guepardito.jamm.block;

import es.guepardito.jamm.Jamm;
import es.guepardito.jamm.block.custom.BluestoneOre;
import es.guepardito.jamm.block.custom.ForgottenRelicBlock;
import es.guepardito.jamm.item.JammItemGroup;
import es.guepardito.jamm.item.JammItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class JammBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Jamm.MOD_ID);

    public static final RegistryObject<Block> BLUESTONE_ORE = registerBlock("bluestone_ore",
            () -> new BluestoneOre(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool()
                    .hardnessAndResistance(5f)));

    public static final RegistryObject<Block> FORGOTTEN_RELIC_BLOCK = registerBlock("forgotten_relic_block",
            () -> new ForgottenRelicBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool()
                    .hardnessAndResistance(8f)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        JammItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(JammItemGroup.JAMM_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
