public class Numerals {
    public int value;
    public boolean isRoman = false;
    public boolean isValid = true;
    public Numerals(String number){
        int rezult = -1;
        try {
            rezult = Integer.parseInt(number);
        }
        catch (NumberFormatException ex){
            this.isRoman = true;
            rezult = RomanNumerals.parse(number.toUpperCase());

        }
        // This block prints 'invalid number' to the console if user input is not valid numeral
        if (rezult == -1) {
            this.isValid = false;
            System.out.println("invalid number: " + number);
            System.out.println("use Roman o Arabic numbers only");
        }
        this.value = rezult;

    }
}
