package main.Java.aarana14.localChatApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GCGui1 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Fields
	 */
	private JFrame frame = new JFrame("OG Chat");
	private static String ipAd, port, name;
	private static JTextField ipTF, portTF, nameTF;
	private static Boolean sub = false;
	private JLabel ipLabel, portLabel, nameLabel;
	private static JButton send;

	/*
	 * Constructors
	 */
	GCGui1(int i) {
		System.out.println("ActionCheckOpen1");
	}

	public GCGui1() {
		// Creating the Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		// Menubar
		JMenuBar mb = new JMenuBar();

		// Creating the panel at bottom and adding components
		JPanel panel = new JPanel();
		ipLabel = new JLabel("IP: ");
		ipTF = new JTextField(20);
		portLabel = new JLabel("Port: ");
		portTF = new JTextField(7);
		nameLabel = new JLabel("Name: ");
		nameTF = new JTextField(10);
		send = new JButton("Enter");

		//Action Scanner
		GCGui1 te = new GCGui1(1);
		send.addActionListener(te);

		panel.add(ipLabel);
		panel.add(ipTF);
		panel.add(portLabel);
		panel.add(portTF);
		panel.add(nameLabel);
		panel.add(nameTF);
		panel.add(send);

		// Adding Components to the frame.
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.setVisible(true);
	}

	public void visibleFrame(Boolean vis) {
		frame.setVisible(vis);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Enter")) {
			setIpAd(ipTF.getText());
			setPort(portTF.getText());
			setUName(nameTF.getText());
			setSub(true);
		}
	}

	/*
	 * Getter/Setter
	 */

	public String getIpAd() {
		return ipAd;
	}

	public String getPort() {
		return port;
	}

	public String getUName() {
		return name;
	}

	public Boolean getSub() {
		// This is stupid
		System.out.print("");
		return sub;
	}

	private void setIpAd(String ipAd) {
		GCGui1.ipAd = ipAd;
	}

	private void setPort(String port) {
		GCGui1.port = port;
	}

	private void setUName(String name) {
		GCGui1.name = name;
	}

	private void setSub(Boolean sub) {
		GCGui1.sub = sub;
	}
}
