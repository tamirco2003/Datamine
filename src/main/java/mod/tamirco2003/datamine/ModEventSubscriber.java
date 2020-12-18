package mod.tamirco2003.datamine;

import mod.tamirco2003.datamine.capabilities.PetCapability;
import mod.tamirco2003.datamine.items.PetItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = Datamine.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
  @SubscribeEvent
  public static void onRegisterItems(RegistryEvent.Register<Item> event) {
    Datamine.LOGGER.debug("Register");
    event.getRegistry().registerAll(
        (new PetItem(new Item.Properties()).setRegistryName(new ResourceLocation(Datamine.MODID, "example_item"))));
    Datamine.LOGGER.debug("Register: Registered");
  }

  @SubscribeEvent
  public static void commonSetup(FMLCommonSetupEvent event) {
    Datamine.LOGGER.debug("Common");
    PetCapability.register();
    Datamine.LOGGER.debug("Common: Set up");
  }
}