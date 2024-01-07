package Practical_20;

import Practical_20.SierpinskiCarpet;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SierpinskiTest {

    //TODO: fix file finding? intellij cannot find the files despite them being in a test resources folder

    // Compare to text files given in SierpinskiCarpet.zip
    public void testCarpet(int n){
        char[][] test = SierpinskiCarpet.generateSierpinskiCarpet(n);

        int size = (int) Math.pow(3, n);
        char[][] document = new char[size][size];

        try{

            File testFile = new File("Sierpinski_Carpet_"+size+".txt");
            Scanner s = new Scanner(testFile);

            int currLine = 0;

            while(s.hasNextLine()){
                char[] line = s.nextLine().toCharArray();
                document[currLine] = line;
                currLine++;
            }

        }catch(FileNotFoundException e){
            fail("Test file not found for that value of n:" + n);
        }

        assertEquals(test, document);
    }

    // Compare to text files given in SierpinskiCarpetLevel.zip
    public void testCarpetLevels(int n){
        char[][] test = SierpinskiCarpet.generateSierpinskiCarpetLevels(n);

        int size = (int) Math.pow(3, n);
        char[][] document = new char[size][size];

        try{

            File testFile = new File("Sierpinski_Carpet_Levels_"+size+".txt");
            Scanner s = new Scanner(testFile);

            int currLine = 0;

            while(s.hasNextLine()){
                char[] line = s.nextLine().toCharArray();
                document[currLine] = line;
                currLine++;
            }

        }catch(FileNotFoundException e){
            fail("Test file not found for that value of n:" + n);
        }

        assertEquals(test, document);
    }

    @Test
    public void test1(){
        testCarpet(1);
    }

    @Test
    public void test2(){
        testCarpet(2);
    }

    @Test
    public void test3(){
        testCarpet(3);
    }

    @Test
    public void test4(){
        testCarpet(4);
    }

    @Test
    public void test5(){
        testCarpet(5);
    }

    @Test
    public void test1withlevels(){
        testCarpetLevels(1);
    }

    @Test
    public void test2withlevels(){
        testCarpetLevels(2);
    }

    @Test
    public void test3withlevels(){
        testCarpetLevels(3);
    }

    @Test
    public void test4withlevels(){
        testCarpetLevels(4);
    }

    @Test
    public void test5withlevels(){
        testCarpetLevels(5);
    }

}
