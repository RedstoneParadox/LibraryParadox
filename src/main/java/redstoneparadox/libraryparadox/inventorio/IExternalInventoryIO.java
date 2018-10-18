package redstoneparadox.libraryparadox.inventorio;

/**
 * Created by RedstoneParadox on 10/15/2018.
 */
public interface IExternalInventoryIO {

    /*
    Implement this interface so that InventoryManagers in TEs can easily communicate with each other
    Without having to go through Forge Capabilities. Make sure to return the one that the TE itself
    creates and not some other instance.
    */
    public InventoryManager getInventory();
}
