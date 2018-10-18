package redstoneparadox.libraryparadox.signals;

import redstoneparadox.libraryparadox.LibraryParadox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RedstoneParadox on 9/10/2018.
 */
public final class Switchboard{

    private Map<String, ArrayList<ISignalReceiver>> signals = new HashMap<>();

    public void addSignal(String signal) {
        if (signals.get(signal) == null) {
            signals.put(signal, new ArrayList());
        }
        else {
            LibraryParadox.logger.error("Signal " + signal + " already exists!");
        }
    }

    public void removeSignal(String signal) {
        if (signals.get(signal) != null) {
            signals.remove(signal);
        }
        else {
            LibraryParadox.logger.error("Signal " + signal + " does not exist!");
        }
    }

    @Deprecated
    public void addProtectedSignal(String signal) {
        LibraryParadox.logger.error("Switchboard#addProtectedSignal() never did anything special in the first place. Just use Switchboard#addSignal().");
        addSignal(signal);
    }

    public void addReceiver(ISignalReceiver receiver, String signal) {
        if (signals.get(signal) != null) {
            ArrayList receivers = signals.get(signal);
            receivers.add(receiver);
            LibraryParadox.logger.error(receivers.size());
        }
        else {
            LibraryParadox.logger.error("Signal " + signal + " does not exist!");
        }
    }

    public void removeReceiver(ISignalReceiver receiver, String signal) {
        if (signals.get(signal) != null) {
            ArrayList receivers = signals.get(signal);
            if (receivers.contains(receiver)) {
                receivers.remove(receiver);
            }
            else {
                LibraryParadox.logger.info("Reciever " + receiver + " was not listening for this signal.");
            }
        }
        else {
            LibraryParadox.logger.error("Signal " + signal + " does not exist!");
        }
    }

    public boolean sendSignal(String signal, ArrayList<Object> arguments) {

        if (signals.get(signal) != null) {
            ArrayList receivers = signals.get(signal);
            if (receivers.isEmpty()) {
                LibraryParadox.logger.info("No one is listening to signal" + signal + "!");
                return false;
            }
            else {
                boolean returnBool = false;
                for (int i = 0; i < receivers.size(); i++) {
                    Object receiver = receivers.get(i);
                    //Method calls to relay the signal to the receiver.
                    if (receiver instanceof ISignalReceiver) {
                        relaySignal(((ISignalReceiver) receiver), signal, arguments);
                        returnBool = true;
                    }
                    else {
                        LibraryParadox.logger.error(receiver + "does not implement ISignalReceiver! Signal " + signal + " will not be sent to " + receiver + "!");
                    }
                }
                return returnBool;
            }
        }
        LibraryParadox.logger.error("Signal " + signal + " does not exist!");
        return false;
    }

    private <T extends Object & ISignalReceiver> void relaySignal(T receiver, String signal, ArrayList<Object> arguments) {
        receiver.receiveSignal(signal, arguments);
    }
}
