/**
 * Provides a test application window with a panel "DrawingArea" and some "Buttons".
 * 
 * @author Björn Gottfried
 * @version 2.0
 */

package drawingTool_00;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DrawingTool extends JFrame implements ActionListener {
	private DrawingArea drawing;
	private Buttons buttons = new Buttons();

	public DrawingTool(String title) {
		super(title);

		setLayout(new BorderLayout());

		constructButtonMenu();
		constructDrawingArea();

		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		setVisible(true);
	}

	private void constructButtonMenu() {
		buttons.addButtonsToAPanel(this);
		buttons.addActionListener(this);
	}

	private void constructDrawingArea() {
		drawing = new DrawingArea();
		add(drawing, BorderLayout.CENTER);
	}

	private void tidyUpDrawingArea() {
		drawing.removeAll();
		drawing.revalidate();
		drawing.repaint();
	}

	public static void main(String[] args) {
		new DrawingTool("Draw a house");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed");
		if (e.getSource() == buttons.getTrainButton()) {
			System.out.println("Train Button has been pushed");
			tidyUpDrawingArea();
			drawing.getScene().showTrains();

		} else if (e.getSource() == buttons.getTrainStationButton()) {
			System.out.println("Train Station button has been pushed");
			tidyUpDrawingArea();
			drawing.getScene().showTrainStation();
		} else if (e.getSource() == buttons.getSceneButton()) {
			System.out.println(" Scene button has been pushed");
			tidyUpDrawingArea();
			drawing.getScene().showScene();
		}
	}
}
