public class String_Methods {
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

    public String hextoDec(String hex){
        int nb = Integer.parseInt(hex,10);
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
}