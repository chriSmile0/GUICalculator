
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;


public class Fenetre extends JFrame  {
	String[] tab_strButtons = {"1","2","3","4","5","6","7","8","9","0",".","=","C","+","-","*","/","B","D","O","H"};
	JButton[] tabBoutons = new JButton[tab_strButtons.length];
	private JPanel Calto = new JPanel();
	private JLabel Ecran = new JLabel();
	private Dimension dim1 = new Dimension(110,89);
	private Dimension dim2 = new Dimension(100,70);
	//private Dimension dim3 = new Dimension(110,89);
	private boolean upd = false;
	private char mode = 'D';

	public Fenetre(){
		
		this.setTitle("Une premiere Calto");
		this.setSize(620,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creationElements();
		this.setContentPane(Calto);
		this.setVisible(true);
	}

	public int bintoDec(String bin){
        int nb = Integer.parseInt(bin,2);
        return nb;
    }

    public  String bintoHex(String bin){
        int nb = bintoDec(bin);
        return Integer.toHexString(nb);
    }

    public  String binToOct(String bin){
        int nb = bintoDec(bin);
        return decToOct(nb);
    }

    public  String dectoBin(int nb){
        String str = Integer.toBinaryString(nb);
        return str;
    }

    public  String decToOct(int dec){
        return Integer.toOctalString(dec);
    }

    public  String dectoHex(int dec){
        return Integer.toHexString(dec);
    }

    public  String OctoBin(String Oct){
        int nb = Integer.parseInt(Oct,8);
        return dectoBin(nb);
    }

    public  int OcttoDec(String oct){
        return Integer.parseInt(oct,8);
    }

    public  String OctToHex(String Oct){
        int nb = OcttoDec(Oct);
        return dectoHex(nb);
    }

    public  String hexToOct(String hex){
        int nb = hextoDec(hex);
        return decToOct(nb);
    }

    public int hextoDec(String hex){
        int nb = Integer.parseInt(hex,16);
        return nb;
    }

    public  String hexToBin(String hex){
        int nb = Integer.parseInt(hex,16);
        return dectoBin(nb);
    }

    public  String intoBinary(String ch){
        String result="";
        int i=0;
        while(i<ch.length()){
            char c = ch.charAt(i++);
            result += Integer.toBinaryString((int)c);
        }
        return result;
    }


	private void creationElements(){
		Font police = new Font("Arial", Font.BOLD,20);
		Ecran.setFont(police);
		Ecran.setHorizontalAlignment(JLabel.RIGHT);
		Ecran.setPreferredSize(new Dimension(620,40));
		JPanel op = new JPanel();
		op.setPreferredSize(new Dimension(220,480));
		JPanel chiffre = new JPanel();
		chiffre.setPreferredSize(new Dimension(350,480));
		JPanel panelEcran = new JPanel();
		panelEcran.setPreferredSize(new Dimension(620,60));
		/*JPanel opBiOcDecHexa = new JPanel();
		opBiOcDecHexa.setPreferredSize(new Dimension(700,300));*/

		for(int i=0;i<tab_strButtons.length;i++){
			tabBoutons[i]= new JButton(tab_strButtons[i]);
			tabBoutons[i].setPreferredSize(dim1);

			switch(i){
				case 11 : 
					tabBoutons[i].addActionListener(new EgalListener());
					chiffre.add(tabBoutons[i]);
					break;
				case 12 :
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new ResetListener());
					op.add(tabBoutons[i]);
					break;
				case 13 :
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new PlusListener()); 
					op.add(tabBoutons[i]);
					break;
				case 14 : 
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new MoinsListener());
					op.add(tabBoutons[i]);
					break;
				case 15 : 
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new MulListener());
					op.add(tabBoutons[i]);
					break;
				case 16 : 
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new DivListener());
					op.add(tabBoutons[i]);
					break;
				case 17 : 
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new BinaireListener());
					op.add(tabBoutons[i]);
					break;
				case 18 : 
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new DecimalListener());
					op.add(tabBoutons[i]);
					break;
				case 19 : 
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new OctalListener());
					op.add(tabBoutons[i]);
					break;
				case 20 : 
					tabBoutons[i].setPreferredSize(dim2);
					tabBoutons[i].addActionListener(new HexaListener());
					op.add(tabBoutons[i]);
					break;
				default :
					tabBoutons[i].addActionListener(new ChiffreListener());
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

	class ChiffreListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			String str = ((JButton)arg0.getSource()).getText();
			Ecran.setText(Ecran.getText()+str);
		}
	}

	class EgalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		//Ici utiliser la fonction parse_on pour parser la chaine de caracteres récuperée
		String str = Ecran.getText();
		EXPR e = PARSER.parse_on(str);
		double result = e.eval();
		String resulte = String.valueOf(result);
		Ecran.setText(resulte);
		upd = true;
		}

	}

	class MoinsListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"-");
		}
	}

	class PlusListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"+");
		}
	}

	class DivListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"/");
		}
	}

	class MulListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"*");
		}
	}

	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			mode = 'D';
			Ecran.setText("");
		}
	}

	//Creer un char pour chaque mode qui a était cliquer en dernier 
	//Sois B sois D sois O sois H 

	class DecimalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		EXPR e = PARSER.parse_on(str);
		double result = e.eval();
		String resulte;
		if(mode=='B'){
			resulte = Integer.toString((int)result);
			resulte = Integer.toString(bintoDec(resulte));
		}
		else if (mode=='O'){
			resulte = Integer.toString((int)result);
			resulte = Integer.toString(OcttoDec(resulte));
	
		}
		else if (mode=='H'){
			resulte = Integer.toString((int)result);
			resulte = Integer.toString(hextoDec(resulte));
		}
		else {
			resulte = Double.toString(result);
		}
		mode = 'D';
		Ecran.setText(resulte);
		upd = true;
		}
	}

	class BinaireListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		//On reconvertit ce que l'on a reçu en base 10 pour que le parser ne sois pas perdu 
		
		EXPR e = PARSER.parse_on(str);
		double result = e.eval();
		String resulte;
		if(mode=='D'){
			//resulte = Integer.toString((int)result);
			resulte = dectoBin((int)result);
		}
		else if (mode=='O'){
			resulte = Integer.toString((int)result);
			resulte = OctoBin(resulte);
		}
		else if (mode=='H'){
			resulte = Integer.toString((int)result);
			resulte = hexToBin(resulte);
		}
		else {
			resulte = Integer.toString((int)result);
		}
		mode = 'B';
		Ecran.setText(resulte);
		upd = true;
		}
	}

	class OctalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		EXPR e = PARSER.parse_on(str);
		double result = e.eval();
		String resulte;
		if(mode=='D'){
			resulte = decToOct((int)result);
		}
		else if (mode=='B'){
			resulte = Integer.toString((int)result);
			resulte = binToOct(resulte);
		}
		else if (mode=='H'){
			resulte = Integer.toString((int)result);
			resulte = hexToOct(resulte);
		}
		else {
			 resulte = Integer.toString((int)result);
		}
		mode = 'O';
		Ecran.setText(resulte);
		upd = true;
		}
	}
	
	class HexaListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		EXPR e = PARSER.parse_on(str);
		double result = e.eval();
		String resulte;
		if(mode=='D'){
			resulte = dectoHex((int)result);
		}
		else if (mode=='O'){
			resulte = Integer.toString((int)result);
			resulte = OctToHex(resulte);
		}
		else if (mode=='B'){
			resulte = Integer.toString((int)result);
			resulte = bintoHex(resulte);
		}
		else {
			resulte = Integer.toString((int)result);
		}
		mode = 'H';
		Ecran.setText(resulte);
		upd = true;
		}
	}

	



	

}

