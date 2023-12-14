package zmaster587.advancedRocketry.mixin.forge;

import net.minecraft.world.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zmaster587.advancedRocketry.AdvancedRocketry;
import zmaster587.advancedRocketry.dimension.DimensionManager;
import zmaster587.advancedRocketry.dimension.DimensionProperties;

@Mixin(DimensionType.class)
public abstract class DimensionTypeMixin {

    @Inject(method = "getName", at = @At("RETURN"), cancellable = true)
    public void onGetName(CallbackInfoReturnable<String> ci) {

        AdvancedRocketry.logger.info("DimensionTypeMixin");

        DimensionProperties dimensionProperties = DimensionManager.getInstance().getDimensionProperties(getId());

        AdvancedRocketry.logger.info("Found dimensionProperties: " + dimensionProperties);

        AdvancedRocketry.logger.info("Found dimensionProperties with name: " + dimensionProperties.getName());

        if (dimensionProperties == DimensionManager.overworldProperties) {

            AdvancedRocketry.logger.info("Seems to be overworld, returning");
            return;
        }

        AdvancedRocketry.logger.info("Returning with dim name");

        ci.setReturnValue(dimensionProperties.getName());
    }

    @Shadow
    abstract int getId();

}
