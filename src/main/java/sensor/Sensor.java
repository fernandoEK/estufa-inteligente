package sensor;

public abstract class Sensor {
    private String tipo;
    private String unidade;
    private double valorAtual;
    private double limiteMinimo;
    private double limiteMaximo;

    public Sensor(String tipo, String unidade, double limiteMinimo, double limiteMaximo) {
        this.tipo = tipo;
        this.unidade = unidade;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
    }

    public abstract double lerDado();

    public boolean dentroDoLimite() {
        return valorAtual >= limiteMinimo && valorAtual <= limiteMaximo;
    }

    public String getTipo() { return tipo; }
    public String getUnidade() { return unidade; }
    public double getValorAtual() { return valorAtual; }
    public void setValorAtual(double valorAtual) { this.valorAtual = valorAtual; }
    public double getLimiteMinimo() { return limiteMinimo; }
    public double getLimiteMaximo() { return limiteMaximo; }
}
