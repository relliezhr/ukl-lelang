import java.util.ArrayList;

public class Masyarakat implements User {
    private ArrayList<String> nama =  new ArrayList<String>();
    private ArrayList<String> alamat =  new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    public Masyarakat() {
        nama.add("Rellie");
        alamat.add("Tuban");
        telepon.add("0859492012");

        nama.add("Asan");
        alamat.add("Jakarta");
        telepon.add("0696996969");
    }

    public void removeMasyarakat(int id){
        nama.remove(id);
        alamat.remove(id);
        telepon.remove(id);
    }

    @Override
    public void addNama(String newNama) {
        this.nama.add(newNama);
    }

    @Override
    public String getNama(int id) {
        return nama.get(id);
    }

    @Override
    public void addAlamat(String newAlamat) {
        this.alamat.add(newAlamat);
    }

    @Override
    public String getAlamat(int id) {
        return alamat.get(id);
    }

    @Override
    public void addTelepon(String newTelp) {
        this.telepon.add(newTelp);
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