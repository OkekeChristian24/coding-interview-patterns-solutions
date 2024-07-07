class BackspaceStringCompare {

    public static Boolean compare(String str1, String str2){
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;

        while(index1 >= 0 && index2 >= 0){
            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);

            if(i1 < 0 && i2 < 0)
                return true;

            if(i1 < 0 || i2 < 0){
                return false;
            }
            
            if(str1.charAt(i1) != str2.charAt(i2)){
                return false;

            }

            index1 = i1 - 1;
            index2 = i2 - 1;

        }

        return true;
    }
    private static int getNextValidCharIndex(String str, int index){

        int backspaceCount = 0;
        /*
        while(index >= 0){
            if(str.charAt(index) == '#')
                backspaceCount++;
            else if(backspaceCount > 0)
                backspaceCount--;
            else 
                break;

            index--;
        }
        */
       while(index >= 0){
        if(str.charAt(index) == '#'){
            backspaceCount++;
            index--;
        }else{
            if(backspaceCount > 0){
                backspaceCount--;
                index--;
            }else
                break;
        }

       }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#")); // true
        System.out.println(compare("xy#z", "xyz#")); // false
        System.out.println(compare("xywrrmp", "xywrrmu#p")); // true
        
    
    }
}