import java.util.Scanner;

public class Kafe01 {

    public static void ubahNama(String nama) {
        nama = "Tamu";
        System.out.println("Di dalam fungsi: " + nama);
    } 

    public static int hitungTotalHarga01(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, String isMember) {
        int totalAwal = total;

        if (kodePromo.equals("DISKON50")) {
            total -= (total * 0.5);
            System.out.println("Selamat! Anda mendapatkan diskon 50%.");
        } else if (kodePromo.equals("DISKON30")) {
            total -= (total * 0.3);
            System.out.println("Selamat! Anda mendapatkan diskon 30%.");
        } else if (kodePromo.equalsIgnoreCase("-")) {
            System.out.println();
        } else {
            System.out.println("Kode promo invalid.");
        }

        if (isMember.equalsIgnoreCase("y")) {
            total -= (total * 0.1);
        }

        int besarDiskon = totalAwal - total;
        return besarDiskon;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = sc.nextLine();

        System.out.print("Apakah pelanggan adalah member? (y/n): ");
        String isMember = sc.nextLine();
        
        System.out.print("Jam kunjung pelanggan: ");
        int jamKunjung = sc.nextInt();
        System.out.println();

        Menu(namaPelanggan, isMember, jamKunjung);

        int totalBayar = 0, pilihanMenu;

        while (true) {
            do {
                System.out.print("\nMasukkan nomor menu yang ingin Anda pesan (ketik 0 untuk keluar): ");
                pilihanMenu = sc.nextInt();

                if (pilihanMenu == 0) {
                    break;
                }

                if (pilihanMenu < 1 || pilihanMenu > 6) {
                    System.out.println("Menu tidak tersedia.");
                }
            } while (pilihanMenu < 1 || pilihanMenu > 6);

            if (pilihanMenu == 0) {
                break;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            int subtotal = hitungTotalHarga01(pilihanMenu, banyakItem);
            totalBayar += subtotal;
        }

        sc.nextLine();
        System.out.print("\nMasukkan kode promo (ketik - jika tidak ada): ");
        String kodePromo = sc.nextLine();

        System.out.println("======================================");
        System.out.println("Total harga untuk pesanan Anda: Rp" + totalBayar);

        int besarDiskon = hitungDiskon(totalBayar, kodePromo, isMember);
        int totalAkhir = totalBayar - besarDiskon;

        System.out.println("Total harga   : Rp" + totalBayar);
        System.out.println("Besar diskon  : Rp" + besarDiskon);
        System.out.println("Total dibayar : Rp" + totalAkhir);

        sc.close();
    }

    

    public static void Menu(String namaPelanggan, String isMember, int jamKunjung) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember.equalsIgnoreCase("y")) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman.");
        }

        System.out.println("==== MENU RESTO KAFE ====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan.");
    }

    
}
