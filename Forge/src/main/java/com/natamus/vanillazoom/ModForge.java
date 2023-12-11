package com.natamus.vanillazoom;

import com.natamus.collective.check.RegisterMod;
import com.natamus.vanillazoom.forge.events.ForgeZoomEvent;
import com.natamus.vanillazoom.util.Reference;
import com.natamus.vanillazoom.util.Variables;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Reference.MOD_ID)
public class ModForge {
	
	public ModForge() {
		if (!FMLEnvironment.dist.equals(Dist.CLIENT)) {
			return;
		}

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::initClient);

		modEventBus.addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void initClient(final FMLClientSetupEvent event) {
    	Variables.hotkey = new KeyMapping("key.vanillazoom.togglezoom.desc", 342, "key.categories.misc");
    	ClientRegistry.registerKeyBinding(Variables.hotkey);
    }

	private void loadComplete(final FMLLoadCompleteEvent event) {
    	MinecraftForge.EVENT_BUS.register(new ForgeZoomEvent());
	}

	private static void setGlobalConstants() {

	}
}