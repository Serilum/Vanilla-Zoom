package com.natamus.vanillazoom.neoforge.events;

import com.natamus.vanillazoom.events.ZoomEvent;
import net.minecraft.world.InteractionResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class NeoForgeZoomEvent {
	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Pre e) {
		ZoomEvent.onClientTick();
	}

	@SubscribeEvent
	public static void onItemUse(PlayerInteractEvent.RightClickItem e) {
		if (ZoomEvent.onItemUse(e.getEntity(), e.getLevel(), e.getHand()).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific e) {
		if (ZoomEvent.onEntityInteract(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
		}
	}
}
