public class String_Methods {
    public static  int bintoDec(String bin){
        int nb = Integer.parseInt(bin,2);
        return nb;
    }

    public static String bintoHex(String bin){
        int nb = bintoDec(bin);
        return Integer.toHexString(nb);
    }

    public static String binToOct(String bin){
        int nb = bintoDec(bin);
        return decToOct(nb);
    }

    public static String dectoBin(int nb){
        String str = Integer.toBinaryString(nb);
        return str;
    }

    public static String decToOct(int dec){
        return Integer.toOctalString(dec);
    }

    public static String dectoHex(int dec){
        return Integer.toHexString(dec);
    }

    public static  String OctoBin(String Oct){
        int nb = Integer.parseInt(Oct,8);
        return dectoBin(nb);
    }

    public static int OcttoDec(String oct){
        return Integer.parseInt(oct,8);
    }

    public static String OctToHex(String Oct){
        int nb = OcttoDec(Oct);
        return dectoHex(nb);
    }

    public static String hexToOct(String hex){
        int nb = hextoDec(hex);
        return decToOct(nb);
    }

    public static int hextoDec(String hex){
        int nb = Integer.parseInt(hex,16);
        return nb;
    }

    public static String hexToBin(String hex){
        int nb = Integer.parseInt(hex,16);
        return dectoBin(nb);
    }

    public static String intoBinary(String ch){
        String result="";
        int i=0;
        while(i<ch.length()){
            char c = ch.charAt(i++);
            result += Integer.toBinaryString((int)c);
        }
        return result;
    }

    public static boolean Plus_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='+' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static int AnyPlus(String str){
        int i=0;
        int cpt=0;
        for(i=0;i<str.length();i++)
            if(str.charAt(i)=='+') cpt++;

        return cpt;
    }


    public static boolean Moins_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='-' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static int AnyMoins(String str){
        int i=0;
        int cpt=0;
        for(i=0;i<str.length();i++)
            if(str.charAt(i)=='-') cpt++;

        return cpt;
    }


    public static boolean Div_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='/' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static int AnyDiv(String str){
        int i=0;
        int cpt=0;
        for(i=0;i<str.length();i++)
            if(str.charAt(i)=='/') cpt++;

        return cpt;
    }

    public static boolean Mul_is_present(String str){
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!='*' ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static int AnyMul(String str){
        int i=0;
        int cpt=0;
        for(i=0;i<str.length();i++)
            if(str.charAt(i)=='*') cpt++;

        return cpt;
    }

    public static boolean CharIsPresent(String str, char c){//Fonction contains()
        boolean a=false;
        int i =0;
        for(i=0; ((i<str.length()) && (str.charAt(i)!=c ));i++);

        if(i!=str.length()) a = true;

        return a;
    }

    public static int AnyChar(String str, char c){
        int i=0;
        int cpt=0;
        for(i=0;i<str.length();i++)
            if(str.charAt(i)==c) cpt++;

        return cpt;
    }

    public static String AnyCharReturn(String str,String c){
        int i = 0;
        if(str.contains(c)) return c;
        else return ",";
    }

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


    public static void main(String[] args){
        /*String str_plus = "str+";
        String str_moins = "str-";
        String str_mul = "str*";
        String str_div = "str/";
        System.out.println(Plus_is_present(str_plus));//true//Fonctionne
        System.out.println(Moins_is_present(str_moins));//true//Fonctionne
        System.out.println(Mul_is_present(str_mul));//true//Fonctionne
        System.out.println(Div_is_present(str_div));//true//Fonctionne
        System.out.println(CharIsPresent(str_plus,'s'));//true//Fonctionne

        System.out.println(AnyPlus(str_plus));//1//fonctionne
        System.out.println(AnyMoins(str_moins));//1//fonctionne
        System.out.println(AnyMul(str_mul));//1//fonctionne
        System.out.println(AnyDiv(str_div));//1//fonctionne

        String str_bin = "100110";
        System.out.println(isBin(str_bin));//true//Fonctionne

        String str_oct = "12345678";
        System.out.println(isOctal(str_oct));//true//Fonctionne

        String str_dec = "12.3";
        System.out.println(isDec(str_dec));//true//Fonctionne

        String str_hex = "abcdef0123456789";
        System.out.println(isHex(str_hex));//true//Fonctionne

        String str_ops = "+-/*";
        System.out.println(AnyOp(str_ops));*/
        //Dans notre projet cela va nous servir a savoir combien il y'a d'opérations dans la chaine mais il faut aussi s'assurer
        //qu'il y a bien une constante entre ces opérations 
        //Cela ne va pas poser de probleme car en binaire octal et hexa on n'autorisera que les uniques opérations exemples :
        // 100001+1 ; fed + 1 ; 08 + 07 


        /*Important de garder le code qui suit */
        /*String test_str_ecran_bin = "10001++1+100"; //Si on est bien en mode binaire on traitera cette opération de la façon suitante 
        int i = 0;
        int op_test_str_ecran_bin = AnyOp(test_str_ecran_bin);
        System.out.println(op_test_str_ecran_bin);
        String sub_str = test_str_ecran_bin.substring(0);
        System.out.println("sub_str total : "+sub_str);
        int taille_du_binaire = 0;
        String Chaine_Convertit="";
        int index_op = 0;
        int b = 0;
        String op="";*/
        /*if(op_test_str_ecran_bin == 0){
            taille_du_binaire = sub_str.length();
            System.out.println(taille_du_binaire);
            b = bintoDec(sub_str.substring(0,taille_du_binaire));
            System.out.println(b);
            Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
            System.out.println(Chaine_Convertit);//Penser aussi a rajouter l'opérateur qui il y a avant ou après celà depend 
            //Mais on est sur une très bonne voie car avec 10001 cela m'affiche bien 17 donc on a ce qu'on veut 
            //Puis une fois qu'on a 17 et qu'on aura tout la chaine recomposer en entier on pourra la parser avec parse_on 
            //On doit faire ce qu'on vient de faire dans ce if dans le while juste en dessous puis traduire sa dans Fenetre.java 
            //Et donc dans le cas binaire, octal , et hexa pour chaque mode où nous sommmes 
            //Un travail long et fastidieux nous attend !!! (mais sa me plait !!)
        */
            /**Les instructions suivantes sont a garder a tout prix *** */
           /*while(i<(op_test_str_ecran_bin)){ 
                op = AnyCharReturn(sub_str,"+");
                System.out.println(op);
                index_op = sub_str.indexOf(op)+1;
                taille_du_binaire = index_op-1;
                System.out.println("taille du binaire : "+taille_du_binaire);
                if(taille_du_binaire!=0){
                    //System.out.println("taille du binaire : "+taille_du_binaire);
                    b = bintoDec(sub_str.substring(0,taille_du_binaire));
                    System.out.println(b);
                    Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b)+op);
                    System.out.println(Chaine_Convertit);
                    sub_str = sub_str.substring(index_op);
                    System.out.println("sub_str après le + "+sub_str);
                }
                else {
                    Chaine_Convertit = Chaine_Convertit.concat(op);
                    sub_str = sub_str.substring(index_op);
                    System.out.println("sub_str après le + "+sub_str);
                }
                i++;
            }
            if(op_test_str_ecran_bin == i){
                taille_du_binaire = sub_str.length();
                System.out.println(taille_du_binaire);
                b = bintoDec(sub_str.substring(0,taille_du_binaire));
                System.out.println(b);
                Chaine_Convertit = Chaine_Convertit.concat(Integer.toString(b));
                System.out.println(Chaine_Convertit);//Penser aussi a rajouter l'opérateur qui il y a avant ou après celà depend 
                //Mais on est sur une très bonne voie car avec 10001 cela m'affiche bien 17 donc on a ce qu'on veut 
                //Puis une fois qu'on a 17 et qu'on aura tout la chaine recomposer en entier on pourra la parser avec parse_on 
                //On doit faire ce qu'on vient de faire dans ce if dans le while juste en dessous puis traduire sa dans Fenetre.java 
                //Et donc dans le cas binaire, octal , et hexa pour chaque mode où nous sommmes 
                //Un travail long et fastidieux nous attend !!! (mais sa me plait !!)

            System.out.println(Chaine_Convertit);
        }*/
        /*********A mettre dans une fonction d'urgence */
        
        /*taille_du_binaire = index_op;
        System.out.println("taille du binaire : "+taille_du_binaire);
        System.out.println("sub_str après le + "+sub_str);*/
        /**** */
        
        String str_bin = "101*+10+/1";
        System.out.println(BinStringToDecString(str_bin));// avec 101 cela renvoie bien 5// 101+10 renvoie bien 5+2, et 101++10+1 renvoie bien 5++2+1
        //Fonctionne avec tout les opérateurs 
        
        String str_op = "12+*+";
        System.out.println(str_op.contains("+"));
        System.out.println(AnyReturnOp(str_op));//Me renvoie bien plus 

        String str_oct = "107+107+107";
        String resulte = "";
        String chaine_a_parser = OctStringToDecString(str_oct);
        System.out.println(chaine_a_parser);
        EXPR e = PARSER.parse_on(chaine_a_parser);
        double result = e.eval();
        System.out.println(result);
        resulte = decToOct((int)result);	
        System.out.println(resulte);

        String str_hexa = "def+fb";
        resulte = "";
        chaine_a_parser = HexaStringToDecString(str_hexa);//Fonctionne très bien aussi 
        System.out.println(chaine_a_parser);
        e = PARSER.parse_on(chaine_a_parser);
        result = e.eval();
        System.out.println(result);
        resulte = dectoHex((int)result);	
        System.out.println(resulte);

        System.out.println("suite------------------------------------------------------------suite");
        double r = 2.0;
        String r_string = String.valueOf(r);
        System.out.println(r_string);
        double r_d = Double.valueOf(r_string);
        System.out.println(r_d);
        int r_int = (int) r_d;
        System.out.println(r_int);


    }
}