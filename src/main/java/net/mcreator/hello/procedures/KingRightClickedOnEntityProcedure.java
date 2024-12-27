package net.mcreator.hello.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.hello.world.inventory.QuestProvideGUIMenu;
import net.mcreator.hello.world.inventory.QuestNotFinishedMenu;
import net.mcreator.hello.world.inventory.QuestFinishedMenu;
import net.mcreator.hello.network.HelloModVariables;
import net.mcreator.hello.entity.KingEntity;

import io.netty.buffer.Unpooled;

public class KingRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double manwon_num = 0;
		double Ochunwon_num = 0;
		double Chunwon_num = 0;
		if (sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).MainQuestExist == false) {
			{
				HelloModVariables.PlayerVariables _vars = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.Questgoal1 = entity instanceof KingEntity _datEntI ? _datEntI.getEntityData().get(KingEntity.DATA_king_quest1_goal) : 0;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				HelloModVariables.PlayerVariables _vars = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.reward_money = entity instanceof KingEntity _datEntI ? _datEntI.getEntityData().get(KingEntity.DATA_reward_money) : 0;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				HelloModVariables.PlayerVariables _vars = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.MainQuestRequest = true;
				_vars.syncPlayerVariables(sourceentity);
			}
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("QuestProvideGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new QuestProvideGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			{
				HelloModVariables.PlayerVariables _vars = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.quest_Contents = entity instanceof KingEntity _datEntS ? _datEntS.getEntityData().get(KingEntity.DATA_king_quest1) : "";
				_vars.syncPlayerVariables(sourceentity);
			}
		}
		if (sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).MainQuestExist == true) {
			if (sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).Questgoal1 == sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).Questprogress1) {
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("QuestFinished");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new QuestFinishedMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
				{
					HelloModVariables.PlayerVariables _vars = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES);
					_vars.MainRewardRequest = true;
					_vars.syncPlayerVariables(sourceentity);
				}
			} else if (sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).Questgoal1 > sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).Questprogress1) {
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("QuestNotFinished");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new QuestNotFinishedMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
