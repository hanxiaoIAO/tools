package test.test;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test5 {
	JButton b1, b2;
	JLabel jb1, jb2;
	JTextField jt1, jt2;
	JPanel jp1, jp2, jp3, jp4;

	public static void main(String[] args) {
		final JFrame frame = new JFrame("frame");
		JButton b1 = new JButton("登陆");
		JButton b2 = new JButton("清空");
		final JTextField jt1 = new JTextField(20);
		final JTextField jt2 = new JTextField(20);
		JLabel jb1 = new JLabel("用户名");
		JLabel jb2 = new JLabel("密码");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		final JPanel jp4 = new JPanel();
		jp1.add(jb1);
		jp1.add(jt1);
		jp2.add(jb2);
		jp2.add(jt2);
		jp3.add(b1);
		jp3.add(b2);
		jp4.add(jp1);
		jp4.add(jp2);
		jp4.add(jp3);
		frame.add(jp4);
		frame.pack();
		final String ss1, ss2, ss3;
		ss1 = jt1.getText();
		ss2 = jt2.getText();
		ss3 = ss1 + " " + ss2;
		frame.setVisible(true);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Scanner in = new Scanner(new File("d:/c.txt"));

					while (in.hasNextLine()) {
						String str = in.nextLine();
						if (str == ss3) {
							System.out.println("用户名合法");
						}
					}
				} catch (FileNotFoundException c) {

				}
			}
		});
	}
}