

package net.mcreator.hello.item;

public class OchunwonItem extends Item {
public OchunwonItem() {
super(new Item.Properties()
.stacksTo(64)
.rarity(Rarity.COMMON)
);
}
@Override public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
OchunwonRightclickedProcedure.execute(entity);
return ar;
}
}