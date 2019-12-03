public class String_Methods {
    /*public int bintoDec(String bin){
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

    public String hextoDec(String hex){
        int nb = Integer.parseInt(hex,10);
        return nb;
    }

    public  String hexToBin(String hex){
        int nb = Integer.parseInt(hex,16);
        return dectoBin(nb);
    }

    public String intoBinary(String ch){
        String result="";
        int i=0;
        while(i<ch.length()){
            char c = ch.charAt(i++);
            result += Integer.toBinaryString((int)c);
        }
        return result;
    }*/

    public static boolean Plus_is_present(String str){
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
    }

    public static boolean CharIsPresent(String str, char c){
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
    }

    public static void main(String[] args){
        String str_plus = "str+";
        String str_moins = "str-";
        String str_mul = "str*";
        String str_div = "str/";
        System.out.println(Plus_is_present(str_plus));//true//Fonctionne
        System.out.println(Moins_is_present(str_moins));//true//Fonctionne
        System.out.println(Mul_is_present(str_mul));//true//Fonctionne
        System.out.println(Div_is_present(str_div));//true//Fonctionne
        System.out.println(CharIsPresent(str_plus,'s'));//true//Fonctionne

        String str_bin = "100110";
        System.out.println(isBin(str_bin));//true//Fonctionne

        String str_oct = "12345678";
        System.out.println(isOctal(str_oct));//true//Fonctionne

        String str_dec = "12.3";
        System.out.println(isDec(str_dec));//true//Fonctionne

        String str_hex = "abcdef0123456789";
        System.out.println(isHex(str_hex));//true//Fonctionne





    }
}