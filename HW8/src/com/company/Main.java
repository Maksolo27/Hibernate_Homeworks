package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try(FileReader reader = new FileReader("C:\\Users\\maxim\\IdeaProjects\\jdbs\\HW8\\src\\Tariff.xml"))
        {
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
