package sensor;

public class SensorLuminosidade extends Sensor {
    public SensorLuminosidade(String tipo, String unidade, double limiteMinimo, double limiteMaximo) {
        super(tipo, unidade, limiteMinimo, limiteMaximo);
    }

    @Override
    public double lerDado() {
        double valorLido = getValorAtual() * 0.95;
        setValorAtual(valorLido);
        return valorLido;
    }
}
