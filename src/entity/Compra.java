package entity;

public class Compra {
    private int id;

    private String fechaCompra;

    private int cantidad;

    private int idCliente;

    private int idProducto;

    private Cliente Objcliente;

    private Producto Objproducto;

    public Compra() {
    }

    public Compra(String fechaCompra, int cantidad, int idCliente, int idProducto, Cliente objcliente, Producto objproducto) {
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.Objcliente = objcliente;
        this.Objproducto = objproducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Cliente getObjcliente() {
        return Objcliente;
    }

    public void setObjcliente(Cliente objcliente) {
        Objcliente = objcliente;
    }

    public Producto getObjproducto() {
        return Objproducto;
    }

    public void setObjproducto(Producto objproducto) {
        Objproducto = objproducto;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fechaCompra='" + fechaCompra + '\'' +
                ", cantidad=" + cantidad +
                ", idCliente=" + idCliente +
                ", idProducto=" + idProducto +
                ", Objcliente=" + Objcliente +
                ", Objproducto=" + Objproducto +
                '}';
    }
}
