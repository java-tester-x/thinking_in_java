class ParamName {

    int size;

    public static void main(String[] args) {
        ParamName aParamName = new ParamName();
        aParamName.size = 27;
        int i = aParamName.go(aParamName.size);
        System.out.println(aParamName.size + " : " + i);
    }

    public int go(int size) {
        size++;
        return size;
    }

}