/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author asksoft
 */

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.OutputStream;

public class POSPrintDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String portName = "/dev/ttyS4";
        Integer baudrate = 57600;
        Integer timeout = 1000;

        SerialPort serialPort = (SerialPort)CommPortIdentifier.getPortIdentifier(portName).open(POSPrintDemo.class.getName(), 1000);
        serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        serialPort.enableReceiveTimeout(timeout);

        try(OutputStream os = serialPort.getOutputStream()) {
            // select double width and height font
            os.write(new byte[] {0x1b, 0x21, 0x31});

            os.write("       AROMA CAFE\n".getBytes());
            os.write("   1211 Green Street\n".getBytes());
            os.write("      New York, NY\n".getBytes());

            // select normal font
            os.write(new byte[] {0x1b, 0x21, 0x01});

            os.write("03-12-2016       1:11PM\n".getBytes());
            os.write("TBL 1            HOST ALISON\n".getBytes());
            os.write("VISA ######8281\n".getBytes());
            os.write("\n".getBytes());
            os.write("QTY  DESC                              AMT\n".getBytes());
            os.write("----------------------------------------------\n".getBytes());
            os.write("1   GINGER CARROT SOUP                   $6.79\n".getBytes());
            os.write("1   HOUSE SALAD                          $7.69\n".getBytes());
            os.write("1   SURF AND RUTF - 1 PERS              $48.79\n".getBytes());
            os.write("1   WINE - GLASS - FIXE                 $11.50\n".getBytes());
            os.write("1   CHOC CAKE                            $6.75\n".getBytes());
            os.write("\n".getBytes());

            // select double width and height font
            os.write(new byte[] {0x1b, 0x21, 0x31});
            os.write("    AMOUNT    $90.52\n".getBytes());

            os.write(new byte[] {0x1b, 0x21, 0x01});
            os.write("\n".getBytes());
            os.write("        SUB-TOTAL           $81.52\n".getBytes());
            os.write("        TAX                  $9.00\n".getBytes());
            os.write("        BALANCE             $90.52\n".getBytes());
            os.write("\n".getBytes());
            os.write("\n".getBytes());
            os.write("\n".getBytes());

            // center text
            os.write(new byte[] {0x1b, 0x61, 0x31}); 

            // set barcode height to 80px
            os.write(new byte[] {0x1d, 0x68, 0x50}); 

            // print CODE39 with text TEST
            os.write(new byte[] {0x1d, 0x6b, 0x45, 0x04, 'T', 'E', 'S', 'T'});
            os.flush();
        }
    }   
}