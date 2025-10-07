package com.natamus.vanillazoom.forge.events;

import com.natamus.vanillazoom.events.ZoomEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeZoomEvent {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeZoomEvent.class);
	}

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent.Pre e) {
		ZoomEvent.onClientTick();
	}

	@SubscribeEvent
	public static boolean onItemUse(PlayerInteractEvent.RightClickItem e) {
		if (ZoomEvent.onItemUse(e.getEntity(), e.getLevel(), e.getHand()).equals(InteractionResult.FAIL)) {
			return true;
		}
		return false;
	}

	@SubscribeEvent
	public static boolean onEntityInteract(PlayerInteractEvent.EntityInteract e) {
		if (ZoomEvent.onEntityInteract(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			return true;
		}
		return false;
	}
}
