package giselle.kubejs_lcae.common;

import net.minecraft.world.entity.player.Player;

public class PlayerUtils
{
	public static double getReachDistance(Player player)
	{
		if (player.isCreative())
		{
			return 5.0F;
		}

		return 4.5F;
	}

}
