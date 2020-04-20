/**
 * Реализовал следующую логику:
 * 1) программе передается некоторое количество int;
 * 2) последний является искомым числом;
 * 3) остальные являются элементами массива, который сортируется,
 * в нем же происходит бинарный поиск искомого числа.
 * <p>
 * В случае, если я не совсем корректно понял условие, прошу уточнить,
 * каким образом будут передаваться входные данные.
 */

public class Main {

    public static void main(String[] args) {

        int[] mas = new int[args.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Integer.valueOf(args[i]);
        }

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 2; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }

        for (int i = 0; i < mas.length - 1; i++) {
            System.out.println(mas[i]);
        }

        binarySearch(mas, mas.length - 2, mas[mas.length - 1]);
    }

    public static void binarySearch(int[] array, int last, int item) {
        int position;
        int first = 0;

        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {
            if (array[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " - искомое число");
        } else {
            System.out.println("В массиве нет числа " + item);
        }
    }

}
