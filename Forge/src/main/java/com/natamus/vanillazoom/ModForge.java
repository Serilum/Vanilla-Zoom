package com.natamus.vanillazoom;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.vanillazoom.forge.events.ForgeZoomEvent;
import com.natamus.vanillazoom.util.Reference;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Reference.MOD_ID)
public class ModForge {
	
	public ModForge(FMLJavaModLoadingContext modLoadingContext) {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		if (!FMLEnvironment.dist.equals(Dist.CLIENT)) {
			return;
		}

		BusGroup busGroup = modLoadingContext.getModBusGroup();

		ModCommon.loadHotkeys();

		FMLLoadCompleteEvent.getBus(busGroup).addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
    	ForgeZoomEvent.registerEventsInBus();
	}

	private static void setGlobalConstants() {

	}
}