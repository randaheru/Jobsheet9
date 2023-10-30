import java.util.Scanner;

public class peminjaman7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama peminjam: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM peminjam: ");
        String NIM = input.nextLine();
        System.out.print("Masukkan jumlah buku yang ingin dipinjam: ");
        int jumlahBuku = input.nextInt();
        input.nextLine(); // Consume the newline character

        String[] namaBuku = new String[jumlahBuku];
        int[] hariLamaPnjm = new int[jumlahBuku];
        int[] blnLamaPnjm = new int[jumlahBuku];
        int[] thnLamaPnjm = new int[jumlahBuku];
        int[] tglpnjm = new int[jumlahBuku];
        int[] blnpnjm = new int[jumlahBuku];
        int[] thnpnjm = new int[jumlahBuku];
        int[] tglkmbl = new int[jumlahBuku];
        int[] blnkmbl = new int[jumlahBuku];
        int[] thnkmbl = new int[jumlahBuku];

        int totalDenda = 0; // Variabel untuk menyimpan total denda keseluruhan

        for (int i = 0; i < jumlahBuku; i++) {
            System.out.print("\nMasukkan nama buku ke-" + (i + 1) + ": ");
            namaBuku[i] = input.nextLine();
            System.out.print("Lama meminjam (DD): ");
            hariLamaPnjm[i] = input.nextInt();
            System.out.print("Lama meminjam (MM): ");
            blnLamaPnjm[i] = input.nextInt();
            System.out.print("Lama meminjam (YYYY): ");
            thnLamaPnjm[i] = input.nextInt();
            System.out.print("Tanggal peminjaman (DD): ");
            tglpnjm[i] = input.nextInt();
            System.out.print("Tanggal pengembalian (MM): ");
            blnpnjm[i] = input.nextInt();
            System.out.print("Tanggal pengembalian (YYYY): ");
            thnpnjm[i] = input.nextInt();
            System.out.print("Tanggal pengembalian (DD): ");
            tglkmbl[i] = input.nextInt();
            System.out.print("Tanggal pengembalian (MM): ");
            blnkmbl[i] = input.nextInt();
            System.out.print("Tanggal pengembalian (YYYY): ");
            thnkmbl[i] = input.nextInt();
            input.nextLine(); // Consume the newline character

            int hariTerlambat = tglkmbl[i] - (tglpnjm[i] + hariLamaPnjm[i]);
            int bulanTerlambat = blnkmbl[i] - (blnpnjm[i] + blnLamaPnjm[i]);
            int tahunTerlambat = thnkmbl[i] - (thnpnjm[i] + thnLamaPnjm[i]);

            if (tahunTerlambat > 0 || bulanTerlambat > 0 || hariTerlambat > 0) {
                int totalHariTerlambat = tahunTerlambat * 365 + bulanTerlambat * 30 + hariTerlambat;
                int denda = totalHariTerlambat * 500;
                totalDenda += denda; // Menambahkan denda buku saat ini ke total denda keseluruhan
                System.out.println("Anda terkena denda keterlambatan sebesar: " + denda);
                System.out.println("\n=======INFORMASI LENGKAP=======");
                System.out.println("Buku ke-" + (i + 1) + ": " + namaBuku[i]);
                System.out.println("Total Denda: " + denda);
            } else {
                System.out.print("\n=======INFORMASI LENGKAP======= \nBuku ke-" + (i + 1) + ": " + namaBuku[i] + "\nBuku Berhasil Dikembalikan");
            }
        }

        System.out.println("\n=======INFORMASI LENGKAP=======\nNAMA : " +nama+ "\nNIM : " +NIM+ "\nJUMLAH BUKU" +jumlahBuku+ "\nTOTAL DENDA : " +totalDenda);
        if (totalDenda > 0) {
            System.out.println("\nTotal denda keseluruhan: " + totalDenda);
            System.out.print("Apakah anda ingin membayar denda? (ya/tidak): ");
            String jawaban = input.next();

            if (jawaban.equalsIgnoreCase("ya")) {
                System.out.print("Masukkan nominal pembayaran anda: ");
                int bayar = input.nextInt();

                while (bayar < totalDenda) {
                    System.out.println("Nominal pembayaran anda tidak mencukupi, silahkan masukkan nominal yang mencukupi");
                    System.out.print("Masukkan nominal pembayaran anda: ");
                    bayar = input.nextInt();
                }
                if (bayar > totalDenda) {
                    double kembalian = bayar - totalDenda;
                    System.out.println("Kembalian anda adalah: " + kembalian);
                } else {
                    System.out.print("Uang anda pas, ");
                }
                System.out.println("Buku berhasil dikembalikan");
            } else if (jawaban.equalsIgnoreCase("tidak")) {
                System.out.println("Anda memilih untuk tidak membayar denda");
                System.out.println("Buku berhasil dikembalikan");
            } else {
                System.out.println("Input tidak valid, Buku berhasil dikembalikan tanpa pembayaran");
            }
        }
        System.out.print("Masukkan judul buku yang ingin dicari: ");
        String judulCari = input.next();

        // Search for the book title within the namaBuku array
        boolean bookFound = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (namaBuku[i].equalsIgnoreCase(judulCari)) {
                System.out.println("Buku ditemukan di indeks: " + i);
                System.out.println("Judul Buku: " + namaBuku[i]);
                bookFound = true;
                break; // Stop searching after finding the first match
            }
        }

        if (!bookFound) {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}