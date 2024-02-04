package common;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Common {

    private static final long MAX = 999999999;
    private static final long MODULUS = 97;

    public static Boolean isValidIban(String iban) {
        if (iban == null || iban.length() < 5) {
            return false;
        }
        try {
            int modulusResult = calculateModulus(iban);
            return (modulusResult == 1);
        } catch (CheckDigitException  ex) {
            return false;
        }
    }

    private static int calculateModulus(String code) throws CheckDigitException {
        String reformattedCode = code.substring(4) + code.substring(0, 4);
        long total = 0;
        for (int i = 0; i < reformattedCode.length(); i++) {
            int charValue = Character.getNumericValue(reformattedCode.charAt(i));
            if (charValue < 0 || charValue > 35) {
                throw new CheckDigitException("Invalid Character[" +
                        i + "] = '" + charValue + "'");
            }
            total = (charValue > 9 ? total * 100 : total * 10) + charValue;
            if (total > MAX) {
                total = (total % MODULUS);
            }
        }
        return (int)(total % MODULUS);
    }
}
