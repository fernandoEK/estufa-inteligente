package sensor;

public class SensorTemperatura extends Sensor {
    public SensorTemperatura(String tipo, String unidade, double limiteMinimo, double limiteMaximo) {
        super(tipo, unidade, limiteMinimo, limiteMaximo);
    }

    @Override
    public double lerDado() {
        double valorLido = getValorAtual() + 1;
        setValorAtual(valorLido);
        return valorLido;
    }
}
