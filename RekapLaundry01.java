import java.util.Scanner;

public class RekapLaundry01 {

    static void inputBerat(Scanner sc, String[] layanan, String[] hari, int[][] data) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Masukkan berat untuk " + layanan[i] + ":");
            for (int j = 0; j < hari.length; j++) {
                System.out.print("  " + hari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(String[] layanan, int[] harga, String[] hari, int[][] data) {
        System.out.println("\n--- TABEL BERAT CUCIAN (KG) ---");
        System.out.printf("%-16s %-10s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%-10s", h);
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-16s %-10d", layanan[i], harga[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.printf("%-10d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int jumlah = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            jumlah += data[idxLayanan][j];
        }
        return jumlah;
    }

    static void layananTerberat(String[] layanan, int[][] data) {
        int idxMax = 0;
        int beratMax = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int totalSekarang = totalPerLayanan(data, i);
            if (totalSekarang > beratMax) {
                beratMax = totalSekarang;
                idxMax = i;
            }
        }

        System.out.println("\nLayanan terberat: " + layanan[idxMax] + " (" + beratMax + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int jumlahLayanan = data.length;
        int jumlahHari = data[0].length;

        int idxHariMax = 0;
        int totalHariMax = 0;

        for (int j = 0; j < jumlahHari; j++) {
            int totalHariIni = 0;
            for (int i = 0; i < jumlahLayanan; i++) {
                totalHariIni += data[i][j];
            }

            if (j == 0 || totalHariIni > totalHariMax) {
                totalHariMax = totalHariIni;
                idxHariMax = j;
            }
        }

        return idxHariMax;
    }

    static void tampilPendapatan(String[] layanan, int[] harga, int[][] data) {
        int totalPendapatan = 0;
        System.out.println("\n--- PENDAPATAN ---");

        for (int i = 0; i < layanan.length; i++) {
            int kg = totalPerLayanan(data, i);
            int pendapatan = kg * harga[i];
            totalPendapatan += pendapatan;
            System.out.println(layanan[i] + ": Rp" + pendapatan);
        }

        System.out.println("Total pendapatan: Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jumlah layanan: ");
        int jmlLayanan = sc.nextInt();
        System.out.print("Jumlah hari: ");
        int jmlHari = sc.nextInt();
        sc.nextLine(); // buang sisa Enter

        String[] layanan = new String[jmlLayanan];
        int[] harga = new int[jmlLayanan];
        String[] hari = new String[jmlHari];
        int[][] data = new int[jmlLayanan][jmlHari];

        for (int i = 0; i < jmlLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga/kg: ");
            harga[i] = sc.nextInt();
            sc.nextLine(); // buang sisa Enter
        }

        for (int j = 0; j < jmlHari; j++) {
            hari[j] = "Hari ke-" + (j + 1);
        }

        inputBerat(sc, layanan, hari, data);
        tampilTabel(layanan, harga, hari, data);

        System.out.println("\n--- TOTAL KG PER LAYANAN ---");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        layananTerberat(layanan, data);

        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxSibuk]);

        tampilPendapatan(layanan, harga, data);

        sc.close();
    }
}