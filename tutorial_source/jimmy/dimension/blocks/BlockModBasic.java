package jimmy.dimension.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jimmy.dimension.core.TutBlocks;
import jimmy.dimension.core.TutTabs;
import jimmy.dimension.core.lib.Locations;
import jimmy.dimension.core.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockModBasic extends Block{

	private static Material material;
	private static String blockTexture;
	
	public BlockModBasic(int par1, String texture) {
		super(par1, Material.rock);
		this.setTextureName(texture);
		blockTexture = texture;
		this.setHardness(1.0F);
		this.setResistance(3.0F);
		this.setCreativeTab(TutTabs.tutBlocks);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon(Locations.textureLocation + this.getTextureName());
	}
	
	/** What block to drop when destroyed **/
	@Override
	public int idDropped(int par1, Random par2Random, int par3){
		return blockID;
	}

	/** Quantity dropped when destroyed **/
	@Override
	public int quantityDropped(Random random){
		return 1;
	}
}
