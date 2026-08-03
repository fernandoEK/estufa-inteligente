package estufa;

import cultura.Cultura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Relatorio {
    private String localizacao;
    private double area;
    private StatusEstufa status;
    private List<Cultura> culturas;
    private List<String> leiturasSensores;
    private List<String> alertas;
    private double mediaAmbiental;

    public Relatorio(String localizacao, double area, StatusEstufa status,
                     List<Cultura> culturas, List<String> leiturasSensores,
                     List<String> alertas, double mediaAmbiental) {
        this.localizacao = localizacao;
        this.area = area;
        this.status = status;
        this.culturas = culturas;
        this.leiturasSensores = leiturasSensores;
        this.alertas = alertas;
        this.mediaAmbiental = mediaAmbiental;
    }

    public String gerarTexto() {
        String texto = "RELATÓRIO DA ESTUFA\n"
                + "Status: " + status + "\n"
                + "Localização: " + localizacao + "\n"
                + "Área: " + area + " m²\n\n"
                + "CULTURAS\n";

        for (Cultura c : culturas) texto += "- " + c + "\n";
        texto += "\nLEITURAS DOS SENSORES\n";
        for (String s : leiturasSensores) texto += "- " + s + "\n";
        texto += "\nMédia ambiental: " + mediaAmbiental + "\n";

        if (!alertas.isEmpty()) {
            texto += "\nALERTAS\n";
            for (String a : alertas) texto += "- " + a + "\n";
        }
        return texto;
    }

    public void salvarEmArquivo(String nomeArquivo) {
        try {
            File pasta = new File("relatorio");
            pasta.mkdirs();
            File arquivo = new File(pasta, nomeArquivo);
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
            bw.write(gerarTexto());
            bw.close();
            System.out.println("Relatório salvo em: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório.");
        }
    }
}
