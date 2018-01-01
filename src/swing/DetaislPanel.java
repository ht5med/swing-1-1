package swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

import javafx.scene.shape.Ellipse;

public class DetaislPanel extends JPanel {
	private static final long serialVersionUID = -9030426574376174855L;
	
	private EventListenerList eventListenerList = new EventListenerList();
	
	public DetaislPanel() {
		Dimension preferredSize = this.getPreferredSize();
		preferredSize.width = 250;
		this.setPreferredSize(preferredSize);
		
		this.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameField = new JTextField(10);
		JLabel occupyLabel = new JLabel("Occupation: ");
		JTextField occupyField = new JTextField(10);
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupy = occupyField.getText();
				String text = name +": "+ occupy +"\n";
				fireDetailEvent(new DetailEvent(this, text));
			}
		});
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		// column 1
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.5;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		this.add(nameLabel, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		this.add(occupyLabel, gridBagConstraints);
		// column 2
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		this.add(nameField, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		this.add(occupyField, gridBagConstraints);
		// column 3
		gridBagConstraints.weighty = 10;
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		this.add(addButton, gridBagConstraints);
	}

	public void fireDetailEvent(DetailEvent e){
		Object[] listeners = eventListenerList.getListenerList();
		for (int i = 0; i < listeners.length; i+=2) {
			if(listeners[i] == DetailsListener.class){
				DetailsListener detailsListener = (DetailsListener)listeners[i+1];
				detailsListener.detailsEventOccurred(e);
			}
		}
	}
	public void addDetailsListener(DetailsListener detailsListener) {
		eventListenerList.add(DetailsListener.class, detailsListener);
	}
	public void removeDetailsListener(DetailsListener detailsListener) {
		eventListenerList.remove(DetailsListener.class, detailsListener);
	}
}
