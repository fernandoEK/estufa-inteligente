# Estufa Inteligente

Projeto acadêmico desenvolvido em Java para representar o monitoramento de uma estufa inteligente. O sistema cadastra culturas e sensores, acompanha limites ambientais, aciona automaticamente o irrigador quando a umidade fica abaixo do mínimo e gera um relatório em arquivo de texto.

## Funcionalidades

- Cadastro de culturas e seus estágios de crescimento
- Sensores de temperatura, umidade, luminosidade e irrigação
- Monitoramento de valores mínimos e máximos
- Acionamento automático do irrigador
- Registro de alertas
- Cálculo de médias
- Geração de relatório em `.txt`

## Conceitos aplicados

- Programação orientada a objetos
- Herança e polimorfismo
- Classes abstratas e interfaces
- Enumerações
- Coleções e Streams
- Leitura e escrita de arquivos
- Organização em pacotes

## Estrutura

```text
src/main/java/
├── app/
├── cultura/
├── dispositivo/
├── estufa/
└── sensor/
```

## Como executar

Requer Java 17 ou superior.

```bash
mkdir -p out
javac -d out $(find src/main/java -name "*.java")
java -cp out app.Main
```

O relatório será criado em `relatorio/relatorio_estufa.txt`.

## Observação sobre o código-fonte

Os arquivos-fonte deste repositório foram reconstruídos a partir dos arquivos `.class` preservados do projeto acadêmico original. A estrutura, as classes e o comportamento foram recuperados e validados por recompilação, mas comentários e detalhes de formatação do código original não puderam ser restaurados.
