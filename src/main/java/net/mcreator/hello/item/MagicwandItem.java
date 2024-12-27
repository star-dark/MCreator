

package net.mcreator.hello.item;

public class MagicwandItem extends Item {
public MagicwandItem() {
super(new Item.Properties()
.stacksTo(64)
.rarity(Rarity.COMMON)
);
}
@Override public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
boolean retval = super.onEntitySwing(itemstack, entity, hand);
EarnMoneyProcedure.execute(entity);
return retval;
}
@Override public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
super.inventoryTick(itemstack, world, entity, slot, selected);
if (selected)
ClearaitemeulsonedeulgoissneungyeonguProcedure.execute(entity);
}
}