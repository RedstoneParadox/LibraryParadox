package redstoneparadox.libraryparadox.eventhandlers;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import redstoneparadox.libraryparadox.LibraryParadox;

import java.util.ArrayList;

/**
 * Created by RedstoneParadox on 9/22/2018.
 */
public class LPEventHandler {

    @SubscribeEvent
    public void onGameTick(TickEvent.WorldTickEvent event) {
        ArrayList<Object> arguments = new ArrayList<>();
        arguments.add(event);
        LibraryParadox.switchboard.sendSignal("gameTick", arguments);
    }
}
