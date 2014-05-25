package net.tropicraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.IPlantable;
import net.tropicraft.info.TCInfo;
import net.tropicraft.info.TCNames;

public class BlockPineapple extends BlockTallFlowers implements IPlantable {

	public BlockPineapple(String[] names) {
		super(names);
		this.setBlockName(TCNames.pineapple);
		this.setBlockTextureName(TCNames.tallFlower);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {		
		topIcons = new IIcon[names.length];

		for (int i = 0 ; i < names.length ; i++) {
			topIcons[i] = iconRegister.registerIcon(getActualName(getFormattedTextureName()));
		}

		bottomIcon = iconRegister.registerIcon(getActualName(getFormattedTextureName()) + "_" + TCNames.stem);
	}
	
	/**
	 * 
	 * @return Tropicraft-mod formattted texture name/location
	 */
	protected String getFormattedTextureName() {
		return String.format("tile.%s%s", TCInfo.ICON_LOCATION, getActualName(this.getTextureName()));
	}
	
	/**
	 * @return The unlocalized block name
	 */
	@Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", TCInfo.ICON_LOCATION, getActualName(super.getUnlocalizedName()));
    }
	
	/**
	 * Get the true name of the block
	 * @param unlocalizedName tile.%truename%
	 * @return The actual name of the block, rather than tile.%truename%
	 */
	protected String getActualName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
	}
}
