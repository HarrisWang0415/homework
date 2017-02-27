import java.util.*;

class Number {
    private String num;

    public Number(String num) {
        this.num = num;
    }

    public String getNum() {
        return this.num;
    }
}

public class TestComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Number> numList = new ArrayList<Number>();
        for (int i = 0; i < 3; i++) {
            String num = scanner.next();
            numList.add(new Number(num));
        }

        //Anonymous Comparator
        System.out.println("=== Sorted Asc num ===");
        Collections.sort(numList, new Comparator<Number>() {
            public int compare(Number n1, Number n2) {
                return n1.getNum().compareTo(n2.getNum());
            }
        });
        printSortList(numList);

        //Lambda Comparator
        System.out.println("=== Sorted Asc num ===");
        Collections.sort(numList, (Number n1, Number n2) -> n1.getNum().compareTo(n2.getNum()));
        printSortList(numList);

        System.out.println("=== Sorted Desc num ===");
        Collections.sort(numList, (Number n1, Number n2) -> n2.getNum().compareTo(n1.getNum()));
        printSortList(numList);
    }

    public static void printSortList(List<Number> numList) {
        for (Number n : numList) {
            System.out.println(n.getNum());
        }
    }
}