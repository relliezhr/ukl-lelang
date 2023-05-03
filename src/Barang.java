import java.util.ArrayList;
public class Barang {

    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<Integer> harga = new ArrayList<Integer>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();
    public Barang() {
        nama.add("Diamond");
        harga.add(10_000_000);
        status.add(true);

        nama.add("Gold");
        harga.add(20_000_000);
        status.add(true);
    }

    public void removeBarang(int id) {
        nama.remove(id);
        harga.remove(id);
        status.remove(id);
    }

    public int getJmlBarang(){return nama.size();}
    public String getNama(int id) {return nama.get(id);}

    public void addNama(String n) {
        nama.add(n);
    }

    public int getHarga(int id) {
        return harga.get(id);
    }

    public void addHarga(int n) {
        harga.add(n);
    }

    public String getStatus(int id) {
        if ( status.get(id) == true){
            return "Bisa Ditawar\t";
        }else{
            return "Tidak Bisa Ditawar";
        }
    }

    public void addStatus(boolean n) {
        status.add(n);
    }

    public void setStatus(int id, boolean n) {
        status.set(id, n);
    }


}