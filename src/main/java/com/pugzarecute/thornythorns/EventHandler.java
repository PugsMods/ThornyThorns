package com.pugzarecute.thornythorns;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = ThornyThorns.MODID)
public class EventHandler {
    public static boolean sourceThorny(DamageSource in){
        if(in == DamageSource.SWEET_BERRY_BUSH||in==DamageSource.CACTUS) return true;
        return false
    }
    @SubscribeEvent
    public static void onDamage(LivingDamageEvent event){
        if(sourceThorny(event.getSource())){
            event.getEntity().getArmorSlots()
        }
        event.setCanceled(true);
    }
}
