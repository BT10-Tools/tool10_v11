package tool10.util;

public class UtilCrc64b {

	public static void fast() {
        String data = "123456789";
        Crc64b tableDriven = new Crc64b(Crc64b.Parameters.XMODEM);
       	long xmodemCrc = tableDriven.calculateCRC(data.getBytes());
        System.out.printf("CRC is 0x%04X\n", xmodemCrc); // prints "CRC is 0x31C3"

       	// You can also reuse CRC object instance for another crc calculation.
        // Given that the only state for a CRC calculation is the "intermediate value"
        // and it is stored in your code, you can even use same CRC instance to calculate CRC
        // of multiple data sets in parallel.
       	// And if data is too big, you may feed it in chunks
       	long curValue = tableDriven.init(); // initialize intermediate value
       	curValue = tableDriven.update(curValue, "123456789".getBytes()); // feed first chunk
        curValue = tableDriven.update(curValue, "01234567890".getBytes()); // feed next chunk
       	long xmodemCrc2 = tableDriven.finalCRC(curValue); // gets CRC of whole data ("12345678901234567890")
        System.out.printf("CRC is 0x%04X\n", xmodemCrc2); // prints "CRC is 0x2C89"
    }
	
	public static void main(String [] args) {
        String data = "123456789";
        long ccittCrc = Crc64b.calculateCRC(Crc64b.Parameters.CCITT, data.getBytes());
        System.out.printf("CRC is 0x%04X\n", ccittCrc); // prints "CRC is 0x29B1"

        fast();
        
    }
	
}
