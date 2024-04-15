package ss15_exception.demo;

public class how_2_use_Throws {
    public static void main(String[] args) {
        try {
            checkAge(20);
        } catch (Over18YearOldException e) {
            System.out.println(e.getMessage());
        }
    }

    static boolean checkAge(int age) throws Over18YearOldException {
        if(age >= 18) {
            throw new Over18YearOldException("Quá 18 tuổi rồi");
        }
        return true;
    }
}
