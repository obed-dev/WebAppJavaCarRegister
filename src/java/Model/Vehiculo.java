package Model;

public class Vehiculo {
    private int id;
    private String tipo;
    private String placa;
    private String modelo;
    private String marca;
    private int clienteId;

    // Constructor completo
    public Vehiculo(int id, String tipo, String placa, String modelo, String marca, int clienteId) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.clienteId = clienteId;
    }

    // Constructor sin id (para inserciones)
    public Vehiculo(String tipo, String placa, String modelo, String marca, int clienteId) {
        this.tipo = tipo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.clienteId = clienteId;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
}
