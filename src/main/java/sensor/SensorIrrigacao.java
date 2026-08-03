package sensor;

public class SensorIrrigacao extends Sensor {
    public SensorIrrigacao(String tipo, String unidade, double limiteMinimo, double limiteMaximo) {
        super(tipo, unidade, limiteMinimo, limiteMaximo);
    }

    @Override
    public double lerDado() {
        double valorLido = getValorAtual() * 0.98;
        setValorAtual(valorLido);
        return valorLido;
    }
}
