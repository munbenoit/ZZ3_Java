import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		i=0;
		JPanel resultPanel = new JPanel();
		JPanel actionPanel = new JPanel();
		JLabel label = new JLabel();
		JLabel username = new JLabel();
		if(tweets.size()>0) {
			label.setText("<html>"+tweets.get(i%tweets.size()).getText()+"</html>");
			username.setText("<html>"+tweets.get(i%tweets.size()).getUser().getName()+"</html>");
			username.setIcon(new ImageIcon(tweets.get(i%tweets.size()).getUser().get400x400ProfileImageURLHttps()));
		}else {
			label.setText("<html>Pas de tweets trouvés pour ce #, veuillez essayer avec un autre.</html>");
		}
		JButton next = new JButton();
		JButton prev = new JButton();
		next.setText("Next");
		prev.setText("Prev");
		next.setPreferredSize(new Dimension(100, 40));
		prev.setPreferredSize(new Dimension(100, 40));
		
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
				if(i>=tweets.size()) {
					i=0;
				}
				if(tweets.size()>0) {
					label.setText("<html>"+tweets.get(i).getText()+"</html>");
					username.setText("<html>"+tweets.get(i).getUser().getName()+"</html>");
					username.setIcon(new ImageIcon(tweets.get(i).getUser().get400x400ProfileImageURLHttps()));
				}
				
				
			}
		});
		prev.addMouseListener(new MouseListener() {
			
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
				i--;
				if(i<0) {
					i=tweets.size()-1;
				}
				if(tweets.size()>0) {
					label.setText("<html>"+tweets.get(i).getText()+"</html>");
					username.setText("<html>"+tweets.get(i).getUser().getName()+"</html>");
					username.setIcon(new ImageIcon(tweets.get(i).getUser().get400x400ProfileImageURLHttps()));
				}
				
			}
		});
		
		actionPanel.setLayout(new FlowLayout());
		actionPanel.add(prev);
		actionPanel.add(next);
	    resultPanel.setLayout(new GridLayout(0,1));
	    resultPanel.add(username);
	    resultPanel.add(label);
	    resultPanel.add(actionPanel);
	    frame.getContentPane().add(resultPanel);
	    frame.setSize(500, 400);
	    frame.setVisible(true);
	}
}
