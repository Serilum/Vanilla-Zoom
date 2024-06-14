package com.natamus.vanillazoom;

import com.natamus.collective.check.RegisterMod;
import com.natamus.vanillazoom.neoforge.events.NeoForgeZoomEvent;
import com.natamus.vanillazoom.util.Reference;
import com.natamus.vanillazoom.util.Variables;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	
	public ModNeoForge(IEventBus modEventBus) {
		if (!FMLEnvironment.dist.equals(Dist.CLIENT)) {
			return;
		}


		modEventBus.addListener(this::registerKeyBinding);
		modEventBus.addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	public void registerKeyBinding(final RegisterKeyMappingsEvent e) {
		Variables.hotkey = new KeyMapping("key.vanillazoom.togglezoom.desc", 342, "key.categories.misc");
		e.register(Variables.hotkey);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(NeoForgeZoomEvent.class);
	}

	private static void setGlobalConstants() {

	}
}