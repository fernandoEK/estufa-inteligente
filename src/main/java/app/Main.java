package app;

import cultura.Cultura;
import cultura.FaseCultura;
import dispositivo.Irrigador;
import estufa.Estufa;
import estufa.Relatorio;
import estufa.StatusEstufa;
import sensor.SensorIrrigacao;
import sensor.SensorLuminosidade;
import sensor.SensorTemperatura;
import sensor.SensorUmidade;

public class Main {
    public static void main(String[] args) {
        Estufa estufa = new Estufa(1, "Setor Agrícola", 100.0, StatusEstufa.ATIVA);

        Cultura c1 = new Cultura(101, "Tomate", FaseCultura.CRESCIMENTO, 1.2, 300.0);
        Cultura c2 = new Cultura(102, "Alface", FaseCultura.GERMINACAO, 0.8, 120.0);
        estufa.cadastrarCultura(c1);
        estufa.cadastrarCultura(c2);

        SensorTemperatura sTemp = new SensorTemperatura("Temperatura", "°C", 18.0, 30.0);
        sTemp.setValorAtual(27.5);
        estufa.cadastrarSensor(sTemp);

        SensorUmidade sUmi = new SensorUmidade("Umidade", "%", 40.0, 80.0);
        sUmi.setValorAtual(35.0);
        estufa.cadastrarSensor(sUmi);

        SensorLuminosidade sLum = new SensorLuminosidade("Luminosidade", "lux", 300.0, 900.0);
        sLum.setValorAtual(550.0);
        estufa.cadastrarSensor(sLum);

        SensorIrrigacao sIrr = new SensorIrrigacao("Irrigação", "L/h", 20.0, 60.0);
        sIrr.setValorAtual(40.0);
        estufa.cadastrarSensor(sIrr);

        Irrigador irrigador = new Irrigador();
        estufa.instalarIrrigador(irrigador);
        estufa.monitorarSensores();

        Relatorio relatorio = estufa.gerarRelatorio();
        relatorio.salvarEmArquivo("relatorio_estufa.txt");
        System.out.println(relatorio.gerarTexto());
    }
}
