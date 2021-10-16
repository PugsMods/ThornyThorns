package com.pugzarecute.thornythorns;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Iterator;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = ThornyThorns.MODID)
public class EventHandler {
    public static boolean sourceThorny(DamageSource in){
        if(in == DamageSource.SWEET_BERRY_BUSH||in==DamageSource.CACTUS) return true;
        return false;
    }
    @SubscribeEvent
    public static void onDamage(LivingDamageEvent event){
        int damagereductioncounter=0;
        float damagetodeal = event.getAmount()
        if(sourceThorny(event.getSource())){
            for (ItemStack element : event.getEntity().getArmorSlots()) {
                if(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.THORNS,element) >= 1){
                        damagereductioncounter += EnchantmentHelper.getItemEnchantmentLevel(Enchantments.THORNS,element);
                }
            }
        }
        for(int step = 0;step <= damagereductioncounter;step++){

        }
        event.setCanceled(true);
    }
}
