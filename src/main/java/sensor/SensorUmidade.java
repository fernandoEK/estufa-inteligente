package sensor;

public class SensorUmidade extends Sensor {
    public SensorUmidade(String tipo, String unidade, double limiteMinimo, double limiteMaximo) {
        super(tipo, unidade, limiteMinimo, limiteMaximo);
    }

    @Override
    public double lerDado() {
        double valorLido = getValorAtual() - 2;
        setValorAtual(valorLido);
        return valorLido;
    }
}
