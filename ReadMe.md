Longest Compound Word Finder

Overview :

This Java program identifies the longest and second longest compound words in a given list of words. It utilizes a TreeMap and a HashMap for efficient word storage and retrieval.

How to Run : 

1.	Compile the Code:
    •	Open your terminal.
    •	Navigate to the directory with the Java source code.
    •	Run javac FinalAnswer.java to compile the program.
2.	Execute the Program:
    •	Run java FinalAnswer to start the program.
    •	Enter the file name containing the list of words when prompted.
3.	View Results:
    •	The program will display the longest and second longest compound words found, along with the execution time.

Design and Approach :

The program uses a TreeMap for words sorted by length in descending order and a HashMap for efficient word lookup. The core algorithm recursively checks if a word can be formed from smaller words in the list, starting with the longest words. Execution time is measured using System.currentTimeMillis().