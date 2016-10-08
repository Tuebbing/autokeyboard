package autokeyboard;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.Timer;

import javax.swing.*;


public class Main {

	static Robot r ;
	static Timer timer ;
	static int keynumber=0;
	
	public static void main(String[] args) {
		
		try {
			r = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		JButton start = new JButton("Start");
		JButton ende = new JButton("Ende");
		
		JLabel key = new JLabel("Taste:");
		JLabel time = new JLabel("Verzögerung (in ms):");
		
//		JTextField keytext = new JTextField();
		JTextField timetext = new JTextField("7500");
		
		ende.setEnabled(false);
		
		timetext.setPreferredSize(new Dimension(50, 20));
		
		String[] eingaben={"NUM1","NUM2","NUM3","NUM4","NUM5","NUM6", "E", "Q", "F", "G"};
		
		JComboBox<String> keys = new JComboBox<>(eingaben);
		
	
		
		start.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				timer = new Timer();
				
				String item =(String) keys.getSelectedItem();

				switch(item){
					
				case "NUM1" :{ 
					keynumber=KeyEvent.VK_NUMPAD1;
					break;
				}
				case "NUM2" :{ 
					keynumber=KeyEvent.VK_NUMPAD2;
					break;
				}
				case "NUM3" :{ 
					keynumber=KeyEvent.VK_NUMPAD3;
					break;
				}
				case "NUM4" :{ 
					keynumber=KeyEvent.VK_NUMPAD4;
					break;
				}
				case "NUM5" :{ 
					keynumber=KeyEvent.VK_NUMPAD5;
					break;
				}
				case "NUM6" :{ 
					keynumber=KeyEvent.VK_NUMPAD6;
					break;
				}
				case "E":{
					keynumber=KeyEvent.VK_E;
					break;
				}
				
				case "Q":{
					keynumber=KeyEvent.VK_Q;
					break;
				}
				
				case "F":{
					keynumber=KeyEvent.VK_F;
					break;
				}
						
				case "G":{
					keynumber=KeyEvent.VK_G;
					break;
				}
				
				case "N":{
					keynumber=KeyEvent.VK_N;
					break;
				}
				
				}
				
				timer.scheduleAtFixedRate(new TimerTask() {
					
					@Override
					public void run() {
						r.keyPress(keynumber);
						r.keyRelease(keynumber);
					}
				}, new Date(), Integer.parseInt(timetext.getText()));
				
				start.setEnabled(false);
				ende.setEnabled(true);

			}
		});
		
		ende.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				timer.cancel();
				timer.purge();
				start.setEnabled(true);
				ende.setEnabled(false);
				
			}
		});
		
		panel.add(start);
		panel.add(ende);
		panel.add(key);
		panel.add(keys);
		panel.add(time);
		panel.add(timetext);
		
		
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	}

}
