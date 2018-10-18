package redstoneparadox.libraryparadox.blockpointers;

import net.minecraft.world.World;
import redstoneparadox.libraryparadox.LibraryParadox;
import redstoneparadox.libraryparadox.signals.ISignalReceiver;

import java.util.ArrayList;

/**
 * Created by RedstoneParadox on 10/17/2018.
 */
//Construct one of these when the block is placed or when you know that the specific block is being called.
public class BlockPointer implements ISignalReceiver {

    private int posX;
    private int posY;
    private int posZ;

    private boolean isTicking;

    private World worldIn;

    @Override
    public void receiveSignal(String signal, ArrayList<Object> arguments) {
        World world = (World) arguments.get(0);
        if (world == worldIn) {
            update(world);
        }
    }

    public BlockPointer(int x, int y, int z, World world) {
        posX = x;
        posY = y;
        posZ = z;
    }

    public void setTicking(boolean ticking) {
        if (ticking = isTicking) {
            return;
        }
        else if (ticking == true) {
            LibraryParadox.switchboard.addReceiver(this, "gameTick");
        }
        else {
            LibraryParadox.switchboard.removeReceiver(this, "gameTick");
        }
        isTicking = ticking;
    }

    private void update(World world) {

    }
}
