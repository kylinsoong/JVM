package com.kylin.test.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadDataToBuffer {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("/home/kylin/work/tmp/tmp", "rw");
		FileChannel inChannel = aFile.getChannel();
		
		//create buffer with capacity of 128 bytes
		ByteBuffer buf = ByteBuffer.allocate(128);
		
		//read into buffer
		int bytesRead = inChannel.read(buf);
		
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			
			//make buffer ready for read
			buf.flip();
			while (buf.hasRemaining()) {
				//read 1 byte at a time
				System.out.print((char) buf.get());
			}
			//make buffer ready for writing
			buf.clear();
			System.out.println();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}

}
