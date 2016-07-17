/*
 * @Author
 * Ashok Kumar K
 * AKLC
 * celestialcluster@gmail.com | 9742024066  
 */

package com.skit.mongosight;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.skit.mongosight.view.MainFrame;

public class MongoSight {

	public static void main(String[] args) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		Runnable ui = new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
				try {
					new MainFrame();
				} catch (Exception e) {
					System.out.println("Something went wrong");

				}
			}
		};
		SwingUtilities.invokeLater(ui);
	}

}
