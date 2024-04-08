package entity;

public class Compra {
    private int id;

    private String fechaCompra;

    private int cantidad;

    private int idCliente;

    private int idProducto;

    private Cliente ObjCliente;

    private Producto ObjProducto;

    public Compra() {
    }

    public Compra( int cantidad, int idCliente, int idProducto, Cliente objCliente, Producto objProducto) {
        this.cantidad = cantidad;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.ObjCliente = objCliente;
        this.ObjProducto = objProducto;
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

    public Cliente getObjCliente() {
        return ObjCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        ObjCliente = objCliente;
    }

    public Producto getObjProducto() {
        return ObjProducto;
    }

    public void setObjProducto(Producto objProducto) {
        ObjProducto = objProducto;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fechaCompra='" + fechaCompra + '\'' +
                ", cantidad=" + cantidad +
                ", idCliente=" + idCliente +
                ", idProducto=" + idProducto +
                ", ObjCliente=" + ObjCliente +
                ", ObjProducto=" + ObjProducto +
                '}';
    }
}
