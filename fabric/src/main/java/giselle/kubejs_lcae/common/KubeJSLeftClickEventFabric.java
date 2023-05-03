package giselle.kubejs_lcae.common;

import net.fabricmc.api.ModInitializer;

public class KubeJSLeftClickEventFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		KubeJSLeftClickEvent.initializeCommon();
	}

}
