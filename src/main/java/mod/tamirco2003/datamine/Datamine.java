package mod.tamirco2003.datamine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

@Mod(Datamine.MODID)
public class Datamine {
  // Mod ID.
  public static final String MODID = "datamine";

  // Logger.
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  public Datamine() {
    Datamine.LOGGER.debug("Constructing mod...");
  }
}