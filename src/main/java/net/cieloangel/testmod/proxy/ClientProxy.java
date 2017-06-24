package net.cieloangel.testmod.proxy;

import net.cieloangel.testmod.init.ModBlocks;

public class ClientProxy extends CommonProxy {
	
	public void init(){
		// intentionally left blank
	}
	
	@Override
	public void registerRenders() {
		ModBlocks.registerRenders();
	}

}
