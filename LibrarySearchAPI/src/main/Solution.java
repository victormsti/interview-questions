package main;

import java.io.*;
import java.util.*;

/*

Given a string containing book metadata, write a Library class that parses the book metadata and provides an API that lets you search for all books containing a word.

 

API:

Library

<constructor>(book_metadata) -> returns a Library object for the given book metadata

search(word) -> returns a list of titles of books that contain the given word anywhere in the title, author, or description fields.

Return an empty list if no books contain the given word.

No need to worry about the order of the list.

Only matches *whole* words and are case sensitive.

e.g. Searching for "My" or "book" would match a book containing "My book", but searching for "My b" or "boo" would *not* match.

Keep in mind that the search method can get a high volume of calls, so you will want to optimize for this.



*/

public class Solution {
	private static String LIBRARY_DATA = "TITLE: Hitchhiker's Guide to the Galaxy\n" + "AUTHOR: Douglas Adams\n"
			+ "DESCRIPTION: Seconds before the Earth is demolished to make way for a galactic freeway,\n"
			+ "Arthur Dent is plucked off the planet by his friend Ford Prefect, a researcher for the\n"
			+ "revised edition of The Hitchhiker's Guide to the Galaxy who, for the last fifteen years,\n"
			+ "has been posing as an out-of-work actor.\n" + "\n" + "" + "TITLE: Dune\n" + "AUTHOR: Frank Herbert\n"
			+ "DESCRIPTION: The troubles begin when stewardship of Arrakis is transferred by the\n"
			+ "Emperor from the Harkonnen Noble House to House Atreides. The Harkonnens don't want to\n"
			+ "give up their privilege, though, and through sabotage and treachery they cast young\n"
			+ "Duke Paul Atreides out into the planet's harsh environment to die. There he falls in\n"
			+ "with the Fremen, a tribe of desert dwellers who become the basis of the army with which \n"
			+ "he will reclaim what's rightfully his. Paul Atreides, though, is far more than just a\n"
			+ "usurped duke. He might be the end product of a very long-term genetic experiment\n"
			+ "designed to breed a super human; he might be a messiah. His struggle is at the center\n"
			+ "of a nexus of powerful people and events, and the repercussions will be felt throughout\n"
			+ "the Imperium.\n" + "\n" + "TITLE: A Song Of Ice And Fire Series\n" + "AUTHOR: George R.R. Martin\n"
			+ "DESCRIPTION: As the Seven Kingdoms face a generation-long winter, the noble Stark family\n"
			+ "confronts the poisonous plots of the rival Lannisters, the emergence of the\n"
			+ "White Walkers, the arrival of barbarian hordes, and other threats.\n";

	// Complete the Library class below.
	static class Library {

		public static String[] words;

		Library(String data) {
			words = data.split("\n");
		}

		String[] search(String word) {

			String[] title = null;
			String[] author;
			String[] description;
			String[] foundTitles = null;
			String strTitle = null;

			// the list is necessary because we can be adding items dynamically
			// and at the final of the statment pass the itens to the array
			List<String> list = new ArrayList<>();

			// the author and description have more than one line,
			// so the boolean flags are necessary to keep looking at these lines
			boolean isAuthor = false;
			boolean isDescription = false;

			// if already found in a given title, pass until reach the another title
			boolean isFound = false;

			for (String currentWord : Library.words) {

				if (currentWord.length() != 0 && currentWord.substring(0, 5).equals("TITLE")) {
					isFound = false;
					strTitle = currentWord.substring(7, currentWord.length());
					title = currentWord.split(" ");
					for (String eachTitle : title) {

						if (eachTitle.contains(word)) {
							list.add(strTitle);
							isFound = true;
							break;
						}
					}
				}

				if (currentWord.length() != 0 && currentWord.substring(0, 6).equals("AUTHOR") && !isFound) {
					isAuthor = true;
					isDescription = false;
					author = currentWord.split(" ");

					for (String eachAuthor : author) {
						if (eachAuthor.contains(word)) {
							list.add(strTitle);
							isFound = true;
							break;
						}
					}
				}

				if (currentWord.length() != 0 && currentWord.substring(0, 11).equals("DESCRIPTION") && !isFound) {
					isDescription = true;
					isAuthor = false;
					description = currentWord.split(" ");
					for (String eachDescription : description) {
						if (eachDescription.contains(word)) {
							list.add(strTitle);
							isFound = true;
							break;
						}
					}
				}
				if (isAuthor && !isFound) {
					author = currentWord.split(" ");

					for (String eachAuthor : author) {
						if (eachAuthor.contains(word)) {
							list.add(strTitle);
							isFound = true;
							break;
						}
					}
				}
				if (isDescription && !isFound) {
					description = currentWord.split(" ");
					for (String eachDescription : description) {
						if (eachDescription.contains(word)) {
							list.add(strTitle);
							isFound = true;
							break;
						}
					}
				}
			}
			if (list.isEmpty()) {
				return foundTitles;
			} else {
				foundTitles = new String[list.size()];
				for (int i = 0; i < foundTitles.length; i++) {
					foundTitles[i] = list.get(i);
				}
				return foundTitles;

			}
		}

	}

	public String[] doSearch(String word) {
		Library library = new Library(LIBRARY_DATA);

		String[] title = library.search(word);
		
		return title;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		Library library = new Library(LIBRARY_DATA);

		String[] title = library.search("and");

		if (title == null) {
			System.out.println(title);
		} else {
			for (String str : title) {
				System.out.println(str + " ");
			}
		}
	}
}
