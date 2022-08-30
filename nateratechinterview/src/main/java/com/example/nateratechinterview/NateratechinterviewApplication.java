package com.example.nateratechinterview;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jdom2.Element;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.nateratechinterview.entities.Articles;
import com.example.nateratechinterview.repositories.ArticleRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@SpringBootApplication
public class NateratechinterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(NateratechinterviewApplication.class, args);
	}

	/*
	 * read in rss feed
	 * parse through each entry to store important information in articleRepository
	 */

	@Bean
	CommandLineRunner init(ArticleRepository articleRepository) {
		return args -> {
			try {
				URL feedUrl = new URL("https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml");
				SyndFeedInput input = new SyndFeedInput();
				SyndFeed feed = input.build(new XmlReader(feedUrl));
				int size = feed.getEntries().size();
				String nytLogoLink = (feed.getImage().getUrl());

				SyndEntry entry;
				String title;
				String author;
				String description;
				String pubDate;
				String imageLink = null;
				String articleLink;

				for (int numEntries = 0; numEntries < size; numEntries++) {
					entry = feed.getEntries().get(numEntries);
					title = entry.getTitle();
					author = entry.getAuthor();
					description = entry.getDescription().getValue().toString();
					pubDate = entry.getPublishedDate().toString();
					pubDate = pubDate.substring(4, 10) + pubDate.substring(23, 28);
					articleLink = entry.getUri();

					// get image link if it exists. Otherwise store black image link
					List<Element> foreignMarkups = (List<Element>) entry.getForeignMarkup();
					for (Element foreignMarkup : foreignMarkups) {
						if (foreignMarkup.getAttribute("url") != null) {
							imageLink = foreignMarkup.getAttribute("url").getValue();
						}
					}
					if (imageLink == null) {
						imageLink = "https://upload.wikimedia.org/wikipedia/commons/4/49/A_black_image.jpg";
					}

					Articles article = new Articles(nytLogoLink, title, author, description, pubDate, imageLink,
							articleLink);
					articleRepository.save(article);

					imageLink = null;
				}

			} catch (MalformedURLException e) {
				System.out.println("Bad URL");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("ERROR: " + ex.getMessage());
			}
		};
	}

}
