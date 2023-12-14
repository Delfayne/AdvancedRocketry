package zmaster587.advancedRocketry.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@TransformerExclusions(value = {"zmaster587.advancedRocketry.asm.ClassTransformer"})
@MCVersion("1.12.2")
public class AdvancedRocketryPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {

	public AdvancedRocketryPlugin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String[] getASMTransformerClass() {
		return new String[] {ClassTransformer.class.getName()};
	}

	@Override
	public String getModContainerClass() {
		return "zmaster587.advancedRocketry.asm.ModContainer";
	}

	@Override
	public String getSetupClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		
	}

	@Override
	public String getAccessTransformerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getMixinConfigs() {
		return Collections.singletonList("mixins.advancedrocketry.json");
	}
}
