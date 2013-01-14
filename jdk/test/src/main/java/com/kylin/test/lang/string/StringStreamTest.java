package com.kylin.test.lang.string;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class StringStreamTest extends StringTestBase {

	public void test() throws IOException {

		InputStream in = new ByteArrayInputStream(testStr1.getBytes());
		
		int byte2read = -1;
	    int c = 0;
	    byte[] barr = new byte[4];
	    c = in.read(barr);
	    
	    if (c == -1){
	    	throw new EOFException();
	    }
	    
	    if (c < 4){
	    	throw new IOException("Start length field not read successfully , only " + c + " bytes read:\"" + new String(barr) + "\"");
	    }
	    
		String len = new String(barr, "iso-8859-1");
	    
		try {
			byte2read = Integer.parseInt(len);
		} catch (Exception ex) {
	      throw new IOException("Cannot parse " + len + "to integer for pkg length.");
	    }
		
		StringBuffer msgBuf = new StringBuffer();
		
		byte[] buf = new byte[100];
	    int _r = 0;
	    
		for (c = 0; c < byte2read;) {
			
			_r = in.read(buf);
	      
			if (_r < 0){
				throw new IOException("Not enough byte received, only " + len + msgBuf.toString() + " readed");
			}

			c += _r;
			msgBuf.append(new String(buf, 0, _r));
		}
	    
	    println(msgBuf.toString());
	}

	public static void main(String[] args) throws IOException {

		new StringStreamTest().test();
	}

}
