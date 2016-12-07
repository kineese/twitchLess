package kineese.main.view;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import kineese.main.controller.ViewController;
import kineese.main.dataholders.GameItem;
import kineese.main.dataholders.LanguageItem;

public class MainForm {
	private ViewController controller;

	private JFrame frame;

	private JMenuBar menuBar;
	private JMenu mgConnection;
	private JMenuItem miConnect;
	private JMenuItem miSetup;

	private JTextField txtFollowers;
	private JTextField txtViewers;
	private JTextField txtChatMembers;
	private JTextField txtStreamTitle;

	private JComboBox<GameItem> cbGame;
	private JComboBox<LanguageItem> cbLanguage;
	private JTextField txtChatImput;
	private JTextPane tpChat;

	/**
	 * Create the application.
	 */
	public MainForm(ViewController controller) {
		this.controller = controller;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Label lblFollowers = new Label("Follower");
		lblFollowers.setBounds(0, 0, 56, 22);
		frame.getContentPane().add(lblFollowers);

		txtFollowers = new JTextField();
		txtFollowers.setBounds(100, 0, 86, 20);
		txtFollowers.setEditable(false);
		frame.getContentPane().add(txtFollowers);
		txtFollowers.setColumns(10);

		Label lvlViewers = new Label("Current Viewers");
		lvlViewers.setBounds(0, 27, 95, 22);
		frame.getContentPane().add(lvlViewers);

		txtViewers = new JTextField();
		txtViewers.setBounds(100, 29, 86, 20);
		txtViewers.setEditable(false);
		frame.getContentPane().add(txtViewers);
		txtViewers.setColumns(10);

		Label lblCurrentChatters = new Label("New label");
		lblCurrentChatters.setBounds(0, 54, 62, 22);
		frame.getContentPane().add(lblCurrentChatters);

		txtChatMembers = new JTextField();
		txtChatMembers.setBounds(100, 56, 86, 20);
		txtChatMembers.setEditable(false);
		frame.getContentPane().add(txtChatMembers);
		txtChatMembers.setColumns(10);

		txtChatImput = new JTextField();
		txtChatImput.setBounds(524, 406, 300, 20);
		frame.getContentPane().add(txtChatImput);
		txtChatImput.setColumns(10);

		Label lblStreamTitle = new Label("Stream title");
		lblStreamTitle.setBounds(0, 210, 67, 22);
		frame.getContentPane().add(lblStreamTitle);

		txtStreamTitle = new JTextField();
		txtStreamTitle.setBounds(100, 210, 243, 20);
		txtStreamTitle.setToolTipText("");
		frame.getContentPane().add(txtStreamTitle);
		txtStreamTitle.setColumns(10);

		Label lblGame = new Label("Current Game");
		lblGame.setBounds(0, 237, 81, 22);
		frame.getContentPane().add(lblGame);

		cbGame = new JComboBox();
		cbGame.setBounds(100, 237, 243, 20);
		frame.getContentPane().add(cbGame);

		Label lblLanguage = new Label("Language");
		lblLanguage.setBounds(0, 264, 62, 22);
		frame.getContentPane().add(lblLanguage);

		cbLanguage = new JComboBox();
		cbLanguage.setBounds(100, 264, 243, 20);
		frame.getContentPane().add(cbLanguage);

		tpChat = new JTextPane();
		tpChat.setEditable(false);
		tpChat.setBounds(524, 11, 300, 381);
		frame.getContentPane().add(tpChat);

		setMenuBar(new JMenuBar());
		frame.setJMenuBar(getMenuBar());

		mgConnection = new JMenu("Connection");
		getMenuBar().add(mgConnection);

		setMiConnect(new JMenuItem("Connect"));
		mgConnection.add(getMiConnect());

		setMiSetup(new JMenuItem("Setup"));
		mgConnection.add(getMiSetup());
	}

	public void ShowUp() {
		frame.setVisible(true);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenuItem getMiConnect() {
		return miConnect;
	}

	public void setMiConnect(JMenuItem miConnect) {
		this.miConnect = miConnect;
		miConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.connect();
			}
		});
	}

	public JMenuItem getMiSetup() {
		return miSetup;
	}

	public void setMiSetup(JMenuItem miSetup) {
		this.miSetup = miSetup;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtFollowers() {
		return txtFollowers;
	}

	public void setTxtFollowers(JTextField txtFollowers) {
		this.txtFollowers = txtFollowers;
	}

	public JTextField getTxtViewers() {
		return txtViewers;
	}

	public void setTxtViewers(JTextField txtViewers) {
		this.txtViewers = txtViewers;
	}

	public JTextField getTxtChatMembers() {
		return txtChatMembers;
	}

	public void setTxtChatMembers(JTextField txtChatMembers) {
		this.txtChatMembers = txtChatMembers;
	}

	public JTextField getStreamTitle() {
		return this.txtStreamTitle;
	}

	public JTextPane getTpChat() {
		return this.tpChat;
	}

	public JTextField getChatInput() {
		return txtChatImput;
	}
}
