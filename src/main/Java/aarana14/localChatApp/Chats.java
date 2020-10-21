package ChatApp;

import java.util.*;
import java.io.*;
import java.net.*;

public class Chats {
	/*
	 * Important Variables
	 */
	private static final String END = "Exit";
	protected static String name, ipAddy, portNum;
	private String msg;
	protected static GCGui2 chatGUI;

	// Changed by threads w/o warning
	protected static volatile boolean termin = false;

	/*
	 * Constructor
	 */
	public Chats() {

	}

	public Chats(String ipAddress, String portNum, String name) {
		Scanner input = new Scanner(System.in);

		Chats.ipAddy = ipAddress;
		Chats.portNum = portNum;
		Chats.name = name;

		// Program Run
		chatsProgram(input, ipAddress, portNum);
	}

	public void chatsProgram(Scanner input, String ipAddress, String portNum) {
		try {
			System.out.println("Pgrm Running...");
			InetAddress grp = InetAddress.getByName(ipAddress);
			int port = Integer.parseInt(portNum);
			MulticastSocket multiS = new MulticastSocket(port);

			multiS.setTimeToLive(1);

			multiS.joinGroup(grp);
			// Use Runnable
			Thread t = new Thread(new ReadThread(multiS, grp, port));

			t.start();

			// Open 2nd GUI
			chatGUI = new GCGui2();
			chatGUI.visibleFrame(true);

			while (true) {
				// Get Msg from GUI
				msg = chatGUI.getuMsg();

				// Check that message has content
				if (msg != null) {
					// Termination
					if (msg.equalsIgnoreCase(Chats.END)) {
						termin = true;
						multiS.leaveGroup(grp);
						multiS.close();
						System.out.println("PROGRAM CLOSED");
						chatGUI.setdMsg("\n-------\nChat Left\n-------\n");
						break;
					}

					msg = name + ": " + msg;
					byte[] buffer = msg.getBytes();
					DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, grp, port);
					// Send Message
					multiS.send(datagram);
					chatGUI.setdMsg(msg);

					// Change message back to null
					chatGUI.setuMsg(null);
				}
			}
		} catch (SocketException se) {
			System.out.println("Couldn't Create Socket");
			se.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read/write");
			e.printStackTrace();
		}
	}
}
