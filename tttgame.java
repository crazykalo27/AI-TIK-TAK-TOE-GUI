import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class tttgame extends JPanel{
	
	boolean twogame = true;
	char playermark = 'X';
	JButton[] buttons= new JButton[9];
	
	public tttgame()
	{
		setLayout(new GridLayout(3,3));
		gameselect();
		
	}
	
	public void createButtons()
	{
		for(int i = 0; i <= 8; i++)
		{
			buttons[i] = new JButton();
			buttons[i].setText("-");
			buttons[i].setBackground(Color.WHITE);
			buttons[i].addActionListener(new ActionListener() 
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							JButton buttonClicked = (JButton) e.getSource();
							buttonClicked.setText(String.valueOf(playermark));
							if(!twogame)
							{
								buttonClicked.setBackground(Color.CYAN);
								playermark = 'O';
								if(!displayResult())
								{
									cputurn();
								}
								
							}
							else if(playermark == 'X')
							{
								playermark = 'O';
								buttonClicked.setBackground(Color.CYAN);
								displayResult();
							}
							else
							{
								playermark = 'X';
								buttonClicked.setBackground(Color.ORANGE);
								displayResult();
							}
							
						}
					});
					
			add(buttons[i]);
		}
	}
	
	public boolean displayResult()
	{
		if(checkForWinner() == true) 
		{
			
			if(playermark == 'X') 
			{
				playermark = 'O';
			}
			else playermark = 'X';
			
		
			JOptionPane pane = new JOptionPane();
			int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. " + playermark +" wins. Would you like to "
					+ "play again?", "Game Over", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				resettheButtons();
			}
			else
			{
				System.exit(0);
			}
			return true;
		}
		
		else if(checkDraw())
		{
			JOptionPane pane = new JOptionPane();
			int dialogResult = JOptionPane.showConfirmDialog(pane, "Draw. Play Again?", "Game Over", 
					JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				resettheButtons();
			}
			else
			{
				System.exit(0);
			}
			return true;
		}
		return false;
	}
	
	public boolean checkForWinner()
	{
		if(checkRows() == true || checkCol() == true || checkDiag() == true)
		{
			return true;
		}
		else return false;
			
	}

	public boolean checkRows()
	{
		int i = 0;
		for(int j = 0; j < 3; j++)
		{
			if(buttons[i].getText().equals(buttons[i+1].getText()) 
					&& buttons[i].getText().equals(buttons[i+2].getText())
					&& buttons[i].getText().charAt(0) != '-')
			{
				return true;
			}
			i = i + 3;
		}
		return false;
	}
	
	public boolean checkCol()
	{
		int i = 0;
		for(int j = 0; j < 3; j++)
		{
			if(buttons[i].getText().equals(buttons[i+3].getText()) 
					&& buttons[i].getText().equals(buttons[i+6].getText())
					&& buttons[i].getText().charAt(0) != '-')
			{
				return true;
			}
			i++;
		}
		return false;
	}
	
	public boolean checkDiag()
	{
		
	
		if(buttons[0].getText().equals(buttons[4].getText()) 
				&& buttons[0].getText().equals(buttons[8].getText())
				&& buttons[0].getText().charAt(0) != '-')
		{
			return true;
		}
		else if(buttons[2].getText().equals(buttons[4].getText()) 
				&& buttons[2].getText().equals(buttons[6].getText())
				&& buttons[2].getText().charAt(0) != '-')	
		{
			return true;
		}
		else return false;
	}

	private void resettheButtons()
	{
		playermark = 'X';
		for(int i = 0; i < 9; i++)
		{
			buttons[i].setText("-");
			buttons[i].setBackground(Color.WHITE);
		}
	}

	public boolean checkDraw()
	{
		boolean full = true;
		for(int i=0; i<9; i++)
		{
			if(buttons[i].getText().charAt(0) == '-')
			{
				full = false;
			}
		}
		return full;
	}

	public void gameselect()
	{
		JOptionPane pane = new JOptionPane();
		int dialogResult = JOptionPane.showConfirmDialog(pane, "Are there Two Players?", "Game Select", 
				JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION)
		{
			createButtons();
			twogame = true;
		}
		else if(dialogResult == JOptionPane.NO_OPTION)
		{
			createButtons();
			twogame = false;
		}
		
	}

	private void cputurn() {
		Random rand = new Random();
		int choice = rand.nextInt(9);
		while(buttons[choice].getBackground() != Color.WHITE)
		{
			choice = rand.nextInt(9);
		}
			switch(choice)
			{
			case 1:
				buttons[1].setText(String.valueOf('O'));
				buttons[1].setBackground(Color.ORANGE);
				playermark = 'X';
				break;
			case 2:
				buttons[2].setText(String.valueOf('O'));
				buttons[2].setBackground(Color.ORANGE);
				playermark = 'X';
				break;
			case 3:
				buttons[3].setText(String.valueOf('O'));
				buttons[3].setBackground(Color.ORANGE);
				playermark = 'X';
				break;

			case 4:
				buttons[4].setText(String.valueOf('O'));
				buttons[4].setBackground(Color.ORANGE);
				playermark = 'X';
				break;

			case 5:
				buttons[5].setText(String.valueOf('O'));
				buttons[5].setBackground(Color.ORANGE);
				playermark = 'X';
				break;

			case 6:
				buttons[6].setText(String.valueOf('O'));
				buttons[6].setBackground(Color.ORANGE);
				playermark = 'X';
				break;

			case 7:
				buttons[7].setText(String.valueOf('O'));
				buttons[7].setBackground(Color.ORANGE);
				playermark = 'X';
				break;

			case 8:
				buttons[8].setText(String.valueOf('O'));
				buttons[8].setBackground(Color.ORANGE);
				playermark = 'X';
				break;

			case 9:
				buttons[0].setText(String.valueOf('O'));
				buttons[0].setBackground(Color.ORANGE);
				playermark = 'X';
				break;
			}
			displayResult();

			
		}
	

	public static void main(String[] args) {
		JFrame window = new JFrame("tik tak toeeeee");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new tttgame());
		window.setBounds(500, 500, 500, 500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		 
		}
		
	}


