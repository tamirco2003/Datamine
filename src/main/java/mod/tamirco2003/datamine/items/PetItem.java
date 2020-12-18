package mod.tamirco2003.datamine.items;

import mod.tamirco2003.datamine.Datamine;
import mod.tamirco2003.datamine.capabilities.Pet;
import mod.tamirco2003.datamine.capabilities.PetCapability;
import mod.tamirco2003.datamine.capabilities.PetCapabilityProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class PetItem extends Item {
  public PetItem(Item.Properties properties) {
    super(properties);
  }

  @Override
  public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target,
      Hand hand) {
    Pet pet = stack.getCapability(PetCapability.CAPABILITY_PET).orElse(null);

    if (pet == null || !(target instanceof AnimalEntity)) {
      return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }

    pet.setEntityType(target.getType());
    return ActionResultType.SUCCESS;
  }

  // @Override
  // public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity
  // playerIn, LivingEntity target, Hand hand) {
  // // if (target.world.isRemote) {
  // // return false;
  // // }

  // Pet pet = stack.getCapability(PetCapability.CAPABILITY_PET).orElse(null);

  // if (pet == null) {
  // return false;
  // }

  // if (target instanceof AnimalEntity) {
  // pet.setEntityType(target.getType());
  // return true;
  // }

  // Datamine.LOGGER.debug("Pet type: " + pet.getEntityTypeString());

  // return false;
  // }

  @Override
  public ActionResultType onItemUse(ItemUseContext context) {
    Datamine.LOGGER.debug(
        "onItemUse: " + context.getItem().getCapability(PetCapability.CAPABILITY_PET).orElse(null).getEntityType());
    return super.onItemUse(context);
  }

  @Override
  public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
    return new PetCapabilityProvider();
  }
}