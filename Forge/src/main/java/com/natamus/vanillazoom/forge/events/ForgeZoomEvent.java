package com.natamus.vanillazoom.forge.events;

import com.natamus.vanillazoom.events.ZoomEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(Dist.CLIENT)
public class ForgeZoomEvent {
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent e) {
		if (!e.phase.equals(TickEvent.Phase.START)) {
			return;
		}

		ZoomEvent.onClientTick();
	}

	@SubscribeEvent
	public void onItemUse(PlayerInteractEvent.RightClickItem e) {
		if (ZoomEvent.onItemUse(e.getPlayer(), e.getWorld(), e.getHand()).getResult().equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onEntityInteract(PlayerInteractEvent.EntityInteract e) {
		if (ZoomEvent.onEntityInteract(e.getPlayer(), e.getWorld(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
		}
	}
}
