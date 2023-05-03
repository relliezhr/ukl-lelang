import java.util.ArrayList;
import java.util.Scanner;

public class Lelang {
    private ArrayList<Integer> idPenawar = new ArrayList<Integer>();
    private ArrayList<Integer> idBarang = new ArrayList<Integer>();
    private ArrayList<Integer> hargaTawar = new ArrayList<Integer>();

    public void prosesLelang(Barang barang, Masyarakat masyarakat, Petugas petugas, Tabel tabel) {
        Scanner sc = new Scanner(System.in);
        boolean pelelangan = false;
        int idBarang = -1;
        String loop = "";
        // Looping until loop is equal to no
        while (true) {
            System.out.println("========================================");
            if (!pelelangan) {
                System.out.println("Pelelangan Belum Dibuka.");
            } else {
                System.out.println("Pelelangan Dibuka!");
                System.out.println("Barang yang akan dilelang: " + barang.getNama(idBarang));
                System.out.println("Harga Barang: " + barang.getHarga(idBarang));
            }
            System.out.println("----------------------------------------");

            System.out.print("1. Petugas\n2. Masyarakat\nLogin sebagai(1/2): ");
            int login = sc.nextInt();

            //if you login as "petugas"
            switch (login) {
                case 1 -> {
                    String logout = "";
                    while (!logout.equalsIgnoreCase("y")) {
                        System.out.println("========================================");
                        System.out.println("Selamat Datang " + petugas.getNama(0));
                        System.out.println("----------------------------------------");
                        System.out.print("1. Tampilkan Tabel Barang\n2. Tambah Barang\n3. Hapus Barang\n4. Mulai/Hentikan Pelelangan Barang\n5. Logout\nPilih Opsi: ");
                        int act = sc.nextInt();

                        switch (act) {
                            case 1 -> {
                                tabel.printTabelBarang(barang);
                            }

                            case 2 -> {
                                System.out.print("Nama Barang: ");
                                sc.nextLine();
                                barang.addNama(sc.next());
                                System.out.print("Harga Barang: ");
                                barang.addHarga(sc.nextInt());
                                barang.addStatus(true);
                            }

                            case 3 -> {
                                System.out.print("ID Barang: ");
                                barang.removeBarang(sc.nextInt());
                                System.out.println("Barang berhasil di hapus!");
                            }

                            case 4 -> {
                                System.out.print("Mulai (start) atau hentikan (stop) pelelangan barang: ");
                                String lelang = sc.next();
                                if (lelang.equalsIgnoreCase("start")) {
                                    if (idBarang > -1) {
                                        System.out.println("Pelelangan " + barang.getNama(idBarang) + " masih dimulai!");
                                        break;
                                    }
                                        pelelangan = true;
                                        tabel.printTabelBarang(barang);
                                        System.out.print("ID barang yang akan dilelang: ");
                                        idBarang = sc.nextInt();
                                        if (barang.getStatus(idBarang).equalsIgnoreCase("Tidak Bisa Ditawar")){
                                            System.out.println("Barang tidak bisa ditawar.");
                                            idBarang = -1;
                                            break;
                                        }
                                        System.out.println("Pelelangan " + barang.getNama(idBarang) + " dimulai!");
                                } else if (lelang.equalsIgnoreCase("stop")){
                                    if (!pelelangan) {
                                        System.out.println("Pelelangan masih ditutup.");
                                        break;
                                    }
                                        pelelangan = false;
                                        System.out.println("Pelelangan " + barang.getNama(idBarang) + " ditutup!");
                                        ArrayList<Object> penawarTertinggi = getPenawarTertinggi(idBarang, masyarakat, barang.getHarga(idBarang));
                                        if (!penawarTertinggi.get(1).equals(0)) {
                                            System.out.println(barang.getNama(idBarang) + " telah dijual kepada " +
                                                    penawarTertinggi.get(1) + " dengan harga " + penawarTertinggi.get(0));
                                            barang.setStatus(idBarang, false);
                                        }
                                        printTabelTransaksi(barang, masyarakat);
                                        idBarang = -1;
                                }
                            }

                            case 5 -> logout = "y";

                        }
                    }
                }


                // if you login as "masyarakat"
                case 2 -> {
                    String logout = "";
                    while (!logout.equalsIgnoreCase("y")) {
                        tabel.printTabelMasyarakat(masyarakat);
                        System.out.print("Apakah kamu terdaftar sebagai Masyarakat (Y/N): ");
                        String idMember = sc.next();

                        if (idMember.equalsIgnoreCase("N")) {
                            System.out.println("Silahkan input data diri anda!");
                            System.out.print("Input Nama: ");
                            String nama = sc.next();
                            System.out.print("Input Alamat: ");
                            String alamat = sc.next();
                            System.out.print("Input Telepon: ");
                            String telepon = sc.next();

                            masyarakat.addNama(nama);
                            masyarakat.addAlamat(alamat);
                            masyarakat.addTelepon(telepon);

                        } else {
                            if (!pelelangan) {
                                System.out.println("Pelelangan Belum Dibuka.");
                                break;
                            }

                            System.out.print("ID Masyarakat: ");
                            int id = sc.nextInt();

                            if (id > masyarakat.getJml()) {
                                System.out.println("ID yang anda masukkan tidak valid");
                                break;
                            }

                            System.out.println("========================================");
                            System.out.println("Selamat Datang " + masyarakat.getNama(id));
                            System.out.println("----------------------------------------");

                            ArrayList<Object> penawarTertinggi = getPenawarTertinggi(idBarang, masyarakat, barang.getHarga(idBarang));
                            System.out.println("Harga awal " + barang.getNama(idBarang) + " : " + barang.getHarga(idBarang));
                            System.out.println("Tawaran tertinggi saat ini Rp." + penawarTertinggi.get(0) + " atas nama " + penawarTertinggi.get(1));
                            System.out.print("Input harga tawar anda (harus lebih tinggi dari tawaran tertinggi): ");
                            int tawar = sc.nextInt();
                            addTransaksi(id, idBarang, tawar);

                            System.out.print("Logout(y/t)? ");
                            logout = sc.next();
                        }
                    }
                }


                default -> System.out.println("Input anda tidak valid");
            }

            System.out.print("Login ulang (yes) atau Logout (no): ");
            loop = sc.next();
            System.out.println();

            if (!loop.equalsIgnoreCase("yes")) {
                System.exit(0);
            }
        }
    }


    private void addTransaksi(int idPenawar, int idBarang, int hargaTawar) {
        this.idPenawar.add(idPenawar);
        this.idBarang.add(idBarang);
        this.hargaTawar.add(hargaTawar);
    }

    // Penawar dengan tawaran tertinggi
    private ArrayList<Object> getPenawarTertinggi(int idBarang, Masyarakat masyarakat, int hargaBarang) {
        int max = 0;
        String nama = "(belum ada)";
        ArrayList<Object> res = new ArrayList<>();
        for (int i = 0; i < this.idPenawar.size(); i++) {
            if (this.idBarang.get(i) == idBarang) {
                if(this.hargaTawar.get(i) > max && this.hargaTawar.get(i) > hargaBarang) {
                    max = hargaTawar.get(i);
                    nama = masyarakat.getNama(idPenawar.get(i));
                }
            }
        }
        res.add(max);
        res.add(nama);
        return res;
    }

    public int getIdBarang (int id){return this.idBarang.get(id);}

    public int getIdMasyarakat (int id){ return this.idPenawar.get(id);}

    public int getHargaTawar (int id){return this.hargaTawar.get(id);}

    public int getJmlLelang(){return this.idPenawar.size();}

    public void printTabelTransaksi (Barang barang, Masyarakat masyarakat){
        int x = getJmlLelang();
        System.out.println("========================================");
        System.out.println("Tabel Transaksi");
        System.out.println("----------------------------------------");
        System.out.println("Nama Barang\t|\tPenawar\t|\tHarga Tawar\t|");
        for (int i = 0; i < x; i++) {
            System.out.println(barang.getNama(this.idBarang.get(i)) + "\t\t|\t" + masyarakat.getNama(getIdMasyarakat(i)) + "\t|\t" + getHargaTawar(i) + "\t|");
        }
    }



}