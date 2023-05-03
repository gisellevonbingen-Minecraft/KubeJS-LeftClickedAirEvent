package giselle.kubejs_lcae.common.mixin.minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import giselle.kubejs_lcae.common.KubeJSLeftClickEvent;
import net.minecraft.network.protocol.game.ServerboundSwingPacket;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.network.ServerPlayerConnection;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class PlayerConnectionMixin implements ServerPlayerConnection
{
	@Inject(method = "handleAnimate", at = @At("TAIL"))
	private void handleAnimate(ServerboundSwingPacket pPacket, CallbackInfo ci)
	{
		KubeJSLeftClickEvent.handleAnimate(this.getPlayer());
	}

}
