package es.guepardito.jamm.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class ItemUtils {
    public static void lightEntityOnFire(Entity entity, int seconds) {
        entity.setFire(seconds);
    }

    public static void addPlayerEffect(PlayerEntity player, Effect effect, int seconds) {
        player.addPotionEffect(new EffectInstance(effect, seconds));
    }

    public static void addPlayerEffect(PlayerEntity player, Effect effect) {
        player.addPotionEffect(new EffectInstance(effect));
    }
}
