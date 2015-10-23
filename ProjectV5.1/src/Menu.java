import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import element.IFabrique;

public class Menu implements Runnable {

	private IFabrique f;

	public Menu(IFabrique f) {
		this.f = f;
		new Thread(this).start();
	}

	public void run() {
		final JFrame frame = new JFrame("Simulation");
		JPanel panel = new JPanel();
		final JComboBox combo = new JComboBox(this.f.getTypes());
		panel.add(combo);
		panel.setBackground(Color.gray);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		frame.setVisible(true);
		combo.addItemListener(new ItemListener() {
			
			@SuppressWarnings("deprecation")
			public void itemStateChanged(ItemEvent ie) {
				String str = (String) combo.getSelectedItem();
				setNomRegle(str);
				new Simulation(f);
				frame.hide();
				
			}
		});

	}

	public void setNomRegle(String nomRegle) {
		Simulation.setNomRegle(nomRegle);
	}
}
