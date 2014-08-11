package net.sldt_team.assetsManager.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProjectManager {

    public static Map<String, String> getProjectInfos(String file) {
        File f = new File(file);
        if (f.exists()) {
            Map<String, String> prjMap = new HashMap<String, String>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] command = line.split(">");
                    System.out.println(line);
                    if (command.length == 2) {
                        prjMap.put(command[0], command[1]);
                    }
                }
                reader.close();
                return prjMap;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void saveProjectInfos(String file, Map<String, String> prjMap) {
        File f = new File(file);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            for (Map.Entry entry : prjMap.entrySet()) {
                String k = (String) entry.getKey();
                String v = (String) entry.getValue();

                writer.write(k + ">" + v);
                writer.newLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
