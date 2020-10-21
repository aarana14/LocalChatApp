package ChatApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GCGui2 extends JFrame implements ActionListener {
	/*
	 * Fields
	 */
	private JFrame frame = new JFrame("OG Chat");
	private static String uMsg, rMsg, dMsg;
	private static JTextField msgTF;
	private JButton sendMsg;
	private JTextArea ta;

	public GCGui2(int i) {
		System.out.println("ActionCheckOpen2");
	}

	public GCGui2() {
		// Creating the Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		// Menubar
		JMenuBar mb = new JMenuBar();

		// Creating the panel at bottom and adding components
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Message: ");
		msgTF = new JTextField(20);
		sendMsg = new JButton("Send");

		// Action Scanner
		GCGui2 te = new GCGui2(1);
		sendMsg.addActionListener(te);

		panel.add(label);
		panel.add(msgTF);
		panel.add(sendMsg);

		// Text Area at the Center
		ta = new JTextArea("Connection Established!\nWelcome to the OG Chat\nType 'Exit' to exit\n\nIP: "
				+ Chats.ipAddy + " | Port: " + Chats.portNum + " | Name: " + Chats.name);
		ta.setEditable(false);
		// Scroll
		JScrollPane scroll = new JScrollPane(ta);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Adding Components to the frame.
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.getContentPane().add(BorderLayout.CENTER, scroll);
		frame.setVisible(true);
	}

	public void visibleFrame(Boolean vis) {
		frame.setVisible(vis);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Send")) {
			setuMsg(msgTF.getText());
		}
	}

	public String getuMsg() {
		return uMsg;
	}

	public void setuMsg(String uMsg) {
		GCGui2.uMsg = uMsg;
	}

	public String getrMsg() {
		return rMsg;
	}

	public void setrMsg(String rMsg) {
		GCGui2.rMsg = rMsg;
	}

	public String getdMsg() {
		return dMsg;
	}

	public void setdMsg(String dMsg) {
		this.dMsg = dMsg;
		ta.append(dMsg + "\n");
		ta.setCaretPosition(ta.getDocument().getLength());
	}

}
