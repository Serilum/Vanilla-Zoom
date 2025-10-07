package com.natamus.vanillazoom;


import com.natamus.collective.services.Services;
import com.natamus.vanillazoom.util.Variables;

public class ModCommon {

	public static void init() {
		load();
	}

	private static void load() {
		
	}

	public static void loadHotkeys() {
		Variables.hotkey = Services.REGISTERKEYMAPPING.registerKeyMapping("key.vanillazoom.togglezoom.desc", 342, "key.categories.misc");
	}
}