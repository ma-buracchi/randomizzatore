import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.List;

public class Gui extends JFrame {

	private static final long serialVersionUID = -1049958103353244632L;

	private JLabel label;
	private JButton button;
	private JTextField textField;
	private JLabel res;
	private Event evento;
	private String path;
	private Randomizer randomizer;

	public Gui() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		evento = new Event();

		label = new JLabel("Percorso File (slash /)", SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 0, 10);
		gbc.anchor = GridBagConstraints.CENTER;
		add(label, gbc);

		textField = new JTextField(50);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		textField.setDropTarget(new DropTarget() {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public synchronized void drop(DropTargetDropEvent evt) {
	            try {
	                evt.acceptDrop(DnDConstants.ACTION_COPY);
	                @SuppressWarnings("unchecked")
					List<File> droppedFiles = (List<File>) evt
	                        .getTransferable().getTransferData(
	                                DataFlavor.javaFileListFlavor);
	                for (File file : droppedFiles) {
	                    /*
	                     * NOTE:
	                     *  When I change this to a println,
	                     *  it prints the correct path
	                     */
	                    textField.setText(file.getAbsolutePath());
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    });
		add(textField, gbc);

		button = new JButton("Estrai riga casuale");
		button.addActionListener(evento);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		add(button, gbc);

		res = new JLabel("", SwingConstants.CENTER);
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(res,gbc);
	}

	public class Event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			path = textField.getText();
			randomizer = new Randomizer(path);
			res.setText(randomizer.randomize());
		}
	}

}
