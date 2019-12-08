class NEG extends EXPR_UNARY {
    NEG(EXPR v){
        this.value = v;
    }
    double eval()
    {
        return (-1) * (value.eval());
    }
}