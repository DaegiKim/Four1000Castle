
package kr.ac.inha.itlab.daegikim.Four1000Castle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreForm extends JFrame {
	
	private JPanel centerPanel;
	private JPanel southPanel;
	private JPanel northPanel;
	private JButton btLevel1;
	private JButton btLevel2;
	private JButton btLevel3;
	private JButton btLevel4;
	private JButton btLevel5;
	private JButton btClose;
	private JLabel scoreLabel;

	TreeMap<Long, String> scoreListLv1;
	TreeMap<Long, String> scoreListLv2;
	TreeMap<Long, String> scoreListLv3;
	TreeMap<Long, String> scoreListLv4;
	TreeMap<Long, String> scoreListLv5;
	
	DecimalFormat dfms = new DecimalFormat("000");
	
	DecimalFormat dfsc = new DecimalFormat("00");

	public ScoreForm(TreeMap<Long, String> scoreListLv1, TreeMap<Long, String> scoreListLv2, TreeMap<Long, String> scoreListLv3, TreeMap<Long, String> scoreListLv4, TreeMap<Long, String> scoreListLv5){
		super("SCORE");
		setSize(500, 600);
		setResizable(false);

		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm=super.getSize();
		int xpos=(int)screen.getWidth() / 2 - (int)frm.getWidth() / 2;
		int ypos=(int)screen.getHeight() / 2 - (int)frm.getHeight() / 2;
		setLocation(xpos, ypos);
		
		setLayout(new BorderLayout());

		this.scoreListLv1=scoreListLv1;
		this.scoreListLv2=scoreListLv2;
		this.scoreListLv3=scoreListLv3;
		this.scoreListLv4=scoreListLv4;
		this.scoreListLv5=scoreListLv5;

		centerPanel= new JPanel();
		southPanel = new JPanel();
		northPanel= new JPanel();
		
		centerPanel.setBackground(Color.DARK_GRAY);
		southPanel.setBackground(Color.DARK_GRAY);
		northPanel.setBackground(Color.DARK_GRAY);
		
		southPanel.setLayout(new BorderLayout());
		northPanel.setLayout(new FlowLayout());
		
		btLevel1 = new JButton("Level1");
		btLevel2 = new JButton("Level2");
		btLevel3 = new JButton("Level3");
		btLevel4 = new JButton("Level4");
		btLevel5 = new JButton("Level5");
		btClose = new JButton("CLOSE");
		
		btLevel1.addActionListener(new Level1BtHandler());
		btLevel2.addActionListener(new Level2BtHandler());
		btLevel3.addActionListener(new Level3BtHandler());
		btLevel4.addActionListener(new Level4BtHandler());
		btLevel5.addActionListener(new Level5BtHandler());
		btClose.addActionListener(new CloseBtHandler());
		
		
		btLevel1.setBackground(Color.ORANGE);
		btLevel2.setBackground(Color.ORANGE);
		btLevel3.setBackground(Color.ORANGE);
		btLevel4.setBackground(Color.ORANGE);
		btLevel5.setBackground(Color.ORANGE);
		btClose.setBackground(Color.ORANGE);
		
		northPanel.add(btLevel1);
		northPanel.add(btLevel2);
		northPanel.add(btLevel3);
		northPanel.add(btLevel4);
		northPanel.add(btLevel5);
		
		southPanel.add(btClose,BorderLayout.CENTER);
		
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		add(northPanel,BorderLayout.NORTH);
		
		
		this.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent e) {
				   dispose();
				   MainForm.isScoreFramePopUp=false;
			   }	  
		});
		viewScore(1, scoreListLv1);
	}
	
	public void updateForm(){
		viewScore(1, scoreListLv1);
	}

	public TreeMap<Long, String> getScoreListLv1() {
		return scoreListLv1;
	}

	public void setScoreListLv1(TreeMap<Long, String> scoreListLv1) {
		this.scoreListLv1 = scoreListLv1;
	}

	public TreeMap<Long, String> getScoreListLv2() {
		return scoreListLv2;
	}

	public void setScoreListLv2(TreeMap<Long, String> scoreListLv2) {
		this.scoreListLv2 = scoreListLv2;
	}

	public TreeMap<Long, String> getScoreListLv3() {
		return scoreListLv3;
	}

	public void setScoreListLv3(TreeMap<Long, String> scoreListLv3) {
		this.scoreListLv3 = scoreListLv3;
	}

	public TreeMap<Long, String> getScoreListLv4() {
		return scoreListLv4;
	}

	public void setScoreListLv4(TreeMap<Long, String> scoreListLv4) {
		this.scoreListLv4 = scoreListLv4;
	}

	public TreeMap<Long, String> getScoreListLv5() {
		return scoreListLv5;
	}

	public void setScoreListLv5(TreeMap<Long, String> scoreListLv5) {
		this.scoreListLv5 = scoreListLv5;
	}

	public void viewScore(int Level, TreeMap<Long, String> scoreList){
		centerPanel.removeAll();
		java.util.Iterator<Long> it = scoreList.keySet().iterator();
		scoreLabel = new JLabel("********** LEVEL "+Level+" **********");
		scoreLabel.setFont(new Font("Consolas",1,18));
		scoreLabel.setForeground(Color.ORANGE);
		centerPanel.add(scoreLabel);
		int i=0;
		if(!it.hasNext()){
			scoreLabel = new JLabel("********No record********");
			scoreLabel.setFont(new Font("Consolas",1,20));
			scoreLabel.setForeground(Color.ORANGE);
			centerPanel.add(scoreLabel);
		}
		while(it.hasNext()){
			scoreLabel = new JLabel();
			long key = it.next();
			String time = key/60000+":"+dfsc.format((key%60000)/1000)+"."+dfms.format(key%1000);
			scoreLabel.setText(++i+". Name: "+scoreList.get(key)+" ClearTime: "+time);
			scoreLabel.setFont(new Font("Consolas",1,20));
			scoreLabel.setForeground(Color.ORANGE);
			centerPanel.add(scoreLabel);
		}
		centerPanel.updateUI();
	}
	
	//�̺�Ʈ �ڵ鷯
	private class Level1BtHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			viewScore(1, scoreListLv1);
		} 
	} 
	
	private class Level2BtHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			viewScore(2, scoreListLv2);
		}
	} 
	
	private class Level3BtHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			viewScore(3, scoreListLv3);
		} 
	} 
	
	private class Level4BtHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			viewScore(4, scoreListLv4);
		} 
	} 
	
	private class Level5BtHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			viewScore(5, scoreListLv5);
		} 
	} 
	
	private class CloseBtHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			dispose();
			MainForm.isScoreFramePopUp=false;
		} 
	}
}
