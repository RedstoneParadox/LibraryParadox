package redstoneparadox.libraryparadox.signals;

import java.util.ArrayList;

/**
 * Created by RedstoneParadox on 9/10/2018.
 */
public interface ISignalReceiver {

    void receiveSignal(String signal, ArrayList<Object> arguments);
}
