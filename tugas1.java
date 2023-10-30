import java.util.Scanner;

public class tugas1 {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Masukkan banyaknya elemen: ");
    int n = scanner.nextInt();

    int[] array = new int[n];

    // Input nilai tiap elemen
    for (int i = 0; i < n; i++) {
        System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
        array[i] = scanner.nextInt();
    }

    // Mencari nilai tertinggi
    int max = array[0];
    for (int i = 1; i < n; i++) {
        if (array[i] > max) {
            max = array[i];
        }
    }

    // Mencari nilai terendah
    int min = array[0];
    for (int i = 1; i < n; i++) {
        if (array[i] < min) {
            min = array[i];
        }
    }

    // Menghitung nilai rata-rata
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += array[i];
    }
    double average = (double) sum / n;

    // Menampilkan hasil
    System.out.println("Nilai tertinggi: " + max);
    System.out.println("Nilai terendah: " + min);
    System.out.println("Nilai rata-rata: " + average);

}

}