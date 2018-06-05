package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> getResultArray(ArrayList<Integer> arrayList, Integer arraySize){
        ArrayList<Integer> arrayListResults = new ArrayList<>(arraySize);
        arrayListResults.addAll(arrayList);
        Integer result;
        for (Integer element : arrayList) {
            if (element % 3 == 0) {
                result = element / 3;
                arrayListResults.set(arrayList.indexOf(element),result);
                if (result < arraySize) arrayListResults.set(result,0);
            } else
                if(arrayListResults.get(arrayList.indexOf(element))!=0) arrayListResults.set(arrayList.indexOf(element),element);
        }
        return arrayListResults;
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("You can press q for exit");
            System.out.println("--------------------------------------------");
            System.out.println("Enter some numbers via space and press ENTER");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String testString = bufferedReader.readLine();
            if(testString.equalsIgnoreCase("q")) return;
            ArrayList<Integer> arrayList = new ArrayList<>();

            try {
                for (String s : testString.split(" ")) {
                    arrayList.add(Integer.parseInt(s));
                }
                ArrayList<Integer> arrayListResult = getResultArray(arrayList, arrayList.size());
                System.out.println(arrayListResult.toString());
            } catch (Exception e) {
                System.out.println("You enter wrong data!");
            }

        }

    }
}
