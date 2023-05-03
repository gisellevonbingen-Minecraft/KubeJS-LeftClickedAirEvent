package giselle.kubejs_lcae.common;

import giselle.kubejs_lcae.common.KubeJSLeftClickEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(KubeJSLeftClickEvent.MOD_ID)
public class KubeJSLeftClickEventForge
{
	public KubeJSLeftClickEventForge()
	{
		KubeJSLeftClickEvent.initializeCommon();
	}

}
