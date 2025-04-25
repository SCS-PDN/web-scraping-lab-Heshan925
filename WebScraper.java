package lk.ac.pdn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;






public class WebScraper {

    public static void main(String[] args) throws IOException {

        final String url = "https://www.bbc.com/";

        TitleData titleData = scrapeTitleData(url);
        System.out.println("Page Title: "+titleData.getTitle());

        List<HeadingData> headings = scrapeHeadingData(url);
        System.out.println("Headings :");
        for (HeadingData data : headings) {
            System.out.println(data.getHeading());
        }


    }
    private static TitleData scrapeTitleData(String url) throws IOException {


        Document doc = Jsoup.connect(url).get();

        // Extract the title
        String title = doc.title();

        TitleData data = new TitleData();
        data.setTitle(title);
        // Print the title


        return data;
    }

    private static List<HeadingData> scrapeHeadingData(String url) throws IOException{

        Document doc = Jsoup.connect(url).get();

        List<HeadingData> headingData = new ArrayList<>();
        Elements headings = doc.select("h1, h2, h3, h4, h5, h6");


        for (Element heading : headings) {
            HeadingData data = new HeadingData();
            data.setHeading(headings.get(1).text());
        }
        return headingData;
    }
    static class TitleData{
        private String titleName;


        public String getTitle() {
            return titleName;
        }

        public void setTitle(String title) {
            this.titleName = title;
        }


    }
    static class HeadingData{
        private String heading;

        public String getHeading() {
            return heading;
        }

        public void setHeading(String heading) {
            this.heading = heading;
        }



    }
}




