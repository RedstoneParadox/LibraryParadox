package redstoneparadox.libraryparadox.geometry;

/**
 * Created by RedstoneParadox on 9/12/2018.
 */

//Note that this isn't fully ready; just use Java's Vec classes for now.
public class VectorObject {

    private int xLength;
    private int yLength;

    public VectorObject(int x, int y) {
        xLength = x;
        yLength = y;
    }

    public int getXLength() {
        return xLength;
    }

    public int getYLength() {
        return yLength;
    }


    public double getLength() {
        double length = Math.sqrt((xLength * xLength) + (yLength * yLength));
        return length;
    }

    //Returns the angle from this vector to the supplied vector.
    public double angleTo(VectorObject vector) {
        int toa1 = yLength/xLength;
        double angle1 = Math.atan(toa1);

        int toa2 = (vector.getYLength())/(vector.getXLength());
        double angle2 = Math.atan(toa2);

        return angle2 - angle1;
    }

    //Adds the supplied vector to this one and returns a new vector.
    public VectorObject addVector(VectorObject vector) {
        int xNew = xLength + vector.getXLength();
        int yNew = yLength + vector.getYLength();

        return new VectorObject(xNew, yNew);
    }

    //Subtracts the supplied vector from this one and returns a new vector.
    public VectorObject subtractVector(VectorObject vector) {
        int xNew = xLength - vector.getXLength();
        int yNew = yLength - vector.getYLength();

        return new VectorObject(xNew, yNew);
    }
}
