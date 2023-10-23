package com.royals.hairstylegirls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HairStyleList {

    private final String[] EASY = new String[16];
    private final String[] PARTY = new String[16];
    private final String[] SCHOOL = new String[16];
    private final String[] SHORT = new String[16];
    private final String[] WORK = new String[16];

    public HairStyleList() {
        for (int i = 0; i < 16; i++) {
            int num = i + 1;
            EASY[i] = "easy" + num + ".webp";
        }
        for (int i = 0; i < 16; i++) {
            int num = i + 1;
            PARTY[i] = "party" + num + ".webp";
        }
        for (int i = 0; i < 16; i++) {
            int num = i + 1;
            SCHOOL[i] = "school" + num + ".webp";
        }
        for (int i = 0; i < 16; i++) {
            int num = i + 1;
            SHORT[i] = "short" + num + ".webp";
        }
        for (int i = 0; i < 16; i++) {
            int num = i + 1;
            WORK[i] = "work" + num + ".webp";
        }
    }

    public String[] getEasy() {
        return EASY;
    }

    public String[] getParty() {
        return PARTY;
    }

    public String[] getSchool() {
        return SCHOOL;
    }

    public String[] getShort() {
        return SHORT;
    }

    public String[] getWork() {
        return WORK;
    }

    public List<String> getFavorite() {
        String[][] list = new String[][]{EASY,PARTY,SCHOOL,SHORT,WORK};
        List<String> favList = new ArrayList<>();
        for (String[] item : list) {
            Collections.addAll(favList, item);
        }
        return favList;
    }

    public List<String> getSlider() {
        String[][] list = new String[][]{EASY,PARTY,SCHOOL,SHORT,WORK};
        List<String> sliders = new ArrayList<>();
        List<String> slider = Arrays.asList(list[new Random().nextInt(list.length)]);
        Collections.shuffle(slider);
        for (int i = 0; i < 6; i++) {
            sliders.add(slider.get(i));
        }
        return sliders;
    }
}
