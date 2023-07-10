package codegym.com.model;

import java.sql.Date;

public class KhachHang {
    private int id;
    private String name;
    private Date ngaySinh;
    private String address;

    public KhachHang() {
    }

    public KhachHang(int id, String name, Date ngaySinh, String address) {
        this.id = id;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
