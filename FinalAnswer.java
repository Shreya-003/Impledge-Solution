import java.io.*;
import java.util.*;

class Compounds
{
    private TreeMap<String, Boolean> tree;
    private HashMap<String, Boolean> map;

    public Compounds()
    {
        // Initialize data structures for storing words

        this.tree = new TreeMap<>(new SortByDecreasingLength()); // TreeMap to store words in descending order of length
        
        this.map = new HashMap<>(); // HashMap for quick word lookup
    }

    public void readWords(String fileName) throws IOException
    {
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        // Read and store words from the file
        while ((line = br.readLine()) != null)
        {
            String word = line.trim();
            tree.put(word, true); // Store words in the TreeMap
            map.put(word, true); // Store words in the HashMap
        }
        br.close();
    }

    public String[] findLongestCompoundWords()
    {
        String[] ans = new String[2];
        boolean FirstLongest = false;
        boolean SecondLongest = false;

        // Iterate through the TreeMap (words sorted by length)
        for (Map.Entry<String, Boolean> entry : tree.entrySet())
        {
            String word = entry.getKey();

            if (check(word, map))
            {
                if (!FirstLongest)
                {
                    ans[0] = word;
                    FirstLongest = true;
                }
                else if (!SecondLongest)
                {
                    ans[1] = word;
                    SecondLongest = true;
                    break;
                }
            }
        }
        return ans; // Return the longest and second longest compound words
    }

    public boolean check(String s, HashMap<String, Boolean> map)
    {
        if (s.length() == 0)
        {
            return false;
        }

        if (s.length() == 1)
        {
            return map.containsKey(s); // Check if single-character word is in the map
        }

        // spliting the word into two parts and check if both parts are in the map
        for (int i = 1; i < s.length(); i++)
        {
            String first = s.substring(0, i);
            String second = s.substring(i);

            if (map.containsKey(first))
            {
                if (map.containsKey(second) || check(second, map))
                {
                    return true;
                }
            }
        }
        return false; // Word cannot be formed from smaller words
    }
}

class SortByDecreasingLength implements Comparator<String>
{
    public int compare(String a, String b)
    {
        return b.length() - a.length(); // Compare strings by their length in descending order
    }
}
//-------------------------------------------------------------

//Main Class

public class FinalAnswer
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();

        Compounds c = new Compounds();
        c.readWords(fileName);

        long startTime = System.currentTimeMillis();
    
        String[] requiredlongestCompoundWords = c.findLongestCompoundWords();
    
        long endTime = System.currentTimeMillis();

        // Print results and execution time

        System.out.println("Longest Compound Word is: " + requiredlongestCompoundWords[0]);
    
        System.out.println("Second Longest Compound Word is: " + requiredlongestCompoundWords[1]);
    
        System.out.println("Time required to complete the execution is: " + (endTime - startTime) + " milliseconds");
    }
}