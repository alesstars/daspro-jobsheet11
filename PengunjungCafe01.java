public class PengunjungCafe01 {

    static void daftarPengunjung(int nomorMeja, String ...namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung Meja " + nomorMeja + ":");
        for (String tamu : namaPengunjung) {
            System.out.println("- " + tamu);
        }
    }

    public static int hitungTotalBelanja(int ... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        String[] tamu = {"Ali" , "Budi", "Citra"};
        daftarPengunjung(3, tamu);
        daftarPengunjung(7, "Doni", "Eti", "Fahmi", "Galih");

        System.out.println();

        int argumen1 = hitungTotalBelanja(15000);
        System.out.println("Total harga belanja (1 argumen): Rp" + argumen1);
        
        int argumen3 = hitungTotalBelanja(15000, 20000, 12000);
        System.out.println("Total harga belanja (3 argumen): Rp" + argumen3);

        int argumen5 = hitungTotalBelanja(15000, 20000, 12000, 10000, 18000);
        System.out.println("Total harga belanja (5 argumen): Rp" + argumen5);
    }
}
