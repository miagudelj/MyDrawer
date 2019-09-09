
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawArea extends JComponent {
	Draw draw;
	// image in which we are going to draw
	private Image image;
	// object --> used to draw on
	private Graphics2D g2;
	// mouse coordinates
	private int currentX, currentY, oldX, oldY;

	public DrawArea(Draw draw) {
		this.draw = draw;
		init();
	}

	private void init() {
		this.setDoubleBuffered(false);

		// add mouse listener
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// save coordinates x,y when mouse is pressed
				oldX = e.getX();
				oldY = e.getY();
			}
		});

		// add mouse motion listener
		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// coordinates x,y when drag mouse
				currentX = e.getX();
				currentY = e.getY();

				// draw line if g2 context is not null
				if (g2 != null) {
					g2.drawLine(oldX, oldY, currentX, currentY);
					// refresh draw area to repaint
					repaint();
					// stores current coordinates x,y as olds x,y
					oldX = currentX;
					oldY = currentY;
				}
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		if (image == null) {
			// image to draw null ==> we create
			image = createImage(getSize().width, getSize().height);
			g2 = (Graphics2D) image.getGraphics();
			// enable antialiasing
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			// clear draw area
			clear();
		}

		g.drawImage(image, 0, 0, null);
	}

	public void clear() {
		g2.setPaint(Color.white);
		// draw white on entire draw area to clear
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setPaint(Color.black);
		repaint();
	}

	public void color() {
		for (int i = 0; i < draw.colors.size(); i++) {
			g2.setPaint(draw.colors.get(i).getBackground());
		}
	}
}
