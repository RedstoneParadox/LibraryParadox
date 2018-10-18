package redstoneparadox.libraryparadox.inventorio;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by RedstoneParadox on 10/15/2018.
 */
public class InventoryManager {

    private TileEntity tileEntity;

    public InventoryManager(TileEntity tile) {
        tileEntity = tile;
    }

    private void readInventoryData() {
        tileEntity.getTileData().getCompoundTag("tag");
    }

    private void writeInventoryData() {

    }
}
