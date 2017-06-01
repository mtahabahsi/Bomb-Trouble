
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class baba extends JFrame implements KeyListener, ActionListener {
	ArrayList<ates> atesler = new ArrayList<ates>();
	ArrayList<ball> toplar = new ArrayList<ball>();
	int x = 344 - (23 / 2);
	int y = 328;
	Timer timer;
	Image silah, ok, ekran, topý, gameover, win,level;
	boolean temp = true;
	int count = 0, countball = 0;
	JPanel panel;
	JFrame go, w;

	public baba() {
		ekran = new ImageIcon(getClass().getResource("level10.jpg")).getImage();
		ok = new ImageIcon(getClass().getResource("okc.png")).getImage();
		silah = new ImageIcon(getClass().getResource("domuzcuk.png")).getImage();
		topý = new ImageIcon(getClass().getResource("ball4.png")).getImage();
		gameover = new ImageIcon(getClass().getResource("GAME-OVER-2.png")).getImage();
		level = new ImageIcon(getClass().getResource("Level1.png")).getImage();
		win = new ImageIcon(getClass().getResource("win.png")).getImage();
		timer = new Timer(15, this);
		timer.start();
		setBounds(350, 200, 688, 368);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		setVisible(true);
		setResizable(false);

		go = new JFrame();
		ImageIcon arkaplan = new ImageIcon(gameover);
		JLabel goý = new JLabel(arkaplan);
		goý.setBounds(0, 0, 640, 360);
		go.setBounds(350, 200, 640, 360);
		go.setLayout(null);
		go.setDefaultCloseOperation(EXIT_ON_CLOSE);
		go.setVisible(false);
		go.setResizable(false);
		go.add(goý);

		w = new JFrame();
		ImageIcon arkaplan1 = new ImageIcon(win);
		JLabel wý = new JLabel(arkaplan1);
		wý.setBounds(0, 0, 640, 360);
		w.setBounds(0, 0, 640, 360);
		w.setBounds(350, 200, 640, 360);
		w.setLayout(null);
		w.setDefaultCloseOperation(EXIT_ON_CLOSE);
		w.setVisible(false);
		w.setResizable(false);
		w.add(wý);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(ekran, 0, 0, null);
		for (int i = 0; i < atesler.size(); i++) {
			g.drawImage(ok, atesler.get(i).getX(), atesler.get(i).getY(), 4, 368, null);
		}
		for (int i = 0; i < toplar.size(); i++) {
			g.drawImage(topý, toplar.get(i).getBx(), toplar.get(i).getBy(), toplar.get(i).getBw(),
					toplar.get(i).getBh(), null);
		}
		g.drawImage(silah, x, y, 23, 37, null);

		for (int j = 0; j < toplar.size(); j++) {
			Rectangle topp = new Rectangle(toplar.get(j).getBx(), toplar.get(j).getBy(), toplar.get(j).getBw(),
					toplar.get(j).getBh());
			for (int i = 0; i < atesler.size(); i++) {
				Rectangle ok = new Rectangle(atesler.get(i).getX(), atesler.get(i).getY(), 4, 368);
				if (topp.intersects(ok)) {
					if (toplar.get(j).getBh() < 10) {
						toplar.remove(j);
						atesler.remove(i);
						temp = true;
					} else {
						ball w = new ball(toplar.get(j).getBx(), toplar.get(j).getBy(), toplar.get(j).getBw() / 2,
								toplar.get(j).getBh() / 2, toplar.get(j).getVx(),-10);
						ball q = new ball(toplar.get(j).getBx(), toplar.get(j).getBy(), toplar.get(j).getBw() / 2,
								toplar.get(j).getBh() / 2, -toplar.get(j).getVx(),-10);

						toplar.remove(j);
						atesler.remove(i);
						toplar.add(w);
						toplar.add(q);
						temp = true;
						break;
					}
					if (toplar.size() == 0) {
						ball m = new ball(350,55,60,60,1,-5);
						ball t = new ball(450,55,60,60,-1,-5);
						toplar.add(m);
						toplar.add(t);
						countball=0;
						/*w.setVisible(true);
						dispose();*/
					}
				}
			}
		Rectangle oyuncu = new Rectangle(x, y, 23, 37);
			if (topp.intersects(oyuncu)) {
				countball=1;
				go.setVisible(true);
				dispose();
			}
		}
		if(countball==0)
		g.drawImage(level,250,140,null );
		try {
			Thread.sleep(30);
		} catch (InterruptedException ex) {
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			count = 1;
			silah = new ImageIcon(getClass().getResource("rdomuz.png")).getImage();
			countball = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			count = 2;
			silah = new ImageIcon(getClass().getResource("ldomuz.png")).getImage();
			countball = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && temp) {
			ates a = new ates(x + 11, y);
			atesler.add(a);
			countball = 1;

		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			silah = new ImageIcon(getClass().getResource("domuzcuk.png")).getImage();
			count = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			silah = new ImageIcon(getClass().getResource("domuzcuk.png")).getImage();
			count = 0;
		}

	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < atesler.size(); i++) {
			atesler.get(i).setY(atesler.get(i).getY() - 8);
			if (atesler.get(i).getY() < 0) {
				temp = true;
				atesler.remove(i);
			} else {
				temp = false;
			}

		}
		if (count == 1 && x < 663) {
			x += 5;
		}
		if (count == 2 && x > 5) {
			x -= 5;
		}

	}

}
