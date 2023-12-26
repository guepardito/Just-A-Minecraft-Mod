package es.guepardito.jamm.item;

import es.guepardito.jamm.Jamm;
import es.guepardito.jamm.item.custom.ForgottenRelic;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class JammItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Jamm.MOD_ID);

    public static final RegistryObject<Item> BLUESTONE_DUST = ITEMS.register("bluestone_dust",
            () -> new Item(new Item.Properties().group(JammItemGroup.JAMM_GROUP)));

    public static final RegistryObject<Item> FORGOTTEN_RELIC = ITEMS.register("forgotten_relic",
            () -> new ForgottenRelic(new Item.Properties().group(JammItemGroup.JAMM_GROUP).maxDamage(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
