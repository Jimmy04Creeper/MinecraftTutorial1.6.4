package jimmy.dimension.core;

import java.util.Random;

import jimmy.dimension.world.biomes.BiomeDecoratorTutorial;
import jimmy.dimension.world.biomes.BiomeGenBaseTut;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class TutBiomes extends BiomeGenBase{
	
	public static final TutBiomes[] biomeList = new TutBiomes[256];
	public static final BiomeGenBase psionBiome = (new BiomeGenBaseTut(TutDimensions.tutBiomeID));

	public TutBiomes(int par1){
		super(par1);
		biomeList[par1] = this;
	}
	
	//Below adds the code for the biome decorator, be aware i had a lot of issues getting this to work.
	@Override
	public BiomeDecorator createBiomeDecorator(){   
        return getModdedBiomeDecorator(new BiomeDecoratorTutorial(this));
    }
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
      this.theBiomeDecorator.decorate(par1World, par2Random, par3, par4);
    }
}