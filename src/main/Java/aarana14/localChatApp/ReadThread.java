package main.Java.aarana14.localChatApp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//Runnable is an interface for threads
public class ReadThread extends Chats implements Runnable {
	/*
	 * Variables
	 */
	private static final int MAXLENGTH = 1000;

	private MulticastSocket skt;
	private InetAddress group;
	private int port;

	/*
	 * Constructor
	 */
	ReadThread() {

	}

	ReadThread(MulticastSocket socket, InetAddress group, int port) {
		this.skt = socket;
		this.group = group;
		this.port = port;
	}

	/*
	 * Methods
	 */
	public void run() {
		while (!Chats.termin) {
			byte[] bufr = new byte[ReadThread.MAXLENGTH];
			// Recieve packets
			DatagramPacket dtagrm = new DatagramPacket(bufr, bufr.length, group, port);
			String msge;
			try {
				skt.receive(dtagrm);
				msge = new String(bufr, 0, dtagrm.getLength(), "UTF-8");
				if (msge != null && !msge.startsWith(Chats.name)) {
					Chats.chatGUI.setdMsg(msge);
				}

			} catch (IOException e) {
				System.out.println("\n---------------------\nThank You For Using OG Chat");
			}
		}
	}
}
