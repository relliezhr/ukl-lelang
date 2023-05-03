public class Tabel {
    public void printTabelBarang(Barang barang) {
        System.out.println("========================================");
        System.out.println("Tabel Barang");
        System.out.println("----------------------------------------");
        System.out.println("ID\t|\tNama\t|\tHarga\t\t|\tStatus\t\t\t\t|");
        int x = barang.getJmlBarang();
        for (int i = 0; i < x; i++) {
            System.out.println(i + "\t|\t" + barang.getNama(i) + "\t|\t" + barang.getHarga(i) + "\t|\t" + barang.getStatus(i) + "\t|");
        }
    }

    public void printTabelMasyarakat(Masyarakat masyarakat) {
        System.out.println("========================================");
        System.out.println("Tabel Masyarakat");
        System.out.println("----------------------------------------");
        System.out.println("ID\t|\tNama\t|\tAlamat\t|\tTelepon\t\t\t|");
        int x = masyarakat.getJml();
        for (int i = 0; i < x; i++) {
            System.out.println(i + "\t|\t" + masyarakat.getNama(i) + "\t|\t" + masyarakat.getAlamat(i) + "\t|\t" + masyarakat.getTelepon(i) + "\t\t|");
        }
    }




}