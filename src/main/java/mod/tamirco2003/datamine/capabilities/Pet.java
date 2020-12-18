package mod.tamirco2003.datamine.capabilities;

import mod.tamirco2003.datamine.Datamine;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

// Class that stores actual data for capability.
public class Pet {
  private EntityType<?> entityType;

  public Pet() {
    this.entityType = null;
  }

  public String getEntityTypeString() {
    if (this.entityType == null) {
      return "";
    }

    return EntityType.getKey(this.entityType).toString();
  }

  public EntityType<?> getEntityType() {
    return this.entityType;
  }

  public void setEntityType(EntityType<?> entityType) {
    this.entityType = entityType;
    Datamine.LOGGER.debug("setEntityType type: " + this.entityType);
  }

  public void setEntityType(String entityType) {
    this.entityType = EntityType.byKey(entityType).orElse(null);
    Datamine.LOGGER.debug("setEntityType string: " + this.entityType);
  }

  public void releaseEntity() {
    this.entityType = null;
  }

  public static class PetStorage implements IStorage<Pet> {
    @Override
    public void readNBT(Capability<Pet> capability, Pet instance, Direction side, INBT nbt) {
      if (nbt instanceof CompoundNBT) {
        instance.setEntityType(((CompoundNBT) nbt).getString("type"));
      }
    }

    @Override
    public INBT writeNBT(Capability<Pet> capability, Pet instance, Direction side) {
      CompoundNBT nbt = new CompoundNBT();
      nbt.putString("type", instance.getEntityTypeString());
      return nbt;
    }
  }

}