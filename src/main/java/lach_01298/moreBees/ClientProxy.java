package lach_01298.moreBees;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	public void registerProxies() 
	{
	}
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MoreBees.MOD_ID + ":" + id, "inventory"));
	}

}
