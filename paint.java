import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JSlider.*;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.geom.*;
import javax.swing.JComponent;
import java.awt.Color;
import javax.sound.sampled.*;
import java.net.URL;

public class paint extends JFrame implements ActionListener,MouseMotionListener,MouseListener,ChangeListener
{
	BufferedImage img;
	save saveobj;
	open openobj;
	help helpobj;
	JMenuItem on;
	JMenuItem sm;
	JMenuItem hp;
	String msg="";
	String bu="";
	int x,y,x1,y1,tx1,ty1,x4,y4,y5,x5;
	JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34,b35,b36,b37,b38,b39,b40,b41,b42,b43,b44;
	JButton b45,b46,b47,b48,b49,b50,b51,b52;
	JPanel p1,p2,p4;
	 JSlider s1;
	JLabel l;
	JFrame f=new JFrame("paint");
	JPanel p3;
	con c1;
	con c=new con();
	Color colo;
	JLabel l1;
	int x2,y2,x3,y3,stroke;
	float[] dash1 = { 2f, 0f, 2f };
	float[] dash2 = { 1f, 1f, 1f };
	float[] dash3 = { 4f, 0f, 2f };
	float[] dash4 = { 4f, 4f, 1f };

        paint()
        {
		super("Paint");

		
		img=new BufferedImage(1130,520,BufferedImage.TYPE_INT_RGB);
		setimg();
		openobj=new open(this);
		saveobj=new save(this);
		helpobj=new help(this);
		colo=Color.black;
		c=new con();
		setLayout(null);
		stroke=1;
		this.setBackground(Color.black);

	                  ImageIcon i1=new ImageIcon("pencil.png");
		b1=new JButton(i1);
		b1.setActionCommand("pencil");
		b1.addActionListener(this);

		ImageIcon i2=new ImageIcon("brush.png");
		b2=new JButton(i2);
 		b2.setActionCommand("brush");
		b2.addActionListener(this);

		ImageIcon i3=new ImageIcon("eraser.jpg");
		b3=new JButton(i3);
		b3.setActionCommand("eraser");
		b3.addActionListener(this);

		ImageIcon i4=new ImageIcon("bucket.jpg");
		b4=new JButton(i4);
		b4.setActionCommand("bucket");
		b4.addActionListener(this);

		ImageIcon i5=new ImageIcon("arc.gif");
		b5=new JButton(i5);
		b5.setActionCommand("arc");
		b5.addActionListener(this);

		ImageIcon i6=new ImageIcon("polygon.gif");
		b6=new JButton(i6);
		b6.setActionCommand("polygon");
		b6.addActionListener(this);

		ImageIcon i7=new ImageIcon("rectangle.png");
		b7=new JButton(i7);
		b7.setActionCommand("rectangle");
		b7.addActionListener(this);

		ImageIcon i8=new ImageIcon("oval.png");
		b8=new JButton(i8);
		b8.addActionListener(this);
		b8.setActionCommand("oval");

		ImageIcon i9=new ImageIcon("rrect.png");
		b9=new JButton(i9);
		b9.setActionCommand("rrectangle");
		b9.addActionListener(this);

		ImageIcon i10=new ImageIcon("line.jpg");
		b10=new JButton(i10);
		b10.setActionCommand("line");
		b10.addActionListener(this);

		ImageIcon i11=new ImageIcon("filloval.jpg");
		b45=new JButton(i11);
		b45.setActionCommand("filloval");
		b45.addActionListener(this);

		ImageIcon i12=new ImageIcon("fillrectangle.png");
		b46=new JButton(i12 );
		b46.setActionCommand("fillrectangle");
		b46.addActionListener(this);

		ImageIcon i13=new ImageIcon("dragoval.png");
		b47=new JButton(i13);
		b47.setActionCommand("oval1");
		b47.addActionListener(this);

		ImageIcon i14=new ImageIcon("dragrectangle.png");
		b48=new JButton(i14);
		b48.setActionCommand("rect1");
		b48.addActionListener(this);

		ImageIcon i15=new ImageIcon("line1.png");
		b49=new JButton(i15);
		b49.setActionCommand("line1");
		b49.addActionListener(this);

		ImageIcon i16=new ImageIcon("line2.png");
		b50=new JButton(i16);
		b50.setActionCommand("line2");
		b50.addActionListener(this);

		b51=new JButton();
		b51.setActionCommand("lin3");
		b51.addActionListener(this);

		b52=new JButton();
		b52.setActionCommand("line4");
		b52.addActionListener(this);


		p2=new JPanel();
		p2.setBounds(5,5,180,480);
		p2.setBorder(BorderFactory.createLineBorder(Color.black,2));
		add(p2);

		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
                                    p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
		p2.add(b45);
		p2.add(b46);
                                    p2.add(b47);
		p2.add(b48);
		p2.add(b49);
		p2.add(b50);
                                    p2.add(b51);
		p2.add(b52);


		p2.setLayout(new GridLayout(6,18,3,3));



		s1=new JSlider(1,15);
		s1.addChangeListener(this);
		s1.setBounds(10,500,170,40);
		s1.setBorder(BorderFactory.createLineBorder(Color.black,2));
		add(s1);

		b11=new JButton();
		b11.setBackground(Color.red);
		b11.addActionListener(this);
		b11.setActionCommand("red");
		b12=new JButton();
		b12.setBackground(Color.blue);
		b12.addActionListener(this);
		b12.setActionCommand("blue");
		b13=new JButton();
		b13.setBackground(Color.black);
		b13.addActionListener(this);
		b13.setActionCommand("black");
		b14=new JButton();
		b14.setBackground(Color.orange);
		b14.addActionListener(this);
		b14.setActionCommand("orange");
		b15=new JButton();
		b15.setBackground(Color.pink);
		b15.addActionListener(this);
		b15.setActionCommand("pink");
		b16=new JButton();
		b16.setBackground(Color.white);
		b16.addActionListener(this);
		b16.setActionCommand("white");
		b17=new JButton();
		b17.setBackground(Color.green);
		b17.addActionListener(this);
		b17.setActionCommand("green");
		b18=new JButton();
		b18.setBackground(Color.yellow);
		b18.addActionListener(this);
		b18.setActionCommand("yellow");
		b19=new JButton();
		b19.setBackground(Color.magenta);
		b19.addActionListener(this);
		b19.setActionCommand("magenta");
		b20=new JButton();
		b20.setBackground(Color.cyan);
		b20.addActionListener(this);
		b20.setActionCommand("cyan");
		b21=new JButton();
		b21.setBackground(Color.darkGray);
		b21.addActionListener(this);
		b21.setActionCommand("darkGray");
		b22=new JButton();
		b22.setBackground(Color.lightGray);
		b22.addActionListener(this);
		b22.setActionCommand("lightGray");
		b23=new JButton();
		b23.setBackground(new java.awt.Color(180, 200, 100));
		b23.addActionListener(this);
		b23.setActionCommand("13");
		b24=new JButton();
		b24.setBackground(new java.awt.Color(140, 180, 250));
		b24.addActionListener(this);
		b24.setActionCommand("14");
		b25=new JButton();
		b25.setBackground(new java.awt.Color(200, 50, 50));
		b25.addActionListener(this);
		b25.setActionCommand("15");
		b26=new JButton();
		b26.setBackground(new java.awt.Color(20, 100, 200));
		b26.addActionListener(this);
		b26.setActionCommand("16");
		b27=new JButton();
		b27.setBackground(new java.awt.Color(40, 50, 150));
		b27.addActionListener(this);
		b27.setActionCommand("17");
		b28=new JButton();
		b28.setBackground(new java.awt.Color(160, 90, 210));
		b28.addActionListener(this);
		b28.setActionCommand("18");
		b29=new JButton();
		b29.setBackground(new java.awt.Color(140, 100, 20));
		b29.addActionListener(this);
		b29.setActionCommand("19");
		b30=new JButton();
		b30.setBackground(new java.awt.Color(140, 18, 50));
		b30.addActionListener(this);
		b30.setActionCommand("20");
		b31=new JButton();
		b31.setBackground(new java.awt.Color(200, 100, 100));
		b31.addActionListener(this);
		b31.setActionCommand("21");
		b32=new JButton();
		b32.setBackground(new java.awt.Color(180, 200, 250));
		b32.addActionListener(this);
		b32.setActionCommand("22");
		b33=new JButton();
		b33.setBackground(new java.awt.Color(120,10,20));
		b33.addActionListener(this);
		b33.setActionCommand("23");
		b34=new JButton();
		b34.setBackground(new java.awt.Color(100, 150, 245));
		b34.addActionListener(this);
		b34.setActionCommand("24");
		b35=new JButton();
		b35.setBackground(new java.awt.Color(120, 180, 220));
		b35.addActionListener(this);
		b35.setActionCommand("25");
		b36=new JButton();
		b36.setBackground(new java.awt.Color(80, 10, 70));
		b36.addActionListener(this);
		b36.setActionCommand("26");
		b37=new JButton();
		b37.setBackground(new java.awt.Color(60,100,150));
		b37.addActionListener(this);
		b37.setActionCommand("27");
		b38=new JButton();
		b38.setBackground(new java.awt.Color(60,185,195));
		b38.addActionListener(this);
		b38.setActionCommand("28");
		b39=new JButton();
		b39.setBackground(new java.awt.Color(40,55,55));
		b39.addActionListener(this);
		b39.setActionCommand("29");
		b40=new JButton();
		b40.setBackground(new java.awt.Color(160, 170, 180));
		b40.addActionListener(this);
		b40.setActionCommand("30");
		b41=new JButton();
		b41.setBackground(new java.awt.Color(180, 100, 250));
		b41.addActionListener(this);
		b41.setActionCommand("31");
		b42=new JButton();
		b42.setBackground(new java.awt.Color(80,150,250));
		b42.addActionListener(this);
		b42.setActionCommand("32");
		b43=new JButton();
		b43.setBackground(new java.awt.Color(80,155,215));
		b43.addActionListener(this);
		b43.setActionCommand("33");
		b44=new JButton();
		b44.setBackground(new java.awt.Color(20,50,100));
		b44.addActionListener(this);
		b44.setActionCommand("34");
		p1=new JPanel();
		add(p1);
		p1.setBounds(5,550,185,150);
		p1.setBorder(BorderFactory.createLineBorder(Color.black,2));
		p1.setBackground(Color.black);

		p4=new JPanel();
		add(p4);
		p4.setBounds(210,550,1150,150);
		p4.setBorder(BorderFactory.createLineBorder(Color.black,2));


		p4.add(b11);
 		p4.add(b12);
		p4.add(b13);
		p4.add(b14);
		p4.add(b15);
		p4.add(b16);
		p4.add(b17);
		p4.add(b18);
		p4.add(b19);
		p4.add(b20);
		p4.add(b21);
		p4.add(b22);
		p4.add(b23);
		p4.add(b24);
		p4.add(b25);
		p4.add(b26);
		p4.add(b27);
		p4.add(b28);
		p4.add(b29);
		p4.add(b30);
		p4.add(b31);
		p4.add(b32);
		p4.add(b33);
		p4.add(b34);
		p4.add(b35);
		p4.add(b36);
		p4.add(b37);
		p4.add(b38);
		p4.add(b39);
		p4.add(b40);
		p4.add(b41);
		p4.add(b42);
		p4.add(b43);
		p4.add(b44);



		p4.setLayout(new GridLayout(2,34,5,5));


		b1.setPreferredSize(new Dimension(80, 80));
		b2.setPreferredSize(new Dimension(80, 80));
		b3.setPreferredSize(new Dimension(80, 80));
		b4.setPreferredSize(new Dimension(80, 80));
		b5.setPreferredSize(new Dimension(80,80));
		b6.setPreferredSize(new Dimension(80, 80));
		b7.setPreferredSize(new Dimension(80, 80));
		b8.setPreferredSize(new Dimension(80,80));
		b9.setPreferredSize(new Dimension(80, 80));
		b10.setPreferredSize(new Dimension(80,80));
		b11.setPreferredSize(new Dimension(80, 80));
		b12.setPreferredSize(new Dimension(80, 80));
		b13.setPreferredSize(new Dimension(80, 80));
		b14.setPreferredSize(new Dimension(80, 80));
		b15.setPreferredSize(new Dimension(80,80));
		b16.setPreferredSize(new Dimension(80, 80));
		b17.setPreferredSize(new Dimension(80, 80));
		b18.setPreferredSize(new Dimension(80, 80));
		b19.setPreferredSize(new Dimension(80, 80));
		b20.setPreferredSize(new Dimension(80,80));

		JMenuBar mb=new JMenuBar();
		setJMenuBar(mb);

		JMenu fm=new JMenu("File");
		JMenu em=new JMenu("Edit");
		JMenu vm=new JMenu("view");
 		JMenu om=new JMenu("options");
		JMenu hm=new JMenu("help");

		JMenuItem nm=new JMenuItem("New");
		nm.setActionCommand("New");
		nm.addActionListener(this);

		on=new JMenuItem("open");
		on.setActionCommand("openimg");
		on.addActionListener(this);

		sm=new JMenuItem("save");
		sm.setActionCommand("savedialog");
		sm.addActionListener(this);

		JMenuItem et=new JMenuItem("exit");
		et.setActionCommand("exiting");
		et.addActionListener(this);


		fm.addSeparator();
		fm.add(nm);
		fm.addSeparator();
		fm.add(on);
		fm.addSeparator();
		fm.add(sm);
		fm.addSeparator();
		fm.add(et);

		hp=new JMenuItem("help");
		hp.setActionCommand("helpdialog");
		hp.addActionListener(this);

		hm.addSeparator();
		hm.add(hp);

		mb.add(fm);
		mb.add(em);
		mb.add(vm);
		mb.add(om);
		mb.add(hm);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300,1300);
		 setVisible(true);
		 add(c);
		repaint();
		c.addMouseListener(this);
		c.addMouseMotionListener(this);

	}
	public static void main(String args[])
	{
		paint p=new paint();

	}

	public void actionPerformed(ActionEvent ae)
	{


		if(ae.getActionCommand().equals("openimg"));
		{
		//openobj.showopen();
		}
		if(ae.getActionCommand().equals("savedialog"))
		{
		try
			{
				URL url=this.getClass().getClassLoader().getResource("save.wav");
				AudioInputStream ais=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
		
		 saveobj.showsave();
		}
		if(ae.getActionCommand().equals("helpdialog"))
		{
		 helpobj.showhelp();
		}
		if(ae.getActionCommand().equals("exiting"))
		{
			try
			{
				URL url=this.getClass().getClassLoader().getResource("beep.wav");
				AudioInputStream ais=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
			System.exit(0);
		}
		if(ae.getActionCommand().equals("New"))
		{
			System.out.println("abc");
			c.setVisible(false);
			remove(4);
			c1=new con();
			add(c1);
			c1.addMouseListener(this);
			c1.addMouseMotionListener(this);
			c1.setBounds(190,5,1100,500);
			System.out.println("def");
		}
		//b=(JButton)ae.getSource();
		if(ae.getActionCommand().equals("red"))
		{
		p1.setBackground(Color.red);
		colo=Color.red;
		}
		if(ae.getActionCommand().equals("blue"))
		{
 		p1.setBackground(Color.blue);
		colo=Color.blue;
		}
		if(ae.getActionCommand().equals("black"))
		{
		p1.setBackground(Color.black);
		colo=Color.black;
		}
		if(ae.getActionCommand().equals("orange"))
		{
		p1.setBackground(Color.orange);
		colo=Color.orange;
		}
		if(ae.getActionCommand().equals("pink"))
		{
		p1.setBackground(Color.pink);
		colo=Color.pink;
		}
		if(ae.getActionCommand().equals("white"))
		{
		p1.setBackground(Color.white);
		colo=Color.white;
		}
		if(ae.getActionCommand().equals("green"))
		{
		p1.setBackground(Color.green);
		colo=Color.green;
		}
		if(ae.getActionCommand().equals("yellow"))
		{
		p1.setBackground(Color.yellow);
		colo=Color.yellow;
		}
		if(ae.getActionCommand().equals("magenta"))
		{
		p1.setBackground(Color.magenta);
		colo=Color.magenta;
		}
		if(ae.getActionCommand().equals("cyan"))
		{
		p1.setBackground(Color.cyan);
		colo=Color.cyan;
		}
		if(ae.getActionCommand().equals("red"))
		{
		p1.setBackground(Color.red);
		colo=Color.red;
		}
		if(ae.getActionCommand().equals("darkGray"))
		{
		p1.setBackground(Color.darkGray);
		colo=Color.darkGray;
		}
		if(ae.getActionCommand().equals("lightGray"))
		{
		p1.setBackground(Color.lightGray);
		colo=Color.lightGray;
		}
		if(ae.getActionCommand().equals("13"))
		{
		p1.setBackground(new java.awt.Color(180, 200, 100));
		colo=new java.awt.Color(180, 200, 100);
		}
		if(ae.getActionCommand().equals("14"))
		{
		p1.setBackground(new java.awt.Color(140, 180, 250));
		colo=new java.awt.Color(140, 180, 250);
		}
		if(ae.getActionCommand().equals("15"))
		{
		p1.setBackground(new java.awt.Color(200, 50, 50));
		colo=new java.awt.Color(200,50,50);
		}
		if(ae.getActionCommand().equals("16"))
		{
		p1.setBackground(new java.awt.Color(20, 100, 200));
		colo=new java.awt.Color(20, 100, 200);
		}
		if(ae.getActionCommand().equals("17"))
		{
		p1.setBackground(new java.awt.Color(40, 50, 150));
		colo=new java.awt.Color(40, 50, 150);
		}
		if(ae.getActionCommand().equals("18"))
		{
		p1.setBackground(new java.awt.Color(160, 90, 210));
		colo=new java.awt.Color(160, 90, 210);
		}
		if(ae.getActionCommand().equals("19"))
		{
		p1.setBackground(new java.awt.Color(140, 100, 20));
		colo=new java.awt.Color(140, 100, 20);
		}
		if(ae.getActionCommand().equals("20"))
		{
		p1.setBackground(new java.awt.Color(140, 18, 50));
		colo=new java.awt.Color(140, 18, 50);
		}
		if(ae.getActionCommand().equals("21"))
		{
		p1.setBackground(new java.awt.Color(200, 100, 100));
		colo=new java.awt.Color(200, 100, 100);
		}
		if(ae.getActionCommand().equals("22"))
		{
		p1.setBackground(new java.awt.Color(180, 200, 250));
		colo=new java.awt.Color(180, 200, 250);
		}
		if(ae.getActionCommand().equals("23"))
		{
		p1.setBackground(new java.awt.Color(120,10,20));
		colo=new java.awt.Color(120,10,20);
		}
		if(ae.getActionCommand().equals("24"))
		{
		p1.setBackground(new java.awt.Color(100, 150, 245));
		colo=new java.awt.Color(100, 150, 245);
		}
		if(ae.getActionCommand().equals("25"))
		{
		p1.setBackground(new java.awt.Color(120, 180, 220));
		colo=new java.awt.Color(120, 180, 220);
		}
		if(ae.getActionCommand().equals("26"))
		{
		p1.setBackground(new java.awt.Color(80, 10, 70));
		colo=new java.awt.Color(80, 10, 70);
		}
		if(ae.getActionCommand().equals("27"))
		{
		p1.setBackground(new java.awt.Color(60,100,150));
		colo=new java.awt.Color(60,100,150);
		}
		if(ae.getActionCommand().equals("28"))
		{
		b38.setBackground(new java.awt.Color(60,185,195));
		colo=new java.awt.Color(60,185,195);
		}
		if(ae.getActionCommand().equals("29"))
		{
		b29.setBackground(new java.awt.Color(40,55,55));
 		colo=new java.awt.Color(40,55,55);
		}
		if(ae.getActionCommand().equals("30"))
		{
		b30.setBackground(new java.awt.Color(160, 170, 180));
		colo=new java.awt.Color(160, 170, 180);
		}
		if(ae.getActionCommand().equals("31"))
		{
		b41.setBackground(new java.awt.Color(180, 100, 250));
		colo=new java.awt.Color(180, 100, 250);
		}
		if(ae.getActionCommand().equals("32"))
		{
		b42.setBackground(new java.awt.Color(80,150,250));
		colo=new java.awt.Color(80,150,250);
		}
		if(ae.getActionCommand().equals("33"))
		{
		b43.setBackground(new java.awt.Color(80,155,215));
		colo=new java.awt.Color(80,155,2150);
		}
		if(ae.getActionCommand().equals("34"))
		{
		b44.setBackground(new java.awt.Color(20,50,100));
		colo=new java.awt.Color(20,50,100);
		}

		if(ae.getActionCommand().equals("filloval"))
		{
		bu="filloval";
		}
		if(ae.getActionCommand().equals("fillrect"))
		{
		bu="fillrectangle";
		}

		if(ae.getActionCommand().equals("polygon"))
		{
		try
			{
				URL url=this.getClass().getClassLoader().getResource("polygon.wav");
				AudioInputStream ais=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
		
		bu="polygon";
		}
		if(ae.getActionCommand().equals("arc"))
		{
		bu="arc";
		}
		if(ae.getActionCommand().equals("eraser"))
		{
		try
			{
				URL url=this.getClass().getClassLoader().getResource("eraser.wav");
				AudioInputStream ais=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
		
		 bu="eraser";
		}
		if(ae.getActionCommand().equals("brush"))
		{
		try
			{
				URL url=this.getClass().getClassLoader().getResource("paintbrush.wav");
				AudioInputStream ais=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
		 bu="brush";
		}
		if(ae.getActionCommand().equals("pencil"))
		{
		try
			{
				URL url=this.getClass().getClassLoader().getResource("pencil.wav");
				AudioInputStream ais=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
		
		

		 bu="pencil";
		}
		if(ae.getActionCommand().equals("line"))
		{
		try
			{
				URL url=this.getClass().getClassLoader().getResource("line.wav");
				AudioInputStream ais=AudioSystem.getAudioInputStream(url);
				Clip clip=AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
		
		bu="line";
		}
		if(ae.getActionCommand().equals("oval"))
		{
		bu="oval";
		}
		if(ae.getActionCommand().equals("rectangle"))
		{
		bu="rectangle";
		}

		if(ae.getActionCommand().equals("bucket"))
		{
		bu="bucket";
		}
		if(ae.getActionCommand().equals("rrectangle"))
		{
		bu="rrectangle";
		}

		if(ae.getActionCommand().equals("filloval"))
		{
		bu="filloval";
		}
		if(ae.getActionCommand().equals("fillrectangle"))
		{
		bu="fillrectangle";
		}
		if(ae.getActionCommand().equals("oval1"))
		{
		bu="oval1";
		}
		if(ae.getActionCommand().equals("rect1"))
		{
		bu="rect1";
		}
		if(ae.getActionCommand().equals("line1"))
		{
		bu="line1";
		}
		if(ae.getActionCommand().equals("line2"))
		{
		bu="line2";
		}

	}
	public void setimg()
	{
	 Graphics2D g=(Graphics2D)img.getGraphics();
	 g.setColor(colo);
	 g.fillRect(0,0,1130,520);
	}
		class con extends Canvas
	                   {
  			con()
			{
			setSize(1400,520);
			setBounds(190,5,1100,500);
			setBackground(Color.white);
			setVisible(true);

			}
			public void paint(Graphics g)
			{
			 update(g);
			}
			public void update(Graphics g)
			{
			 g.drawImage(img,0,0,this);
			}
			public void oval()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			if(x<x1&&y<y1)
					g.drawOval(x,y,x1-x,y1-y);
				else if(x1<x&&y1<y)
					g.drawOval(x1,y1,x-x1,y-y1);
				else if(x1>x&&y1<y)
					g.drawOval(x,y1,x1-x,y-y1);
				else
					g.drawOval(x1,y,x-x1,y1-y);

			repaint();
			}

			public void line()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.drawLine(x1,y1,x,y);
			repaint();
			}
			public void Pencil()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.drawLine(x1,y1,x,y);
		 		  x1=x;
				   y1=y;
			repaint();
			}
			public void rrectangle()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			if(x<x1&&y<y1)
					g.drawRoundRect(x,y,x1-x,y1-y,20,20);
				else if(x1<x&&y1<y)
					g.drawRoundRect(x1,y1,x-x1,y-y1,20,20);
				else if(x1>x&&y1<y)
					g.drawRoundRect(x,y1,x1-x,y-y1,20,20);
				else
					g.drawRoundRect(x1,y,x-x1,y1-y,20,20);

			repaint();
			}
			public void Rectangle()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			if(x<x1&&y<y1)
					g.drawRect(x,y,x1-x,y1-y);
				else if(x1<x&&y1<y)
					g.drawRect(x1,y1,x-x1,y-y1);
				else if(x1>x&&y1<y)
					g.drawRect(x,y1,x1-x,y-y1);
				else
					g.drawRect(x1,y,x-x1,y1-y);

			repaint();
			}
			public void Arc()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.drawArc(x1,y1,x-x1,y-y1,180,180);
			x1=x-x1;
			y1=y-y1;
			repaint();
			}
			public void polygon()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.drawLine(tx1,ty1,x,y);
			tx1=x;
			ty1=y;
			repaint();
			}
			public void brush()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.fillOval(x1,y1,20,20);
			g.setColor(colo);
			x1=x;
			y1=y;
			repaint();
			}
			public void eraser()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(Color.white);
			g.fillOval(x1,y1,20,20);
			x1=x;
			y1=y;
			repaint();
			}
			public void bucket()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setColor(colo);
			g.setBackground(colo);
			g.fillRect(x1,y1,2000,2000);
			repaint();
			}
			public void filloval()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.fillOval(x1,y1,x-x1,y-y1);
			repaint();
			}
			public void fillrectangle()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.fillRect(x1,y1,x-x1,y-y1);
			repaint();
			}
			public void oval1()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.drawOval(x1,y1,x-x1,y-y1);
			repaint();
			}
			public void rect1()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			g.setColor(colo);
			g.drawRect(x1,y1,x-x1,y-y1);
			repaint();
			}
			public void line1()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			BasicStroke bs1 = new BasicStroke(stroke, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f );
			g.setStroke(bs1);
			g.setColor(colo);
			g.drawLine(x1,y1,x,y);
			repaint();
			}

			public void line2()
			{
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setStroke(new BasicStroke(stroke));
			BasicStroke bs1 = new BasicStroke(stroke, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f );
			g.setStroke(bs1);
			g.setColor(colo);
			g.drawLine(x5,y5,x4,y4);
			x5=x1;
			y5=y1;
			x4=x;
			y4=y;
			repaint();
			}


		}

		public void mousePressed(MouseEvent me)
		{
  		x1=me.getX();
  		y1=me.getY();

 		}
		 public void mouseReleased(MouseEvent me)
 		{
  		x=me.getX();
  		y=me.getY();


		if(bu.equals("rrectangle"))
		c.rrectangle();
		if(bu.equals("rectangle"))
		c.Rectangle();
		if(bu.equals("arc"))
		c.Arc();
		if(bu.equals("polygon"))
		c.polygon();
		tx1=x1;
		ty1=y1;
		if(bu.equals("bucket"))
		c.bucket();
		if(bu.equals("line1"))
		c.line1();


		if(bu.equals("line"))
		c.line();
		if(bu.equals("oval"))
		c.oval();
		if(bu.equals("filloval"))
		c.filloval();
		if(bu.equals("fillrectangle"))
		c.fillrectangle();
		if(bu.equals("line1"))
		c.line1();
		 }


 		 public void mouseEntered(MouseEvent me)
		 {}
		 public void mouseExited(MouseEvent me)
		 {}
		 public void mouseClicked(MouseEvent me)
		 {}
		 public void mouseDragged(MouseEvent me)
 		 {
		 x=me.getX();
		  y=me.getY();
  		Graphics g=getGraphics();
		if(bu.equals("line2"))
			c.line2();
		  if(bu.equals("pencil"))
 		        c.Pencil();
		   if(bu.equals("brush"))
			c.brush();
		    if(bu.equals("eraser"))
			c.eraser();
		 if(bu.equals("oval1"))
			c.oval1();
		 if(bu.equals("rect1"))
			c.rect1();

		}

		public void mouseMoved(MouseEvent me)
		{
		//("Moving mouse  at " + me.getX()  +  " , " + me.getY());

		}
		public void stateChanged(ChangeEvent ce)
		{
			stroke=s1.getValue();
		}
class save extends JDialog implements ActionListener
{
 JButton db;
 JTextField dt;
 JLabel dl;
 save(JFrame f)
 {
  super(f,"Save As",false);
  db=new JButton("save");
  dt=new JTextField(20);
  dl=new JLabel("save as : ");
  db.addActionListener(this);
  add(dl);
  add(dt);
  add(db);
  setSize(400,100);
  setLayout(new FlowLayout());
 }
 public void actionPerformed(ActionEvent ae)
 {
   try{
   //imgg.dispose();
   File file=new File(dt.getText()+".jpg");
   ImageIO.write(img,"jpg",file);}catch(Exception ee){}
  setVisible(false);
 }
 public void showsave()
 {
  dt.setText("");
  setVisible(true);
 }
}
class open extends JDialog implements ActionListener
{
 JButton dbb;
 JTextField dtt;
 JLabel dll;
 open(JFrame f)
 {
  super(f,"Open",false);
  dbb=new JButton("open");
  dtt=new JTextField(20);
  dll=new JLabel("open image : ");
  dbb.addActionListener(this);
  add(dll);
  add(dtt);
  add(dbb);
  setSize(400,100);
  setLayout(new FlowLayout());
 }
 public void actionPerformed(ActionEvent aee)
 {
  if((JButton)aee.getSource()==dbb);
  try{
  File ip=new File(dtt.getText()+".jpg");
  img=ImageIO.read(ip);}catch(Exception eee){}
  c.repaint();
  setVisible(false);
 }
 public void showopen()
 {
  dtt.setText("");
  setVisible(true);
 }
}

class help extends JDialog
{
JTextField tf;
JLabel tl1,tl2,tl3,tl4,tl5;
help(JFrame f)
{
super(f,"help",false);
tf=new JTextField("");
tl1=new JLabel();
tl2=new JLabel();
tl3=new JLabel();
tl4=new JLabel();
tl5=new JLabel();
add(tl1);
tl1.setBackground(Color.blue);
add(tl2);
add(tl5);
add(tl3);
add(tl4);
setSize(600,300);
setLayout(new FlowLayout());
}
public void showhelp()
 {
Font font =new Font("Serif",Font.ITALIC,30);
tl1.setText("special thanks to vijaya laxshmi mam");
tl1.setFont(font);
tl2.setText("special thanks to vimala manohara ruth mam");
tl2.setFont(font);
tl5.setText("special thanks to vanitha mam");
tl5.setFont(font);

  tl3.setText("special thanks to dilip srinivasa");
tl3.setFont(font);
tl4.setText("special thanks to rajesh");
tl4.setFont(font);
  setVisible(true);
 }

}





}
