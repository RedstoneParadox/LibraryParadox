package redstoneparadox.libraryparadox;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import redstoneparadox.libraryparadox.eventhandlers.LPEventHandler;
import redstoneparadox.libraryparadox.signals.Switchboard;

@Mod(
        modid = LibraryParadox.MOD_ID,
        name = LibraryParadox.MOD_NAME,
        version = LibraryParadox.VERSION
)
public class LibraryParadox {

    public static final String MOD_ID = "libraryparadox";
    public static final String MOD_NAME = "LibraryParadox";
    public static final String VERSION = "1.0.0";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */

    @Mod.Instance(MOD_ID)
    public static LibraryParadox INSTANCE;


    public static Logger logger;
    public static Switchboard switchboard;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new LPEventHandler());
        logger = event.getModLog();
        switchboard = new Switchboard();
        switchboard.addSignal("gameTick");
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
