package macromedia;

public class OrderDetail {
    public String namaItem;
    public String hargaPerUnit;
    public String deskripsi;
    public String qty;
    public String frek;
    public String periode;
    public String discount;

    public OrderDetail(String namaItem, String hargaPerUnit, String deskripsi,
                       String qty, String frek, String periode, String discount) {
        this.namaItem = namaItem;
        this.hargaPerUnit = hargaPerUnit;
        this.deskripsi = deskripsi;
        this.qty = qty;
        this.frek = frek;
        this.periode = periode;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("[Item: %s, Harga: %s, Qty: %s, Frek: %s, Periode: %s, Disc: %s, Desc: %s]",
                namaItem, hargaPerUnit, qty, frek, periode, discount, deskripsi);
    }
}
