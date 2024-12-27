
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hello.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.hello.item.OchunwonItem;
import net.mcreator.hello.item.ManwonItem;
import net.mcreator.hello.item.MagicwandItem;
import net.mcreator.hello.item.ChunwonItem;
import net.mcreator.hello.HelloMod;

public class HelloModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(HelloMod.MODID);
	public static final DeferredItem<Item> KING_SPAWN_EGG = REGISTRY.register("king_spawn_egg", () -> new DeferredSpawnEggItem(HelloModEntities.KING, -16711936, -16737895, new Item.Properties()));
	public static final DeferredItem<Item> PIG_SPAWN_EGG = REGISTRY.register("pig_spawn_egg", () -> new DeferredSpawnEggItem(HelloModEntities.PIG, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> MAGICWAND = REGISTRY.register("magicwand", MagicwandItem::new);
	public static final DeferredItem<Item> MANWON = REGISTRY.register("manwon", ManwonItem::new);
	public static final DeferredItem<Item> OCHUNWON = REGISTRY.register("ochunwon", OchunwonItem::new);
	public static final DeferredItem<Item> CHUNWON = REGISTRY.register("chunwon", ChunwonItem::new);
	public static final DeferredItem<Item> QUEEN_SPAWN_EGG = REGISTRY.register("queen_spawn_egg", () -> new DeferredSpawnEggItem(HelloModEntities.QUEEN, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> FARMER_JOB_NPC_SPAWN_EGG = REGISTRY.register("farmer_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(HelloModEntities.FARMER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> FISHER_JOB_NPC_SPAWN_EGG = REGISTRY.register("fisher_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(HelloModEntities.FISHER_JOB_NPC, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> MINER_JOB_NPC_SPAWN_EGG = REGISTRY.register("miner_job_npc_spawn_egg", () -> new DeferredSpawnEggItem(HelloModEntities.MINER_JOB_NPC, -1, -1, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
