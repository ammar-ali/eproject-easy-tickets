package ticketbook.util;

public class StringUtil {

    /*
     * Chua tat ca cac bien, ham xu ly lien quan den chuoi
     */
    public static String toString(String a) {
        if (a != null) {
            return a;
        }
        return "";
    }

    public static String convertToUTF8(String a) {
        try {
            if (a != null && !a.equals("")) {
                byte[] b = a.getBytes("ISO-8859-1");
                String c = new String(b, "UTF-8");
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public static boolean validatePositiveNumber(String number) {
        String temp = "0123456789";
        int i;
        for (i = 0; i < number.length(); i++) {
            int j;
            for (j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == number.charAt(i)) {
                    j = temp.length();
                }
            }

            if (j != temp.length() + 1) {
                i = number.length();
            }
        }
        if (i == number.length() + 1) {
            return false;
        }
        return true;
    }
}
