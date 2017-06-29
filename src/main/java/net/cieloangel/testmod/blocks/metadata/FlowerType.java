package net.cieloangel.testmod.blocks.metadata;

import net.minecraft.util.IStringSerializable;

public enum FlowerType implements IStringSerializable {
	
	HYDRANGEA(0, "hydrangea"),
	IRIS(1, "iris");
    //ORANGE(1, "orange"),
//    MAGENTA(2, "magenta"),
//    LIGHT_BLUE(3, "light_blue"),
//    YELLOW(4, "yellow"),
//    LIME(5, "lime"),
//    PINK(6, "pink"),
//    GRAY(7, "gray"),
//    LIGHT_GRAY(8, "light_gray"),
//    CYAN(9, "cyan"),
//    PURPLE(10, "purple"),
//    BLUE(11, "blue"),
//    BROWN(12, "brown"),
//    GREEN(13, "green"),
//    RED(14, "red"),
//    BLACK(15, "black");

	private int meta;
	private String name;
	
	private FlowerType(int meta, String name) {
		this.meta = meta;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMetadata() {
		return meta;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
