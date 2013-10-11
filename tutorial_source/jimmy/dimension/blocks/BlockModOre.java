package jimmy.dimension.blocks;

import java.util.Random;

import jimmy.dimension.core.TutTabs;
import jimmy.dimension.core.lib.Locations;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockModOre extends Block {

	public BlockModOre(int par1, String texture) {
		super(par1, Material.rock);
		this.setTextureName(texture);
		this.setCreativeTab(TutTabs.tutBlocks);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3){
		return blockID;
	}
	
	@Override
	public int quantityDropped(Random random){
		return 1;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister){
		blockIcon = iconRegister.registerIcon(Locations.textureLocation + this.getTextureName());
	}

}