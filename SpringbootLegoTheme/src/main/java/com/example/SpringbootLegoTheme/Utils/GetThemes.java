package com.example.SpringbootLegoTheme.Utils;

import com.example.SpringbootLegoTheme.Entity.LegothemeEntity;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetThemes {

    private static List<LegothemeEntity> themes = new ArrayList<>();

    public static void loadThemes() {
        try {
            File file = new File("themes.csv");
            Scanner sc = new Scanner(file);
            String nextLine = sc.nextLine();
            while (sc.hasNextLine()) {
                String skipLine = sc.nextLine();
                String[] lineParts = skipLine.split(",");
                if (lineParts.length == 2) {
                    lineParts = outOfBounds(lineParts);
                }
                themes.add(new LegothemeEntity(Integer.parseInt(lineParts[0]) ,lineParts[1], Integer.parseInt(lineParts[2])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static String[] outOfBounds(String[] arr) {

        String[] newArr = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[2] = "0";
        return newArr;
    }

    public static List<LegothemeEntity> getThemeList() {
        loadThemes();
        return themes;
    }
}
