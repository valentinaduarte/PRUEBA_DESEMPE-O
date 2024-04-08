package entity;

public class Producto {
    private int id;

    private String nombre;

    private Double precio;

    private int idTienda;

    private Tienda ObjTienda;

    public Producto() {
    }

    public Producto(String nombre, Double precio, int idTienda, Tienda objTienda) {
        this.nombre = nombre;
        this.precio = precio;
        this.idTienda = idTienda;
        this.ObjTienda = objTienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public Tienda getObjTienda() {
        return ObjTienda;
    }

    public void setObjTienda(Tienda objTienda) {
        ObjTienda = objTienda;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", idTienda=" + idTienda +
                ", ObjTienda=" + ObjTienda +
                '}';
    }
}
