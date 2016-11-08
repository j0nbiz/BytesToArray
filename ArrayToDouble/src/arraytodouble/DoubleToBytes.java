
/**
 *  Converting a double to an eight-byte array and back to a double.
 *
 *  @author     Alex Simonelis
 *  @version    October, 2011
 *
 */


public class DoubleToBytes
{
    public static void main(String s[])
    {
		double d =123.8;
		System.out.println("**** "+ d);
		d = byteArrayToDouble(doubleToByteArray(d));
		System.out.println("**** " + d);
	}


	public static byte [] doubleToByteArray (double numDouble)
	{
		byte [] arrayByte = new byte [8];
		long numLong;
		numLong = Double.doubleToRawLongBits(numDouble);

                for(int i = arrayByte.length - 1; i >= 0; i--)
                {
                    // 
                    arrayByte[i] = (byte)(numLong & 0x00000000000000FFL);
                    // Shift the bits to the right
                    numLong = numLong >> 8;
                }

		return arrayByte;
	}

	public static double byteArrayToDouble (byte [] arrayByte)
	{
		double numDouble;
		long numLong;

		numLong = (((long)arrayByte[0] & 0x00000000000000FFL) << 56) | (((long)arrayByte[1] & 0x00000000000000FFL) << 48) |
			(((long)arrayByte[2] & 0x00000000000000FFL) << 40) |	(((long)arrayByte[3] & 0x00000000000000FFL) << 32) |
			(((long)arrayByte[4] & 0x00000000000000FFL) << 24) | (((long)arrayByte[5] & 0x00000000000000FFL) << 16) |
			(((long)arrayByte[6] & 0x00000000000000FFL) <<  8) | ((long)arrayByte[7] & 0x00000000000000FFL);

		numDouble = Double.longBitsToDouble(numLong);

		return numDouble;
	}
}