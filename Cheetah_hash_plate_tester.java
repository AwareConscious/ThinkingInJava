package com.huobi.prj;

import com.fazecast.jSerialComm.*;

public class Cheetah_hash_plate_tester {

    public static void main(String[] args){
        SerialPort comPort = SerialPort.getCommPorts()[1];
        comPort.setComPortParameters(9600, 8, 1, 0);
        comPort.openPort();

        try {


            byte[] writeBuffer = new byte[]{0x16, 0x55, (byte)0xAA, 0x55, (byte)0xAA, 0x5D, (byte)0x80, (byte)0x81, 0x00, 0x00, 0x00, 0x00, 0x00, (byte)0xBB, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
            while (comPort.bytesAvailable() == 0)
                Thread.sleep(20);
            byte[] readBuffer1 = new byte[comPort.bytesAvailable()];
            int numRead = comPort.readBytes(readBuffer1, readBuffer1.length);
            for (Integer i = 0; i < readBuffer1.length; i++){
                System.out.format("%c", readBuffer1[i]);
            }
            System.out.println('\n');
            while (true)
            {
                int numWrite = comPort.writeBytes(writeBuffer, 22);
                System.out.format("%d bytes sent  : ", numWrite);
                for (Integer i = 0; i < 6; i++){
                    System.out.format("%x ",writeBuffer[i]);
                }
                writeBuffer[5]+=1;

                while (comPort.bytesAvailable() == 0)
                    Thread.sleep(20);
                byte[] readBuffer = new byte[comPort.bytesAvailable()];
                numRead = comPort.readBytes(readBuffer, readBuffer.length);
                System.out.format("\n%d bytes received: ", numRead);
                for (Integer i = 0; i < readBuffer.length; i++){
                    System.out.format("%x ",readBuffer[i]);
                }
                System.out.println('\n');

                Thread.sleep(100);
            }
        } catch (Exception e) {e.printStackTrace();}
        comPort.closePort();
    }
}
