package lach_01298.moreBees.block;

import lach_01298.moreBees.Registry;

public class MoreBeesBlocks 
{

	public static BlockHive hive;
	

	public static void init(Registry registry)
	{
		hive = Registry.registerBlock(new BlockHive("hive"));
		
	
	}

}
