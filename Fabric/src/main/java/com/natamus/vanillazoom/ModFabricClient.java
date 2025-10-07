package com.natamus.vanillazoom;

import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.vanillazoom.events.ZoomEvent;
import com.natamus.vanillazoom.util.Reference;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.Minecraft;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		ModCommon.loadHotkeys();

		registerEvents();
	}
	
	private void registerEvents() {
		ClientTickEvents.START_CLIENT_TICK.register((Minecraft mc) -> {
			ZoomEvent.onClientTick();
		});

		UseItemCallback.EVENT.register((player, world, hand) -> {
			return ZoomEvent.onItemUse(player, world, hand);
		});

		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			return ZoomEvent.onEntityInteract(player, world, hand, entity, hitResult);
		});
	}
}
