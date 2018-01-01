package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {
	
	
	public MyFrame(String title) {
		super(title);
		this.setLayout(new BorderLayout());
		JTextArea jTextArea = new JTextArea();
		DetaislPanel detaislPanel = new DetaislPanel();
		detaislPanel.addDetailsListener(new DetailsListener(){
			public void detailsEventOccurred(DetailEvent e){
				String text = e.getText();
				jTextArea.append(text);
			}
		});
		
		Container container = this.getContentPane();
		container.add(jTextArea, BorderLayout.CENTER);
		container.add(detaislPanel, BorderLayout.WEST);
	}
}
