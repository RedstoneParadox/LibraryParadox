package redstoneparadox.libraryparadox.misc;

import redstoneparadox.libraryparadox.LibraryParadox;
import redstoneparadox.libraryparadox.signals.ISignalReceiver;

import java.util.ArrayList;

/**
 * Created by RedstoneParadox on 9/11/2018.
 */
public final class TickTime implements ISignalReceiver {

    private int ticks;

    private boolean ticking = false;
    private boolean decrementing = false;

    public TickTime(int seconds, int tickCount) {
        ticks = (seconds * 20) + tickCount;
    }

    public TickTime(int minutes, int seconds, int tickCount) {
        ticks = (minutes * 60 * 20) + (seconds *20) + tickCount;
    }

    public TickTime(int hours, int minutes, int seconds, int tickCount) {
        ticks = (hours * 60 * 60 * 20) + (minutes * 60 * 20) + (seconds *20) + tickCount;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicking(boolean enabled, boolean decrement) {
        if (enabled == true) {
            LibraryParadox.switchboard.addReceiver(this, "gameTick");
            ticking = true;
            decrementing = decrement;
        }
        else if (enabled == false) {
            LibraryParadox.switchboard.removeReceiver(this, "gameTick");
            ticking = false;
            decrementing = decrement;
        }
    }

    @Override
    public void receiveSignal(String signal, ArrayList<Object> arguments) {
        if (signal == "gameTick") {
            if (decrementing == false) {
                ticks += 1;
            }
            else if (decrementing == true) {
                ticks -= 1;
            }
        }
    }
}
