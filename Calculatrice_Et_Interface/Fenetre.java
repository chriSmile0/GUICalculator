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
	String[] tab_strButtons = {"1","2","3","4","5","6","7","8","9","0",".","=","C","+","-","*","/","B","D","O","H","a","b","c","d","e","f"};
	JButton[] tabBoutons = new JButton[tab_strButtons.length];
	private JPanel Calto = new JPanel();
	private JLabel Ecran = new JLabel();
	private Dimension dim1 = new Dimension(110,89);
	private Dimension dim2 = new Dimension(100,70);
	private boolean upd = false;
	private char mode = 'D';

	public Fenetre(){
		this.setTitle("Une premiere Calto");
		this.setSize(620,670);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creationElements();
		this.setContentPane(Calto);
		this.setVisible(true);
	}

	public static int bintoDec(String bin)
	{
		try {
			return Integer.parseInt(bin,2);
		}
		catch(Exception e){
			return 0;
		}
    }

	public String bintoHex(String bin)
	{
		try {
		return Integer.toHexString(bintoDec(bin));
		}
		catch(Exception e){
			return "Only Binary";
		}
    }

	public  String binToOct(String bin)
	{
		try {
			return decToOct(bintoDec(bin));
		}
		catch(Exception e){
			return "Only Binary";
		}
    }

	public String dectoBin(int nb)
	{
		try {
        String str = Integer.toBinaryString(nb);
		return str;
		}
		catch(Exception e){
			return "Only Decimal";
		}
    }

	public String decToOct(int dec)
	{
		try {
		return Integer.toOctalString(dec);
		}
		catch(Exception e){
			return "Only Decimal";
		}
    }

	public String dectoHex(int dec)
	{
		try {
		return Integer.toHexString(dec);
		}
		catch(Exception e){
			return "Only decimal";
		}
    }

	public String OctoBin(String Oct)
	{
		try {
		return dectoBin(Integer.parseInt(Oct,8));
		}
		catch(Exception e){
			return "Only Octal";
		}
    }

	public static int OcttoDec(String oct)
	{
		try {
		return Integer.parseInt(oct,8);
		}
		catch(Exception e){
			return 0;
		}
    }

	public  String OctToHex(String Oct)
	{
		try {
		return dectoHex(OcttoDec(Oct));
		}
		catch(Exception e){
			return "Only Octal";
		}
    }

	public  String hexToOct(String hex)
	{
		try {
		return decToOct(hextoDec(hex));
		}
		catch(Exception e){
			return "Only Hexa";
		}
    }

	public static int hextoDec(String hex)
	{
		try {
		return Integer.parseInt(hex,16);
		}
		catch(Exception e){
			return 0;
		}
	}

	public  String hexToBin(String hex)
	{
		try {
        int nb = Integer.parseInt(hex,16);
		return dectoBin(nb);
		}
		catch(Exception e){
			return "Only Hexa";
		}
	}
	
	private void creationElements()
	{
		Font police = new Font("Arial", Font.BOLD,30);
		Ecran.setFont(police);
		Ecran.setHorizontalAlignment(JLabel.RIGHT);
		Ecran.setPreferredSize(new Dimension(620,40));
		JPanel op = new JPanel();
		op.setPreferredSize(new Dimension(220,480));
		JPanel chiffre = new JPanel();
		chiffre.setPreferredSize(new Dimension(350,600));
		JPanel panelEcran = new JPanel();
		panelEcran.setPreferredSize(new Dimension(620,60));
		for (int i = 0;i < tab_strButtons.length;i++) {
			tabBoutons[i]= new JButton(tab_strButtons[i]);
			tabBoutons[i].setPreferredSize(dim1);

			switch (i) {
				case 11 : 
					tabBoutons[i].setForeground(Color.red);
					tabBoutons[i].setPreferredSize(dim1);
					tabBoutons[i].addActionListener(new EgalListener());
					chiffre.add(tabBoutons[i]);
					break;
				case 12 :
					tabBoutons[i].setForeground(Color.red);
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
		public void actionPerformed(ActionEvent arg0)
		{
			String str = ((JButton)arg0.getSource()).getText();
			Ecran.setText(Ecran.getText()+str);
			upd = false;
		}
	}

	class EgalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			String str = Ecran.getText();
			String chaine_a_parser = "";
			EXPR e;
			double result = 0;
			String resulte = "";
			//Dans cette partie nous allons caller nos 3 nouvelles fonctions en fonctions du mode choisi
			if (mode == 'B') {
				chaine_a_parser = BinStringToDecString(str);
				System.out.println(chaine_a_parser);
				e = PARSER.parse_on(chaine_a_parser);
				result = e.eval();
				System.out.println(result);
				resulte = dectoBin((int)result);
				System.out.println(resulte);
			}
			else if (mode == 'O') {
				chaine_a_parser = OctStringToDecString(str);
				System.out.println(chaine_a_parser);
				e = PARSER.parse_on(chaine_a_parser);
				result = e.eval();
				resulte = decToOct((int)result);
			}
			else if (mode == 'H') {
				chaine_a_parser = HexaStringToDecString(str);
				System.out.println(chaine_a_parser);
				e = PARSER.parse_on(chaine_a_parser);
				result = e.eval();
				resulte = dectoHex((int)result);	
			}
			else if (mode == 'D') {
				e = PARSER.parse_on(str);
				result = e.eval();
				resulte = String.valueOf(result);	
			}
			Ecran.setText(resulte);
			upd = true;
		}
	}

	class MoinsListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			Ecran.setText(Ecran.getText()+"-");
			upd = false;
		}
	}

	class PlusListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			Ecran.setText(Ecran.getText()+"+");
			upd = false;
		}
	}

	class DivListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			Ecran.setText(Ecran.getText()+"/");
			upd = false;
		}
	}

	class MulListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			Ecran.setText(Ecran.getText()+"*");
			upd = false;
		}
	}

	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			mode = 'D';
			Ecran.setText("");
			upd = false;
		}
	}

	class DecimalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			String str = Ecran.getText();
			String resulte = "";
			if (upd == true) {
				if (mode == 'H') 
					resulte = Double.toString(hextoDec(str));
				else if(mode == 'B')
					resulte = Double.toString(bintoDec(str));
				else if (mode == 'O')
					resulte = Double.toString(OcttoDec(str));
				else if (mode == 'D')
					resulte = str;
			}
			mode = 'D';
			System.out.println("Mode decimal activé");
			Ecran.setText(resulte);
			upd = true;
		}
	}
	

	class BinaireListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			String str = Ecran.getText();
			String resulte = "";
			if (upd == true) {
				if(mode=='H')
					resulte = dectoBin(hextoDec(str));
				else if(mode=='D') {
       				double r_d = Double.valueOf(str);
        			int r_int = (int) r_d;
        			resulte = dectoBin(r_int);
				}
				else if (mode=='O')
					resulte = OctoBin(str);
				else if (mode=='B')
					resulte = str;
			}
			mode = 'B';
			System.out.println("Mode binaire activé");
			Ecran.setText(resulte);
			upd = true;
		}	
	}

	class OctalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			String str = Ecran.getText();
			String resulte = "";
			if (upd == true) {
				if (mode == 'H') 
					resulte = decToOct(hextoDec(str));
				else if (mode == 'D') {
					double r_d = Double.valueOf(str);
        			int r_int = (int) r_d;
        			resulte = decToOct(r_int);
				}
				else if (mode == 'B')
					resulte = binToOct(str);
				else if(mode == 'O')
				    resulte = str;
			}
			mode = 'O';
			System.out.println("Mode octal activé");
			Ecran.setText(resulte);
			upd = true;
		}
	}
	
	class HexaListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0)
		{
			String str = Ecran.getText();
			String resulte = "";
			if (upd == true) {
				if (mode == 'D') {
					double r_d = Double.valueOf(str);
        			int r_int = (int) r_d;
        			resulte = dectoHex(r_int);
				}
				else if (mode == 'O')
					resulte = OctToHex(str);
				else if (mode == 'B')
					resulte = bintoHex(str);
				else 
					resulte = str;
			}
			mode = 'H';
			System.out.println("Mode hexadecimal activé");
			Ecran.setText(resulte);
			upd = true;
		}
	}

	public static int AnyOp(String str)
	{
        char plus = '+';
        char moins = '-';
        char mul = '*';
        char div = '/';
        int i=0;
        int cpt=0;
        for (i = 0;i < str.length();i++)
			if ((str.charAt(i) == plus) || (str.charAt(i) == moins)||
			(str.charAt(i) == mul) || (str.charAt(i) == div))
                cpt++;
        return cpt;
	}
	
	public static String AnyReturnOp(String str)
	{
        int i = 0;
		for (i = 0;((i < str.length()) && ((str.charAt(i) != '+') 
		&& (str.charAt(i) != '-') && (str.charAt(i) != '/') && 
		(str.charAt(i) != '*')));i++);
        if ( i < str.length())
           return String.valueOf(str.charAt(i));
        else return ",";
	}

	public static String BinStringToDecString(String str)
	{
        //Si on est bien en mode binaire on traitera cette opération de la façon suitante 
        int i = 0;
        int op_str = AnyOp(str);
        String sub_str = str.substring(0);
        int taille_du_binaire = 0;
        String Chaine_Convertit = "";
        int index_op = 0;
        int b = 0;
        String op = "";
        while (i < op_str) { 
            op = AnyReturnOp(sub_str);
            index_op = sub_str.indexOf(op)+1;
            taille_du_binaire = index_op-1;
            if (taille_du_binaire != 0) {
				b = bintoDec(sub_str.substring(0,taille_du_binaire));
				if (b == 0) System.out.println("Only Binary");
                //Si la sous chaine n'est pas du binaire alors celà lancera l'erreur 
                Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b)+op);
                sub_str = sub_str.substring(index_op);
            }
            else {
                Chaine_Convertit = Chaine_Convertit.concat(op);
                sub_str = sub_str.substring(index_op);
            }
            i++;
        }
        if (op_str == i) {
            taille_du_binaire = sub_str.length();
			b = bintoDec(sub_str.substring(0,taille_du_binaire));
			if (b == 0) System.out.println("Only Binary");
            Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
        }
        return Chaine_Convertit;
    }

	public static String OctStringToDecString(String str)
	{
        //Si on est bien en mode binaire on traitera cette opération de la façon suivante 
        int i = 0;
        int op_str = AnyOp(str);
        String sub_str = str.substring(0);
        int taille_de_Loctal = 0;
        String Chaine_Convertit = "";
        int index_op = 0;
        int b = 0;
        String op = "";
        while (i < op_str) { 
            op = AnyReturnOp(sub_str);
            index_op = sub_str.indexOf(op)+1;
            taille_de_Loctal = index_op-1;
            if (taille_de_Loctal != 0) {
				b = OcttoDec(sub_str.substring(0,taille_de_Loctal));
				if (b == 0) System.out.println("Only Octal");
                //Si la sous chaine n'est pas du binaire alors celà lancera l'erreur 
                Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b)+op);
                sub_str = sub_str.substring(index_op);
            }
            else {
                Chaine_Convertit = Chaine_Convertit.concat(op);
                sub_str = sub_str.substring(index_op);
            }
            i++;
        }
        if(op_str == i){
            taille_de_Loctal = sub_str.length();
			b = OcttoDec(sub_str.substring(0,taille_de_Loctal));
			if (b == 0) System.out.println("Only Octal");
            Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
        }
        return Chaine_Convertit;
    }

	public static String HexaStringToDecString(String str)
	{
        //Si on est bien en mode binaire on traitera cette opération de la façon suivante 
        int i = 0;
        int op_str = AnyOp(str);
        String sub_str = str.substring(0);
        int taille_de_Lhexa = 0;
        String Chaine_Convertit = "";
        int index_op = 0;
        int b = 0;
        String op = "";
        while (i < op_str) { 
            op = AnyReturnOp(sub_str);
            index_op = sub_str.indexOf(op)+1;
            taille_de_Lhexa = index_op-1;
            if (taille_de_Lhexa != 0) {
				b = hextoDec(sub_str.substring(0,taille_de_Lhexa));
				if (b == 0) System.out.println("Hexa Only");
				 //Si la sous chaine n'est pas du binaire alors celà lancera l'erreur
                Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b)+op);
                sub_str = sub_str.substring(index_op);
            }
            else {
                Chaine_Convertit = Chaine_Convertit.concat(op);
                sub_str = sub_str.substring(index_op);
            }
            i++;
        }
        if (op_str == i) {
            taille_de_Lhexa = sub_str.length();
            b = hextoDec(sub_str.substring(0,taille_de_Lhexa));
            Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
        }
        return Chaine_Convertit;
    }
}

