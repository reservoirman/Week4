import java.util.*;
import java.io.*;
import java.io.File;
import java.io.PrintWriter;

public class Main {

    static public void swap(int a, int b, ArrayList<String> list)
    {
        String temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    static void bubbleSort(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int k = i + 1; k < list.size(); k++)
            {
                if (list.get(i).compareTo(list.get(k)) > 0) {
                    swap(i, k, list);
                }
            }
        }
    }

    static void insertionSort(ArrayList<String> list)
    {
        for (int i = 1; i < list.size(); i++)
        {
            for (int k = i; k > 0; k--)
            {
                if (list.get(k - 1).compareTo(list.get(k)) > 0)
                {
                    swap(k - 1, k, list);
                }
            }
        }
    }

    static void mergeSort(List<String> list)
    {
        int n = list.size();
        int m = n / 2;
        mergeSort(list.subList(0, m));
        mergeSort(list.subList(m + 1, n - 1));

        ArrayList<String> b = new ArrayList<>(list.subList(0, m));
        int i = 0, j = m, k = 0;
        while (i <= m && j <= n)
        {
            if (list.get(j).compareTo(b.get(i)) < 0)
            {
                list.set(k, list.get(j));
                k++;
                j++;
            }
            else
            {
                list.set(k, b.get(i));
                k++;
                i++;
            }
        }
        while (i <= m)
        {
            list.set(k, b.get(i));
            k++;
            i++;
        }
    }

    static void sortPractice()
    {
        int [] array = {4,1,5,3,2};

        Arrays.sort(array);
        int index = Arrays.binarySearch(array, 3);
        System.out.println("3 is at: " + index);
        System.out.println(array);

        ArrayList<Integer> alist = new ArrayList<Integer>();
        alist.add(new Integer(4));
        alist.add(new Integer(8));
        alist.add(new Integer(3));
        boolean yes = alist.contains(new Integer(6));
        System.out.println(yes);
        System.out.println(alist);
        //alist.sort(Comparator.<Integer>naturalOrder());

        System.currentTimeMillis();

        Scanner scan;
        ArrayList<String> list = new ArrayList<>();
        try {  // Create the input stream.
           scan = new Scanner(new File("namelist.txt"));

        }
        catch (FileNotFoundException e) {
            System.out.println("Can't find file!  Please check the name and try again.");
            return;
        }
        while (scan.hasNextLine())
        {
            list.add(scan.nextLine());
        }

        PrintWriter writer;
        try {
            writer = new PrintWriter(new File("namelistduplicate.txt"));
        }
        catch (IOException e) {
            System.out.println("Can't open file for writing!  Please check the name and try again.");
            return;
        }

        mergeSort(list);

        for (String name : list)
        {
            writer.println(name);
        }

        writer.close();

        index = Collections.binarySearch(alist, new Integer(3));
        System.out.println("4 is at: " + index);
        Collections.sort(alist);
        index = Collections.binarySearch(alist, new Integer(3));
        System.out.println("4 is at: " + index);

        System.out.println(alist);
    }

    static void searchPractice()
    {

    }


    public static void main(String[] args) {
	// write your code here
        sortPractice();
    }
}
