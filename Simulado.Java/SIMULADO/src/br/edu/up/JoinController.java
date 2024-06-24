package br.edu.up;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoinController {
    public static void main(String[] args) {
        List<Pessoa> pessoas = lerPessoasCsv("Pessoas.csv");
        List<Endereco> enderecos = lerEnderecoCsv("Enderecos.csv");

        // Join por ID
        List<Pessoa> dadosCombinados = new ArrayList<>();

        for (Pessoa p : pessoas) {
            for (Endereco e : enderecos) {
                if (p.getId() == e.getId()) {
                    Pessoa pessoaCombinada = new Pessoa(p.getId(), p.getNome(), e.getRua(), e.getCidade());
                    dadosCombinados.add(pessoaCombinada);
                    break;
                }
            }
        }

        // Gravar CSV
        try (PrintWriter writer = new PrintWriter(new FileWriter("DadosCombinados.csv"))) {
            for (Pessoa pessoa : dadosCombinados) {
                writer.println(
                        pessoa.getId() + ";" + pessoa.getNome() + ";" + pessoa.getRua() + ";" + pessoa.getCidade());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Pessoa> lerPessoasCsv(String filename) {
        List<Pessoa> pessoas = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.nextLine(); // Ignora a primeira linha (cabeçalho)
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String nome = parts[1];
                pessoas.add(new Pessoa(id, nome)); // Cria Pessoa sem endereço inicialmente
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    private static List<Endereco> lerEnderecoCsv(String filename) {
        List<Endereco> enderecos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.nextLine(); // Ignora a primeira linha (cabeçalho)
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String rua = parts[1];
                String cidade = parts[2];
                enderecos.add(new Endereco(id, rua, cidade));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return enderecos;
    }
}
