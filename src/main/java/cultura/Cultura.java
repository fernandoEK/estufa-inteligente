package cultura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cultura implements Serializable {
    private int id;
    private String nome;
    private FaseCultura faseCrescimento;
    private double necessidadeHidrica;
    private double producaoEstimativa;
    private List<Double> historicoProducao;

    public Cultura(int id, String nome, FaseCultura faseCrescimento,
                   double necessidadeHidrica, double producaoEstimativa) {
        this.id = id;
        this.nome = nome;
        this.faseCrescimento = faseCrescimento;
        this.necessidadeHidrica = necessidadeHidrica;
        this.producaoEstimativa = producaoEstimativa;
        this.historicoProducao = new ArrayList<>();
        this.historicoProducao.add(producaoEstimativa);
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public FaseCultura getFaseCrescimento() { return faseCrescimento; }
    public double getNecessidadeHidrica() { return necessidadeHidrica; }
    public double getProducaoEstimativa() { return producaoEstimativa; }
    public List<Double> getHistoricoProducao() { return historicoProducao; }

    public void atualizarFaseCrescimento(FaseCultura novaFase) {
        this.faseCrescimento = novaFase;
    }

    public void atualizarProducao(double novoValor) {
        this.producaoEstimativa = novoValor;
        this.historicoProducao.add(novoValor);
    }

    public double calcularMediaProducao() {
        return historicoProducao.stream().mapToDouble(valor -> valor).average().orElse(0);
    }

    @Override
    public String toString() {
        return nome + " | Fase: " + faseCrescimento
                + " | Produção estimada: " + producaoEstimativa
                + " | Necessidade hídrica: " + necessidadeHidrica;
    }
}
