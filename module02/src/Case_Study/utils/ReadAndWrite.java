package Case_Study.utils;

import Case_Study.models.Facility;
import Case_Study.models.Villa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ReadAndWrite<T> {
    public List<String> readFile(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<Facility, Integer> aggregateByKeys(String filePath) {
        Map<Facility,Integer> map = new LinkedHashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.filter(line -> line.contains(","))
                    .forEach(line -> {
                        String[] tmp = line.split(",");
                        String code = tmp[0];
                        String fullName = tmp[1];
                        double areaUsed = Double.parseDouble(tmp[2]);
                        double cost = Double.parseDouble(tmp[3]);
                        int maxPeople = Integer.parseInt(tmp[4]);
                        ConstantUtil.RentType rentType = ConstantUtil.RentType.valueOf(tmp[5]);
                        ConstantUtil.RoomStandard roomStandard = ConstantUtil.RoomStandard.valueOf(tmp[6]);
                        double areaPool = Double.parseDouble(tmp[7]);
                        int numberOfFloor = Integer.parseInt(tmp[8]);

                        Villa villa = new Villa(code, fullName, areaUsed, cost,
                                maxPeople, rentType, roomStandard, areaPool, numberOfFloor);

                        map.put(villa, 0);
//                        String[] keyValuePair = line.split(",");
//                        String key = keyValuePair[0];
//                        String value = keyValuePair[1];
//                        if (map.containsKey(key)) {
//                            map.get(key).add(value);
//                        } else {
//                            map.put(key, Stream.of(value).collect(Collectors.toList()));
//                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    public void write(String path, List<T> list, boolean isAppend) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, isAppend));
            for (T obj : list) {
                writer.write(obj.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

