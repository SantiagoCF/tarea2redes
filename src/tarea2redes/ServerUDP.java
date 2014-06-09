package tarea2redes;

import java.io.*;
import java.net.*;

class ServerUDP
{
    public static  void main(String args[]) throws IOException
    {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        System.out.print("Servidor UDP iniciado");
        byte[] recData = new byte[1024];
        int i =0;

        FileWriter file = new FileWriter
        		("recivido.txt");
        PrintWriter out = new PrintWriter(file);


        //BufferedOutputStream bos = new BufferedOutputStream(fos);

        while(true)
        {
            //PrintWriter out = new PrintWriter(file);

        	DatagramPacket recPacket = new DatagramPacket(recData, recData.length);
            serverSocket.receive(recPacket);
            System.out.println("\n Packet length: " + recPacket.getLength());
            String line = new String(recPacket.getData(), 0, recPacket.getLength());
            System.out.println("\n Data: " + line);
            out.println(line);
            System.out.println("\nPacket" + ++i + " written to file\n");
            out.flush();
        }
    }
}
