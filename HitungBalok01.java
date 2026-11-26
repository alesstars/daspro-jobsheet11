import java.util.Scanner;

public class HitungBalok01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int p, l, t, L, vol, Lp, jmlBalok;

        System.out.print("Masukkan jumlah balok: ");
        jmlBalok = sc.nextInt();

        for (int i = 1; i <= jmlBalok; i++) {
            System.out.println("PERSEGI KE-" + i);

            System.out.print("Masukkan panjang: ");
            p = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            l = sc.nextInt();
            System.out.print("Masukkan tinggi: ");
            t = sc.nextInt();

            L = hitungLuas(p, l);
            System.out.println("Luas persegi panjang ke-" + i + " adalah " +  L);

            vol = hitungVolume(t, p, l);
            System.out.println("Volume balok ke-" + i + " adalah " + vol);

            Lp = hitungLuasPermukaanBalok(p, l, t);
            System.out.println("Luas permukaan balok ke-" + i + " adalah: " + Lp);
        }

        sc.close();

    }

    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        int luasPermukaan = 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(t, l));
        return luasPermukaan;
    }
}
