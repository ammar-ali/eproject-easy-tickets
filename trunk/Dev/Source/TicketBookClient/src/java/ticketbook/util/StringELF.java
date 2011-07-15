/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

/**
 *
 * @author Admin
 */
public class StringELF {

    public static Integer validatePositiveNumber(String number) {
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
            return new Integer(0);
        }
        return new Integer(1);
    }
}
