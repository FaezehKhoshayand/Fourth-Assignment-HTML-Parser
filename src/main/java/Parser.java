import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        //TODO
        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        //TODO
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        //TODO
        return sortedByArea;
    }

    public static void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        //TODO
        String path = "C:\\Users\\BEROOZ\\Desktop\\html\\Fourth-Assignment-HTML-Parser\\src\\Resources\\country-list.html";
        try {
            // Extract data from the HTML
            //TODO
            File input = new File(path);
            Document document = Jsoup.parse(input, "UTF-8");
            Elements countryDivs = document.select("div.country");
            // Iterate through each country div to extract country data
            //TODO
            for (Element countryDiv : countryDivs) {
                String name = countryDiv.select(".country-name").text();
                String capital = countryDiv.select(".country-info").text();
                int population = Integer.parseInt(countryDiv.select(".country-info").select("span.country-population").text());
                double area = Double.parseDouble(countryDiv.select(".country-info").select("span.country-area").text());
                countries.add(new Country(name, capital, population, area));
            }
        }
        catch(IOException e) {
            throw new IOException("File Not Found");
        }
    }

    public static void main(String[] args) throws IOException{
        setUp();
        //you can test your code here before you run the unit tests ;)

    }
}
