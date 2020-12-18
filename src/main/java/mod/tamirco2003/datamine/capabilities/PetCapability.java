package mod.tamirco2003.datamine.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

// Class for storing and serializing the capability.
public class PetCapability {
  @CapabilityInject(Pet.class)
  public static Capability<Pet> CAPABILITY_PET = null;

  public static void register() {
    CapabilityManager.INSTANCE.register(Pet.class, new Pet.PetStorage(), () -> new Pet());
  }
}