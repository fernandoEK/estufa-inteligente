package estufa;

import cultura.Cultura;
import dispositivo.Irrigador;
import sensor.Sensor;
import sensor.SensorUmidade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estufa {
    private int id;
    private String localizacao;
    private double area;
    private StatusEstufa status;
    private List<Cultura> culturas;
    private List<Sensor> sensores;
    private Irrigador irrigador;
    private List<String> alertas;

    public Estufa(int id, String localizacao, double area, StatusEstufa status) {
        this.id = id;
        this.localizacao = localizacao;
        this.area = area;
        this.status = status;
        this.culturas = new ArrayList<>();
        this.sensores = new ArrayList<>();
        this.alertas = new ArrayList<>();
    }

    public void cadastrarCultura(Cultura cultura) { culturas.add(cultura); }
    public void cadastrarSensor(Sensor sensor) { sensores.add(sensor); }
    public void instalarIrrigador(Irrigador irrigador) { this.irrigador = irrigador; }

    public void monitorarSensores() {
        alertas.clear();
        for (Sensor s : sensores) {
            double valor = s.lerDado();
            if (valor < s.getLimiteMinimo() || valor > s.getLimiteMaximo()) {
                alertas.add("Alerta: " + s.getTipo() + " fora do limite: " + valor);
                if (s instanceof SensorUmidade && valor < s.getLimiteMinimo() && irrigador != null) {
                    irrigador.ligar();
                    alertas.add("Irrigação ativada automaticamente");
                }
            }
        }
    }

    public double calcularMediaAmbiental() {
        return sensores.stream().mapToDouble(Sensor::getValorAtual).average().orElse(0);
    }

    public Relatorio gerarRelatorio() {
        monitorarSensores();
        List<String> leituras = sensores.stream()
                .map(s -> s.getTipo() + ": " + s.lerDado() + " " + s.getUnidade())
                .collect(Collectors.toList());
        return new Relatorio(localizacao, area, status, culturas, leituras, alertas, calcularMediaAmbiental());
    }

    public List<Cultura> getCulturas() { return culturas; }
    public List<Sensor> getSensores() { return sensores; }
    public StatusEstufa getStatus() { return status; }
    public String getLocalizacao() { return localizacao; }
}
