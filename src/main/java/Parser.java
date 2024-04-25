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
        Collections.sort(sortedByName,Comparator.comparing(Country :: getName));
        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        //TODO
        Collections.sort(sortedByPopulation,Comparator.comparing(Country :: getPopulation).reversed());
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        //TODO
        Collections.sort(sortedByArea,Comparator.comparing(Country :: getArea).reversed());
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
                String capital = countryDiv.select(".country-info").select("span.country-capital").text();
                int population = Integer.parseInt(countryDiv.select(".country-info").select("span.country-population").text());
                double area = Double.parseDouble(countryDiv.select(".country-info").select("span.country-area").text());
                Country country = new Country(name, capital, population, area);
                countries.add(country);
            }
        }
        catch(IOException e) {
            throw new IOException("File Not Found");
        }
    }

    public static void main(String[] args) throws IOException{
        setUp();
        Parser parser = new Parser();
        while(true) {
            System.out.println("1-Sorted By Name\n2-Sorted By Population\n3-Sorted By Area\n4-Exit");
            Scanner cmd = new Scanner(System.in);
            int command = cmd.nextInt();
            switch(command) {
                case 1:
                    List<Country> a = parser.sortByName();
                    int i = 0;
                    for(Country c : a) {
                        System.out.println(i + c.toString());
                        i++;
                    }
                    break;
                case 2:
                    List<Country> b = parser.sortByPopulation();
                    int j = 0;
                    for(Country c : b) {
                        System.out.println(j + c.toString());
                        j++;
                    }
                    break;
                case 3:
                    List<Country> d = parser.sortByArea();
                    int k = 0;
                    for(Country c : d) {
                        System.out.println(k + c.toString());
                        k++;
                    }
                    break;
                case 4:
                    return;
            }

        }
        //you can test your code here before you run the unit tests ;)

    }
}
