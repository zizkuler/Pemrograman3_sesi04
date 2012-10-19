import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ButtonDemo extends JPanel implements ActionListener
{
	protected JButton b1, b2, b3;

	public ButtonDemo()
	{
		ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
		ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
		ImageIcon rightButtonIcon = createImageIcon("images/left.gif");

		b1 = new JButton ("Disable middle button", leftButtonIcon);
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEADING);
		b1.setMnemonic(KeyEvent.VK_D);
		b1.setActionCommand("disable");

		b2 = new JButton ("Middle button", middleButtonIcon);
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_M);

		b3 = new JButton ("Enable middle button", rightButtonIcon);
		b3.setMnemonic(KeyEvent.VK_E);
		b3.setActionCommand("enable");
		b3.setEnabled(false);

		b1.addActionListener(this);
		b3.addActionListener(this);

		b1.setToolTipText("Click this button to disable the middle button.");
		b2.setToolTipText("This middle button does nothing when you click it.");
		b3.setToolTipText("Click this button to enable the middle button.");

		add(b1);
		add(b2);
		add(b3);
	}

	public void actionPerformed(ActionEvent e)
	{
		if("disable".equals(e.getActionCommand()))
		{
			b2.setEnabled(false);
			b1.setEnabled(false);
			b3.setEnabled(true);
		}
		else
		{
			b2.setEnabled(true);
			b1.setEnabled(true);
			b3.setEnabled(false);
		}
	}

	protected static ImageIcon createImageIcon(String path)
	{
		java.net.URL imgURL = ButtonDemo.class.getResource(path);
		if(imgURL != null)
		{
			return new ImageIcon(imgURL);
		}
		else
		{
			System.err.println("Couldn't find file : " + path);
			return null;
		}
	}

	private static void createAndShowGUI()
	{
		JFrame frame = new JFrame("Button Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonDemo newContentPane = new ButtonDemo();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
}