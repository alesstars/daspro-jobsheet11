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

        double r, t, La, Lp, volKrct, volTbg;

        System.out.print("Masukkan jari-jari alas: ");
        r = sc.nextDouble();

        System.out.print("Masukkan tinggi kerucut: ");
        t = sc.nextDouble();

        La = luasLingkaran(r);
        System.out.println("Luas alas adalah " + La);

        Lp = luasPermukaanTabung(r, t);
        System.out.println("Luas permukaan tabung adalah " + Lp);

        volKrct = volumeKerucut(r, t);
        System.out.println("Volume kerucut adalah " + volKrct);

        volTbg = volumeTabung(r, t);
        System.out.println("Volume tabung adalah " + volTbg);

        sc.close();
    }
}
