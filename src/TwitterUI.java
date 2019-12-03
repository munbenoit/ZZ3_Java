import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterUI {

	private Twitter twitterInstance;
	private int i=0;
	public TwitterUI(Twitter t) {
		twitterInstance = t;
		initWindow();
	}
	
	public void initWindow() {
		JFrame  frame = new  JFrame("exemple");
	    JButton  searchBtn = new  JButton("Search Tweet");
	    JTextField searchField = new JTextField();
	    searchField.setColumns(20);
	    
	    
	    /*
	     * SEARCHBAR
	     * 
	     * */
	    JPanel searchBar = new JPanel();
	    searchBar.setLayout(new FlowLayout());
	    searchBar.add(searchField);
	    searchBar.add(searchBtn);
	    searchBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(searchField.getText().length()!=0) {
						/*
						for(Status s : Main.getTweetsbyHashtag(twitterInstance,searchField.getText())) {
							System.out.print(s.getText());
						}*/
						displayTweets(Main.getTweetsbyHashtag(twitterInstance,searchField.getText()));
					}
					
				} catch (TwitterException e1) {
					// TODO Bloc catch généré automatiquement
					e1.printStackTrace();
				}
				
			}
		});
	    
	    
	    /*
	     * MAIN WINDOW
	     * 
	     */
	    JPanel  pane = new  JPanel ();
	    pane.setLayout(new  BorderLayout ());
	    pane.add(searchBar , BorderLayout.NORTH);
	    frame.getContentPane ().add(pane , BorderLayout.CENTER );
	    frame.setSize(500, 300);
	    frame.setVisible(true);
	}
	
	public void displayTweets(List<Status> tweets) {
		JFrame  frame = new  JFrame("Tweets");
		
		JPanel resultPanel = new JPanel();
		JLabel label = new JLabel();
		
		JButton next = new JButton();
		next.setText("Next");
		
		next.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Stub de la méthode généré automatiquement
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				i++;
				
			}
		});
		
		
	    resultPanel.setLayout(new GridLayout(0,1));
	    while(i<tweets.size()) {
	    	label.setText("<html>"+tweets.get(i).getText()+"</html>");
	    	
	    }
	    resultPanel.add(label);
	    resultPanel.add(next);
	    frame.getContentPane().add(resultPanel);
	    frame.setSize(800, 200);
	    frame.setVisible(true);
	}
}
