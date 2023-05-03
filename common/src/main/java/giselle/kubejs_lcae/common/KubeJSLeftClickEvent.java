package giselle.kubejs_lcae.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.latvian.mods.kubejs.bindings.event.PlayerEvents;
import dev.latvian.mods.kubejs.event.EventHandler;
import giselle.kubejs_lcae.common.player.PlayerLeftClickedAirEventJS;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;

public class KubeJSLeftClickEvent
{
	public static final String MOD_ID = "kubejs_lcae";
	public static final Logger LOGGER = LogManager.getLogger();

	public static final EventHandler LEFT_CLICKED_AIR = PlayerEvents.GROUP.server("leftClickedAir", () -> PlayerLeftClickedAirEventJS.class);

	public static void initializeCommon()
	{

	}

	public static void handleAnimate(ServerPlayer player)
	{
		double reachDistance = PlayerUtils.getReachDistance(player);
		float pPartialTicks = 1.0F;
		Vec3 vec3 = player.getEyePosition(pPartialTicks);
		Vec3 vec31 = player.getViewVector(pPartialTicks).scale((double) reachDistance);
		Vec3 vec32 = vec3.add(vec31);
		HitResult result = player.getLevel().clip(new ClipContext(vec3, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

		if (result != null && result.getType() != Type.MISS)
		{
			return;
		}

		AABB aabb = player.getBoundingBox().expandTowards(vec31).inflate(1.0D);
		result = ProjectileUtil.getEntityHitResult(player, vec3, vec32, aabb, KubeJSLeftClickEvent::testEntityPickable, reachDistance * reachDistance);

		if (result != null && result.getType() != Type.MISS)
		{
			return;
		}

		KubeJSLeftClickEvent.LEFT_CLICKED_AIR.post(new PlayerLeftClickedAirEventJS(player, InteractionHand.MAIN_HAND));
	}

	public static boolean testEntityPickable(Entity e)
	{
		return !e.isSpectator();
	}

	public static ResourceLocation rl(String path)
	{
		return new ResourceLocation(MOD_ID, path);
	}

	private KubeJSLeftClickEvent()
	{

	}

}
