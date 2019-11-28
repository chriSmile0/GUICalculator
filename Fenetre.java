
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;


public class Fenetre extends JFrame {
	String[] tab_strButtons = {"1","2","3","4","5","6","7","8","9","0",".","=","C","+","-","*","/"};
	JButton[] tabBoutons = new JButton[tab_strButtons.length];
	private JPanel Calto = new JPanel();
	private JLabel Ecran = new JLabel();
	private Dimension dim1 = new Dimension(110,89);
	private Dimension dim2 = new Dimension(100,70);
	//private double chiffre;
	//private boolean clicOp = false;
	//private boolean update = false;
	//private String op = "";

	public Fenetre(){
		
		this.setTitle("Une premiere Calto");
		this.setSize(480,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		creationElements();
		
		this.setContentPane(Calto);

		this.setVisible(true);
	}

	private void creationElements(){
		Ecran = new JLabel("");
		Ecran.setHorizontalAlignment(JLabel.RIGHT);
		Ecran.setPreferredSize(new Dimension(500,40));
		JPanel op = new JPanel();
		op.setPreferredSize(new Dimension(110,480));
		JPanel chiffre = new JPanel();
		chiffre.setPreferredSize(new Dimension(350,480));
		JPanel panelEcran = new JPanel();
		panelEcran.setPreferredSize(new Dimension(480,60));

		for(int i=0;i<tab_strButtons.length;i++){
			tabBoutons[i]= new JButton(tab_strButtons[i]);
			tabBoutons[i].setPreferredSize(dim1);

			switch(i){
				case 11 : 
					chiffre.add(tabBoutons[i]);
					break;
				case 12 :
					tabBoutons[i].setPreferredSize(dim2);
					op.add(tabBoutons[i]);
					break;
				case 13 :
					tabBoutons[i].setPreferredSize(dim2); 
					op.add(tabBoutons[i]);
					break;
				case 14 : 
					tabBoutons[i].setPreferredSize(dim2);
					op.add(tabBoutons[i]);
					break;
				case 15 : 
					tabBoutons[i].setPreferredSize(dim2);
					op.add(tabBoutons[i]);
					break;
				case 16 : 
					tabBoutons[i].setPreferredSize(dim2);
					op.add(tabBoutons[i]);
					break;
				default :
					chiffre.add(tabBoutons[i]);
					break;
			}
		}
	panelEcran.add(Ecran);
	panelEcran.setBorder(BorderFactory.createLineBorder(Color.black));
	Calto.add(panelEcran,BorderLayout.NORTH);
	Calto.add(chiffre,BorderLayout.CENTER);
	Calto.add(op,BorderLayout.EAST);
	}

}

