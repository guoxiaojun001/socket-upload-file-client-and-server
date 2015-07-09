package com.nb.server;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ServerWindow extends Frame{

	private static final long serialVersionUID = 1L;
	private SocketServer server;
	private Label label;

	public ServerWindow(String title){
		super(title);
		server = new SocketServer(7878);
		label = new Label();
		add(label, BorderLayout.PAGE_START);
		label.setText("service start");
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				new Thread(new Runnable() {         
					@Override
					public void run() {
						try {
							server.start();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				server.quit();
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerWindow window = new ServerWindow("upload file manager"); 
		window.setSize(300, 300); 
		window.setVisible(true);
	}

}
