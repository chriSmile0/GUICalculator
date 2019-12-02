import java.util.*;

class PARSER {
    private static String src;
    private static int idx;
    private static char last_char;
    private static double last_cst;

    private static boolean read_char(char c)
    {
        if ((idx < src.length()) && (src.charAt(idx) == c)) {
            idx++;
            last_char = c;
            return true;
        }
        return false;
    }

   
    private static boolean read_cst()
    {
        //Indication : '4'-'0' == 4
        //Indication : 234 == ((2*10)+3)*10)+4
        //....
       
        //Conversion d'une chaine de caractere en int
        last_cst = 0;
        int idx_dep = idx;
        for(;((idx<src.length())&&(((src.charAt(idx)>='0')&&(src.charAt(idx)<='9'))||(src.charAt(idx)=='.')));idx++);
        
        String str_sub = src.substring(idx_dep,idx);
        if(str_sub.length()>0){
            last_cst = Double.valueOf(str_sub);
            return true;
        }
        else return false;
    }

   

    private static EXPR read_e_cst()
    {
        EXPR result;
        //CST cst;




        if(read_cst() == true){

            result = new CST(last_cst);
            return result;
        }
        else {
            return null;
        }
       
    }

    private static EXPR read_e_unary()
    {
        EXPR result;
        char op;
        result = read_e_cst();
        if(result==null){
            while (read_char('+') || read_char('-')) {
                result = read_e_cst();
                if (result == null) error();
                op = last_char;
                if (op == '-')
                    result = new NEG(result);
                else 
                    result = new NEUTRAL(result);
            }
        }
        return result;
    }

    private static EXPR read_e_mul()
    {
        EXPR result,right;
        char op;
        result = read_e_unary();

        if (result != null){
            while (read_char('*') || read_char('/')) {
                op = last_char;
                right = read_e_unary();
                if (right == null) error();
                if (op == '*')
                    result =  new MUL(result,right);
                else 
                    result = new DIV(result,right);
            }
        }
    return result;
    }

    private static EXPR read_e()
    {
        EXPR result,right;
        char op;
        result = read_e_mul();
        if (result !=null){
            while (read_char('+') || read_char('-')) {
                op = last_char;
                right = read_e_mul();
                if (right == null)  error();
                if (op == '+')
                    result = new ADD(result,right);
                else
                    result = new SUB(result,right);
            }
        }
        return result;
    }
    //Indication : Une fonction par règle de grammaire

    private static void error()
    {
        int j;
        System.out.println(src);
        for (j=0;j<idx;j++) System.out.println(' ');
        System.out.println('I');
        System.exit(1);
    }

    public static EXPR parse_on(String txt)
    {
        EXPR e;
        src = txt;
        idx = 0;
        e = read_e();
        if ((e == null)|| (idx < src.length())){
             System.out.println("e: "+e);
             error();
        }
        return e;
    }

}