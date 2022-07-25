import java.util.ArrayList;

public class PasswordCheckerUtility {

    public static boolean isValidPassword(String passwordString) throws 
    
    
    LengthException,
    NoDigitException, 
    NoLowerAlphaException, 
    NoUpperAlphaException,
    InvalidSequenceException {

    	
        boolean strong = false;
        int tops_count = 0, lower_count = 0, noDigit_count = 0;
        int tops_index = 0 , lower_index = 0;

        

        for(int i = 0 ; i < passwordString.length(); i++){


            if(passwordString.length() <= 6){
                throw new LengthException();
            }
            if(Character.isUpperCase(passwordString.charAt(i))){
                tops_count++;
                tops_index = i;
            }
            if (Character.isLowerCase(passwordString.charAt(i))){
                lower_count++;
                lower_index = i;
            }
            if(Character.isDigit(passwordString.charAt(i))){
               noDigit_count++;

            }

        }
        @SuppressWarnings("unused")
		int count = 0;
        while(tops_count >= 0){
            if(tops_count == 0){
                throw new NoUpperAlphaException();
            }
            else if(tops_count < 3){
                break;
            }
            else if(passwordString.charAt(tops_index) == passwordString.charAt(tops_index-1) && passwordString.charAt(tops_index - 2) == passwordString.charAt(tops_index)){
                    throw new InvalidSequenceException();
                }
            else  {
                break;
            }


        }
        while(lower_count >= 0) {


            if (lower_count == 0) {
                throw new NoLowerAlphaException();
            }
            else if(lower_count < 3){
                break;
            }

            else if(passwordString.charAt(lower_index) == passwordString.charAt(lower_index-1) && passwordString.charAt(lower_index - 2) == passwordString.charAt(lower_index)){
                    throw new InvalidSequenceException();
                }
            else {
                break;
            }

        }


        if(noDigit_count == 0){
            throw new NoDigitException();
        }
        else {
            strong = true;
        }



        return strong;
    }

    public static boolean isWeakPassword(String passwordString) {

        boolean weakPassword = false;

        try {
			if(isValidPassword(passwordString)){
			    if(passwordString.length()  < 10 ){
			        weakPassword = true;
			        
			        
			    }


			}
		} catch (LengthException | NoDigitException | NoLowerAlphaException | NoUpperAlphaException
				| InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        return weakPassword;






}

    public static ArrayList<String> invalidPasswords(ArrayList<String> passwords) {

        ArrayList<String> invalids = new ArrayList<>();
        String error_message ;

        int i = 0;
        while (i < passwords.size()){

                try
                {
                    if(isValidPassword(passwords.get(i))){

                    }



                }

                catch (LengthException exception)
                {
                    error_message = passwords.get(i) + " The password must be at least 6 characters long";
                  invalids.add(error_message);
                }

                catch (InvalidSequenceException exception)
                {
                    error_message = passwords.get(i) + " The password cannot contain more than two of the same character in sequence.";
                   invalids.add(error_message);
                }

                catch (NoDigitException exception)
                {
                    error_message = passwords.get(i) + " The password must contain at least one digit.";
                    invalids.add(error_message);
                }

                catch (NoUpperAlphaException exception)
                {
                    error_message = passwords.get(i) + " The password must contain at least one uppercase alphabetic character.";
                   invalids.add(error_message);
                }

                catch (NoLowerAlphaException exception)
                {
                    error_message = passwords.get(i) + " The password must contain at least one lowercase alphabetic character.";
                    invalids.add(error_message);
                }
            i++;
        }
        return invalids;
    }
}
