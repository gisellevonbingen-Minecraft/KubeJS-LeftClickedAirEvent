package giselle.kubejs_lcae.common.player;

import dev.latvian.mods.kubejs.player.PlayerEventJS;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;

public class PlayerLeftClickedAirEventJS extends PlayerEventJS
{
	private final ServerPlayer player;
	private final InteractionHand hand;

	public PlayerLeftClickedAirEventJS(ServerPlayer player, InteractionHand hand)
	{
		this.player = player;
		this.hand = hand;
	}

	@Override
	public Player getEntity()
	{
		return this.player;
	}

	public InteractionHand getHand()
	{
		return this.hand;
	}

}
