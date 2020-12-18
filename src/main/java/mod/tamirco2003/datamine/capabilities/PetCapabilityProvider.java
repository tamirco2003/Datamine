package mod.tamirco2003.datamine.capabilities;

import mod.tamirco2003.datamine.Datamine;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

// Class that provides an instance of the capability to the item.
public class PetCapabilityProvider implements ICapabilitySerializable<INBT> {
  private final Pet pet = new Pet();
  private final LazyOptional<Pet> petOptional = LazyOptional.of(() -> pet);

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    if (cap == PetCapability.CAPABILITY_PET) {
      return petOptional.cast();
    }

    return null;
  }

  @Override
  public INBT serializeNBT() {
    return PetCapability.CAPABILITY_PET.writeNBT(this.pet, null);
  }

  @Override
  public void deserializeNBT(INBT nbt) {
    PetCapability.CAPABILITY_PET.readNBT(this.pet, null, nbt);
  }

}