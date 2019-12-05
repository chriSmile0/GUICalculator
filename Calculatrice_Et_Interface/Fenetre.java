
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
	//private Dimension dim3 = new Dimension(110,89);
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

	public static int bintoDec(String bin){
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

    public static int OcttoDec(String oct){
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

    public static int hextoDec(String hex){
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
		chiffre.setPreferredSize(new Dimension(350,600));
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
			upd=false;
		}
	}

	class EgalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		//Ici utiliser la fonction parse_on pour parser la chaine de caracteres récuperée
		String str = Ecran.getText();
		String chaine_a_parser="";
		EXPR e;
		double result=0;
		String resulte="";
		//Dans cette partie nous allons caller nos 3 nouvelles fonctions en fonctions du mode choisi
		/******************************** */
		if(mode=='B'){
			chaine_a_parser = BinStringToDecString(str);
			System.out.println(chaine_a_parser);
			e = PARSER.parse_on(chaine_a_parser);
			result = e.eval();
			System.out.println(result);
			resulte = dectoBin((int)result);
			System.out.println(resulte);

		}
		else if(mode=='O'){
			chaine_a_parser = OctStringToDecString(str);
			System.out.println(chaine_a_parser);
			e = PARSER.parse_on(chaine_a_parser);
			result = e.eval();
			resulte = decToOct((int)result);
		}
		else if(mode=='H'){
			chaine_a_parser = HexaStringToDecString(str);
			System.out.println(chaine_a_parser);
			e = PARSER.parse_on(chaine_a_parser);
			result = e.eval();
			resulte = dectoHex((int)result);	
		}

		else if(mode=='D'){
			e = PARSER.parse_on(str);
			result = e.eval();
			resulte = String.valueOf(result);	
		}
		/******************************************** */
		Ecran.setText(resulte);
		upd = true;
		}

	}

	class MoinsListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"-");
			upd=false;
		}
	}

	class PlusListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"+");
			upd=false;
		}
	}

	class DivListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"/");
			upd=false;
		}
	}

	class MulListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			Ecran.setText(Ecran.getText()+"*");
			upd=false;
		}
	}

	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			mode = 'D';
			Ecran.setText("");
			upd=false;
		}
	}

	//Creer un char pour chaque mode qui a était cliquer en dernier 
	//Sois B sois D sois O sois H 

	class DecimalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		//int r = 0;
		String resulte="";
		if(upd==true){
			if(mode=='H'){
				resulte = Integer.toString(hextoDec(str));
			}
				//EXPR e = PARSER.parse_on(str);
				//double result = e.eval();
			else if(mode=='B'){
				//resulte = Integer.toString((int)result);
				resulte = Integer.toString(bintoDec(str));
			}
			else if (mode=='O'){
				//resulte = Integer.toString((int)result);
				resulte = Integer.toString(OcttoDec(str));
			}
			else if (mode=='D'){
				resulte = str;
			}
		}
		mode = 'D';
		System.out.println("Mode decimal activé");
		Ecran.setText(resulte);
		upd = true;
		
		}
	}
	

	class BinaireListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		//On reconvertit ce que l'on a reçu en base 10 pour que le parser ne sois pas perdu 
		String resulte="";
		int r=0;
		if(upd==true){
			if(mode=='H'){
				resulte = dectoBin(hextoDec(str));
			}
			else if(mode=='D') {
		//EXPR e = PARSER.parse_on(str);
		//double result = e.eval();
			//resulte = Integer.toString((int)result);
				/*r = Integer.valueOf(str);
				System.out.println(r);
				resulte = dectoBin(r);
				System.out.println(resulte);*/
				/*r = dectoBin();
				resulte = dectoBin(r);
				System.out.println(Integer.valueOf(str));**/
       		double r_d = Double.valueOf(str);
        	int r_int = (int) r_d;
        	resulte = dectoBin(r_int);

			}
			else if (mode=='O'){
			//resulte = Integer.toString((int)result);
				resulte = OctoBin(str);
			}
			else if (mode=='B'){
			//resulte = Integer.toString((int)result);
				resulte = str;
			}	
		}
		mode = 'B';
		System.out.println("Mode binaire activé");
		Ecran.setText(resulte);
		upd = true;
		
		}
		
		
	}

	class OctalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		int r = 0;
		String resulte="";
		if(upd==true){
			if(mode=='H'){
				r = hextoDec(str);
				resulte = decToOct(r);
			}
			else if(mode=='D'){
			//EXPR e = PARSER.parse_on(str);
			//double result = e.eval();
				double r_d = Double.valueOf(str);
        		int r_int = (int) r_d;
        		resulte = decToOct(r_int);
			}
			else if (mode=='B'){
				//resulte = Integer.toString((int)result);
				resulte = binToOct(str);
			}
			else if(mode=='O'){
				 //resulte = Integer.toString((int)result);
				 resulte = str;
			}
		}
		mode = 'O';
		System.out.println("Mode octal activé");
		Ecran.setText(resulte);
		upd = true;
		}
	}
	
	class HexaListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		String str = Ecran.getText();
		//EXPR e = PARSER.parse_on(str);
		//double result = e.eval();
		String resulte="";
		if(upd==true){
			if(mode=='D'){
				//System.out.println(Integer.valueOf(str));
				double r_d = Double.valueOf(str);
        		int r_int = (int) r_d;
        		resulte = dectoHex(r_int);
			}
			else if (mode=='O'){
			//resulte = Integer.toString((int)result);
				resulte = OctToHex(str);
			}
			else if (mode=='B'){
			//resulte = Integer.toString((int)result);
				resulte = bintoHex(str);
			}
			else {
				resulte = str;
			}
		}
		mode = 'H';
		System.out.println("Mode hexadecimal activé");
		Ecran.setText(resulte);
		upd = true;
		}
	}





	//Les nouvelles methodes effectives du fichier 'String_Methods'
	//Les 4 méthodes suivantes sont un peu obsoletes car remplacer d'une certaine maniere par CharIsPresent
	/*public static boolean Plus_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='+' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static boolean Moins_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='-' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }


    public static boolean Div_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='/' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static boolean Mul_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='*' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }*/

    /*public static boolean CharIsPresent(String str, char c){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!=c ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static boolean isBin(String str){
        int i=0;
        boolean b=true;
        for(i=0;((i<str.length()) && (str.charAt(i)=='0' || str.charAt(i)=='1'));i++);

        if(i==str.length()) return b;

        else return false;
        
    }

    public static boolean isOctal(String str){
        int i =0;
        boolean b=true;
        for(i=0;(i<str.length() && (str.charAt(i)>='0' && str.charAt(i)<'9'));i++);

        if(i==str.length()) return b;

        else return false;
    }

    public static boolean isDec(String str){
        return CharIsPresent(str,'.');
    }

    public static boolean isHex(String str){
        int i=0;
        boolean b=true;
        for(i=0;(i<str.length() && ((str.charAt(i)>='0' && str.charAt(i)<='9') || (str.charAt(i)>='a' && str.charAt(i)<='f')));i++);

        if(i==str.length()) return b;

        else return false;
	}*/
	public static int AnyOp(String str){
        char plus = '+';
        char moins = '-';
        char mul = '*';
        char div = '/';
        int i=0;
        int cpt=0;
        for(i=0;i<str.length();i++){
            if((str.charAt(i)==plus)||(str.charAt(i)==moins)||(str.charAt(i)==mul)||(str.charAt(i)==div))
                cpt++;
        }
        return cpt;
    }
    public static String AnyReturnOp(String str){
        int i=0;
        for(i=0;((i<str.length()) && ((str.charAt(i)!='+') && (str.charAt(i)!='-') && (str.charAt(i)!='/') && (str.charAt(i)!='*')));i++);
        if(i<str.length()){
           return String.valueOf(str.charAt(i));
        }
        else return ",";
	}
	public static String BinStringToDecString(String str){
        //Si on est bien en mode binaire on traitera cette opération de la façon suitante 
        //Il faudra penser aussi a verifier que cette chaine ne contient que du binaire car si on est bien en mode binaire il faudra le faire 
        int i = 0;
        int op_str = AnyOp(str);
        //System.out.println(op_str);
        String sub_str = str.substring(0);
        //System.out.println("sub_str total : "+sub_str);
        int taille_du_binaire = 0;
        String Chaine_Convertit="";
        int index_op = 0;
        int b = 0;
        String op="";
        while(i<(op_str)){ 
            op = AnyReturnOp(sub_str);
            //System.out.println(op);
            index_op = sub_str.indexOf(op)+1;
            taille_du_binaire = index_op-1;
            //System.out.println("taille du binaire : "+taille_du_binaire);
            if(taille_du_binaire!=0){
                b = bintoDec(sub_str.substring(0,taille_du_binaire));
                //Si la sous chaine n'est pas du binaire alors celà lancera l'erreur , voir pour mettre un try and catch 
                //System.out.println(b);
                Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b)+op);
               // System.out.println(Chaine_Convertit);
                sub_str = sub_str.substring(index_op);
                //System.out.println("sub_str après le + "+sub_str);
            }
            else {
                Chaine_Convertit = Chaine_Convertit.concat(op);
                sub_str = sub_str.substring(index_op);
                //System.out.println("sub_str après le + "+sub_str);
            }
            i++;
        }
        if(op_str == i){
            taille_du_binaire = sub_str.length();
            //System.out.println(taille_du_binaire);
            b = bintoDec(sub_str.substring(0,taille_du_binaire));
            //System.out.println(b);
            Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
            //System.out.println(Chaine_Convertit);//Penser aussi a rajouter l'opérateur qui il y a avant ou après celà depend 
            //Mais on est sur une très bonne voie car avec 10001 cela m'affiche bien 17 donc on a ce qu'on veut 
            //Puis une fois qu'on a 17 et qu'on aura tout la chaine recomposer en entier on pourra la parser avec parse_on 
            //On doit faire ce qu'on vient de faire dans ce if dans le while juste en dessous puis traduire sa dans Fenetre.java 
            //Et donc dans le cas binaire, octal , et hexa pour chaque mode où nous sommmes 
            //Un travail long et fastidieux nous attend !!! (mais sa me plait !!)
            //System.out.println(Chaine_Convertit);
        }
        return Chaine_Convertit;
    }

    public static String OctStringToDecString(String str){
        //Si on est bien en mode binaire on traitera cette opération de la façon suitante 
        //Il faudra penser aussi a verifier que cette chaine ne contient que du binaire car si on est bien en mode binaire il faudra le faire 
        int i = 0;
        int op_str = AnyOp(str);
        //System.out.println(op_str);
        String sub_str = str.substring(0);
        //System.out.println("sub_str total : "+sub_str);
        int taille_de_Loctal = 0;
        String Chaine_Convertit="";
        int index_op = 0;
        int b = 0;
        String op="";
        while(i<(op_str)){ 
            op = AnyReturnOp(sub_str);
            //System.out.println(op);
            index_op = sub_str.indexOf(op)+1;
            taille_de_Loctal = index_op-1;
            //System.out.println("taille du binaire : "+taille_du_binaire);
            if(taille_de_Loctal!=0){
                b = OcttoDec(sub_str.substring(0,taille_de_Loctal));
                //Si la sous chaine n'est pas du binaire alors celà lancera l'erreur , voir pour mettre un try and catch 
                //System.out.println(b);
                Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b)+op);
               // System.out.println(Chaine_Convertit);
                sub_str = sub_str.substring(index_op);
                //System.out.println("sub_str après le + "+sub_str);
            }
            else {
                Chaine_Convertit = Chaine_Convertit.concat(op);
                sub_str = sub_str.substring(index_op);
                //System.out.println("sub_str après le + "+sub_str);
            }
            i++;
        }
        if(op_str == i){
            taille_de_Loctal = sub_str.length();
            //System.out.println(taille_du_binaire);
            b = OcttoDec(sub_str.substring(0,taille_de_Loctal));
            //System.out.println(b);
            Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
            //System.out.println(Chaine_Convertit);//Penser aussi a rajouter l'opérateur qui il y a avant ou après celà depend 
            //Mais on est sur une très bonne voie car avec 10001 cela m'affiche bien 17 donc on a ce qu'on veut 
            //Puis une fois qu'on a 17 et qu'on aura tout la chaine recomposer en entier on pourra la parser avec parse_on 
            //On doit faire ce qu'on vient de faire dans ce if dans le while juste en dessous puis traduire sa dans Fenetre.java 
            //Et donc dans le cas binaire, octal , et hexa pour chaque mode où nous sommmes 
            //Un travail long et fastidieux nous attend !!! (mais sa me plait !!)
            //System.out.println(Chaine_Convertit);
        }
        return Chaine_Convertit;
    }

    public static String HexaStringToDecString(String str){
        //Si on est bien en mode binaire on traitera cette opération de la façon suitante 
        //Il faudra penser aussi a verifier que cette chaine ne contient que du binaire car si on est bien en mode binaire il faudra le faire 
        int i = 0;
        int op_str = AnyOp(str);
        //System.out.println(op_str);
        String sub_str = str.substring(0);
        //System.out.println("sub_str total : "+sub_str);
        int taille_de_Lhexa = 0;
        String Chaine_Convertit="";
        int index_op = 0;
        int b = 0;
        String op="";
        while(i<(op_str)){ 
            op = AnyReturnOp(sub_str);
            //System.out.println(op);
            index_op = sub_str.indexOf(op)+1;
            taille_de_Lhexa = index_op-1;
            //System.out.println("taille du binaire : "+taille_du_binaire);
            if(taille_de_Lhexa!=0){
                b = hextoDec(sub_str.substring(0,taille_de_Lhexa));
                //Si la sous chaine n'est pas du binaire alors celà lancera l'erreur , voir pour mettre un try and catch 
                //System.out.println(b);
                Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b)+op);
               // System.out.println(Chaine_Convertit);
                sub_str = sub_str.substring(index_op);
                //System.out.println("sub_str après le + "+sub_str);
            }
            else {
                Chaine_Convertit = Chaine_Convertit.concat(op);
                sub_str = sub_str.substring(index_op);
                //System.out.println("sub_str après le + "+sub_str);
            }
            i++;
        }
        if(op_str == i){
            taille_de_Lhexa = sub_str.length();
            //System.out.println(taille_du_binaire);
            b = hextoDec(sub_str.substring(0,taille_de_Lhexa));
            //System.out.println(b);
            Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
            //System.out.println(Chaine_Convertit);//Penser aussi a rajouter l'opérateur qui il y a avant ou après celà depend 
            //Mais on est sur une très bonne voie car avec 10001 cela m'affiche bien 17 donc on a ce qu'on veut 
            //Puis une fois qu'on a 17 et qu'on aura tout la chaine recomposer en entier on pourra la parser avec parse_on 
            //On doit faire ce qu'on vient de faire dans ce if dans le while juste en dessous puis traduire sa dans Fenetre.java 
            //Et donc dans le cas binaire, octal , et hexa pour chaque mode où nous sommmes 
            //Un travail long et fastidieux nous attend !!! (mais sa me plait !!)
            //System.out.println(Chaine_Convertit);
        }
        return Chaine_Convertit;
    }

	//Fin des methodes de String_Methods'




	

}

