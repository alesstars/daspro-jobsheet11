import java.util.Scanner;

public class BankSampah01 {

    static double[] inputSetoran(int n, Scanner sc) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + ": ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double ... setoran) {
        System.out.println("\n=== DAFTAR SETORAN NASABAH ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + i + ": " + setoran[i] + " kg.");
        }
    }

    static double totalSetoran(double ... setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    static double hitungSaldo(double beratSetoran, int hargaPerKg) {
        return beratSetoran * hargaPerKg;
    }

    static int nasabahTerbanyak(double ... setoran) {
        int urutanTeratas = 0;
        for (int i = 0; i < setoran.length; i++) {
            if (setoran[i] > setoran[urutanTeratas]) {
                urutanTeratas = i;
            }
        }
        return urutanTeratas;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int hargaPerKg = 3000;

        System.out.print("Masukkan jumlah nasabah: ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n, sc);
        tampilSetoran(dataSetoran);

        System.out.println("\n=== SALDO TIAP NASABAH ===");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldoNasabah = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.println("Saldo nasabah ke-" + (i + 1) + ": Rp" + saldoNasabah);
        }

        double totalBerat = totalSetoran(dataSetoran);
        double totalSaldo = hitungSaldo(totalBerat, hargaPerKg);

        int urutanTeratas = nasabahTerbanyak(dataSetoran);

        System.out.println("\n====================");
        System.out.println("Total berat setoran: " + totalBerat + " kg.");
        System.out.println("Total saldo: Rp" + totalSaldo);
        System.out.println("Nasabah terbanyak: Nasabah ke-" + (urutanTeratas + 1) + " dengan setoran " + dataSetoran[urutanTeratas] + " kg.");

        sc.close();
    }
}
