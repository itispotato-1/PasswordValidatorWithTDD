package lib;

public class PasswordValidator {

    /**
     * ตรวจสอบว่ารหัสที่กรอกมาแข็งแรงแค่ไหน
     * @param ใส่ค่าเป็น String ของรหัสที่รับมา
     * @return ส่งค่าความแข็งแรงของรหัสเป็น 
     * 1. if ความยาวของPassword < 8 | Output :INVALID  
     * 2. if StrengthCount == 1 | Output :WEAK  
     * 3. if StrengthCount == 2 | Output :MEDIUM  
     * 4. if StrengthCount == 3 | Output :STRONG  
     */

    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength

        if(password.length() < 8){
            return PasswordStrength.INVALID; //ต้องมีอย่างน้อย 8 ตัวอักษร
        }

        boolean symbol = true, number = true, upper = true;
        int StrengthCount = 0;
        PasswordStrength level = PasswordStrength.INVALID; //ใส่ค่าดักไว้ก่อน
        for (int i = 0; i < password.length(); i++) {
            int indexPassword = (password.charAt(i));
            if (upper && indexPassword <= 90 && indexPassword >= 65) {
                upper = false; //if เช็กUperCase ตามAscii
                StrengthCount++;
            } else if (number && indexPassword >= 48 && indexPassword <= 57) {
                number = false; //if เช็กnumber ตามAscii
                StrengthCount++;
            }else if(symbol && (indexPassword >= 33 && indexPassword <=47 || indexPassword >= 58 && indexPassword <=64 || indexPassword >= 91 && indexPassword <= 96 || indexPassword >= 123 && indexPassword <= 126)){
                symbol = false; //if เช็กSymbol ตามAscii
                StrengthCount++;
            }
        }
        if(StrengthCount == 1){
            level = PasswordStrength.WEAK;
        }else if(StrengthCount == 2){
            level = PasswordStrength.MEDIUM;
        }else if(StrengthCount == 3){
            level = PasswordStrength.STRONG;
        }
        return level;

    }
}