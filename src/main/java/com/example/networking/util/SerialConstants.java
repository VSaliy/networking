package com.example.networking.util;

public final class SerialConstants {
	//TODO: extend framework constants class se.extenda.eps.messaging.serial.SerialConstants
	private SerialConstants() {
	}
	
	public static final byte STX_CHAR = 0x02; //Start of text 
    public static final byte ETX_CHAR = 0x03; //End of text
    public static final byte EOT_CHAR = 0x04; //End of transmission
    public static final byte ENQ_CHAR = 0x05; //Enquiry
    public static final byte ACK_CHAR = 0x06; //Acknowledgement
    public static final byte DLE_CHAR = 0x10; //Data link escape
    public static final byte NAK_CHAR = 0x15; //Negative acknowledgement
    public static final byte BSY_CHAR = 0x16; //Busy
    public static final byte FS_CHAR = 0x1C; //Field separator
    public static final byte RS_CHAR = 0x1E; //Record separator
}
