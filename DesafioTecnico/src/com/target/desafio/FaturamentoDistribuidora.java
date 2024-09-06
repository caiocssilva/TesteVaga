package com.target.desafio;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        try {
            // Usando um caminho relativo dentro do diretório src
            File inputFile = new File("src/com/target/desafio/faturamento.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("row");

            // Inicializa o vetor com o tamanho do número de dias
            double[] faturamento = new double[nodeList.getLength()];
            int diasComFaturamento = 0;
            double soma = 0;

            // Processamento dos dados XML e preenchimento do vetor
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());
                    faturamento[i] = valor; // Armazena o valor no vetor

                    if (valor > 0) {
                        soma += valor;
                        diasComFaturamento++;
                    }
                }
            }

            double media = soma / diasComFaturamento;
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            int diasAcimaMedia = 0;

            // Processamento dos dados no vetor
            for (double valor : faturamento) {
                if (valor > 0) {
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                    if (valor > media) {
                        diasAcimaMedia++;
                    }
                }
            }

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
