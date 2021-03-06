package main.Java.aarana14.localChatApp;


public class MainProgram {
	public static void main(String[] args) {
		System.out.println("OG Chat Program Open\n---------------------\n");
		/*
		 * Variables
		 */
		String ipAddress = null, portNum = null, uName = null;

		// Set GUI's
		GCGui1 menuGUI = new GCGui1();
		menuGUI.visibleFrame(true);

		// Get IP Address and Port Number from user
		System.out.println("Getting IP Address, Port, Name");
		while (!menuGUI.getSub()) {
			ipAddress = menuGUI.getIpAd();
			portNum = menuGUI.getPort();
			uName = menuGUI.getUName();
		}


		System.out.println("Info Recieved: " + ipAddress + portNum + uName);
		menuGUI.visibleFrame(false);

		// Start GC Object
		@SuppressWarnings("unused")
		Chats gc = new Chats(ipAddress, portNum, uName);
	}
}
