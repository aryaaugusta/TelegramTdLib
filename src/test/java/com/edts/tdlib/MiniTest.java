package com.edts.tdlib;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class MiniTest {


    public static void main(String[] args) throws ParseException, IOException {


        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        //remove all elements from second list
        listTwo.removeAll(listOne);

        System.out.println(listTwo);


        /*String test = "aaa #bbbb# cccc #ddd# ee #ff#";
        AtomicInteger index = new AtomicInteger();
        AtomicInteger limit = new AtomicInteger();

        StringBuilder stringBuilder = new StringBuilder();

        test.codePoints().mapToObj(Character::toString).forEach(s -> {
            index.getAndIncrement();
            if (s.equals("#")) {
                limit.getAndIncrement();

                System.out.println("" + s + " - " + index + " - " + limit);

                stringBuilder.append(index.get());
                if (limit.get() == 1) {
                    stringBuilder.append(",");
                } else {
                    stringBuilder.append("#");
                }


                if (limit.get() == 2) {

                    limit.getAndSet(0);
                }
            }
        });


        System.out.println(stringBuilder.toString());
        String[] splitString = stringBuilder.toString().split("#");

        String[] integerStrings = new String[splitString.length];

        List<String> attributes = new ArrayList<>();

        for (int i = 0; i < splitString.length; i++) {
            String tmp = splitString[i].toString();
            System.out.println(tmp.split(",")[0] + " - " + tmp.split(",")[1]);
            String tmpAttr = test.substring(Integer.parseInt(tmp.split(",")[0]), Integer.parseInt(tmp.split(",")[1]) - 1);
            attributes.add(tmpAttr);
        }
        attributes.forEach(a ->{
            System.out.println("attributes : " + a);
        });
*/
        // System.out.println(integerStrings[0]);

        /*String dayFromStart = "THU";
        String dayFromExe = "FRI";

        System.out.println(dayFromStart.toUpperCase());


        String daysValue[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        System.out.println(Arrays.stream(daysValue).filter(s -> dayFromStart.equals(s))
                .findFirst().orElse(""));


        int dayStart = IntStream.range(0, daysValue.length)
                .filter(i -> dayFromStart.equals(daysValue[i]))
                .findFirst()
                .orElse(-1);

        int dayExe = IntStream.range(0, daysValue.length)
                .filter(i -> dayFromExe.equals(daysValue[i]))
                .findFirst()
                .orElse(-1);

        int max = 6;
        int fromMax = max - dayStart;

        int startDayExe = 0;
        if (dayStart < dayExe) {
            startDayExe = dayExe - dayStart;
        } else {
            startDayExe = fromMax + dayExe + 1;
        }

        System.out.println("day start : " + dayStart);
        System.out.println("day exe : " + dayExe);


        System.out.println("from max :" + fromMax);

        System.out.println("start day exe : " + startDayExe);

*/


        /*String s = "message_image/8f4816f6-4226-412f-9350-ba241d2ea6e5.jpg";

        String ss [] = s.split("/");
        String xx = FileUtil.getExtensionByStringHandling(s).get();

        System.out.println(ss[1]);*/

        //String rrr = "test **bold** \ntest __italic__";

        /*String sss = "test bold _puguh_";

        String qqq = sss.replaceAll("_", "");
        qqq = qqq.replaceAll("\\*", "");
        System.out.println(qqq);


        List<Integer> integerList = new ArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicInteger h = new AtomicInteger();

        AtomicInteger a = new AtomicInteger();

        List<Map<Integer, Integer>> maps = new ArrayList<>();


        sss.codePoints().mapToObj(Character::toString).forEach(k -> {
            atomicInteger.getAndIncrement();
            if (k.equals("_")) {
                a.getAndIncrement();
                int ll = a.get() % 2;

                h.getAndIncrement();
                if (h.get() == 1) {
                    int s = atomicInteger.get() - 1;

                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(s, a.get() - 1);
                    maps.add(map);

                    integerList.add(s);
                    h.set(0);
                }

            }
        });

        AtomicInteger g = new AtomicInteger();
        AtomicInteger oo = new AtomicInteger(0);

        StringBuilder stringBuilder = new StringBuilder();

        AtomicInteger end = new AtomicInteger();
        integerList.forEach(s -> {
            end.getAndIncrement();
            g.getAndIncrement();
            int ll = g.get() % 2;
            if (ll != 0) {

                Map<Integer, Integer> map = maps.get(end.get() - 1);
                int dec = map.get(s);

                stringBuilder.append(s - dec + ",");
                oo.getAndSet(s + 1);
            }
            if (ll == 0) {
                int u = s - oo.get();
                stringBuilder.append(u);
                if (end.get() < integerList.size()) {
                    stringBuilder.append("#");
                }
            }
        });


        String toEntities[] = stringBuilder.toString().split("#");
        TdApi.TextEntity[] textEntities = new TdApi.TextEntity[toEntities.length];

        int num = 0;
        for (String item : toEntities) {

            String offsetLength[] = item.split(",");
            TdApi.TextEntityType textEntityTypeBold = new TdApi.TextEntityTypeItalic();
            TdApi.TextEntity textEntity = new TdApi.TextEntity(Integer.parseInt(offsetLength[0]), Integer.parseInt(offsetLength[1]), textEntityTypeBold);
            textEntities[num] = textEntity;
            num++;
        }

        System.out.println(textEntities.length);*/


        /*String sss = "test bold __puguh__ hoe ! jjjj **tri**";

        String qqq = sss.replaceAll("\\*", "");
        System.out.println(qqq);


        List<Integer> integerList = new ArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicInteger h = new AtomicInteger();

        AtomicInteger a = new AtomicInteger();

        List<Map<Integer, Integer>> maps = new ArrayList<>();


        sss.codePoints().mapToObj(Character::toString).forEach(k -> {
            atomicInteger.getAndIncrement();
            if (k.equals("*")) {
                a.getAndIncrement();
                int ll = a.get() % 2;

                h.getAndIncrement();
                if (h.get() == 2) {
                    int s = atomicInteger.get() - 2;

                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(s, a.get() - 2);
                    maps.add(map);

                    integerList.add(s);
                    h.set(0);
                }

            }
        });

        AtomicInteger g = new AtomicInteger();
        AtomicInteger oo = new AtomicInteger(0);

        StringBuilder stringBuilder = new StringBuilder();

        AtomicInteger end = new AtomicInteger();
        integerList.forEach(s -> {
            end.getAndIncrement();
            g.getAndIncrement();
            int ll = g.get() % 2;
            if (ll != 0) {

                Map<Integer, Integer> map = maps.get(end.get()-1);
                int dec = map.get(s);

                stringBuilder.append(s - dec + ",");
                oo.getAndSet(s + 2);
            }
            if (ll == 0) {
                int u = s - oo.get();
                stringBuilder.append(u);
                if (end.get() < integerList.size()) {
                    stringBuilder.append("#");
                }
            }
        });


        String toEntities[] = stringBuilder.toString().split("#");
        TdApi.TextEntity[] textEntities = new TdApi.TextEntity[toEntities.length];

        int num = 0;
        for (String item : toEntities) {

            String offsetLength[] = item.split(",");
            TdApi.TextEntityType textEntityTypeBold = new TdApi.TextEntityTypeBold();
            TdApi.TextEntity textEntity = new TdApi.TextEntity(Integer.parseInt(offsetLength[0]), Integer.parseInt(offsetLength[1]), textEntityTypeBold);
            textEntities[num] = textEntity;
            num++;
        }

        System.out.println(textEntities.length);*/

      /*  LocalDate localDate = LocalDate.fromDateFields(new Date());
        int m = localDate.getMonthOfYear();
        int y = localDate.getYear();
        System.out.println(m +"-"+ y);

       String s =   GeneralUtil.dateToStr(new Date(), "MM/yyyy");

        System.out.println(s);*/

        /*long ut2 = System.currentTimeMillis() / 1000L;
        System.out.println(ut2);

        Date now = new Date();
        long ut3 = now.getTime() / 1000L;
        System.out.println(ut3);

        Date nowNext = GeneralUtil.strToDate("2021-03-29 20:31:00","yyyy-MM-dd HH:mm:ss");
        long ut4 = nowNext.getTime() / 1000L;
        System.out.println(ut4);*/


    }
}
