package com.natamus.vanillazoom;


import com.natamus.collective.services.Services;
import com.natamus.vanillazoom.util.Variables;
import com.mojang.blaze3d.platform.InputConstants;

public class ModCommon {

	public static void init() {
		load();
	}

	private static void load() {
		
	}

	public static void loadHotkeys() {
		Variables.hotkey = Services.REGISTERKEYMAPPING.registerKeyMapping("key.vanillazoom.togglezoom.desc", InputConstants.KEY_LALT,"key.categories.misc");
	}
}