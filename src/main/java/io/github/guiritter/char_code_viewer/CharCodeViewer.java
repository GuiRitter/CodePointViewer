package io.github.guiritter.char_code_viewer;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.util.stream.Collectors.joining;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import static java.lang.String.format;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CharCodeViewer {

	static {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
	}

	public static void main(String args[]) {
		var frame = new JFrame("Char Code Viewer");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		var inputArea = new JTextArea();

		var inputPane = new JScrollPane(inputArea);
		frame.getContentPane().add(inputPane, NORTH);
		
		var outputArea = new JTextArea();
		
		var outputPane = new JScrollPane(outputArea);
		frame.getContentPane().add(outputPane, CENTER);
		
		var button = new JButton("do it");
		button.addActionListener(actionEvent -> 
			// Arrays.stream(inputArea.getText().toCharArray())
			// Arrays.stream(new char[]{})
			outputArea.setText(inputArea.getText().chars().mapToObj(codePoint -> (">" + Character.toString(codePoint) + "<" + format("%x", codePoint))).collect(joining("\n")) + "")
		);
		frame.getContentPane().add(button, SOUTH);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
