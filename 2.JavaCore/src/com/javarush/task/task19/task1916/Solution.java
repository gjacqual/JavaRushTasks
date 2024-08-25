package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static List<String> file1Lines = new ArrayList<String>();

    public static List<String> file2Lines = new ArrayList<String>();

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = console.readLine();
            String file2 = console.readLine();

            try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
                 BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

                while (br1.ready() || br2.ready()) {
                    if (br1.ready()) {
                        file1Lines.add(br1.readLine());
                    }
                    if (br2.ready()) {
                        file2Lines.add(br2.readLine());
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }

            int i = 0;
            int k = 0;
            Boolean sameFlag = false;
            for (String line : file1Lines) {
                if (file2Lines.size() > i) {
                    if (!sameFlag) {
                        if (line.equals(file2Lines.get(i))) {
                            lines.add(new LineItem(Type.SAME, line));
                            sameFlag = true;
                            k++;
                        }
                    } else {
                        if (!line.equals(file2Lines.get(i)) && line.equals(file2Lines.get(i + 1))) {
                            lines.add(new LineItem(Type.ADDED, file2Lines.get(i)));
                            lines.add(new LineItem(Type.SAME, line));
                            sameFlag = true;
                            i++;
                            k++;
                        } else if (file1Lines.get(k + 1).equals(file2Lines.get(i))) {
                            lines.add(new LineItem(Type.REMOVED, line));
                            sameFlag = false;
                            k++;
                            continue;
                        }
                    }
                } else {
                    lines.add(new LineItem(Type.REMOVED, line));
                    k++;
                }
                i++;
            }
            if (file2Lines.size() > i) {
                lines.add(new LineItem(Type.ADDED, file2Lines.get(file2Lines.size() - 1)));
            }
            for (LineItem item : lines) {
                System.out.printf("%s %s \n", item.type, item.line);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
