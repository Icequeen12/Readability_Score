package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String path = "./" + args[0];

        String txt = null;
        try {
            txt = readFileAsString(path);
            result(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void result(String txt) {
        String regex = "[!?.]";
        System.out.println(txt);

        String[] sentencesArray = txt.split(regex);
        String[] wordsArray = txt.split(" ");

        int sentences = sentencesArray.length;
        int words = wordsArray.length;


        int characters = 0;
        int syllables = 0;
        int sylResult = 0;
        int polysyllables = 0;


        for (String s : wordsArray) {
            characters += s.length();
            sylResult = countSyllables(s);
            syllables += sylResult;

            if (sylResult > 2) {
                polysyllables++;
            }
        }

        System.out.println("Words:" + words + "\n" +
                "Sentences: " + sentences + "\n" +
                "Characters: " + characters + "\n" +
                "Syllables: " + syllables + "\n" +
                "Polysyllables: " + polysyllables);

        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        String choice = scanner.next();

        switch (choice) {
            case "ARI":
                ari(characters, words, sentences);
                break;
            case "FK":
                fk(words, sentences, syllables);
                break;
            case "SMOG":
                smog(polysyllables, sentences);
                break;
            case "CL":
                cl(characters, words, sentences);
                break;
            case "all":
                all(characters, words, sentences, syllables, polysyllables);
                break;
        }


    }

    public static void ari(int characters, int words, int sentences) {
        double score = 4.71 * characters / words + 0.5 * words / sentences - 21.43;
        score = Math.round(score * 100);
        score /= 100;
        int age = getAge(score);

        System.out.println("Automated Readability Index: " + score + "(about " + age + " year olds)");
    }

    public static void fk(int words, int sentences, int syllables) {
        double score = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
        score = Math.round(score * 100);
        score /= 100;
        int age = getAge(score);

        System.out.println("Flesch–Kincaid readability tests: " + score + " (about " + age + " year olds).");

    }

    public static void smog(int polysyllables, int sentences) {
        double score = 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
        score = Math.round(score * 100);
        score /= 100;

        int age = getAge(score);

        System.out.println("Simple Measure of Gobbledygook: " + score + " (about " + age + " year olds).");

    }

    public static void cl(int characters, int words, int sentences) {
        float L = (float) characters / words * 100;
        float S = (float) sentences / words * 100;

        double score = 0.0588 * L - 0.296 * S - 15.8;
        score = Math.round(score * 100);
        score /= 100;

        int age = getAge(score);

        System.out.println("Coleman–Liau index: " + score + " (about " + age + " year olds).");
    }

    public static void all(int characters, int words, int sentences, int syllables, int polysyllables) {
        ari(characters, words, sentences);
        fk(words, sentences, syllables);
        smog(polysyllables, sentences);
        cl(characters, words, sentences);
    }

    public static int getAge(double score) {
        int number = (int) Math.ceil(score);
        int result = 0;

        switch (number) {
            case 1:
                result = 5;
                break;
            case 2:
                result = 6;
                break;
            case 3:
                result = 7;
                break;
            case 4:
                result = 9;
                break;
            case 5:
                result = 10;
                break;
            case 6:
                result = 11;
                break;
            case 7:
                result = 12;
                break;
            case 8:
                result = 13;
                break;
            case 9:
                result = 14;
                break;
            case 10:
                result = 15;
                break;
            case 11:
                result = 16;
                break;
            case 12:
                result = 17;
                break;
            case 13:
                result = 18;
                break;
            default:
                result = 24;
                break;
        }
        return result;
    }

    public static int countSyllables(String word) {
        String vowels = "[aeiouAEIOU]";
        word = word.concat(" ");
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).matches(vowels)) {
                if (!String.valueOf(word.charAt(i + 1)).matches(vowels)) {
                    result++;
                }
            }
        }

        if (word.charAt(word.length() - 2) == 'e') {
            result--;
        }

        if (result == 0) {
            result = 1;
        }

        System.out.println(result);
        return result;
    }
}
