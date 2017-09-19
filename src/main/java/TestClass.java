import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class TestClass {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
   public static void main(String[] args) {
       String siteText = new String(urlToString("http://erdani.com/tdpl/hamlet.txt"));
       System.out.println(siteText);
       int numberOfWords = 1;
       for (int i = 0; i < siteText.length(); i++) {
           char checkForSpaces = siteText.charAt(i);
           if (checkForSpaces == ' ') {
               numberOfWords++;
           }
       }
       String checkForThisWord = new String("the");
       int countOfWords = 0;
       for (int i = 0; i < siteText.length() - checkForThisWord.length(); i++) {
           if (siteText.substring(i, i + checkForThisWord.length()).toLowerCase().equals(
               checkForThisWord.toLowerCase())) {
               countOfWords++;
           }
       }
       System.out.println("This site has " + numberOfWords + " words.");
       System.out.println("This site contains the word \"" + checkForThisWord + "\" "
       + countOfWords + " time(s).");
   }
}
