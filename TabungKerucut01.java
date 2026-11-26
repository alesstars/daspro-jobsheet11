import java.util.Scanner;

public class TabungKerucut01 {

    static double luasLingkaran(double r) {
        double luas = 3.14 * r * r;
        return luas;
    }

    static double volumeTabung(double r, double t) {
        double volTabung = 3.14 * r * r * t;
        return volTabung;
    }

    static double luasPermukaanTabung(double r, double t) {
        double luasPermukaan = 2 * 3.14 * r * (r + t);
        return luasPermukaan;
    }

    static double volumeKerucut(double r, double t) {
        double volKerucut = volumeTabung(r, t) / 3;
        return volKerucut;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double r = 0, t = 0, La, Lp, volKrct, volTbg;
        int menu;

        System.out.println("========================");
        System.out.println("1. Menghitung luas lingkaran");
        System.out.println("2. Menghitung volume tabung");
        System.out.println("3. Menghitung luas permukaan tabung");
        System.out.println("4. Menghitung volume kerucut");
        System.out.println("0. Keluar");
        System.out.println("========================");

        while (true) {
            do {
                System.out.print("\nMasukkan menu perhitungan: ");
                menu = sc.nextInt();

                if (menu == 0) {
                    break;
                }

                if (menu < 1 || menu > 4) {
                    System.out.println("Menu tidak tersedia.");
                }
            } while (menu < 1 || menu > 4);

            if (menu == 0) {
                System.out.println("Program dihentikan.");
                break;
            }

            System.out.print("Masukkan jari-jari lingkaran: ");
            r = sc.nextDouble();

            if (menu == 1) {
                La = luasLingkaran(r);
                System.out.println("Luas lingkaran adalah " + La);
            } else if (menu == 2) {
                System.out.print("Masukkan tinggi bangun ruang: ");
                t = sc.nextDouble();

                volTbg = volumeTabung(r, t);
                System.out.println("Volume tabung adalah " + volTbg);
            } else if (menu == 3) {
                System.out.print("Masukkan tinggi bangun ruang: ");
                t = sc.nextDouble();

                Lp = luasPermukaanTabung(r, t);
                System.out.println("Luas permukaan tabung adalah " + Lp);
            } else if (menu == 4) {
                System.out.print("Masukkan tinggi bangun ruang: ");
                t = sc.nextDouble();

                volKrct = volumeKerucut(r, t);
                System.out.println("Volume kerucut adalah " + volKrct);
            }
        }

        sc.close();
    }
}