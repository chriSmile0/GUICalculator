class NEUTRAL extends EXPR_UNARY {
    NEUTRAL(EXPR v){
        this.value = v;
    }
    double eval()
    {
        return  value.eval();
    }
}