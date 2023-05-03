import java.util.ArrayList;

public class Petugas implements User {
    private ArrayList<String> nama =  new ArrayList<String>();
    private ArrayList<String> alamat =  new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    public Petugas() {
        addNama("Admin");
        addAlamat("Swiss");
        addTelepon("087274727674");
    }

    @Override
    public void addNama(String n) {
        nama.add(n);
    }

    @Override
    public String getNama(int id) {
        return nama.get(id);
    }

    @Override
    public void addAlamat(String n) {
        alamat.add(n);
    }

    @Override
    public String getAlamat(int id) {
        return alamat.get(id);
    }

    @Override
    public void addTelepon(String n) {
        telepon.add(n);
    }

    @Override
    public String getTelepon(int id) {
        return telepon.get(id);
    }

    @Override
    public int getJml() {
        return nama.size();
    }
}