package com.natamus.vanillazoom;

import com.natamus.vanillazoom.events.ZoomEvent;
import com.natamus.vanillazoom.util.Variables;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Variables.hotkey = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.vanillazoom.togglezoom.desc", 342, "key.categories.misc"));

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
