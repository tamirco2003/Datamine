package mod.tamirco2003.datamine;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Datamine.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
  // @SubscribeEvent
  // public static void OnEntityInteract(EntityInteract context) {
  //   if (!context.getWorld().isRemote && context.getHand() == Hand.MAIN_HAND) {
  //     Datamine.LOGGER.debug("Interact with entity.");
  //   }
  // }
}