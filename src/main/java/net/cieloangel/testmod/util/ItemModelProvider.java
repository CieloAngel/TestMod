// Created class so blocks and items that do not extend BlockBase or ItemBase can still use the system for registering items

package net.cieloangel.testmod.util;

import net.minecraft.item.Item;

public interface ItemModelProvider {

	void registerItemModel(Item item);

}
