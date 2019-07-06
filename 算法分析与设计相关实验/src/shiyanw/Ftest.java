package shiyanw;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ftest extends JFrame{
	private static final long serialVersionUID = 1l;
	private JPanel jContentPane = null;
	private JTextArea jTextArea= null;
	private JPanel controlPanel = null;
	private JButton openButton = null;
	private JButton closeButton = null;
	
	private JButton getOpenButton(){
		if(openButton == null){
			openButton = new JButton();
			openButton.setText("写入文件夹");
			openButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					File file = new File("word.txt");
					try{
						FileWriter out = new FileWriter(file);
						String s = jTextArea.getText();
						out.write(s);
						out.close();
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
			});
		}
		return openButton;
	}
	
	private JButton getCloseButton(){
		if(closeButton == null){
			closeButton = new JButton();
			closeButton.setText("读取文件");
			closeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					File file = new File("word.txt");
					try{
						FileReader in = new FileReader(file);
						char byt[] = new char[1024];
						int len = in.read(byt);
						jTextArea.setText(new String(byt,0,len));
						in.close();
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
			});
		}
		return closeButton;
	}
	
	public Ftest(){
		super();
		initialize();
	}
	
	private void initialize(){
		this.setSize(300,200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}
	
	private JPanel getJContentPane(){
		if(jContentPane == null){
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTextArea(),BorderLayout.CENTER);
			jContentPane.add(getControlPanel(),BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	private JPanel getControlPanel(){
		// TODO Auto-generated method stub
		if(controlPanel == null){
			controlPanel = new JPanel(new GridLayout(1,2,10,10));
			controlPanel.add(getOpenButton());
			controlPanel.add(getCloseButton());
		}
		return controlPanel;
	}

	private JTextArea getJTextArea() {
		// TODO Auto-generated method stub
		if(jTextArea == null){
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}

	public static void main(String[] args){
		Ftest thisClass = new Ftest();
		thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisClass.setVisible(true);
	}

}
