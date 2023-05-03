public class Main {
    public static void main(String[] args) {
        Masyarakat masyarakat = new Masyarakat();
        Petugas petugas = new Petugas();
        Barang barang = new Barang();
        Tabel tabel = new Tabel();
        Lelang lelang = new Lelang();

        lelang.prosesLelang(barang, masyarakat, petugas, tabel);


    }
}