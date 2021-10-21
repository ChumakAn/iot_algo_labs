import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Reader {

    public static int numberOfEdges;
    public static int source;
    static List<Integer> listOfNodes = new ArrayList<>();
    static List <Integer> dataForAdj = new ArrayList<>();
    public static void readFromFile(String DIJKSTRA_IN){
        List<Integer> arrayList = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DIJKSTRA_IN));
            String line = bufferedReader.readLine();
            for (String number : line.split(" ")) {
                arrayList.add(Integer.parseInt(number));
            }
            int[] list = arrayList.stream().mapToInt(Integer::intValue).toArray();
            numberOfEdges = list[0];
            source = list[1];

            line = bufferedReader.readLine();
            while (line!= null){
                int[] splitInts = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                listOfNodes.add(splitInts[0]);
                listOfNodes.add(splitInts[1]);
                for (int number: splitInts){
                    dataForAdj.add(number);
                }
                line = bufferedReader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int countDistinct()
    {
        Integer[] arr = new Integer[Reader.listOfNodes.size()];
        arr = Reader.listOfNodes.toArray(arr);
        int res = 1;
        for (int i = 1; i < arr.length; i++)
        {
            int j = 0;
            for (j = 0; j < i; j++)
                if (arr[i].equals( arr[j]))
                    break;
            if (i == j)
                res++;
        }
        return res;
    }

}
