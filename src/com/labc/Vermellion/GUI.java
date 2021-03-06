package com.labc.Vermellion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Cursor;
import javax.swing.JScrollPane;

public class GUI {
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmVermellion = new JFrame();
		frmVermellion.setLocationByPlatform(true);
		frmVermellion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmVermellion.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmVermellion.setTitle("Vermellion");
		frmVermellion.getContentPane().setBackground(Color.BLACK);
		frmVermellion.setBackground(Color.WHITE);
		frmVermellion.setAlwaysOnTop(true);
		frmVermellion.setBounds(100, 100, 857, 576);
		frmVermellion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVermellion.getContentPane().setLayout(null);
		frmVermellion.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 11, 364, 361);
		Start.pic = lblNewLabel;
		frmVermellion.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 52, 460, 491);
		frmVermellion.getContentPane().add(scrollPane);
		
		JTextArea txtrHello = new JTextArea();
		scrollPane.setViewportView(txtrHello);
		txtrHello.setWrapStyleWord(true);
		txtrHello.setLineWrap(true);
		txtrHello.setEditable(false);
		txtrHello.setFont(new Font("Segoe Print", Font.ITALIC, 16));
		txtrHello.setForeground(Color.WHITE);
		txtrHello.setBackground(Color.DARK_GRAY);
		Start.ta = txtrHello;
		
		JTextField txtInsertText = new JTextField();
		txtInsertText.setFont(new Font("Segoe Print", Font.ITALIC, 16));
		txtInsertText.setToolTipText("");
		txtInsertText.setForeground(Color.WHITE);
		txtInsertText.setBackground(Color.DARK_GRAY);
		txtInsertText.setBounds(10, 383, 370, 104);
		frmVermellion.getContentPane().add(txtInsertText);
		txtInsertText.setColumns(10);
		Start.tf = txtInsertText;
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(25, 25, 112));
		textArea.setEditable(false);
		textArea.setBackground(Color.GRAY);
		textArea.setFont(new Font("Segoe Print", Font.ITALIC, 25));
		textArea.setBounds(384, 11, 460, 42);
		Start.TileTitle = textArea;
		frmVermellion.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setBackground(Color.GRAY);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Segoe Print", Font.ITALIC, 15));
		textArea_1.setBounds(10, 498, 370, 45);
		Start.Stats = textArea_1;
		frmVermellion.getContentPane().add(textArea_1);
		frmVermellion.setResizable(false);
		Start.frame = frmVermellion;
	}
}
