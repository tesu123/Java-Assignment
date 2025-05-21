public class Assignment2Problem2 {
    public static void main(String[] args) {
        int num = 42;
        Integer obj = num;
        System.out.println("i) Basic type to object: " + obj);

        int unboxedNum = obj;
        System.out.println("ii) Object to basic type: " + unboxedNum);

        String strFromPrimitive = String.valueOf(num);
        System.out.println("iii) Basic type to String: " + strFromPrimitive);

        String numericStr = "123";
        Integer objFromString = Integer.valueOf(numericStr);
        System.out.println("iv) String to numeric object: " + objFromString);

        String strFromObject = obj.toString();
        System.out.println("v) Object to String: " + strFromObject);
    }
}