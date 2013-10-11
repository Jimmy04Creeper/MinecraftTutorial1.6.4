package jimmy.dimension.blocks;

import jimmy.dimension.core.TutTabs;
import jimmy.dimension.core.lib.Locations;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLog extends BlockModBasic
{
	@SideOnly(Side.CLIENT)
	private Icon LogTop;
	@SideOnly(Side.CLIENT)
	private Icon LogSide;
	
	private String texture;

	public BlockModLog(int par1, String par2)
	{
		super(par1, par2);
		this.setStepSound(soundWoodFootstep);
		this.setHardness(2.0F);
		Block.setBurnProperties(blockID, 30, 60);
		this.setCreativeTab(TutTabs.tutBlocks);
	}

	/** gets the icon **/
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		int k = par2 & 12;
		int l = par2 & 3;
		return k == 0 && (par1 == 1 || par1 == 0) ? this.LogTop : (k == 4 && (par1 == 5 || par1 == 4) ? this.LogTop : (k == 8 && (par1 == 2 || par1 == 3) ? this.LogTop : this.LogSide));
	}

	@Override
	@SideOnly(Side.CLIENT)
	/** Register Icons for this block used in method above **/
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.LogTop = par1IconRegister.registerIcon(Locations.textureLocation + this.getTextureName() + "_Top");
		this.LogSide = par1IconRegister.registerIcon(Locations.textureLocation + this.getTextureName() + "_Side");
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	public int idDropped(int par1)
	{
		return par1;
	}

	@Override
	public int damageDropped(int i)
	{
		return i;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
		return true;
	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	 */
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	{
		int j1 = par9 & 3;
		byte b0 = 0;
		switch (par5)
		{
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}
		return j1 | b0;
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		byte b0 = 4;
		int j1 = b0 + 1;

		if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
		{
			for (int k1 = -b0; k1 <= b0; ++k1)
			{
				for (int l1 = -b0; l1 <= b0; ++l1)
				{
					for (int i2 = -b0; i2 <= b0; ++i2)
					{
						int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

						if (Block.blocksList[j2] != null)
						{
							Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}
	}
}