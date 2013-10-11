package jimmy.dimension.blocks;

import java.util.Random;

import jimmy.dimension.core.TutBlocks;
import jimmy.dimension.core.TutTabs;
import jimmy.dimension.core.lib.Locations;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModGrass extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon iconGrassTop;
    @SideOnly(Side.CLIENT)
    private Icon iconSnowSide;

    public BlockModGrass(int par1, String texture)
    {
        super(par1, Material.grass);
        this.setTickRandomly(true);
		this.setTextureName(texture);
		this.setCreativeTab(TutTabs.tutBlocks);
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.iconGrassTop : (par1 == 0 ? TutBlocks.tutDirt.getBlockTextureFromSide(par1) : this.blockIcon);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.setBlock(par2, par3, par4, TutBlocks.tutDirt.blockID);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    int l1 = par1World.getBlockId(i1, j1 + 1, k1);

                    if (par1World.getBlockId(i1, j1, k1) == TutBlocks.tutDirt.blockID && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, this.blockID);
                    }
                }
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 == 1)
        {
            return this.iconGrassTop;
        }
        else if (par5 == 0)
        {
            return TutBlocks.tutDirt.getBlockTextureFromSide(par5);
        }
		return blockIcon;
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Locations.textureLocation + this.getTextureName() + "_side");
        this.iconGrassTop = par1IconRegister.registerIcon(Locations.textureLocation+ this.getTextureName() + "_top");
    }

	@Override
	public boolean canSustainPlant(World world, int x, int y, int z,
			ForgeDirection direction, IPlantable plant) {
			return true;
	}
}
